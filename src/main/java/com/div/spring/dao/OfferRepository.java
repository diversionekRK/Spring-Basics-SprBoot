package com.div.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by Div on 2018-05-08.
 */

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

    @Query("SELECT p FROM Offer p WHERE LOWER(p.user.username) = LOWER(:username)")
    public List<Offer> findByUsername(@Param("username") String username);
}
