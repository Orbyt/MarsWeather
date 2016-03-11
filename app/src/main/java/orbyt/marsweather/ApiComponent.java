package orbyt.marsweather;

import javax.inject.Singleton;

import dagger.Component;
import orbyt.marsweather.api.ApiModule;

/**
 * Created by orbyt on 3/11/2016.
 */
@Singleton
@Component(modules = ApiModule.class)
public interface ApiComponent {

    void inject (MarsWeatherWidget marsWeatherWidget);

}
