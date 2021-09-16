package com.example.tripple_s;

import org.json.JSONObject;

public class MqttClientRequestParser {
    private static String TAG = "MqttClientRequestParser";
    // xml parser

    // json parser
    public static String notificationJsonParse(String message) throws Exception {
        JSONObject json = new JSONObject(message);
        String responserqi = json.getString("rqi");

        return responserqi;
    }
}
