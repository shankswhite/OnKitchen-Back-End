package info.liuyyang.FoodAppDemo;

import info.liuyyang.FoodAppDemo.repository.IngredientRepository;
import info.liuyyang.FoodAppDemo.repository.RecipeRepositoryV2;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * IngredientController class
 * This class is used to handle the requests related to the ingredients.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/bags")
public class IngredientController {
  private IngredientRepository ingredientRepository;

  /**
   * Constructor
   * @param ingredientRepository the ingredient repository
   */
  public IngredientController(IngredientRepository ingredientRepository) {
    this.ingredientRepository = ingredientRepository;
  }

  /**
   * Get all the ingredients
   * @return the list of all the ingredients
   */
  @GetMapping
  public ResponseEntity<List<Ingredient>> getAllIngredients() {
    Predicate<? super Ingredient> predicate =
        ingredient -> ingredient.getNumber() > 0;
    return new ResponseEntity<List<Ingredient>>(ingredientRepository.findAll().stream().filter(predicate).toList(), HttpStatus.OK);
  }

  /**
   * Get the count of the ingredients
   * @param name the name of the ingredient
   * @param ingredient the ingredient
   * @return the count of the ingredients
   */
  @PutMapping
  public ResponseEntity<Optional<Ingredient>> updateRecipe(@PathVariable String name, @RequestBody Ingredient ingredient) {
    ingredientRepository.save(ingredient);
    return new ResponseEntity<Optional<Ingredient>>(Optional.of(ingredient), HttpStatus.OK);
  }
}
