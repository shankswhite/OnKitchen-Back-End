package info.liuyyang.FoodAppDemo;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import info.liuyyang.FoodAppDemo.Recipe;
import info.liuyyang.FoodAppDemo.RecipeController;
import info.liuyyang.FoodAppDemo.repository.RecipeRepositoryV2;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


/**
 * This class tests the RecipeController class.
 * It mocks the RecipeRepositoryV2 and sets up the expected response.
 * It tests the getAllRecipes, getRecipeCount, getSingleRecipe, deleteRecipe, updateRecipe, and createRecipe methods.
 * It then performs the GET, POST, PUT, and DELETE requests and asserts the responses.
 * It also verifies the RecipeRepositoryV2 methods are called.
 * @see RecipeController
 * @see RecipeRepositoryV2
 * @see Recipe
 */
@WebMvcTest(RecipeController.class)
@AutoConfigureMockMvc
// @SpringBootTest(classes = RecipeController.class)
public class RecipeControllerTest {

  // Mock the RecipeRepositoryV2
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private RecipeRepositoryV2 recipeRepository;

  /**
   * This method tests the GET request to get all recipes.
   * It mocks the RecipeRepositoryV2 and sets up the expected response.
   * It then performs the GET request and asserts the response.
   */
  @Test
  public void getAllRecipesTest() throws Exception {
    // Arrange
    Recipe recipe = new Recipe();
    recipe.setName("Pasta");
    recipe.setRecipeNo(1);
    recipe.setRecipePic("pasta.jpg");
    recipe.setRecipeBackground(List.of("pasta_bg.jpg"));
    recipe.setIngredients((Map<String, Integer>) Map.of("Noodle", 1));
    recipe.setCuisine("Italian");
    recipe.setSeasonings(List.of("Salt", "Pepper"));
    recipe.setTags(List.of("Easy", "Quick"));
    recipe.setTutorial("https://www.youtube.com/watch?v=1234");
    recipe.setNumber(2);

    // Mock the RecipeRepositoryV2
    when(recipeRepository.findAll()).thenReturn(List.of(recipe));

    // Act & Assert
    mockMvc.perform(get("/recipes"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(APPLICATION_JSON))
        .andExpect(jsonPath("$[0].name").value("Pasta"))
        .andExpect(jsonPath("$[0].recipeNo").value(1))
        .andExpect(jsonPath("$[0].recipePic").value("pasta.jpg"))
        .andExpect(jsonPath("$[0].recipeBackground[0]").value("pasta_bg.jpg"))
        .andExpect(jsonPath("$[0].ingredients.Noodle").value(1))
        .andExpect(jsonPath("$[0].cuisine").value("Italian"))
        .andExpect(jsonPath("$[0].seasonings[0]").value("Salt"))
        .andExpect(jsonPath("$[0].seasonings[1]").value("Pepper"))
        .andExpect(jsonPath("$[0].tags[0]").value("Easy"))
        .andExpect(jsonPath("$[0].tags[1]").value("Quick"))
        .andExpect(jsonPath("$[0].tutorial").value("https://www.youtube.com/watch?v=1234"))
        .andExpect(jsonPath("$[0].number").value(2));

    verify(recipeRepository, times(1)).findAll();
  }

  /**
   * This method tests the GET request to get the recipe count.
   * It mocks the RecipeRepositoryV2 and sets up the expected response.
   * It then performs the GET request and asserts the response.
   */
  @Test
  public void getRecipeCountTest() throws Exception {
    // Arrange
    when(recipeRepository.count()).thenReturn(10L);

    // Act & Assert
    mockMvc.perform(get("/recipes/count"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(APPLICATION_JSON))
        .andExpect(content().string("10"));

    verify(recipeRepository, times(1)).count();
  }

  /**
   * This method tests the GET request to get a single recipe.
   * It mocks the RecipeRepositoryV2 and sets up the expected response.
   * It then performs the GET request and asserts the response.
   */
  @Test
  public void getSingleRecipeTest() throws Exception {
    Recipe recipe = new Recipe();
    recipe.setName("Pasta");
    recipe.setRecipeNo(1);
    recipe.setRecipePic("pasta.jpg");
    recipe.setRecipeBackground(List.of("pasta_bg.jpg"));
    recipe.setIngredients((Map<String, Integer>) Map.of("Noodle", 1));
    recipe.setCuisine("Italian");
    recipe.setSeasonings(List.of("Salt", "Pepper"));
    recipe.setTags(List.of("Easy", "Quick"));
    recipe.setTutorial("https://www.youtube.com/watch?v=1234");
    recipe.setNumber(2);

    // Arrange
    when(recipeRepository.findRecipeByRecipeNo(1)).thenReturn(Optional.of(recipe));

    // Act & Assert
    mockMvc.perform(get("/recipes/1"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(APPLICATION_JSON))
        .andExpect(jsonPath("$.name").value("Pasta"))
        .andExpect(jsonPath("$.recipeNo").value(1))
        .andExpect(jsonPath("$.recipePic").value("pasta.jpg"))
        .andExpect(jsonPath("$.recipeBackground[0]").value("pasta_bg.jpg"))
        .andExpect(jsonPath("$.ingredients.Noodle").value(1))
        .andExpect(jsonPath("$.cuisine").value("Italian"))
        .andExpect(jsonPath("$.seasonings[0]").value("Salt"))
        .andExpect(jsonPath("$.seasonings[1]").value("Pepper"))
        .andExpect(jsonPath("$.tags[0]").value("Easy"))
        .andExpect(jsonPath("$.tags[1]").value("Quick"))
        .andExpect(jsonPath("$.tutorial").value("https://www.youtube.com/watch?v=1234"))
        .andExpect(jsonPath("$.number").value(2));

    verify(recipeRepository, times(1)).findRecipeByRecipeNo(1);
  }

  /**
   * This method tests the DELETE request to delete a recipe.
   * It mocks the RecipeRepositoryV2 and sets up the expected response.
   * It then performs the DELETE request and asserts the response.
   */
  @Test
  public void deleteRecipeTest() throws Exception {
    // Arrange
    doNothing().when(recipeRepository).deleteByRecipeNo(1);

    // Act & Assert
    mockMvc.perform(delete("/recipes/1"))
        .andExpect(status().isNoContent());

    verify(recipeRepository, times(1)).deleteByRecipeNo(1);
  }

  /**
   * This method tests the PUT request to update a recipe.
   * It mocks the RecipeRepositoryV2 and sets up the expected response.
   * It then performs the PUT request and asserts the response.
   */
  @Test
  public void updateRecipeTest() throws Exception {
    // Arrange
    Recipe existingRecipe = new Recipe(1, "Pasta");
    Recipe updatedRecipe = new Recipe(1, "Updated Pasta");
    when(recipeRepository.findRecipeByRecipeNo(1)).thenReturn(Optional.of(existingRecipe));
    when(recipeRepository.save(any(Recipe.class))).thenReturn(updatedRecipe);

    // Act & Assert
    mockMvc.perform(put("/recipes/1")
            .contentType(APPLICATION_JSON)
            .content("{\"name\":\"Updated Pasta\"}"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(APPLICATION_JSON))
        .andExpect(jsonPath("$.name").value("Updated Pasta"));

    verify(recipeRepository, times(1)).findRecipeByRecipeNo(1);
  }

  /**
   * This method tests the POST request to create a recipe.
   * It mocks the RecipeRepositoryV2 and sets up the expected response.
   * It then performs the POST request and asserts the response.
   */
  @Test
  public void createRecipeTest() throws Exception {
    // Arrange
    Recipe newRecipe = new Recipe(1, "Pasta");
    when(recipeRepository.save(any(Recipe.class))).thenReturn(newRecipe);

    // Act & Assert
    mockMvc.perform(post("/recipes/1")
            .contentType(APPLICATION_JSON)
            .content("{\"name\":\"Pasta\"}"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(APPLICATION_JSON))
        .andExpect(jsonPath("$.name").value("Pasta"))
        .andExpect(jsonPath("$.recipeNo").value(1));

    verify(recipeRepository, times(1)).save(any(Recipe.class));
  }
}
