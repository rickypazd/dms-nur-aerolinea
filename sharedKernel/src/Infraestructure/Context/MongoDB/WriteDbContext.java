package Infraestructure.Context.MongoDB;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import org.bson.Document;

import Infraestructure.Context.IWriteDbContext;
import SharedKernel.JSON;
import SharedKernel.db.DbSet;

public class WriteDbContext extends IWriteDbContext {

    private MongoClient client;
    private MongoDatabase db;

    private final String DB_NAME = "dmsnur_aeronave";
    private final String DB_USER = "root";
    private final String DB_PASS = "rootpassword";
    private final String DB_HOST = "servisofts.com";
    private final int DB_PORT = 27017;

    public WriteDbContext() {
        super(WriteDbContext.class);
    }

    @Override
    public void onModelCreating(List<DbSet> sets) {
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        MongoClientURI uri = new MongoClientURI(
                "mongodb://" + DB_USER + ":" + DB_PASS + "@" + DB_HOST + ":" + DB_PORT + "/?authSource=admin");
        this.client = new MongoClient(uri);
        this.db = client.getDatabase(DB_NAME);
        sets.iterator().forEachRemaining(obj -> {
            this.db.getCollection(obj.getName());

        });
    }

    @Override
    public boolean isConnected() {
        return this.db != null;
    }

    @Override
    public void Commit() {
        System.out.println("WriteDbContext::Commit Not implemented");
    }

    @Override
    public void Transaction() {
        System.out.println("WriteDbContext::Transaction Not implemented");
    }

    @Override
    public void Rollback() {
        System.out.println("WriteDbContext::Rollback Not implemented");
    }

    @Override
    public void Add(Object obj, DbSet dbSet) {
        this.db.getCollection(dbSet.getName())
                .insertOne(Document.parse(JSON.getInstance().toJson(obj, obj.getClass())));
    }

    @Override
    public void Update(Object obj_to_edit, BooleanFunction fun, DbSet dbSet) {
        this.db.getCollection(dbSet.getName()).find().iterator().forEachRemaining(action -> {
            Object obj = parseObject(dbSet, (Document) action);
            if (fun.run(obj)) {
                Document doc = Document.parse(JSON.getInstance().toJson(obj_to_edit, obj_to_edit.getClass()));
                doc.entrySet().iterator().forEachRemaining(k -> {
                    if (!k.getKey().equals("_id")) {
                        action.replace(k.getKey(), doc.get(k.getKey()));
                    }
                });
                this.db.getCollection(dbSet.getName()).replaceOne(Filters.eq("_id", action.get("_id")), action);
            }
        });
    }

    @Override
    public void Delete(BooleanFunction fun, DbSet dbSet) {
        this.db.getCollection(dbSet.getName()).find().iterator().forEachRemaining(action -> {
            Object obj = parseObject(dbSet, (Document) action);
            if (fun.run(obj)) {
                this.db.getCollection(dbSet.getName()).deleteOne(action);
            }
        });
    }

    @Override
    public Object Single(BooleanFunction fun, DbSet dbSet) {
        ArrayList<Object> list = new ArrayList<>();
        this.db.getCollection(dbSet.getName()).find().iterator().forEachRemaining(action -> {
            Object obj = parseObject(dbSet, (Document) action);
            if (fun.run(obj)) {
                list.add(obj);
            }
        });
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public List All(DbSet dbSet) {
        ArrayList<Object> list = new ArrayList<>();
        this.db.getCollection(dbSet.getName()).find().iterator().forEachRemaining(action -> {
            list.add(parseObject(dbSet, (Document) action));
        });
        return list;
    }

    @Override
    public List Filter(BooleanFunction fun, DbSet dbSet) {
        ArrayList<Object> list = new ArrayList<>();
        this.db.getCollection(dbSet.getName()).find().iterator().forEachRemaining(action -> {
            Object obj = parseObject(dbSet, (Document) action);
            if (fun.run(obj)) {
                list.add(obj);
            }
        });
        return list;
    }

    public Object parseObject(DbSet dbSet, Document doc) {
        return JSON.getInstance().fromJson(doc.toJson(), dbSet.get_type());
    }

}
