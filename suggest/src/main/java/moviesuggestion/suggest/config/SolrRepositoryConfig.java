package moviesuggestion.suggest.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrOperations;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@Configuration
@EnableSolrRepositories
public class SolrRepositoryConfig {

    //TODO: long term, make this a configuration property
    @Value("${search.datasource.url}")
    private String solrUrl;

    @Bean
    public SolrClient solrClient() {
        return new HttpSolrClient(solrUrl);
    }

    @Bean
    public SolrOperations solrTemplate(SolrClient server) throws Exception {
        return new SolrTemplate(server);
    }


}
