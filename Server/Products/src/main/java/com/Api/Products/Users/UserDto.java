package com.Api.Products.Users;

import com.Api.Products.Products.Product;
import com.Api.Products.Products.ProductDto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class UserDto implements Serializable {
    private final Long id;
    private final String userName;
    private final String password;
    private final List<ProductDto> product;

    public UserDto(Long id, String userName, String password, List<ProductDto> product) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public List<ProductDto> getProduct() {
        return product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto entity = (UserDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.userName, entity.userName) &&
                Objects.equals(this.password, entity.password) &&
                Objects.equals(this.product, entity.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, password, product);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + userName + ", " +
                "password = " + password + ", " +
                "product = " + product + ")";
    }
}
