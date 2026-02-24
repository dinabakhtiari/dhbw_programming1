package com.example.final_project_programming;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ApiClient {
    private static final String API_URL = "https://restcountries.com/v3.1/all?fields=name,capital";

    public ArrayList<Country> fetchCountries() {
        ArrayList<Country> countries = new ArrayList<>();
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(API_URL)).build();
            String responseBody = client.send(request, HttpResponse.BodyHandlers.ofString()).body();

            com.google.gson.JsonArray rootArray = com.google.gson.JsonParser.parseString(responseBody).getAsJsonArray();

            for (int i = 0; i < rootArray.size(); i++) {
                com.google.gson.JsonObject countryObject = rootArray.get(i).getAsJsonObject();

                String name = countryObject.get("name").getAsJsonObject().get("common").getAsString();

                if (countryObject.has("capital") && !countryObject.get("capital").isJsonNull()) {
                    com.google.gson.JsonArray capitalArray = countryObject.get("capital").getAsJsonArray();
                    if (capitalArray.size() > 0) {
                        String capital = capitalArray.get(0).getAsString();

                        countries.add(new Country(name, capital));
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error in getting data " + e.getMessage());
        }
        return countries;
    }
}
