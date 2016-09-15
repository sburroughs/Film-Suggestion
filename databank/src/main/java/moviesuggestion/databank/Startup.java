package moviesuggestion.databank;

import moviesuggestion.databank.io.pipeline.MovieDeliveryPipeline;
import moviesuggestion.databank.io.pipeline.OhGodWhyException;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by Sburroughs on 9/14/2016.
 */
@Component
public class Startup implements ApplicationListener<ContextRefreshedEvent> {


    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {

        //TODO: temporary for testing. Remove in production
        MovieDeliveryPipeline pipeline = new MovieDeliveryPipeline();
        try {
            pipeline.run();
        } catch (OhGodWhyException e) {
            e.printStackTrace();
        }

    }



}
