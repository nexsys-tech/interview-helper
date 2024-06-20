package com.nexsystech.interview.helper.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document(collection = "sessions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Session {
    @Id
    private String id;

    @Field(name ="userId")
    @NotBlank
    private String userId;

    @Field(name ="jwtToken")
    private String jwtToken;

    @Field(name ="createdAt")
    @CreatedDate
    private LocalDateTime createdAt;

    @Field(name ="email")
    @LastModifiedDate
    private LocalDateTime lastAccessedAt;

}
