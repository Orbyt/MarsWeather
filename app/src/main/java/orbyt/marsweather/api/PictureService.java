package orbyt.marsweather.api;

import orbyt.marsweather.models.picture.PictureAPI;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by orbyt on 12/9/2015.
 */
public interface PictureService {

    @GET("/mars-photos/api/v1/rovers/curiosity/photos?api_key=DEMO_KEY")
    Call<PictureAPI> getPhotos(@Query("earth_date") String earthDate);
}
