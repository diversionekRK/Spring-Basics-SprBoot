package com.div.spring.controllers;

import com.div.spring.SpringbootApplication;
import com.div.spring.dao.Offer;
import com.div.spring.dao.OfferRepository;
import com.div.spring.service.OfferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

/**
 * Created by Div on 2018-05-07.
 */

@Controller
public class HomeController {

    @Autowired
    private OfferService offerService;

    private static final Logger log = LoggerFactory.getLogger(SpringbootApplication.class);

    @RequestMapping("/")
    public String home(Model model, Principal principal) {

        List<Offer> offers = offerService.getOffers();
        for (Offer offer : offers) {
				log.info(offer.toString());
			}
        model.addAttribute("offers", offers);


        return "home";
    }
}
