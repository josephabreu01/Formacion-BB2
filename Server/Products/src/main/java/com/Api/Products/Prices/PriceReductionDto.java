package com.Api.Products.Prices;

import com.Api.Products.Products.ProductDto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class PriceReductionDto implements Serializable {
    private final Long id;
    private final Integer price;
    private final Date starDate;
    private final Date endDate;
    private final ProductDto product;

    public PriceReductionDto(Long id, Integer price, Date starDate, Date endDate, ProductDto product) {
        this.id = id;
        this.price = price;
        this.starDate = starDate;
        this.endDate = endDate;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public Integer getPrice() {
        return price;
    }

    public Date getStarDate() {
        return starDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public ProductDto getProduct() {
        return product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceReductionDto entity = (PriceReductionDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.price, entity.price) &&
                Objects.equals(this.starDate, entity.starDate) &&
                Objects.equals(this.endDate, entity.endDate) &&
                Objects.equals(this.product, entity.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, starDate, endDate, product);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "price = " + price + ", " +
                "starDate = " + starDate + ", " +
                "endDate = " + endDate + ", " +
                "product = " + product + ")";
    }
}
