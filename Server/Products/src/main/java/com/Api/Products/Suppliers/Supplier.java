package com.Api.Products.Suppliers;

import com.Api.Products.Products.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "supplier", schema = "public")
@NamedQueries({
        @NamedQuery(name = "Supplier.findByNameLikeIgnoreCaseOrderByNameAsc", query = "select s from Supplier s where upper(s.name) like upper(:name) order by s.name")
})
public class Supplier {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "country")
    private String country;
    @JsonIgnore
    @OneToMany(mappedBy = "supplier", orphanRemoval = true)
    private Set<Product> products = new LinkedHashSet<>();

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }


    public Supplier() {
    }

    public Supplier(String name, String country, Set<Product> products) {
        this.name = name;
        this.country = country;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


}
