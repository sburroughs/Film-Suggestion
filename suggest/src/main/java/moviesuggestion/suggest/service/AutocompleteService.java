package moviesuggestion.suggest.service;

import moviesuggestion.suggest.model.AutocompleteSuggestion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sburroughs on 10/28/2016.
 */
@Service
public class AutocompleteService {


    public List<AutocompleteSuggestion> suggest(String search) {

        AutocompleteSuggestion sampleAutocompleteSuggestion = new AutocompleteSuggestion();
        sampleAutocompleteSuggestion.setSource("TITLE");
        sampleAutocompleteSuggestion.setName("Jumanji");

        List<AutocompleteSuggestion> suggestions = new ArrayList<>();
        suggestions.add(sampleAutocompleteSuggestion);

        return suggestions;

    }


}
