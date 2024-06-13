package com.baldur.flight_booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TEST {

//    @Autowired
    private static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static void main(String[] args) {
        String password="password123";
        String encryptedPass = passwordEncoder.encode(password);
        System.out.println("password___________ :"+encryptedPass);
        double random = Math.random() * 49 + 1;

        for(int i =0;i<50;i++){
            System.out.println("RANDOM ____ :"+(int)random);
        }
//        int random1 = random.intValue();
    }
}
