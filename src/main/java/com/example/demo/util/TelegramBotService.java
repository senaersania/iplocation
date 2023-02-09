package com.example.demo.util;

import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class TelegramBotService {
    public void getDetail() throws IOException {
        // avoid creating several instances, should be singleon
        OkHttpClient client = new OkHttpClient();

        RequestBody formBodyChannel = new FormBody.Builder()
                .add("chat_id", "@senadev")
                .add("text", "hello to channel")
                .build();

        RequestBody formBodyGroup = new FormBody.Builder()
                .add("chat_id", "-806033268")
                .add("text", "hello to group")
                .build();

        Request requestChannel = new Request.Builder()
                .url("https://api.telegram.org/bot5400897033:AAH0C4YgX_r-AKZUIi6vmEPVv-iphKFJSW8/sendMessage")
                .post(formBodyChannel)
                .build();

        Request requestGroup = new Request.Builder()
                .url("https://api.telegram.org/bot5400897033:AAH0C4YgX_r-AKZUIi6vmEPVv-iphKFJSW8/sendMessage")
                .post(formBodyGroup)
                .build();

        Response responseChannel = client.newCall(requestChannel).execute();
        Response responseGroup = client.newCall(requestGroup).execute();
        System.out.println(responseChannel.body().string());
        System.out.println(responseGroup.body().string());
    }
}
