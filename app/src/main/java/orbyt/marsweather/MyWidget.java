package orbyt.marsweather;

import android.app.Application;

import orbyt.marsweather.api.ApiModule;

/**
 * Created by orbyt on 3/11/2016.
 */
public class MyWidget extends Application {

    ApiComponent mApiComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApiComponent = DaggerApiComponent.builder().apiModule(new ApiModule()).build();
    }

    public ApiComponent getApiComponent() {
        return mApiComponent;
    }
}
