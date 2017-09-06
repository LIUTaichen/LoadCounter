package com.dempseywood.loadcounter;

import android.location.Location;

import com.dempseywood.loadcounter.db.entity.EquipmentStatus;

import java.util.Date;

/**
 * Created by musing on 04/09/2017.
 */

public class Data {

    private static int count = 0;

    private static String operator ="John Smith";
    private static String equipment  ="SJY873";

    private static String material = "Top soil";

    private static String status = "Unloaded";

    private static Location location;

    public static int getCount() {
        return count;
    }

    public static void setCount(int count1) {
        Data.count = count1;
    }

    public static String getMaterial() {
        return material;
    }

    public static void setMaterial(String material1) {
        Data.material = material1;
    }

    public static String getStatus() {
        return status;
    }

    public static void setStatus(String status) {
        Data.status = status;
    }

    public static Location getLocation() {
        return location;
    }

    public static void setLocation(Location location1) {
        Data.location = location1;
    }

    public static String getOperator() {
        return operator;
    }

    public static void setOperator(String operator) {
        Data.operator = operator;
    }

    public static String getEquipment() {
        return equipment;
    }

    public static void setEquipment(String equipment) {
        Data.equipment = equipment;
    }


}
