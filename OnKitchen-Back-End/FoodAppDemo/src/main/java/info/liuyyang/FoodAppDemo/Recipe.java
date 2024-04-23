package info.liuyyang.FoodAppDemo;

import java.util.List;
import java.util.Map;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public Recipe() {
  }

  public ObjectId getId() {
    return id;
  }

  public void setId(ObjectId id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRecipePic() {
    return recipePic;
  }

  public void setRecipePic(String recipePic) {
    this.recipePic = recipePic;
  }

  public List<String> getRecipeBackground() {
    return recipeBackground;
  }

  public void setRecipeBackground(List<String> recipeBackground) {
    this.recipeBackground = recipeBackground;
  }

  public Integer getRecipeNo() {
    return recipeNo;
  }

  public void setRecipeNo(Integer recipeNo) {
    this.recipeNo = recipeNo;
  }

  public String getCuisine() {
    return cuisine;
  }

  public void setCuisine(String cuisine) {
    this.cuisine = cuisine;
  }

  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  public Map<String, Integer> getIngredients() {
    return ingredients;
  }

  public void setIngredients(Map<String, Integer> ingredients) {
    this.ingredients = ingredients;
  }

  public List<String> getSeasonings() {
    return seasonings;
  }

  public void setSeasonings(List<String> seasonings) {
    this.seasonings = seasonings;
  }

  public String getTutorial() {
    return tutorial;
  }

  public void setTutorial(String tutorial) {
    this.tutorial = tutorial;
  }

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
