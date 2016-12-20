package moviesuggestion.suggest.service;

import moviesuggestion.suggest.exception.AutoCompleteException;
import moviesuggestion.suggest.model.AutocompleteSuggestion;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.SuggesterResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sburroughs on 10/28/2016.
 */
@Service
public class AutocompleteService {

    private static final String REQUEST_HANDLER = "/suggest";
    private static final String SOLR_CORE = "movie";
    private static final String SUGGESTER_KEY = "suggest_main";


    @Autowired
    private SolrClient solrClient;

    public List<AutocompleteSuggestion> suggest(String search) throws AutoCompleteException {

        List<AutocompleteSuggestion> suggestions = new ArrayList<>();

        SolrQuery query = new SolrQuery();
        query.setRequestHandler(REQUEST_HANDLER);
        query.setQuery(search);

        SuggesterResponse results = null;
        try {
            QueryResponse response = solrClient.query(SOLR_CORE, query);
            results = response.getSuggesterResponse();

            if (results == null) {
                throw new IllegalStateException(String.format("Null response from search: %s", results));
            }

        } catch (SolrServerException | IOException | IllegalStateException e) {
            throw new AutoCompleteException("Unable to retrieve results", e);
        }

        List<String> suggestedTerms = results.getSuggestedTerms().get(SUGGESTER_KEY);
        for (String currentSuggestion : suggestedTerms) {

            String term = removehighlighting(currentSuggestion);

            AutocompleteSuggestion suggest = new AutocompleteSuggestion();
            suggest.setSource("TITLE");
            suggest.setName(term);

            suggestions.add(suggest);
        }


        return suggestions;

    }

    /**
     * Removes term highlighting provided as part of the Solr suggester implementation. This should be addressed in solr config long term.
     *
     * @param currentSuggestion
     * @return
     */
    private String removehighlighting(String currentSuggestion) {
        //stackoverflow sourced regex to remove html elements and avoid edge cases.
        return currentSuggestion.replaceAll("<(?:[^>=]|='[^']*'|=\"[^\"]*\"|=[^'\"][^\\s>]*)*>", "");
    }


}
