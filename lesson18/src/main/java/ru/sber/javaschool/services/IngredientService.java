package ru.sber.javaschool.services;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.sber.javaschool.dto.IngredientDto;
import ru.sber.javaschool.entity.Ingredient;
import ru.sber.javaschool.repositories.IngredientRepository;
import ru.sber.javaschool.utils.mapper.IngredientConverter;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IngredientService {
    private final IngredientConverter converter;
    private final IngredientRepository ingredientRepository;

    public Optional<Ingredient> findIngredientById(Long id){
        return ingredientRepository.findById(id);
    }

    public Optional<IngredientDto> findIngredientDtoById(Long id){
        return ingredientRepository.findById(id).map(converter::convertToIngredientDto);
    }

    public Page<IngredientDto> findAllIngredients(Specification<Ingredient> spec, int page, int pageSize){
        //PageRequest.of(так создается Pageable)
        //мы не достаем из базы все продукты а достаем только те что нужны для отображения на странице(например 5 штук)
        Page<Ingredient> originalPage = ingredientRepository.findAll(spec,PageRequest.of(page - 1, pageSize));
        return originalPage.map(converter::convertToIngredientDto);
    }

    public Ingredient saveOrUpdate(Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }

    public void deleteById(Long id){
        ingredientRepository.deleteById(id);
    }
}
