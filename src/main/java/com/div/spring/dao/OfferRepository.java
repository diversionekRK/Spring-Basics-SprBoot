package com.div.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by Div on 2018-05-08.
 */

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

}
