package com.example.demo.util;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import com.example.demo.models.IpLocation;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import io.ipgeolocation.api.Geolocation;
import io.ipgeolocation.api.GeolocationParams;
import io.ipgeolocation.api.IPGeolocationAPI;
@Service
public class ReadFileService  {

    public void singleIp(){
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url("https://api.ipgeolocation.io/ipgeo?apiKey=aed3ebc4481f41198913144bcfb01c9a&ip=147.139.135.31&fields=geo")
                    .method("GET", null)
                    .build();
            Response response = client.newCall(request).execute();
            try {
                String result = response.body().string();
                ObjectMapper objectMapper = new ObjectMapper();
                IpLocation ipLocation = objectMapper.readValue(result, IpLocation.class);
                System.out.println("DTO : " + ipLocation);
            } catch (Exception exc) {
                exc.getMessage();
            }
        } catch (Exception exception){
            exception.getMessage();
        }
    }

    public Map readFile(String file){
        Map result = new HashMap<>();
        // file = "src/main/resources/static/uploadedfile/ecs.json";
        
        try {
            String json = readFileAsString(file);
            JSONArray jsonArray = new JSONArray(json);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                String sourceIP = obj.getString("SourceCidrIp");
                String newIP = sourceIP.replaceAll("/32", "")
                                        .replaceAll("/12", "")
                                        .replaceAll("/16", "")
                                        .replaceAll("/24", "")
                                        .replaceAll("/30", "");
                                        
                String apiKeyGeoLocation = "aed3ebc4481f41198913144bcfb01c9a";
                // String old_account = "96f77b8fedc84f89997a9a2b5a50ff1e";

                IPGeolocationAPI ipGeolocationRequest = new IPGeolocationAPI(apiKeyGeoLocation);
                GeolocationParams geoParams = new GeolocationParams();
                geoParams.setIPAddress(newIP);

                Geolocation geolocation = ipGeolocationRequest.getGeolocation(geoParams);
                // System.out.println(geolocation);
                // result.put(sourceIP, geolocation.getCountryName());
                // result.put(sourceIP, geolocation.getMessage());

                // Check if geolocation lookup was successful 
                 if(geolocation.getStatus() == 200) {
                     result.put(sourceIP, geolocation.getCountryName());
                     System.out.printf("IP : %s, Location: %s\n", sourceIP, geolocation.getCountryName());
                 }
                 else {
                     System.out.printf("Status Code: %d, Message: %s\n", geolocation.getStatus(), geolocation.getMessage());
                 }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public String readFileAsString(String file)throws Exception
    {
        return new String(Files.readAllBytes(Paths.get(file)));
    }
}
