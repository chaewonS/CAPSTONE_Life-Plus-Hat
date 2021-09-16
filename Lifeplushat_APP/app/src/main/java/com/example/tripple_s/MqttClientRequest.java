package com.example.tripple_s;

public class MqttClientRequest {

    public static String notificationResponse(String response) {
        String responseMessage =
                "{\"rsc\":\"2000\",\n" +
                        "\"rqi\":\""+ response + "\",\n" +
                        "\"pc\":\"\"}";

        return responseMessage;
    }
}
