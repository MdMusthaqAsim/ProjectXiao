package org.genshin.controller;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

//takes a URL and saves data from it in a file in the given save directory
public class JsonToFileWriter {
    public static void saveURLContentToFile(String fileURL, String saveDir) throws IOException {
        // Open a connection to the URL
        URL url = new URL(fileURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        // Set the User-Agent header to mimic a browser
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        // Check for a successful response code (200)
        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            // Read from the URL using BufferedReader
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(saveDir))) {
                String line;
                // Read each line from the URL and write it to the file
                while ((line = reader.readLine()) != null) {
                    writer.write(line);
                    writer.newLine();
                }
                System.out.println("Content saved successfully to: " + saveDir);
            }
        } else {
            System.out.println("Failed to connect. HTTP Response code: " + connection.getResponseCode());
        }
    }
}
