package com.Api.Products.Prices;

import com.Api.Products.Users.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "pricereduction")
public class PriceReduction {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "price")
    private Integer price ;

    @Column(name = "stardate")
    private Date starDate;

    @Column(name = "enddate")
    private Date endDate;

    @Column(name = "product_id")
    private Long product_id;

    @JsonIgnore
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private User user;





    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PriceReduction() {
    }

    public PriceReduction(Integer price, Date starDate, Date endDate, Long product_id) {
        this.price = price;
        this.starDate = starDate;
        this.endDate = endDate;
        this.product_id = product_id;
    }


    public Long getId() {
        return id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getStarDate() {
        return starDate;
    }

    public void setStarDate(Date starDate) {
        this.starDate = starDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }
}
