package com.Api.Products.Suppliers;

import com.Api.Products.Products.Product;
import com.Api.Products.Products.ProductDto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class SupplierDto implements Serializable {
    private final Long id;
    private final Long name;
    private final String country;
    private final List<ProductDto> products;

    public SupplierDto(Long id, Long name, String country, List<ProductDto> products) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public Long getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SupplierDto entity = (SupplierDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.country, entity.country) &&
                Objects.equals(this.products, entity.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country, products);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "country = " + country + ", " +
                "products = " + products + ")";
    }
}
