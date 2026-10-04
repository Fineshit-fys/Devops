package com.napier.sem;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.util.logging.Logger;
import java.util.logging.Level;

public class app {
    public static void main(String[] args) {
        // Suppress MongoDB driver logging output
        Logger.getLogger("org.mongodb.driver").setLevel(Level.SEVERE);

        // Uses MONGO_HOST environment variable if set, otherwise defaults to localhost for IntelliJ
        String mongoHost = System.getenv("MONGO_HOST");
        if (mongoHost == null || mongoHost.isEmpty()) {
            mongoHost = "localhost";
        }

        MongoClient mongoClient = new MongoClient(mongoHost, 27017);
        MongoDatabase database = mongoClient.getDatabase("mydb");
        MongoCollection<Document> collection = database.getCollection("test");

        Document doc = new Document("name", "Kevin Sim")
                .append("class", "DevOps")
                .append("year", "2024")
                .append("result", new Document("CW", 95).append("EX", 85));

        collection.insertOne(doc);

        Document myDoc = collection.find().first();
        System.out.println(myDoc.toJson());
    }
}