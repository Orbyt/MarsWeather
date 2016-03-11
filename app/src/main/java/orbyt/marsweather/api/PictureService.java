package orbyt.marsweather.api;

import orbyt.marsweather.models.picture.PictureAPI;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by orbyt on 12/9/2015.
 */
public interface PictureService {

    @GET("/mars-photos/api/v1/rovers/curiosity/photos?api_key=DEMO_KEY")
    Observable<PictureAPI> getPhotos(@Query("earth_date") String earthDate);
}
