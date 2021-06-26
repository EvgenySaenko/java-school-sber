package ru.sber.javaschool.specifications;


import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.MultiValueMap;
import ru.sber.javaschool.entity.Ingredient;

public class IngredientSpecifications {
    private static Specification<Ingredient> titleLike(String titlePart) {
        return (Specification<Ingredient>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), String.format("%%%s%%", titlePart));
    }

    //MultiValueMap для каждого ключа -  List значений - getFirst()
    public static Specification<Ingredient> build(MultiValueMap<String, String> params) {
        Specification<Ingredient> spec = Specification.where(null);
        if (params.containsKey("title") && !params.getFirst("title").isBlank()) {
            spec = spec.and(IngredientSpecifications.titleLike(params.getFirst("title")));
        }
        return spec;
    }
}
