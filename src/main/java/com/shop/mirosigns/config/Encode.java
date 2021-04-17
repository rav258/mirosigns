package com.shop.mirosigns.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encode {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("123"));
        //$2a$10$1q/bUMRjR/S0rNU4r8kJRuX.2dDzm1WgD7vOVZuP3P9UZLHFF1FMS

    }

}
