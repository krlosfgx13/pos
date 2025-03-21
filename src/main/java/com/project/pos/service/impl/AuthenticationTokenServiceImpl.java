package com.project.pos.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.pos.request.GetTokenRequest;
import com.project.pos.service.AuthenticationTokenService;
import com.project.pos.utils.LocalDateTimeAdapter;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

@Service
public class AuthenticationTokenServiceImpl implements AuthenticationTokenService {

    @Value("${banking.api.username}")
    private String userName;

    @Value("${banking.api.password}")
    private String password;

    @Value("${banking.login.uri}")
    private String getTokenEndpoint;

    private static final String JSON_MEDIA_TYPE = "application/json; charset=utf-8";

    @Override
    public String getToken(){
        OkHttpClient client = new OkHttpClient();
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .create();
        MediaType JSON = MediaType.get(JSON_MEDIA_TYPE);

        String json = gson.toJson(GetTokenRequest
                .builder()
                .userName(userName)
                .password(password)
                .build());

        RequestBody requestBody = RequestBody.create(json, JSON);

        Request request = new Request.Builder()
                .url(getTokenEndpoint)
                .post(requestBody)
                .build();

        // Execute the request and get response
        try (Response response = client.newCall(request).execute()) {
            if(!Objects.isNull(response.body())){

                // Convert response body to a Map<String, String>
                ObjectMapper objectMapper = new ObjectMapper();
                Map<String, String> data = objectMapper.readValue(response.body().string(), Map.class);
                return data.get("token");

//                String responseBody = response.body().string();
//                return gson.fromJson(responseBody, String.class);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "";
    }

}
