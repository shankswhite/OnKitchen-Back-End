package info.liuyyang.FoodAppDemo;

import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ingredient")
public class Ingredient {
  @Id
  private ObjectId id;
  private String name;
  private String type;
  private String unit;
  private int number;
  private String grocery;

  public Ingredient() {
  }

  public Ingredient(String name, String type, String unit, int number, String grocery) {
    this.name = name;
    this.type = type;
    this.unit = unit;
    this.number = number;
    this.grocery = grocery;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
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

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  public String getGrocery() {
    return grocery;
  }

  public void setGrocery(String grocery) {
    this.grocery = grocery;
  }

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
