package ru.sber.javaschool.services;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.sber.javaschool.dto.RecipeDto;
import ru.sber.javaschool.entity.Ingredient;
import ru.sber.javaschool.entity.Recipe;
import ru.sber.javaschool.repositories.RecipeRepository;
import ru.sber.javaschool.utils.mapper.RecipeConverter;

import javax.transaction.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final IngredientService ingredientService;
    private RecipeConverter converter;

    @Autowired
    public void setConverter(RecipeConverter converter) {
        this.converter = converter;
    }

    public Optional<Recipe> findById(Long id){
        return recipeRepository.findById(id);
    }

    public Optional<Recipe> findRecipeById(Long id){
        return recipeRepository.findById(id);
    }

    public Page<RecipeDto> findAll(Specification<Recipe> spec, int page, int pageSize){
        return recipeRepository.findAll(spec,PageRequest.of(page - 1, pageSize)).map(converter::convertToRecipeDto);
    }

    @Transactional
    public RecipeDto saveOrUpdate(Recipe recipe){
        Recipe newRecipe = recipeRepository.save(recipe);
        newRecipe.getIngredients().forEach(ingredient -> ingredient.setRecipe(newRecipe));
        return converter.convertToRecipeDto(recipe);
    }

    public void deleteById(Long id){
        recipeRepository.deleteById(id);
    }
}
