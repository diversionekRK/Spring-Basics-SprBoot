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

        if (principal != null) {
            String username = principal.getName();
            offer = offerService.getOffer(username);
            if (offer != null)
                log.info(offer.toString());
        }

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

        String username = principal.getName();
        offer.getUser().setUsername(username);
        if (delete == null) {
            log.info("Save or update: " + offer.toString());
            offerService.saveOrUpdateOffer(offer);
            return "offercreated";
        } else {
            log.info("Delete: " + offer.toString());
            offerService.deleteOffer(offer);
            return "offerdeleted";
        }
    }
}
