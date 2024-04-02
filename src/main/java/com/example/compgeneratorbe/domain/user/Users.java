package com.example.compgeneratorbe.domain.user;

import com.example.compgeneratorbe.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Users extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String email;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public Users(String email, String name, Role role) {
        this.email = email;
        this.name = name;
        this.role = role;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}
