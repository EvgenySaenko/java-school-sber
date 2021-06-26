package ru.sber.javaschool.controllers;



import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import ru.sber.javaschool.dto.RecipeDto;
import ru.sber.javaschool.entity.Recipe;
import ru.sber.javaschool.exceptions.ResourceNotFoundException;
import ru.sber.javaschool.services.RecipeService;
import ru.sber.javaschool.specifications.RecipeSpecifications;
import ru.sber.javaschool.utils.mapper.RecipeConverter;

@RestController
@RequestMapping("/api/v1/recipes")
@RequiredArgsConstructor
public class RecipeController {
    private  RecipeService recipeService;
    private final RecipeConverter recipeConverter;

    @Autowired
    public void setRecipeService(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public Page<RecipeDto> findAllRecipes(
            @RequestParam MultiValueMap<String, String> params,
            @RequestParam(name = "p", defaultValue = "1") Integer page
    ) {
        if (page < 1) {
            page = 1;
        }
        return recipeService.findAll(RecipeSpecifications.build(params), page, 5);
    }

    @GetMapping("/{id}")
    public RecipeDto findRecipeById(@PathVariable Long id){
        return recipeService.findById(id).map(recipeConverter::convertToRecipeDto).orElseThrow(()-> new ResourceNotFoundException("Recipe with id: " + id + " does not exist"));
    }

    @PostMapping("new_recipe")
    @ResponseStatus(HttpStatus.CREATED)
    public RecipeDto saveNewRecipe(@RequestBody Recipe recipe){
        recipe.setId(null);
        return recipeService.saveOrUpdate(recipe);
    }

    @PutMapping
    public RecipeDto updateRecipe(@RequestBody Recipe recipe){
        return recipeService.saveOrUpdate(recipe);
    }

    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable Long id) {
        recipeService.deleteById(id);
    }
}
