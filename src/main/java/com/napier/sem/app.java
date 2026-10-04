package com.napier.sem;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class app {
    private MongoClient mongoClient;

    public void connect(String location, int delay) {
        try {
            // Wait for database to initialize
            Thread.sleep(delay);
            mongoClient = new MongoClient(location, 27017);
        } catch (InterruptedException e) {
            System.out.println("Connection interrupted");
        } catch (Exception e) {
            System.out.println("Could not connect to MongoDB server");
        }
    }

    public void disconnect() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }

    public static void main(String[] args) {
        app a = new app();

        // Connect to database
        if (args.length < 1) {
            a.connect("localhost:27017", 0);
        } else {
            a.connect(args[0], 0);
        }

        a.disconnect();
    }
}