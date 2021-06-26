package ru.sber.javaschool.dto;

import lombok.*;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecipeDto {
    private Long id;
    private String title;
    private String description;
    private List<IngredientDto> ingredients;
}
