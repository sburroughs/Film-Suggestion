package moviesuggestion.databank;

import moviesuggestion.databank.io.pipeline.MovieImportPipeline;
import moviesuggestion.databank.exception.OhGodWhyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by Sburroughs on 9/14/2016.
 */
@Component
public class Startup implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    MovieImportPipeline pipeline;

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {

        //TODO: temporary for testing. Remove in production
        try {
            pipeline.run();
        } catch (OhGodWhyException e) {
            e.printStackTrace();
        }

    }


}
