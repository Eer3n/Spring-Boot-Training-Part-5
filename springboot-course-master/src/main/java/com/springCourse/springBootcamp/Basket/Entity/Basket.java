package com.springCourse.springBootcamp.Basket.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.springCourse.springBootcamp.Buyer.Entity.Buyer;
import com.springCourse.springBootcamp.Product.Entity.Product;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SPRING_BASKET", schema = "public")
@Data
public class Basket implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="product_id")
    private Product product;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;

    private String productName;
    private int amount;
    private Boolean isEmpty;

    @Override
    public Basket clone(){
        try{
            Basket clone = (Basket) super.clone();
            return clone;
        } catch (CloneNotSupportedException e){
            throw new AssertionError();
        }
    }



}
