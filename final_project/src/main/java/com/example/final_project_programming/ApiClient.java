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

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            List<Map<String, Object>> rawData = gson.fromJson(response.body(),
                    new TypeToken<List<Map<String, Object>>>(){}.getType());

            for (Map<String, Object> entry : rawData) {
                Map<String, Object> nameMap = (Map<String, Object>) entry.get("name");
                String commonName = (String) nameMap.get("common");
                List<String> capitals = (List<String>) entry.get("capital");

                if (capitals != null && !capitals.isEmpty()) {
                    countries.add(new Country(commonName, capitals.get(0)));
                }
            }
        } catch (Exception e) {
            System.err.println("Error in getting data " + e.getMessage());
        }
        return countries;
    }
}
