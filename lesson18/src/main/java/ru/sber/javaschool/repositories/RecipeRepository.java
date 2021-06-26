package ru.sber.javaschool.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.sber.javaschool.entity.Recipe;


@Repository
public interface RecipeRepository extends JpaRepository<Recipe,Long>, JpaSpecificationExecutor<Recipe> {
}
