package orbyt.marsweather.api;

import orbyt.marsweather.models.weather.WeatherAPI;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by orbyt on 12/9/2015.
 */
public interface WeatherService {

    /**
     * Gets the latest weather report
     *
     * @return a Report
     */

    @GET("/v1/latest/")
    Observable<WeatherAPI> getReport();
}
