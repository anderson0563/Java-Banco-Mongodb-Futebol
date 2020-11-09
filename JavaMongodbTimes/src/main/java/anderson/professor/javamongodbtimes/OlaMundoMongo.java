/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anderson.professor.javamongodbtimes;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author anderson
 */
public class OlaMundoMongo {

    public static void main(String[] args) {
        //conexao
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        //mongodb://galvaobueno:ronaldinho@localhost:27017/futebol

        //selacao base
        MongoDatabase base = mongoClient.getDatabase("futebol");

        //selacao documento
        MongoCollection<Document> collection = base.getCollection("times");

        //percorrendo a base
        try (MongoCursor< Document> cur = collection.find().iterator()) {

            while (cur.hasNext()) {

                Document doc = cur.next();
                ArrayList<Object> users = new ArrayList<>(doc.values());

                System.out.printf("%s: %s%n", users.get(1), users.get(2));
            }
        }

    }
}
