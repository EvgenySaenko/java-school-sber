package ru.sber.javaschool.utils.mapper;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.sber.javaschool.dto.IngredientDto;
import ru.sber.javaschool.entity.Ingredient;


@Component
@RequiredArgsConstructor
public class IngredientConverter {

    public IngredientDto convertToIngredientDto(Ingredient ingredient){
        return IngredientDto.builder()
                .id(ingredient.getId())
                .title(ingredient.getTitle())
                .quantity(ingredient.getQuantity())
        .build();
    }
}
