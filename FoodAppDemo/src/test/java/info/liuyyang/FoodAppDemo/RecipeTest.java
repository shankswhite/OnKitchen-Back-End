package info.liuyyang.FoodAppDemo;

import static org.junit.jupiter.api.Assertions.*;

import info.liuyyang.FoodAppDemo.Recipe;
import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * RecipeTest.java
 * tests for Recipe.java
 * This class tests the Recipe class.
 * It tests the getters and setters for all the fields in the Recipe class.
 */
class RecipeTest {

  Recipe recipe;
  Recipe recipe2;

  @BeforeEach
  void setUp() {
    recipe = new Recipe();
    recipe2 = new Recipe();
  }

  /**
   * Test the getter and setter for the Recipe number
   */
  @Test
  void testNumber() {
    recipe.setNumber(5);
    assertEquals(5, recipe.getNumber());
    recipe2.setNumber(10);
    assertEquals(10, recipe2.getNumber());
  }

  /**
   * Test the getter and setter for the Recipe id
   */
  @Test
  void testId() {
    recipe.setId(null);
    assertNull(recipe.getId());
    recipe2.setId(null);
    assertNull(recipe2.getId());
  }

  /**
   * Test the getter and setter for the Recipe name
   */
  @Test
  void testName() {
    recipe.setName("beefSteak");
    assertEquals("beefSteak", recipe.getName());
    recipe2.setName("chicken");
    assertEquals("chicken", recipe2.getName());
  }

  /**
   * Test the getter and setter for the Recipe picture
   */
  @Test
  void testRecipePic() {
    recipe.setRecipePic("beefSteak.jpg");
    assertEquals("beefSteak.jpg", recipe.getRecipePic());
    recipe2.setRecipePic("chicken.jpg");
    assertEquals("chicken.jpg", recipe2.getRecipePic());
  }

  /**
   * Test the getter and setter for the Recipe background
   */
  @Test
  void testRecipeBackground() {
    recipe.setRecipeBackground(Collections.singletonList("beefSteak.jpg"));
    assertEquals(Collections.singletonList("beefSteak.jpg"), recipe.getRecipeBackground());
    recipe2.setRecipeBackground(Collections.singletonList("chicken.jpg"));
    assertEquals(Collections.singletonList("chicken.jpg"), recipe2.getRecipeBackground());
  }

  /**
   * Test the getter and setter for the Recipe number
   */
  @Test
  void testRecipeNo() {
    recipe.setRecipeNo(1);
    assertEquals(1, recipe.getRecipeNo());
    recipe2.setRecipeNo(2);
    assertEquals(2, recipe2.getRecipeNo());
  }

  /**
   * Test the getter and setter for the Recipe cuisine
   */
  @Test
  void testCuisine() {
    recipe.setCuisine("American");
    assertEquals("American", recipe.getCuisine());
    recipe2.setCuisine("Chinese");
    assertEquals("Chinese", recipe2.getCuisine());
  }

  /**
   * Test the getter and setter for the Recipe tags
   */
  @Test
  void testTags() {
    recipe.setTags(Collections.singletonList("spicy"));
    assertEquals(Collections.singletonList("spicy"), recipe.getTags());
    recipe2.setTags(Collections.singletonList("sweet"));
    assertEquals(Collections.singletonList("sweet"), recipe2.getTags());
  }

  /**
   * Test the getter and setter for the Recipe ingredients
   */
  @Test
  void testIngredients() {
    recipe.setIngredients(Collections.singletonMap("beef", 5));
    assertEquals(Collections.singletonMap("beef", 5), recipe.getIngredients());
    recipe2.setIngredients(Collections.singletonMap("chicken", 10));
    assertEquals(Collections.singletonMap("chicken", 10), recipe2.getIngredients());
  }

  /**
   * Test the getter and setter for the Recipe seasonings
   */
  @Test
  void testSeasonings() {
    recipe.setSeasonings(Collections.singletonList("salt"));
    assertEquals(Collections.singletonList("salt"), recipe.getSeasonings());
    recipe2.setSeasonings(Collections.singletonList("sugar"));
    assertEquals(Collections.singletonList("sugar"), recipe2.getSeasonings());
  }

  /**
   * Test the getter and setter for the Recipe tutorial
   */
  @Test
  void testTutorial() {
    recipe.setTutorial("cook beef steak");
    assertEquals("cook beef steak", recipe.getTutorial());
    recipe2.setTutorial("cook chicken");
    assertEquals("cook chicken", recipe2.getTutorial());
  }
}