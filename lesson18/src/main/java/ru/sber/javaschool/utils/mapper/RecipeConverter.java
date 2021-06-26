package ru.sber.javaschool.utils.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.sber.javaschool.dto.RecipeDto;
import ru.sber.javaschool.entity.Recipe;

import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class RecipeConverter {
    private final IngredientConverter ingredientConverter;

    public RecipeDto convertToRecipeDto(Recipe recipe){
        return RecipeDto.builder()
                .id(recipe.getId())
                .title(recipe.getTitle())
                .description(recipe.getDescription())
                .ingredients(recipe.getIngredients().stream().map(ingredientConverter::convertToIngredientDto).collect(Collectors.toList()))
                .build();
    }
}