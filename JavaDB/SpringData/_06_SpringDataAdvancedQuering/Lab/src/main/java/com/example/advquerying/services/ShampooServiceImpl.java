package com.example.advquerying.services;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import com.example.advquerying.repositories.ShampooRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Service
public class ShampooServiceImpl implements ShampooService {

    private  final ShampooRepository shampooRepository;

    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }

    @Override
    public List<Shampoo> findAllBySizeOrderById(Size size) {
        return shampooRepository.findAllBySizeOrderById(size);
    }

    @Override
    public List<Shampoo> findAllBySizeOrLabel_IdOrderByPrice(Size size, Long labelId) {
        return shampooRepository.findAllBySizeOrLabel_IdOrderByPrice(size, labelId);
    }

    @Override
    public List<Shampoo> findAllByPriceGreaterThanOrderByPriceDesc(BigDecimal price) {
        return shampooRepository.findAllByPriceGreaterThanOrderByPriceDesc(price);
    }

    @Override
    public Integer findAllByPriceLessThanCount(BigDecimal price) {
        return shampooRepository
                .findAllByPriceLessThan(price).size();
    }

    @Override
    public List<Shampoo> findAllByIngredientsIncluded(List<String> names) {
        return shampooRepository.findAllByIngredientsIncluded(names);
    }

    @Override
    public List<Shampoo> findAllByTheNumberOfIngredientsLessThan(int number) {
        return shampooRepository
                .findAllByTheNumberOfIngredientsLessThan(number);
    }
}
