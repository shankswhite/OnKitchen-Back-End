package info.liuyyang.FoodAppDemo.nouse;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tutorials")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tutorial {
  @Id
  private ObjectId id;
  private String tutorialBody;


  public Tutorial(String tutorialBody) {
    this.tutorialBody = tutorialBody;
  }
}
