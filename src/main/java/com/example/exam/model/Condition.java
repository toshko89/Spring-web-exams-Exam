package com.example.exam.model;

import com.example.exam.model.enums.ConditionEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "conditions")
public class Condition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private ConditionEnum name;

    @Column(nullable = false)
    private String description;

    public Condition() {
    }

    public Long getId() {
        return id;
    }

    public Condition setId(Long id) {
        this.id = id;
        return this;
    }

    public ConditionEnum getName() {
        return name;
    }

    public Condition setName(ConditionEnum name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Condition setDescription(String description) {
        this.description = description;
        return this;
    }
}
