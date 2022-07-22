package com.Api.Products.Prices;

import com.Api.Products.Prices.PriceReduction;
import com.Api.Products.Prices.PriceReductionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class PriceReductionControllers {
    private final PriceReductionRepository priceReductionRepository;

    public PriceReductionControllers(PriceReductionRepository priceReductionRepository) {
        this.priceReductionRepository = priceReductionRepository;
    }

    @GetMapping("/priceReductions")
    List<PriceReduction> findAll(){
        return priceReductionRepository.findAll();
    }

    @PostMapping("/priceReductions")
    PriceReduction newPriceReduction(@RequestBody PriceReduction newPriceReduction){
        try {
            return priceReductionRepository.save(newPriceReduction);

        }catch (RuntimeException ex) {
            throw new RuntimeException(ex);
        }
    }

    @GetMapping("/priceReductions/{id}")
    PriceReduction findById(@PathVariable Long id){
        return priceReductionRepository.findById(id)
                .orElseThrow(()-> new RuntimeException());
    }

    @PutMapping("/priceReductions/{id}")
    PriceReduction updatePriceReductiono(@RequestBody PriceReduction newPriceReduction , @PathVariable Long id){
        return priceReductionRepository.findById(id)
                .map(priceReduction -> {
                    priceReduction = newPriceReduction;
                    return priceReductionRepository.save(priceReduction);
                })
                .orElseGet(()->{
                    return priceReductionRepository.save(newPriceReduction);
                });
    }

    @DeleteMapping("/priceReductions/{id}")
    void deletePriceReduction(@PathVariable Long id){
        priceReductionRepository.deleteById(id);
    }

}
