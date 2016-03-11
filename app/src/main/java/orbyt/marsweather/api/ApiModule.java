package orbyt.marsweather.api;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import orbyt.marsweather.MarsWeatherWidget;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by orbyt on 3/11/2016.
 */
@Module
public class ApiModule {

    @Provides
    @Singleton
    GsonConverterFactory provideGson() {
        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    RxJavaCallAdapterFactory provideRxCallAdapter() {
        return RxJavaCallAdapterFactory.create();
    }

    @Singleton
    @Provides
    Retrofit providePictureRetrofit(GsonConverterFactory gsonConverterFactory, RxJavaCallAdapterFactory rxJavaCallAdapterFactory) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MarsWeatherWidget.PICTURE_URL)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .build();
        return retrofit;
    }

    @Singleton
    @Provides
    @Named("weather")
    Retrofit provideWeatherRetrofit(GsonConverterFactory gsonConverterFactory, RxJavaCallAdapterFactory rxJavaCallAdapterFactory) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MarsWeatherWidget.WEATHER_URL)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .build();
        return retrofit;
    }
}

