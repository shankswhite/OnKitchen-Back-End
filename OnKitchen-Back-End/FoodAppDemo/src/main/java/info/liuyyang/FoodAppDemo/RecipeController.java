package info.liuyyang.FoodAppDemo;

import info.liuyyang.FoodAppDemo.repository.RecipeRepositoryV2;
import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
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


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/recipes")
public class RecipeController {
  private RecipeRepositoryV2 recipeRepository;
  private static final String DEFAULT_RECIPE_IMAGE = "https://assets.wfcdn.com/im/99076659/resize-h500-w750%5Ecompr-r85/2406/240630936/default_name.jpg";

  public RecipeController(RecipeRepositoryV2 recipeRepository) {
    this.recipeRepository = recipeRepository;
  }

  @GetMapping
  public ResponseEntity<List<Recipe>> getAllRecipes() {
    return new ResponseEntity<List<Recipe>>(recipeRepository.findAll(), HttpStatus.OK);
  }

  @GetMapping("/count")
  public ResponseEntity<Long> getRecipeCount() {
    long count = recipeRepository.count();
    return ResponseEntity.ok(count);
  }

  @GetMapping("/{recipeNo}")
  public ResponseEntity<Recipe> getSingleRecipe(@PathVariable int recipeNo) {
    Optional<Recipe> recipeOptional = recipeRepository.findRecipeByRecipeNo(recipeNo);
    if (recipeOptional.isPresent()) {
      Recipe recipe = recipeOptional.get();
      if (recipe.getRecipePic() == null || recipe.getRecipePic().isEmpty()) {
        recipe.setRecipePic(DEFAULT_RECIPE_IMAGE);
      }
      return new ResponseEntity<Recipe>(recipe, HttpStatus.OK);
    } else {
      Recipe recipe = new Recipe();
      recipe.setRecipePic(DEFAULT_RECIPE_IMAGE);
      recipe.setRecipeNo(recipeNo);
      return new ResponseEntity<Recipe>(recipe, HttpStatus.OK);
    }
  }

  @DeleteMapping("/{recipeNo}")
  public ResponseEntity<Optional<Void>> deleteRecipe(@PathVariable int recipeNo) {
    recipeRepository.deleteByRecipeNo(recipeNo);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/{recipeNo}")
  public ResponseEntity<Recipe> updateRecipe(@PathVariable int recipeNo, @RequestBody Recipe recipe) {
    Optional<Recipe> existingRecipeOpt = recipeRepository.findRecipeByRecipeNo(recipeNo);
    if (existingRecipeOpt.isPresent()) {
        Recipe existingRecipe = existingRecipeOpt.get();

        existingRecipe.setName(recipe.getName() != null ? recipe.getName() : existingRecipe.getName());
        existingRecipe.setCuisine(recipe.getCuisine() != null ? recipe.getCuisine() : existingRecipe.getCuisine());
        existingRecipe.setTags(recipe.getTags() != null ? recipe.getTags() : existingRecipe.getTags());
        existingRecipe.setIngredients(recipe.getIngredients() != null ? recipe.getIngredients() : existingRecipe.getIngredients());
        existingRecipe.setSeasonings(recipe.getSeasonings() != null ? recipe.getSeasonings() : existingRecipe.getSeasonings());
        existingRecipe.setTutorial(recipe.getTutorial() != null ? recipe.getTutorial() : existingRecipe.getTutorial());
        existingRecipe.setRecipePic(recipe.getRecipePic() != null ? recipe.getRecipePic() : existingRecipe.getRecipePic());
        existingRecipe.setRecipeBackground(recipe.getRecipeBackground() != null ? recipe.getRecipeBackground() : existingRecipe.getRecipeBackground());
        existingRecipe.setNumber(recipe.getNumber() != null ? recipe.getNumber() : existingRecipe.getNumber());

        Recipe updatedRecipe = recipeRepository.save(existingRecipe);
        return ResponseEntity.ok(updatedRecipe);
    } else {
        return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/{recipeNo}")
  public ResponseEntity<Optional<Recipe>> createRecipe(@PathVariable int recipeNo, @RequestBody Recipe recipe) {
    recipe.setRecipeNo(recipeNo);
    recipeRepository.save(recipe);
    return new ResponseEntity<Optional<Recipe>>(Optional.of(recipe), HttpStatus.OK);
  }
}
