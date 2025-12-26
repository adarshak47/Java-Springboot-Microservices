package com.pm.authservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_users_email", columnNames = "email")
        }
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Email
    @NotBlank
    @Column(nullable = false, length = 255)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 50)
    private String role;

    /* =====================
       Constructors
       ===================== */

    public User(String email, String encodedPassword, String role) {
        this.email = email;
        this.password = encodedPassword;
        this.role = role;
    }

    /* =====================
       Domain behavior
       ===================== */

    public void changePassword(String encodedPassword) {
        this.password = encodedPassword;
    }

    public void changeRole(String role) {
        this.role = role;
    }
}
