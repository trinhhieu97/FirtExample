package com.bachhoastore.model.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;

public class ConnectToDB {
        public static MongoClient mongo;
    public MongoClient connectToDB() {
        // Creating a Mongo client
        mongo = new MongoClient( "localhost" , 27017 );
        // Creating Credentials
        MongoCredential credential;
        credential = MongoCredential.createCredential("sampleUser", "myDb",
                "password".toCharArray());
        return mongo;
    }
}