package info.liuyyang.FoodAppDemo;

import info.liuyyang.FoodAppDemo.Ingredient;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 * IngredientTest.java
 * This file contains the test cases for the Ingredient class.
 * The test cases include testing the getter and setter methods
 * for the Ingredient class.
 */
public class IngredientTest {

  Ingredient steak;
  Ingredient carrot;

  @BeforeEach
  void setUp() {
    steak = new Ingredient("beefSteak", "meet", "pound", 5, "grocery");
    carrot = new Ingredient("carrot", "vegetable", "kg", 3, "grocery");
  }

  /**
   * Test the getter for the Ingredient number
   */
  @Test
  void getNumber() {
    assert steak.getNumber() == 5;
    assert carrot.getNumber() == 3;
  }

  /**
   * Test the setter for the Ingredient number
   */
  @Test
  void setNumber() {
    steak.setNumber(10);
    carrot.setNumber(10);
    assert steak.getNumber() == 10;
    assert carrot.getNumber() == 10;
  }

  /**
   * Test the getter for the Ingredient id
   */
  @Test
  void getId() {
    assertNull(steak.getId());
    assertNull(carrot.getId());
  }

  /**
   * Test the setter for the Ingredient id
   */
  @Test
  void setId() {
    steak.setId(new ObjectId("5f7b1b3b1d1f3b1d1f3b1d1f"));
    carrot.setId(new ObjectId("2d3b1d1f3b1d1f3b1d1f3b5a"));
    assertEquals(new ObjectId("5f7b1b3b1d1f3b1d1f3b1d1f"), steak.getId());
    assertEquals(new ObjectId("2d3b1d1f3b1d1f3b1d1f3b5a"), carrot.getId());
  }

  /**
   * Test the getter for the Ingredient name
   */
  @Test
  void getName() {
    assertEquals("beefSteak", steak.getName());
    assertEquals("carrot", carrot.getName());
  }

  /**
   * Test the setter for the Ingredient name
   */
  @Test
  void setName() {
    steak.setName("chicken");
    assertEquals("chicken", steak.getName());
    carrot.setName("potato");
    assertEquals("potato", carrot.getName());
  }

  /**
   * Test the getter for the Ingredient type
   */
  @Test
  void getType() {
    assertEquals("meet", steak.getType());
    assertEquals("vegetable", carrot.getType());
  }

  /**
   * Test the setter for the Ingredient type
   */
  @Test
  void setType() {
    steak.setType("vegetable");
    assertEquals("vegetable", steak.getType());
    carrot.setType("meet");
    assertEquals("meet", carrot.getType());
  }

  /**
   * Test the getter for the Ingredient unit
   */
  @Test
  void getUnit() {
    assertEquals("pound", steak.getUnit());
    assertEquals("kg", carrot.getUnit());
  }

  /**
   * Test the setter for the Ingredient unit
   */
  @Test
  void setUnit() {
    steak.setUnit("ounce");
    assertEquals("ounce", steak.getUnit());
    carrot.setUnit("g");
    assertEquals("g", carrot.getUnit());
  }

  /**
   * Test the getter for the Ingredient grocery
   */
  @Test
  void getGrocery() {
    assertEquals("grocery", steak.getGrocery());
    assertEquals("grocery", carrot.getGrocery());
  }

  /**
   * Test the setter for the Ingredient grocery
   */
  @Test
  void setGrocery() {
    steak.setGrocery("market");
    assertEquals("market", steak.getGrocery());
    carrot.setGrocery("store");
    assertEquals("store", carrot.getGrocery());
  }
}
