package Infraestructure.MongoRepository;

import Domain.Model.Aeronaves.*;
import SharedKernel.db.DbContext;
import SharedKernel.db.DbSet;

import java.util.Arrays;
import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

public class WriteDbContext extends DbContext {

    public DbSet<Aeronave> Aeronave;
    public DbSet<Asiento> Asiento;

    private MongoClient db;

    private final String DB_NAME = "admin";
    private final String DB_USER = "root";
    private final String DB_PASS = "rootpassword";
    private final String DB_HOST = "servisofts.com";
    private final int DB_PORT = 27017;

    public WriteDbContext() {
        super(WriteDbContext.class);
        MongoClientURI uri = new MongoClientURI(
                "mongodb://" + DB_USER + ":" + DB_PASS + "@" + DB_HOST + ":" + DB_PORT + "/?authSource=" + DB_NAME);

        this.db = new MongoClient(uri);
        this.db.listDatabases().iterator().forEachRemaining(i -> {
            System.out.println(i.toJson());
        });

    }

    @Override
    public void onModelCreating(List<DbSet> sets) {
        System.out.println("WriteDbContext::onModelCreating Not implemented");
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
    public void Add(Object obj) {
        System.out.println("WriteDbContext::Add Not implemented");
    }

    @Override
    public void Update(Object obj) {
        System.out.println("WriteDbContext::Update Not implemented");

    }

    @Override
    public boolean isConnected() {
        return this.db != null;
    }

}
