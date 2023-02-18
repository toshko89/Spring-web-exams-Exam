package com.example.exam.web;

import com.example.exam.model.Offer;
import com.example.exam.service.OfferService;
import com.example.exam.service.UserService;
import com.example.exam.session.LoggedUserSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

@Controller
public class HomeController {

    private final LoggedUserSession loggedUserSession;
    private final OfferService offerService;
    private final UserService userService;

    public HomeController(LoggedUserSession loggedUserSession, OfferService offerService, UserService userService) {
        this.loggedUserSession = loggedUserSession;
        this.offerService = offerService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/home")
    public String home(Model model){
        if(!loggedUserSession.isLoggeinIn()){
            return "redirect:/login";
        }

        Set<Offer> allUserOffer = this.offerService.getAllUserPosts(loggedUserSession.getId());
        Set<Offer> otherUsersOffers = this.offerService.getOtherPosts(loggedUserSession.getId());
        Set<Offer> allBoughtItems = this.userService.findAllBoughtItems(loggedUserSession.getId());

        model.addAttribute("allUserOffer",allUserOffer);
        model.addAttribute("otherUsersOffers",otherUsersOffers);
        model.addAttribute("allBoughtItems",allBoughtItems);

        return "home";
    }
}
