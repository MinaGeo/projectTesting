package com.example.demo;

public class GlobalData {
    private static String userID;
    private static long time;

    public static String getUserID() {
        return userID;
    }

    public static void setUserID(String userID) {
        GlobalData.userID = userID;
    }

    public static void setStartTime(long time)
    {
        GlobalData.time= time;
    }

    public static long getTime()
    {
        return time;
    }


}