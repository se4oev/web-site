package ru.se4oev.auth;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by karpenko on 02.12.2022.
 * Description:
 */
public class Generator {

    public static void main(String[] args) {
        byte[] bytes = new byte[32];
        new SecureRandom().nextBytes(bytes);
        String secretKey = new BigInteger(1, bytes).toString(16);
        System.out.println(secretKey);
    }

}
