package com.onestechsolution.gbvjewellers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by PSGanesh on 5/3/17.
 */

public class GenerateUniqueId {
    private static long counter = 1;
    private String uidDate, uidTime;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();
    public void getCurrentDateAndTime() {

        String currentDate = dateFormat.format(date);
        String[] splitDate = currentDate.split("\\s");

        for(int i = 0; i<splitDate.length; i++) {
            if(i==0) {
                uidDate = splitDate[i];
            }
            if(i==1) {
                uidTime = splitDate[i];
            }
        }
        System.out.println(uidDate);
        System.out.println(uidTime);
    }

    public String generateUUId() {
        getCurrentDateAndTime();
        String uidDateArray[] = uidDate.split("/");
        String uidTimeArray[] = uidTime.split(":");
        uidDate = "";
        uidTime = "";
        for(String d:uidDateArray) {
            uidDate += d;
        }

        for(String t: uidTimeArray) {
            uidTime += t;
        }

        //uidDate = uidDate.split("/");
        //uidTime = uidTime.split(":");
        System.out.println(dateFormat.format(date));
        String uniqueID = "C"+counter+"_"+uidDate+"_"+uidTime;
        System.out.println("Creating a unique id: "+uniqueID);
        counter++;
        return uniqueID;
    }
}

