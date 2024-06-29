package com.baldur.flight_booking.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
public class JwtResponse {
    private String token;
    private String accessToken;

    public JwtResponse(String token, String accessToken) {
        this.token = token;
        this.accessToken = accessToken;
    }

    public JwtResponse() {
    }

    @Override
    public String toString() {
        return "JwtResponse{" +
                "token='" + token + '\'' +
                ", accessToken='" + accessToken + '\'' +
                '}';
    }

    public static JwtResponseBuilder builder() {
        return new JwtResponseBuilder();
    }

    // The builder class
    public static class JwtResponseBuilder {
        private String token;
        private String accessToken;

        // Setter methods for the builder
        public JwtResponseBuilder token(String token) {
            this.token = token;
            return this;
        }

        public JwtResponseBuilder accessToken(String accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        // Build method to create the JwtResponse instance
        public JwtResponse build() {
            return new JwtResponse(token, accessToken);
        }
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    //    private String type = "Bearer";
//    private Long id;
//    private String username;
//    private String email;
//    private List<String> roles;

//    public JwtResponse(String accessToken, Long id, String username, String email, List<String> roles) {
//        this.token = accessToken;
//        this.id = id;
//        this.username = username;
//        this.email = email;
//        this.roles = roles;
//    }

//    public String getAccessToken() {
//        return token;
//    }
//
//    public void setAccessToken(String accessToken) {
//        this.token = accessToken;
//    }
//
//    public String getTokenType() {
//        return type;
//    }
//
//    public void setTokenType(String tokenType) {
//        this.type = tokenType;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public List<String> getRoles() {
//        return roles;
//    }
}