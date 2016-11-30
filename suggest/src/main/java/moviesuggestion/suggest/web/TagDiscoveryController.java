package moviesuggestion.suggest.web;

import moviesuggestion.suggest.model.AutocompleteSuggestion;
import moviesuggestion.suggest.model.movie.Tag;
import moviesuggestion.suggest.service.AutocompleteService;
import moviesuggestion.suggest.service.TagDiscoveryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Sburroughs on 9/23/2016.
 */
@Controller
public class TagDiscoveryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TagDiscoveryController.class);

    @Autowired
    private TagDiscoveryService tagDiscoveryService;

    @RequestMapping(value = "/discover", method = RequestMethod.GET)
    @ResponseBody
    public List<Tag> suggest(@RequestParam(name = "type", defaultValue = "default") String type) {

        LOGGER.info("Tag Discovery request received: {}", type);

        List<Tag> results = tagDiscoveryService.discover();
        return results;

    }
}
