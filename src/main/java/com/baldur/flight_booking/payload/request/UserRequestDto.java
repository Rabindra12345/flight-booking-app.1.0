package com.baldur.flight_booking.payload.request;

import com.baldur.flight_booking.model.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

//@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class UserRequestDto {

    private Long id;

    private String username;

    private String email;

    private String passportNumOrNid;

    public UserRequestDto() {
    }

    public UserRequestDto(Long id, String username, String email, String passportNumOrNid, String password, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.passportNumOrNid = passportNumOrNid;
        this.password = password;
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserRequestDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", passportNumOrNid='" + passportNumOrNid + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }

    private String password;

    private Set<Role> roles = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
