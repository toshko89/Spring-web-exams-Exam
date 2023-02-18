package com.example.exam.web;

import com.example.exam.model.dto.OfferDTO;
import com.example.exam.service.OfferService;
import com.example.exam.session.LoggedUserSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class OfferController {
    private final LoggedUserSession loggedUserSession;
    private final OfferService offerService;

    public OfferController(LoggedUserSession loggedUserSession, OfferService offerService) {
        this.loggedUserSession = loggedUserSession;
        this.offerService = offerService;
    }

    @ModelAttribute
    public OfferDTO initOfferDTO() {
        return new OfferDTO();
    }

    @GetMapping("/offer-add")
    public String addPost() {
        if (!loggedUserSession.isLoggeinIn()) {
            return "redirect:/login";
        }

        return "/offer-add";
    }

    @PostMapping("/offer-add")
    public String addPost(@Valid OfferDTO offerDTO, BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {
        if (!loggedUserSession.isLoggeinIn()) {
            return "redirect:/login";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("offerDTO", offerDTO);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.offerDTO", bindingResult);

            return "redirect:/offer-add";
        }

        this.offerService.addOffer(offerDTO);

        return "redirect:/home";
    }

    @GetMapping("/remove-offer/{id}")
    public String removePost(@PathVariable long id) {
        if (!loggedUserSession.isLoggeinIn()) {
            return "redirect:/login";
        }

        this.offerService.removePostById(id);

        return "redirect:/home";
    }

    @GetMapping("/buy-offer/{id}")
    public String buyOffer(@PathVariable long id) {
        if (!loggedUserSession.isLoggeinIn()) {
            return "redirect:/login";
        }

        this.offerService.buyOffer(id);

        return "redirect:/home";
    }


}
