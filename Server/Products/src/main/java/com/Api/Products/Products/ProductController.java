package com.Api.Products.Products;

import com.Api.Products.Prices.PriceReduction;
import com.Api.Products.Prices.PriceReductionRepository;
import com.Api.Products.Suppliers.SuplierRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductRepository productRepository;
    private final PriceReductionRepository priceReductionRepository;

    public ProductController(ProductRepository productRepository, PriceReductionRepository priceReductionRepository) {
        this.productRepository = productRepository;
        this.priceReductionRepository = priceReductionRepository;


    }


    @GetMapping("/products")
    Collection<Product> findAll(){
        return productRepository.findAll();
    }

    @PostMapping("/products")
   public ResponseEntity<Product> newProduct(@RequestBody Product newProduct){
        try {

            productRepository.save(newProduct);
            for (PriceReduction priceReduction : newProduct.getPriceReductions()){
                priceReductionRepository.save(priceReduction);
            }

        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
        }catch (RuntimeException ex) {
            throw new RuntimeException(ex);
        }
    }


    @GetMapping("/products/{id}")
    Product findById(@PathVariable Long id){
        return productRepository.findById(id)
                .orElseThrow(()-> new ProductExceptios(id));
    }

    @PutMapping("/products/{id}")
    Product updateProducto(@RequestBody Product newProduct , @PathVariable Long id){
        return productRepository.findById(id)
                .map(product -> {
                    product = newProduct;
                    product.setPriceReductions(newProduct.getPriceReductions());

                    return productRepository.save(product);
                })
                .orElseGet(()->{
                    return productRepository.save(newProduct);
                });
    }

    @DeleteMapping("/products/{id}")
    void deleteProduct(@PathVariable Long id){
        productRepository.deleteById(id);
    }

}
