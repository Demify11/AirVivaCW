package com.example.airvivacw;

public class CurrentUser {
    private static String userId;

    public static String getUserId() {
        return userId;
    }

    public static void setUserId(String userId) {
        CurrentUser.userId = userId;
    }
}
