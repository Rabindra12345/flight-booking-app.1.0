package com.baldur.flight_booking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "token", columnDefinition = "TEXT")
    private String token;
    private LocalDateTime expiryDate;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User userInfo;

    public RefreshToken() {
    }

    public RefreshToken(Integer id, String token, LocalDateTime expiryDate, User userInfo) {
        this.id = id;
        this.token = token;
        this.expiryDate = expiryDate;
        this.userInfo = userInfo;
    }

    public static RefreshTokenBuilder builder() {
        return new RefreshTokenBuilder();
    }

    // The builder class
    public static class RefreshTokenBuilder {
        private Integer id;
        private String token;
        private LocalDateTime expiryDate;
        private User userInfo;

        // Setter methods for the builder
        public RefreshTokenBuilder id(Integer id) {
            this.id = id;
            return this;
        }
        public RefreshTokenBuilder token(String token) {
            this.token = token;
            return this;
        }

        public RefreshTokenBuilder expiryDate(LocalDateTime accessToken) {
            this.expiryDate = expiryDate;
            return this;
        }

        public RefreshTokenBuilder userInfo(User userInfo) {
            this.userInfo = userInfo;
            return this;
        }

        // Build method to create the JwtResponse instance
        public RefreshToken build() {
            return new RefreshToken(id,token, expiryDate,userInfo);
        }
    }

    @Override
    public String toString() {
        return "RefreshToken{" +
                "id=" + id +
                ", token='" + token + '\'' +
                ", expiryDate=" + expiryDate +
                ", userInfo=" + userInfo +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public User getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(User userInfo) {
        this.userInfo = userInfo;
    }
}
