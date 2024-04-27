package info.liuyyang.FoodAppDemo.repository;

import info.liuyyang.FoodAppDemo.Recipe;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * RecipeRepositoryV2 interface
 */
@Repository
public interface RecipeRepositoryV2 extends MongoRepository<Recipe, ObjectId> {
    Optional<Recipe> findRecipeByRecipeNo(int recipeNo);

    void deleteByRecipeNo(int recipeNo);
}
