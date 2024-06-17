package com.nexsystech.interview.helper.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Document(collection ="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    //Does ID Generation Automatically
    @Id
    private Integer id;

    @Field(name ="firstName")
    @Size(max = 20)
    private String firstName;

    @Field(name ="lastName")
    @Size(max = 20)
    private String lastName;

    @Size(max = 20)
    private String username;

    @DBRef
    private Set<Role> roles = new HashSet<>();

    @Field(name ="email")
    @NotBlank
    private String email;


    @Field(name ="phone")
    @NotBlank
    private String phone;

    @Field(name ="password")
    private String password;

    @Field(name ="createdAt")
    @CreatedDate
    private Date createdAt;

    @Field(name = "updatedAt")
    @LastModifiedDate
    private Date updatedAt;

    public User(String username, String email, String password) {
        this.username=username;
        this.email=email;
        this.password= password;

    }
}
