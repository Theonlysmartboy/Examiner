package com.otema.examiner.utils;

import java.util.Random;

/**
 *
 * @author TheOnlySmartBoy
 */
public class RandomGen {

    //Generate Password
    public static String passwordGen() {
        String pass = "N";
        final String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ@#$%^&*_()/|!.?abcdefghijklmnopqrstuvwxyz";
        final int N = alphabet.length();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            pass += alphabet.charAt(r.nextInt(N));
        }
        return pass;
    }

}
