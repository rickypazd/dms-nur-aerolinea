package Infraestructure.Context.PostgreSQL;

import Infraestructure.Context.IWriteDbContext;
import SharedKernel.db.DbSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

public class WriteDbContext extends IWriteDbContext {

    private MongoClient client;
    private MongoDatabase db;

    private final String DB_NAME = "dmsnur_postgres";
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
        MongoClientURI uri = new MongoClientURI("mongodb://" + DB_USER + ":" + DB_PASS + "@" + DB_HOST + ":" + DB_PORT + "/?authSource=admin");
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
        this.db.getCollection(dbSet.getName()).insertOne(Document.parse(new Gson().toJson(obj, obj.getClass())));
    }

    @Override
    public void Update(Object obj, DbSet dbSet) {

        System.out.println("WriteDbContext::Update Not implemented");
    }

    @Override
    public void Delete(Object obj, DbSet dbSet) {
        System.out.println("WriteDbContext::Delete Not implemented");
    }

}
