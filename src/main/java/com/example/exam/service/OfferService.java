package com.example.exam.service;

import com.example.exam.model.Offer;
import com.example.exam.model.User;
import com.example.exam.model.dto.OfferDTO;
import com.example.exam.model.enums.ConditionEnum;
import com.example.exam.repository.OfferRepo;
import com.example.exam.session.LoggedUserSession;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Set;

@Service
public class OfferService {
    private final OfferRepo offerRepo;
    private final ConditionService conditionService;
    private final UserService userService;
    private final LoggedUserSession loggedUserSession;

    public OfferService(OfferRepo offerRepo, ConditionService conditionService, UserService userService, LoggedUserSession loggedUserSession) {
        this.offerRepo = offerRepo;
        this.conditionService = conditionService;
        this.userService = userService;
        this.loggedUserSession = loggedUserSession;
    }

    public void initOfferDB() {
        if (this.offerRepo.count() == 0) {
            Offer offer = new Offer()
                    .setPrice(BigDecimal.valueOf(10))
                    .setDescription("Offer 1")
                    .setCondition(this.conditionService.findConditionByName(ConditionEnum.GOOD))
                    .setSeller(this.userService.findUserById(1L));
            this.offerRepo.save(offer);

            Offer offer2 = new Offer()
                    .setPrice(BigDecimal.valueOf(5))
                    .setDescription("Offer 2")
                    .setCondition(this.conditionService.findConditionByName(ConditionEnum.ACCEPTABLE))
                    .setSeller(this.userService.findUserById(1L));
            this.offerRepo.save(offer2);

            Offer offer3 = new Offer()
                    .setPrice(BigDecimal.valueOf(100))
                    .setDescription("Offer 3")
                    .setCondition(this.conditionService.findConditionByName(ConditionEnum.EXCELLENT))
                    .setSeller(this.userService.findUserById(2L));
            this.offerRepo.save(offer3);
        }
    }

    public Offer findOfferById(long id) {
        return this.offerRepo.findById(id).orElse(null);
    }

    public void addOffer(OfferDTO offerDTO) {
        Offer offer = new Offer()
                .setDescription(offerDTO.getDescription())
                .setPrice(offerDTO.getPrice())
                .setCondition(this.conditionService.findConditionByName(ConditionEnum.valueOf(offerDTO.getCondition())))
                .setSeller(this.userService.findUserById(loggedUserSession.getId()));
        this.offerRepo.save(offer);
    }

    public Set<Offer> getAllUserPosts(long id) {
        return this.offerRepo.findAllBySellerId(id);
    }

    public Set<Offer> getOtherPosts(long id) {
        return this.offerRepo.findAllPostsBySellerIdNot(id);
    }

    public void removePostById(long id) {
        this.offerRepo.deleteById(id);
    }

    public void buyOffer(long id) {
        Offer offer = this.offerRepo.findById(id).orElse(null);
        User buyer = this.userService.findUserById(loggedUserSession.getId());
        if (offer != null) {
            offer.setSeller(null);
            this.offerRepo.save(offer);
            buyer.getBoughtOffers().add(offer);
            this.userService.saveUser(buyer);
        }


    }
}
