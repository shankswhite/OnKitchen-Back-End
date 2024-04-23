package info.liuyyang.FoodAppDemo.repository;

import info.liuyyang.FoodAppDemo.Ingredient;
import info.liuyyang.FoodAppDemo.Recipe;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends MongoRepository<Ingredient, ObjectId> {
}
