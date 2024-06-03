package com.example.beambackend.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String id;
    private String name;
    private String email;
    private String password;
}
