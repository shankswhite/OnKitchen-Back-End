package info.liuyyang.FoodAppDemo;

import java.util.List;
import java.util.Map;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Recipe class
 * This class is used to store the recipe information.
 * It contains the following fields:
 * - id: the id of the recipe
 * - name: the name of the recipe
 * - recipePic: the picture of the recipe
 * - recipeBackground: the background information of the recipe
 * - recipeNo: the number of the recipe
 * - cuisine: the cuisine of the recipe
 * - tags: the tags of the recipe
 * - ingredients: the ingredients of the recipe
 * - seasonings: the seasonings of the recipe
 * - tutorial: the tutorial of the recipe
 */
@Document(collection = "recipes-v2")
public class Recipe {
  @Id
  private ObjectId id;
  private String name;
  private String recipePic;
  private List<String> recipeBackground;
  private Integer recipeNo;
  private String cuisine;
  private List<String> tags;
  private Map<String, Integer> ingredients;
  private List<String> seasonings;
  private String tutorial;
  private Integer number;

  /**
   * Constructor
   * @param number
   * @param name
   * This constructor is used to create a recipe object with the number and name.
   * The number is the number of the recipe, and the name is the name of the recipe.
   * The other fields are set to null.
   */
  public Recipe(Integer number, String name) {
    this.name = name;
    this.number = number;
  }

  /**
   * Constructor
   * @param id, name, recipePic, recipeBackground, recipeNo, cuisine, tags, ingredients, seasonings, tutorial
   * This constructor is used to create a recipe object with all the fields.
   */
  public Recipe(ObjectId id, String name, String recipePic, List<String> recipeBackground,
      Integer recipeNo, String cuisine, List<String> tags, Map<String, Integer> ingredients,
      List<String> seasonings, String tutorial, Integer number) {
    this.id = id;
    this.name = name;
    this.recipePic = recipePic;
    this.recipeBackground = recipeBackground;
    this.recipeNo = recipeNo;
    this.cuisine = cuisine;
    this.tags = tags;
    this.ingredients = ingredients;
    this.seasonings = seasonings;
    this.tutorial = tutorial;
    this.number = number;
  }

  /**
   * Get the number of the recipe
   * @return the number of the recipe
   */
  public Integer getNumber() {
    return number;
  }

  /**
   * Set the number of the recipe
   * @param number the number of the recipe
   */
  public void setNumber(Integer number) {
    this.number = number;
  }

  /**
   * Constructor
   */
  public Recipe() {
  }

  /**
   * Get the id of the recipe
   * @return the id of the recipe
   */
  public ObjectId getId() {
    return id;
  }

  /**
   * Set the id of the recipe
   * @param id the id of the recipe
   */
  public void setId(ObjectId id) {
    this.id = id;
  }

  /**
   * Get the name of the recipe
   * @return the name of the recipe
   */
  public String getName() {
    return name;
  }

  /**
   * Set the name of the recipe
   * @param name the name of the recipe
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Get the picture of the recipe
   * @return the picture of the recipe
   */
  public String getRecipePic() {
    return recipePic;
  }

  /**
   * Set the picture of the recipe
   * @param recipePic the picture of the recipe
   */
  public void setRecipePic(String recipePic) {
    this.recipePic = recipePic;
  }

  /**
   * Get the background information of the recipe
   * @return the background information of the recipe
   */
  public List<String> getRecipeBackground() {
    return recipeBackground;
  }

  /**
   * Set the background information of the recipe
   * @param recipeBackground the background information of the recipe
   */
  public void setRecipeBackground(List<String> recipeBackground) {
    this.recipeBackground = recipeBackground;
  }

  /**
   * Get the number of the recipe
   * @return the number of the recipe
   */
  public Integer getRecipeNo() {
    return recipeNo;
  }

  /**
   * Set the number of the recipe
   * @param recipeNo the number of the recipe
   */
  public void setRecipeNo(Integer recipeNo) {
    this.recipeNo = recipeNo;
  }

  /**
   * Get the cuisine of the recipe
   * @return the cuisine of the recipe
   */
  public String getCuisine() {
    return cuisine;
  }

  /**
   * Set the cuisine of the recipe
   * @param cuisine the cuisine of the recipe
   */
  public void setCuisine(String cuisine) {
    this.cuisine = cuisine;
  }

  /**
   * Get the tags of the recipe
   * @return the tags of the recipe
   */
  public List<String> getTags() {
    return tags;
  }

  /**
   * Set the tags of the recipe
   * @param tags the tags of the recipe
   */
  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  /**
   * Get the ingredients of the recipe
   * @return the ingredients of the recipe
   */
  public Map<String, Integer> getIngredients() {
    return ingredients;
  }

  /**
   * Set the ingredients of the recipe
   * @param ingredients the ingredients of the recipe
   */
  public void setIngredients(Map<String, Integer> ingredients) {
    this.ingredients = ingredients;
  }

  /**
   * Get the seasonings of the recipe
   * @return the seasonings of the recipe
   */
  public List<String> getSeasonings() {
    return seasonings;
  }

  /**
   * Set the seasonings of the recipe
   * @param seasonings the seasonings of the recipe
   */
  public void setSeasonings(List<String> seasonings) {
    this.seasonings = seasonings;
  }

  /**
   * Get the tutorial of the recipe
   * @return the tutorial of the recipe
   */
  public String getTutorial() {
    return tutorial;
  }

  /**
   * Set the tutorial of the recipe
   * @param tutorial the tutorial of the recipe
   */
  public void setTutorial(String tutorial) {
    this.tutorial = tutorial;
  }

  /**
   * Override the toString method
   * @return the string representation of the recipe
   */
  @Override
  public String toString() {
    return "Recipe{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", recipePic='" + recipePic + '\'' +
        ", recipeBackground=" + recipeBackground +
        ", recipeNo='" + recipeNo + '\'' +
        ", cuisine='" + cuisine + '\'' +
        ", tags=" + tags +
        ", ingredients=" + ingredients +
        ", seasonings=" + seasonings +
        ", tutorial='" + tutorial + '\'' +
        '}';
  }
}
