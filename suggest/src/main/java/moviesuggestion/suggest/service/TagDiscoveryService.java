package moviesuggestion.suggest.service;

import moviesuggestion.suggest.model.movie.Tag;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sburroughs on 11/29/2016.
 */
@Service
public class TagDiscoveryService {

    public List<Tag> discover() {

        List<Tag> tags = new ArrayList<>();

        Tag tag1 = new Tag();
        tag1.setDisplay("Action");
        tag1.setSearchField("Genre");
        tag1.setSearchKeyword("Action");

        Tag tag2 = new Tag();
        tag2.setDisplay("Comedy");
        tag2.setSearchField("Genre");
        tag2.setSearchKeyword("Comedy");

        Tag tag3 = new Tag();
        tag3.setDisplay("Drama");
        tag3.setSearchField("Genre");
        tag3.setSearchKeyword("Drama");

        Tag tag4 = new Tag();
        tag4.setDisplay("Romance");
        tag4.setSearchField("Genre");
        tag4.setSearchKeyword("Romance");

        tags.add(tag1);
        tags.add(tag2);
        tags.add(tag3);
        tags.add(tag4);

        return tags;
    }

}
