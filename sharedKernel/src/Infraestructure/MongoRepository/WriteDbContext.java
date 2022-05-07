package Infraestructure.MongoRepository;

import Domain.Model.Aeronaves.*;
import SharedKernel.db.DbContext;
import SharedKernel.db.DbSet;

import java.util.Arrays;
import java.util.List;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

public class WriteDbContext extends DbContext {

    public DbSet<Aeronave> Aeronave;
    public DbSet<Asiento> Asiento;

    private MongoClient client;
    private MongoDatabase db;
    private final String DB_NAME = "dmsnur-aeronave";
    private final String DB_USER = "root";
    private final String DB_PASS = "rootpassword";
    private final String DB_HOST = "servisofts.com";
    private final int DB_PORT = 27017;

    public WriteDbContext() {
        super(WriteDbContext.class);
    }

    @Override
    public void onModelCreating(List<DbSet> sets) {
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
        System.out.println("WriteDbContext::Add Not implemented");
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
