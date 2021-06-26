package ru.sber.javaschool.specifications;


import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.MultiValueMap;
import ru.sber.javaschool.entity.Recipe;

public class RecipeSpecifications {
    private static Specification<Recipe> titleLike(String titlePart) {
        return (Specification<Recipe>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), String.format("%%%s%%", titlePart));
    }

    //MultiValueMap для каждого ключа -  List значений - getFirst()
    public static Specification<Recipe> build(MultiValueMap<String, String> params) {
        Specification<Recipe> spec = Specification.where(null);
        if (params.containsKey("title") && !params.getFirst("title").isBlank()) {
            spec = spec.and(RecipeSpecifications.titleLike(params.getFirst("title")));
        }
        return spec;
    }
}
