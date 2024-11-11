package com.mhyusuf.hackerrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import org.json.JSONArray;
import java.io.InputStream;

public class RestPopulation {
    public static int getPopulationDensity(String name) {
        try {
            // Buat URL dengan parameter nama negara
            URL url = new URL("https://jsonmock.hackerrank.com/api/countries?name=" + name);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Periksa status respons
            if (connection.getResponseCode() != 200) {
                return -1; // Jika respons gagal, kembalikan -1
            }

            // Baca data JSON dari respons
            InputStream inputStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Parse respons ke JSON
            JSONObject jsonResponse = new JSONObject(response.toString());
            JSONArray dataArray = jsonResponse.getJSONArray("data");

            // Periksa apakah array `data` kosong
            if (dataArray.length() == 0) {
                return -1; // Jika tidak ada data, kembalikan -1
            }

            // Ambil objek pertama dari array `data`
            JSONObject countryData = dataArray.getJSONObject(0);
            int population = countryData.getInt("population");
            int area = countryData.getInt("area");

            // Hitung kepadatan penduduk
            if (area == 0) {
                return -1; // Hindari pembagian dengan nol
            }
            int populationDensity = Math.round((float) population / area);
            return populationDensity;

        } catch (Exception e) {
            e.printStackTrace();
            return -1; // Jika terjadi kesalahan, kembalikan -1
        }
    }

    public static void main(String[] args) {
        int populationDensity = getPopulationDensity("India");
        System.out.println("Population Density of Indonesia: " + populationDensity);
    }
}
