package dev.ceymikey.webutilsj.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Jwu {

    public static String fetch(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        /**
         * This is just saying its a GET request and not a POSY
         */
        connection.setRequestMethod("GET");

        /**
         * Sets connection timeouts.
         */
        connection.setConnectTimeout(5000); // 5 seconds
        connection.setReadTimeout(5000);    // 5 seconds

        /**
         * Sets the user agent header
         */
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");

        int responseCode = connection.getResponseCode();

        StringBuilder response = new StringBuilder();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line).append("\n");
            }
            reader.close();
        } else {
            response.append("Error: ").append(responseCode).append(" ").append(connection.getResponseMessage());
        }

        connection.disconnect();

        return response.toString();
    }
}
