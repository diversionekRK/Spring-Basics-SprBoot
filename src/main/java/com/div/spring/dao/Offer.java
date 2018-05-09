package com.div.spring.dao;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by Div on 2018-05-08.
 */

@Data
@Entity
@Table(name = "offers")
public class Offer {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Size(min = 20, max = 255, message = "Text must be between 20 and 255 characters")
    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    public Offer() {
        this.user = new User();
    }
}
