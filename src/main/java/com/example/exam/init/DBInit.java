package com.example.exam.init;

import com.example.exam.service.ConditionService;
import com.example.exam.service.OfferService;
import com.example.exam.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class DBInit implements CommandLineRunner {

    private final UserService userService;
    private final ConditionService conditionService;
    private final OfferService offerService;

    public DBInit(UserService userService, ConditionService conditionService, OfferService offerService) {
        this.userService = userService;
        this.conditionService = conditionService;
        this.offerService = offerService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.conditionService.initConditionDB();
        this.userService.initUsersDB();
        this.offerService.initOfferDB();
    }
}
