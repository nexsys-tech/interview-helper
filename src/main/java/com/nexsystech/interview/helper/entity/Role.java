package com.nexsystech.interview.helper.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "roles")
public class Role {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Enumerated(EnumType.STRING)
        @Column(length = 20)
        private ERole name;

        @ManyToMany(mappedBy = "roles")
        private Set<User> users = new HashSet<>();

        public Role() {

        }

        public Role(ERole name) {
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public ERole getName() {
            return name;
        }

        public void setName(ERole name) {
            this.name = name;
        }
}
