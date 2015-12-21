package orbyt.marsweather;

import orbyt.marsweather.models.picture.PictureAPI;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by orbyt on 12/9/2015.
 */
public interface PictureService {

    @GET("/mars-photos/api/v1/rovers/curiosity/photos?api_key=NkXYxgk2rJBDvAlhBipu7Zg0gp2fEiikjQiXsPZP")
    Call<PictureAPI> getPhotos(@Query("earth_date") String earthDate);
}
