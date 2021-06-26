package ru.sber.javaschool.controllers;



import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import ru.sber.javaschool.dto.IngredientDto;
import ru.sber.javaschool.entity.Ingredient;
import ru.sber.javaschool.exceptions.ResourceNotFoundException;
import ru.sber.javaschool.services.IngredientService;
import ru.sber.javaschool.specifications.IngredientSpecifications;


@RestController
@RequestMapping("/api/v1/ingredients")
@RequiredArgsConstructor
public class IngredientController {
    private final IngredientService ingredientService;

    @GetMapping
    public Page<IngredientDto> findAllIngredients(
            @RequestParam MultiValueMap<String, String> params,
            @RequestParam(name = "p", defaultValue = "1") Integer page
    ) {
        if (page < 1) {
            page = 1;
        }
        return ingredientService.findAllIngredients(IngredientSpecifications.build(params), page, 5);
    }

    @GetMapping("/{id}")
    public IngredientDto findIngredientById(@PathVariable Long id){
        return ingredientService.findIngredientDtoById(id).orElseThrow(()-> new ResourceNotFoundException("Ingredient with id: " + id + " does not exist"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ingredient saveNewIngredient(@RequestBody Ingredient ingredient){
        ingredient.setId(null);
        return ingredientService.saveOrUpdate(ingredient);
    }

    @PutMapping
    public Ingredient updateIngredient(@RequestBody Ingredient ingredient){
        return ingredientService.saveOrUpdate(ingredient);
    }

    @DeleteMapping("/{id}")
    public void deleteIngredient(@PathVariable Long id) {
        ingredientService.deleteById(id);
    }
}
