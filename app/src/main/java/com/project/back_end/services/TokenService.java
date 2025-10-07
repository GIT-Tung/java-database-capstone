package com.project.back_end.services;

import java.util.Base64;

public class TokenService {

    private static final String SECRET_KEY = "MySecretKey12345";

    // 🔐 Sinh token (giả lập)
    public String generateToken(String userEmail) {
        String tokenData = userEmail + ":" + System.currentTimeMillis();
        return Base64.getEncoder().encodeToString(tokenData.getBytes());
    }

    // 🔑 Lấy signing key từ secret key (mô phỏng)
    public String getSigningKey() {
        return Base64.getEncoder().encodeToString(SECRET_KEY.getBytes());
    }
}
