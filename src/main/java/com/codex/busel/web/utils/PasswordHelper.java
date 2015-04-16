package com.codex.busel.web.utils;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;

@Service
public class PasswordHelper implements PasswordEncoder{

    private MessageDigest md;

    @Override
    public String encode(CharSequence rawPassword) {
        if (md == null) {
            return rawPassword.toString();
        }

        md.update(rawPassword.toString().getBytes());
        byte byteData[] = md.digest();

        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < byteData.length; i++){
            String hex = Integer.toHexString(0xff & byteData[1]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        return hexString.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return rawPassword.equals(encodedPassword);
    }
}
