package com.vocera.rock_paper_scissor.util;

public class ApiResponse {
    private String status;
    private String token;

    public ApiResponse(String status, String token) {
        this.status = status;
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public String getToken() {
        return token;
    }
}
