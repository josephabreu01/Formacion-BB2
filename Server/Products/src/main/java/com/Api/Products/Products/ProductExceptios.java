package com.Api.Products.Products;

public class ProductExceptios extends  RuntimeException{
    public ProductExceptios(Long id){
        super("no se encontro este producto "+ id);
    }
}
