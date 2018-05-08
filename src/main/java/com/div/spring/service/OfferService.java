package com.div.spring.service;

import com.div.spring.dao.Offer;
import com.div.spring.dao.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Div on 2018-05-08.
 */

@Service
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;

    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public List<Offer> getOffers() {
        return offerRepository.findAll();
    }
}
