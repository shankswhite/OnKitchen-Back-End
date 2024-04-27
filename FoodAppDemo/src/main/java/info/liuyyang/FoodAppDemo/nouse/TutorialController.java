package info.liuyyang.FoodAppDemo.nouse;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/tutorials")
public class TutorialController {
    @Autowired
    private TutorialService tutorialService;


    @PostMapping
    public ResponseEntity<Tutorial> createTutorial(@RequestBody Map<String,String> payload){
        return new ResponseEntity<Tutorial>(tutorialService.createTutorial(payload.get("tutorialBody"),payload.get("recipeNo")),
            HttpStatus.CREATED);
    }
}
