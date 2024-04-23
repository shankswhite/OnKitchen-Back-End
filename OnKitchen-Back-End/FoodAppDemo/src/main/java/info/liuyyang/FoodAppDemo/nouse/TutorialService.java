package info.liuyyang.FoodAppDemo.nouse;

import info.liuyyang.FoodAppDemo.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class TutorialService {
    @Autowired
    private TutorialRepository tutorialRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Tutorial createTutorial(String tutorialBody, String recipeNo){
        Tutorial tutorial = tutorialRepository.insert(new Tutorial(tutorialBody));

        mongoTemplate.update(Recipe.class)
            .matching(Criteria.where("recipeNo").is(recipeNo))
            .apply(new Update().push("tutorialIds").value(tutorial)).first();

        return tutorial;


    }
}
