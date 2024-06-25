package com.nexsystech.interview.helper.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;



@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;
    @Column(name = "username")
    private String username;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "phone", unique = true)
    private String phone;
    @Column(name = "password")
    private String password;
    @Column(name = "createdAt")
    private Date createdAt;
    @Column(name = "updatedAt")
    private Date updatedAt;

    public User(String username, String email, String encode) {
        this.username=username;
        this.email=email;
        this.password=encode;
    }
}
