package info.liuyyang.FoodAppDemo;

import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * Ingredient class
 * This class is used to store the ingredient information.
 */
@Document(collection = "ingredient")
public class Ingredient {
  @Id
  private ObjectId id;
  private String name;
  private String type;
  private String unit;
  private int number;
  private String grocery;

  /**
   * Constructor
   * This constructor is used to create an ingredient object with the default values.
   */
  public Ingredient() {
  }

  /**
   * Constructor
   * This constructor is used to create an ingredient object with the name and number.
   * @param name the name of the ingredient
   * @param number the number of the ingredient
   */
  public Ingredient(String name, int number) {
    this.name = name;
    this.number = number;
  }

  /**
   * Constructor
   * This constructor is used to create an ingredient object with all the fields.
   * @param name the name of the ingredient
   * @param type the type of the ingredient
   * @param unit the unit of the ingredient
   * @param number the number of the ingredient
   * @param grocery the grocery of the ingredient
   */
  public Ingredient(String name, String type, String unit, int number, String grocery) {
    this.name = name;
    this.type = type;
    this.unit = unit;
    this.number = number;
    this.grocery = grocery;
  }

  /**
   * Get the number of the ingredient
   * @return  the number of the ingredient
   */
  public int getNumber() {
    return number;
  }

  /**
   * Set the number of the ingredient
   * @param number the number of the ingredient
   */
  public void setNumber(int number) {
    this.number = number;
  }

  /**
   * Get the id of the ingredient
   * @return the id of the ingredient
   */
  public ObjectId getId() {
    return id;
  }

  /**
   * Set the id of the ingredient
   * @param id  the id of the ingredient
   */
  public void setId(ObjectId id) {
    this.id = id;
  }

  /**
   * Get the name of the ingredient
   * @return the name of the ingredient
   */
  public String getName() {
    return name;
  }

  /**
   * Set the name of the ingredient
   * @param name the name of the ingredient
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Get the type of the ingredient
   * @return the type of the ingredient
   */
  public String getType() {
    return type;
  }

  /**
   * Set the type of the ingredient
   * @param type the type of the ingredient
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * Get the unit of the ingredient
   * @return the unit of the ingredient
   */
  public String getUnit() {
    return unit;
  }

  /**
   * Set the unit of the ingredient
   * @param unit the unit of the ingredient
   */
  public void setUnit(String unit) {
    this.unit = unit;
  }

  /**
   * Get the grocery of the ingredient
   * @return the grocery of the ingredient
   */
  public String getGrocery() {
    return grocery;
  }

  /**
   * Set the grocery of the ingredient
   * @param grocery the grocery of the ingredient
   */
  public void setGrocery(String grocery) {
    this.grocery = grocery;
  }

  /**
   * Get the string representation of the ingredient
   * @return the string representation of the ingredient
   */
  @Override
  public String toString() {
    return "Ingredient{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", type='" + type + '\'' +
        ", unit='" + unit + '\'' +
        ", number=" + number +
        ", grocery='" + grocery + '\'' +
        '}';
  }

}
