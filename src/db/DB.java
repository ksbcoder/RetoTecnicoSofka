/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import com.mongodb.MongoException;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.result.InsertOneResult;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import concursopreguntas.entidades.Jugador;
import com.google.gson.Gson;

/**
 *
 * @author kevin
 */
public class DB {

    String uri = "mongodb+srv://dbRetoPreguntas:dbR37oPr3gunt4s@retopreguntas.3orepdb.mongodb.net/RetoPreguntas?retryWrites=true&w=majority";

    public MongoClient crearConexion() {
        MongoClient mongoClient = null;
        try {
            Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
            mongoLogger.setLevel(Level.SEVERE);
            mongoClient = MongoClients.create(uri);
            MongoDatabase database = mongoClient.getDatabase("RetoPreguntas");
            MongoCollection<Document> collection = database.getCollection("Jugadores");
            System.out.println("Conexión exitosa a la db: " + collection.getNamespace());
        } catch (MongoException ex) {
            System.out.println("Error en la conexión a la db, error: " + ex);
        }
        return mongoClient;
    }

    public MongoClient InsertOne(String nombre, int puntajeTotal) {
        MongoClient mongoClient = null;
        try {
            Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
            mongoLogger.setLevel(Level.SEVERE);
            mongoClient = MongoClients.create(uri);
            MongoDatabase database = mongoClient.getDatabase("RetoPreguntas");
            MongoCollection<Document> collection = database.getCollection("Jugadores");
            System.out.println("Guardando partida...");
            InsertOneResult result = collection.insertOne(new Document()
                    .append("_id", new ObjectId())
                    .append("nombre", nombre)
                    .append("puntajeTotal", puntajeTotal));
            System.out.println("Partida Guardada.");
        } catch (MongoException ex) {
            System.err.println("No se pudo insertar, error: " + ex);
        }
        return mongoClient;
    }

    public MongoClient Find() {
        MongoClient mongoClient = null;
        try {
            Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
            mongoLogger.setLevel(Level.SEVERE);
            mongoClient = MongoClients.create(uri);
            MongoDatabase database = mongoClient.getDatabase("RetoPreguntas");
            MongoCollection<Document> collection = database.getCollection("Jugadores");

            Bson projectionFields = Projections.fields(
                    Projections.include("nombre", "puntajeTotal"),
                    Projections.excludeId());
            MongoCursor<Document> cursor = collection.find()
                    .projection(projectionFields)
                    .sort(Sorts.ascending("_id")).iterator();
            try {
                if (!cursor.hasNext()) {
                    System.out.println("No hay partidas registradas.");
                } else {
                    int posicion = 1;
                    System.out.println("\nHistorial de juegos. \n");
                    while (cursor.hasNext()) {
                        String lista = cursor.next().toJson();
                        Jugador data = new Gson().fromJson(lista, Jugador.class);
                        System.out.println(posicion + ". " + data.getNombre() + " - " + data.getPuntajeTotal() + " Puntos");
                        posicion++;
                    }
                }
            } finally {
                cursor.close();
            }
        } catch (MongoException ex) {
            System.err.println("No se pudo consultar, error: " + ex);
        }
        return mongoClient;
    }
}
