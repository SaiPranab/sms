package org.jt.finalsms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private int roll;
    private String name;
    private String email;
}
