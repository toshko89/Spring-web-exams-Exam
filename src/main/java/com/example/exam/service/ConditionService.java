package com.example.exam.service;

import com.example.exam.model.Condition;
import com.example.exam.model.enums.ConditionEnum;
import com.example.exam.repository.ConditionRepo;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ConditionService {
    private final ConditionRepo conditionRepo;

    public ConditionService(ConditionRepo conditionRepo) {
        this.conditionRepo = conditionRepo;
    }

    public void initConditionDB() {
        if(this.conditionRepo.count()==0){
            Arrays.stream(ConditionEnum.values()).forEach(conditionEnum -> {
                Condition condition = new Condition()
                        .setName(conditionEnum)
                        .setDescription(conditionEnum.getDescription());

                this.conditionRepo.save(condition);
            });
        }
    }

    public Condition findConditionByName(ConditionEnum name) {
        return this.conditionRepo.findByName(name).orElse(null);
    }
}
