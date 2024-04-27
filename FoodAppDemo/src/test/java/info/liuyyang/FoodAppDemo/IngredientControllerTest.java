package info.liuyyang.FoodAppDemo;

import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import info.liuyyang.FoodAppDemo.Ingredient;
import info.liuyyang.FoodAppDemo.IngredientController;
import info.liuyyang.FoodAppDemo.repository.IngredientRepository;
import info.liuyyang.FoodAppDemo.repository.RecipeRepositoryV2;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


/**
 * This class tests the IngredientController class.
 * It tests the getAllIngredients method and the updateIngredient method.
 * The getAllIngredients method tests the GET request to get all ingredients.
 * The updateIngredient method tests the PUT request to update an ingredient.
 * It mocks the IngredientRepository and sets up the expected response.
 * It then performs the GET and PUT requests and asserts the responses.
 * It also verifies the IngredientRepository methods are called.
 * @see IngredientController
 * @see IngredientRepository
 * @see Ingredient
 */
@WebMvcTest(IngredientController.class)
@AutoConfigureMockMvc
public class IngredientControllerTest {

  @Autowired
  private MockMvc mockMvc;

  // Mock the IngredientRepository
  @MockBean
  private IngredientRepository ingredientRepository;

  /**
   * This method tests the GET request to get all ingredients.
   * It mocks the IngredientRepository and sets up the expected response.
   * It then performs the GET request and asserts the response.
   */
  @Test
  public void testGetAllIngredients() throws Exception {
    // Setup
    Ingredient ingredient = new Ingredient();
    ingredient.setName("Salt");
    ingredient.setNumber(1);
    ingredient.setType("Seasoning");
    ingredient.setUnit("tsp");
    ingredient.setGrocery("Aisle 1");

    // Mock the IngredientRepository
    List<Ingredient> ingredients = List.of(ingredient);
    when(ingredientRepository.findAll()).thenReturn(ingredients);

    // Execute & Assert
    mockMvc.perform(get("/bags"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(APPLICATION_JSON))
        .andExpect(jsonPath("$[0].name").value("Salt"))
        .andExpect(jsonPath("$[0].number").value(1))
        .andExpect(jsonPath("$[0].type").value("Seasoning"))
        .andExpect(jsonPath("$[0].unit").value("tsp"))
        .andExpect(jsonPath("$[0].grocery").value("Aisle 1"));

    // Verify
    verify(ingredientRepository, times(1)).findAll();
  }

  /**
   * This method tests the PUT request to update an ingredient.
   * It mocks the IngredientRepository and sets up the expected response.
   * It then performs the PUT request and asserts the response.
   */
  @Test
  public void testUpdateIngredient() throws Exception {
    // Setup
    Ingredient existingIngredient = new Ingredient("Salt", 1);
    when(ingredientRepository.findIngredientByName("Salt")).thenReturn(Optional.of(existingIngredient));
    Ingredient ingredient = new Ingredient("Salt", 2);
    when(ingredientRepository.save(any(Ingredient.class))).thenReturn(ingredient);

    // Execute & Assert
    mockMvc.perform(put("/bags/Salt")
            .contentType(APPLICATION_JSON)
            .content("{\"name\":\"Salt\",\"number\":2}"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name").value("Salt"))
        .andExpect(jsonPath("$.number").value(2));

    // Verify
    verify(ingredientRepository, times(1)).save(any(Ingredient.class));
  }
}
