package com.example.exam.repository;

import com.example.exam.model.Condition;
import com.example.exam.model.enums.ConditionEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConditionRepo extends JpaRepository<Condition, Long>{
    Optional<Condition> findByName(ConditionEnum name);
}
