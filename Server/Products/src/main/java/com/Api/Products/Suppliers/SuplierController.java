package com.Api.Products.Suppliers;

import com.Api.Products.Products.ProductExceptios;
import com.Api.Products.Suppliers.Supplier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class SuplierController {
private final SuplierRepository suplierRepository;

    public SuplierController(SuplierRepository suplierRepository) {
        this.suplierRepository = suplierRepository;
    }

    @GetMapping("/suppliers")
    List<Supplier> findAll(){
        return suplierRepository.findAll();
    }

    @PostMapping("/suppliers")
    Supplier newSupplier(@RequestBody Supplier newSupplier){
        try {
            return suplierRepository.save(newSupplier);

        }catch (RuntimeException ex) {
            throw new RuntimeException(ex);
        }
    }


    @GetMapping("/suppliers/{id}")
    Supplier findById(@PathVariable Long id){
        return suplierRepository.findById(id)
                .orElseThrow(()-> new ProductExceptios(id));
    }

    @PutMapping("/suppliers/{id}")
    Supplier updateSupplier(@RequestBody Supplier newSupplier , @PathVariable Long id){
        return suplierRepository.findById(id)
                .map(supplier  -> {
                     supplier =newSupplier ;
                    return suplierRepository.save(supplier);
                })
                .orElseGet(()->{
                    return suplierRepository.save(newSupplier);
                });
    }

    @DeleteMapping("/suppliers/{id}")
    void deleteSupplier(@PathVariable Long id){
        suplierRepository.deleteById(id);
    }
}
