package com.codebreaker.pacmanclient.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.time.Duration;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.codebreaker.pacmanclient.models.Submission;

public class APIService {
    public static final String GET_URL = "http://localhost:8080/api/getLeaderboard/";
    public static final String POST_URL = "http://localhost:8080/api/submit/";
    public static final String DELETE_URL_FORMAT = "http://localhost:8080/api/delete/%s";

    /**
     * Fungsi untuk memasukan object submission leaderboard ke database
     * @param obj Object Submission Leaderboard yang akan didaftarkan ke db
     */
    public static void post(Submission obj){
        // membuat client baru
        // ibaratnya buka tab chrome baru
        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();
        
        // Membuat request baru
        // Ibaratnya masukin link google.com ke search bar
        HttpRequest req = HttpRequest
                .newBuilder(URI.create(POST_URL))
                .POST(HttpRequest.BodyPublishers.ofString(obj.toString()))
                .setHeader("Accept", "application/json")
                .setHeader("Content-Type", "application/json")
                .build();
        
        // Deklarasi variable untuk response
        HttpResponse response;
        try {
            // mensend request dan mengisi hasil request ke variable reponse
            response = client.send(req, HttpResponse.BodyHandlers.ofString());
            
            // Memprint hasil request, ini bisa kalian ganti jadi apa gek
            System.out.println("Status code: " + response.statusCode());
            System.out.println("Body :" + response.body());
        } catch (IOException | InterruptedException ex) {
            // Logger gak penting
            Logger.getLogger(APIService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Fungsi untuk admin menghapus submission leaderboard yang ada di database
     * @param id Id untuk submission yang ingin dihapus
     */
    public static void delete(int id){
        // membuat client baru
        // ibaratnya buka tab chrome baru
        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();
        
        // Membuat request baru
        // Ibaratnya masukin link google.com ke search bar
        HttpRequest req = HttpRequest
                .newBuilder(URI.create(String.format(DELETE_URL_FORMAT, id)))
                .DELETE()
                .setHeader("Accept", "application/json")
                .setHeader("Content-Type", "application/json")
                .build();
        
        // Deklarasi variable untuk response
        HttpResponse response;
        try {
            // mensend request dan mengisi hasil request ke variable reponse
            response = client.send(req, HttpResponse.BodyHandlers.ofString());
            
            // Memprint hasil request, ini bisa kalian ganti jadi apa gek
            System.out.println("Status code: " + response.statusCode());
            System.out.println("Body :" + response.body());
        } catch (IOException | InterruptedException ex) {
            // Logger gak penting
            Logger.getLogger(APIService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Fungsi ini melakukan get request ke server untuk meminta isi database
     */
    public static void get(){
        // membuat client baru
        // ibaratnya buka tab chrome baru
        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();
        
        // Membuat request baru
        // Ibaratnya masukin link google.com ke search bar
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(GET_URL))
                .build();
        
        // Deklarasi variable untuk response
        HttpResponse response;
        try {
            // mensend request dan mengisi hasil request ke variable reponse
            // ibarat pencet enter abis masukin link
            response = client.send(req, HttpResponse.BodyHandlers.ofString());
            
            // Memprint hasil request, ini bisa kalian ganti jadi apa gek
            System.out.println("Status code: " + response.statusCode());
            System.out.println("Body :" + response.body());
        } catch (IOException | InterruptedException ex) {
            // Logger gak penting
            Logger.getLogger(APIService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
