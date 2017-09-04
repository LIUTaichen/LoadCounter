package com.dempseywood.loadcounter;

/**
 * Created by musing on 04/09/2017.
 */

public class Data {

    private static int count = 0;

    private static String material = "top soil";

    public static int getCount() {
        return count;
    }

    public static void setCount(int count1) {
        count = count1;
    }

    public static String getMaterial() {
        return material;
    }

    public static void setMaterial(String material1) {
       material = material1;
    }
}
