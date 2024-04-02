package com.example.compgeneratorbe.domain.user;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class UserId implements Serializable {
    @Id
    private Long id;
    @Id
    private String email;
}
