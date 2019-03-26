package com.example.user.utils;

import java.util.Random;

public class KeyUtil {

    public static synchronized String genUniquekey(){
        Random random = new Random();
        int number = random.nextInt(9000000);
        return System.currentTimeMillis() + String.format("%06d",number);
    }
}
