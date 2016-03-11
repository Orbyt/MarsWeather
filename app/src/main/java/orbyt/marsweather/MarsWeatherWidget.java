package orbyt.marsweather;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;

import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;
import javax.inject.Named;

import orbyt.marsweather.api.PictureService;
import orbyt.marsweather.api.WeatherService;
import orbyt.marsweather.models.picture.Photo;
import orbyt.marsweather.models.weather.Report;
import orbyt.marsweather.settings.ConfigActivity;
import retrofit2.Retrofit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Implementation of App Widget functionality.
 * @author orbyt
 */
public class MarsWeatherWidget extends AppWidgetProvider {

    public static final String WEATHER_URL = "http://marsweather.ingenology.com";
    public static final String PICTURE_URL = "https://api.nasa.gov";

    public static int[] mAppWidgetIds;
    public static int widgetId;

    @Inject Retrofit pictureRetrofit;
    @Inject @Named("weather") Retrofit weatherRetrofit;

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        mAppWidgetIds = appWidgetIds;
        ((MyWidget) context.getApplicationContext()).getApiComponent().inject(this);
        final int N = appWidgetIds.length;
        for (int i = 0; i < N; i++) {
            updateAppWidget(context, appWidgetManager, appWidgetIds[i]);
        }
    }

    public void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.mars_weather_widget);

        Intent intent = new Intent(context, ConfigActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, widgetId, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        views.setOnClickPendingIntent(R.id.settingsIconImageView, pendingIntent);

        widgetId = appWidgetId;

        updatePicture(context, views, getFormattedDate(-3));
        updateWeather(views, appWidgetManager, appWidgetId);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }


    /**
     * Updates to latest picture, retrying for previous 3 days.
     *
     * TODO: Inject Retrofit with Dagger.
     */
    public void updatePicture(final Context context, final RemoteViews views, final String date) {

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(PICTURE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .build();

        PictureService pictureService = pictureRetrofit.create(PictureService.class);

        /**
         * TODO: Do not execute requests for previous dates if first returns OK.
         */
        Observable.just(getFormattedDate(0), getFormattedDate(-1), getFormattedDate(-2))
                .flatMap(s -> pictureService.getPhotos(s))
                .filter(pictureAPI -> pictureAPI.getPhotos() != null || pictureAPI.getPhotos().size() > 0)
                .take(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(pictureAPI -> {

                    List<Photo> photoList = pictureAPI.getPhotos();

                    Random random = new Random();
                    Photo currentPhoto = photoList.get(random.nextInt(photoList.size()));

                    Picasso.with(context)
                            .load(currentPhoto.getImg_src())
                            .into(views, R.id.pictureImageView, mAppWidgetIds);

                    views.setTextViewText(R.id.rover, currentPhoto.getRover().getName());
                    views.setTextViewText(R.id.missonSol, Integer.toString(currentPhoto.getRover().getMaxSol()) + "sol");
                    views.setTextViewText(R.id.roverCamera, currentPhoto.getCamera().getFullName());
                    Uri uri = Uri.parse(currentPhoto.getImg_src());
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    PendingIntent pendingIntent = PendingIntent.getActivity(context, widgetId, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                    views.setOnClickPendingIntent(R.id.viewInBrowser, pendingIntent);
                });
    }

    /**
     * Updates weather report to latest.
     *
     *
     * @param views
     * @param appWidgetManager
     * @param appWidgetId
     */
    public void updateWeather(final RemoteViews views, final AppWidgetManager appWidgetManager,
                                     final int appWidgetId) {

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(WEATHER_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .build();

        WeatherService weatherService = weatherRetrofit.create(WeatherService.class);

        weatherService.getReport()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(weatherAPI -> {

                    Report report = weatherAPI.getReport();
                    double minTemp = report.getMin_temp_fahrenheit();
                    double maxTemp = report.getMax_temp_fahrenheit();

                    views.setTextViewText(R.id.temperature, minTemp + "/" + maxTemp + "\u2109");
                    views.setTextViewText(R.id.pressureTextView, Double.toString(report.getPressure()) + "Pa");

                    appWidgetManager.updateAppWidget(appWidgetId, views);
                });
    }

    private static String getFormattedDate(int numPreviousDays) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, numPreviousDays);
        return dateFormat.format(cal.getTime());
    }

    /**
     * Gets current Mars Sol Date.
     * @param views
     * @return current MSD
     */
    private static double getCurrentMSD(RemoteViews views) {
        long millis = System.currentTimeMillis();

        double julianDate = 2440587.5 + (millis / 86400000);

        double julianDateTT = julianDate + (35 + 32.184)/86400;

        double j2000Epoch = julianDateTT - 2451545.0;

        double marsSolDate =((j2000Epoch - 4.5) / 1.027491252) + 44796 - 0.00096;

        return marsSolDate;
    }
}

