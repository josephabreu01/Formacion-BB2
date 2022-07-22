package com.Api.Products.Products;

import com.Api.Products.Prices.PriceReductionDto;
import com.Api.Products.Suppliers.SupplierDto;
import com.Api.Products.Users.UserDto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ProductDto implements Serializable {
    private final Long id;
    private final String itemCode;
    private final String description;
    private final Integer price;
    private final ProductsEstateEnum estate;
    private final Date createDate;
    private final UserDto creator;
    private final List<SupplierDto> suppliers;
    private final List<PriceReductionDto> priceReductions;

    public ProductDto(Long id, String itemCode, String description, Integer price, ProductsEstateEnum estate, Date createDate, UserDto creator, List<SupplierDto> suppliers, List<PriceReductionDto> priceReductions) {
        this.id = id;
        this.itemCode = itemCode;
        this.description = description;
        this.price = price;
        this.estate = estate;
        this.createDate = createDate;
        this.creator = creator;
        this.suppliers = suppliers;
        this.priceReductions = priceReductions;
    }

    public Long getId() {
        return id;
    }

    public String getItemCode() {
        return itemCode;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPrice() {
        return price;
    }

    public ProductsEstateEnum getEstate() {
        return estate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public UserDto getCreator() {
        return creator;
    }

    public List<SupplierDto> getSuppliers() {
        return suppliers;
    }

    public List<PriceReductionDto> getPriceReductions() {
        return priceReductions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto entity = (ProductDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.itemCode, entity.itemCode) &&
                Objects.equals(this.description, entity.description) &&
                Objects.equals(this.price, entity.price) &&
                Objects.equals(this.estate, entity.estate) &&
                Objects.equals(this.createDate, entity.createDate) &&
                Objects.equals(this.creator, entity.creator) &&
                Objects.equals(this.suppliers, entity.suppliers) &&
                Objects.equals(this.priceReductions, entity.priceReductions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itemCode, description, price, estate, createDate, creator, suppliers, priceReductions);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "itemCode = " + itemCode + ", " +
                "description = " + description + ", " +
                "price = " + price + ", " +
                "estate = " + estate + ", " +
                "createDate = " + createDate + ", " +
                "creator = " + creator + ", " +
                "suppliers = " + suppliers + ", " +
                "priceReductions = " + priceReductions + ")";
    }
}
