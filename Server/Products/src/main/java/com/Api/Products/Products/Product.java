package com.Api.Products.Products;


import com.Api.Products.Prices.PriceReduction;
import com.Api.Products.Suppliers.Supplier;
import com.Api.Products.Users.User;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(name = "itemcode",unique = true)
    private String itemCode;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Integer price;
    @Enumerated
    @Column(name = "estate")
    private ProductsEstateEnum estate;
    @Column(name ="createdate")
    private Date createDate;



    @OneToMany
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Set<PriceReduction> priceReductions = new java.util.LinkedHashSet<>();

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User creator;




    public Product() {
    }

    public Product(String itemCode, String description, Integer price, ProductsEstateEnum estate, Date createDate, User creator,
                   Supplier suppliers,
                   Set<PriceReduction> priceReductions) {
        this.itemCode = itemCode;
        this.description = description;
        this.price = price;
        this.estate = estate;
        this.createDate = createDate;
        this.creator = creator;
        this.supplier = suppliers;
        this.priceReductions = priceReductions;
    }

    public Long getId() {
        return id;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public ProductsEstateEnum getEstate() {
        return estate;
    }

    public void setEstate(ProductsEstateEnum estate) {
        this.estate = estate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }


    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }



    public Set<PriceReduction> getPriceReductions() {
        return priceReductions;
    }

    public void setPriceReductions(Set<PriceReduction> priceReductions) {
        this.priceReductions = priceReductions;
    }
}
