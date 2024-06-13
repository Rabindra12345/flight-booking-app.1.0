package com.baldur.flight_booking.controller;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

//import java.crypto.Mac;
//import java.crypto.spec.SecretKeySpec;
//import org.apache.commons.codec.binary.Base64;
public class Base64Signature {
    public static void main(String[] args) {
        try {
            String secret = "8gBm/:&EnhH.1/q("; // UAT Secret Key
            String message = "total_amount=10,transaction_uuid=123456,product_code=EPAYTEST";

            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            String hash = Base64.encodeBase64String(sha256_HMAC.doFinal(message.getBytes()));
            System.out.println(hash);
        } catch (Exception e) {
            System.out.println("Error generating HMAC-SHA256 signature: " + e.getMessage());
        }
    }
}

