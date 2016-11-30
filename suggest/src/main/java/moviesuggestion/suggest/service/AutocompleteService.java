package moviesuggestion.suggest.service;

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

    public List<AutocompleteSuggestion> suggest(String search) {

        List<AutocompleteSuggestion> suggestions = new ArrayList<>();

        SolrQuery query = new SolrQuery();
        query.setRequestHandler(REQUEST_HANDLER);
        query.setQuery(search);

        SuggesterResponse results = null;
        try {
            QueryResponse yeah = solrClient.query(SOLR_CORE, query);

            results = yeah.getSuggesterResponse();
        } catch (SolrServerException | IOException e) {
            e.printStackTrace();
        }

        if (results != null) {

            List<String> terms = results.getSuggestedTerms().get(SUGGESTER_KEY);
            for (String term : terms) {

                AutocompleteSuggestion currentSuggestion = new AutocompleteSuggestion();
                currentSuggestion.setSource("TITLE");
                currentSuggestion.setName(term);

                suggestions.add(currentSuggestion);
            }

        }

        return suggestions;

    }


}
