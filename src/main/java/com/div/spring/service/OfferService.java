package com.div.spring.service;

import com.div.spring.SpringbootApplication;
import com.div.spring.dao.Offer;
import com.div.spring.dao.OfferRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Div on 2018-05-08.
 */

@Service
public class OfferService {

    private static final Logger log = LoggerFactory.getLogger(SpringbootApplication.class);

    @Autowired
    private OfferRepository offerRepository;

    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public List<Offer> getOffers() {
        return offerRepository.findAll();
    }

    public boolean hasOffer(String username) {
        if (username == null)
            return false;

        if(offerRepository.findByUsername(username).isEmpty())
            return false;
        return true;
    }
}
