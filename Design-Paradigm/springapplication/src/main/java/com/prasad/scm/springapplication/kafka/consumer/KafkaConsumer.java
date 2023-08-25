package com.prasad.scm.springapplication.kafka.consumer;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
@Component
@EnableBinding(StringSink.class)
@PropertySource("application.properties")
public class KafkaConsumer
{
    @Value("spring.data.mongodb.uri")
	private String mongoUri;
	@Value("spring.data.mongodb.database")
	private String mongoDatabase;

	private String mongoCollection="data";

	MongoClient mongoClient = MongoClients.create("mongodb://127.0.0.1:27017/scm");
    MongoDatabase mongodatabase = mongoClient.getDatabase("scm");
	private MongoCollection<Document> mongocollection =mongodatabase.getCollection(mongoCollection);
	@StreamListener(StringSink.INPUT)
    public void receive(String message) {
        System.out.println("Received message: " + message);
        Document documentdata = Document.parse(message);
        mongocollection.insertOne(documentdata);
        System.out.println("insertion on...11111");
    }
}
