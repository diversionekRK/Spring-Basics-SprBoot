package com.div.spring.controllers;

import com.div.spring.SpringbootApplication;
import com.div.spring.dao.Offer;
import com.div.spring.dao.User;
import com.div.spring.service.OfferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.security.Principal;

/**
 * Created by Div on 2018-05-08.
 */
@Controller
public class OfferController {

    private static final Logger log = LoggerFactory.getLogger(SpringbootApplication.class);

    @Autowired
    private OfferService offerService;

    @RequestMapping("/createoffer")
    public String createOffer(Model model, Principal principal) {

        Offer offer = null;

//        if (principal.getName() != null) {
//            String username = principal.getName();
//
//            offer = offerService.getOffer(username);
//        }
        String username = "testuser";
        offer = offerService.getOffer(username);
        log.info(offer.toString());

        if(principal != null)
            log.info("zalogowany");
        else
            log.info("niezalogowany");

        if (offer == null)
            offer = new Offer();

        model.addAttribute("offer", offer);

        return "createoffer";
    }

    @RequestMapping(value = "/docreate", method = RequestMethod.POST)
    public String doCreate(@Valid Offer offer, BindingResult result,
                           Principal principal, @RequestParam(value = "delete", required = false) String delete) {
        if (result.hasErrors()) {
            return "createoffer";
        }

        if(delete == null) {
            log.info(offer.toString());
            String username = "testuser";
            offer.getUser().setUsername(username);
            //offerService.saveOrUpdateOffer(offer);

            return "offercreated";
        }
        else {
            //offerService.delete(offer.getId());

            return "offerdeleted";
        }
    }
}
