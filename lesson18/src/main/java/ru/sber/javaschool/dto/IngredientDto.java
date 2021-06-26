package ru.sber.javaschool.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IngredientDto {
    private Long id;
    private String title;
    private int quantity;
}
