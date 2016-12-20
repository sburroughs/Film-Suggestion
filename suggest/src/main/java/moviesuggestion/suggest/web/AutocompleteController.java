package moviesuggestion.suggest.web;

import moviesuggestion.suggest.exception.AutoCompleteException;
import moviesuggestion.suggest.model.AutocompleteSuggestion;
import moviesuggestion.suggest.service.AutocompleteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Sburroughs on 9/23/2016.
 */
@Controller
public class AutocompleteController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AutocompleteController.class);

    @Autowired
    private AutocompleteService autocompleteService;

    @RequestMapping(value = "/autocomplete/{keyword}", method = RequestMethod.GET)
    @ResponseBody
    public List<AutocompleteSuggestion> suggest(@PathVariable("keyword") String keyword) throws AutoCompleteException {

        LOGGER.info("New autocomplete request received: {}", keyword);


        List<AutocompleteSuggestion> results = autocompleteService.suggest(keyword);

        return results;

    }
}
