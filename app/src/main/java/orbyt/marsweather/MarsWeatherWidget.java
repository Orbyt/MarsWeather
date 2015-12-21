package orbyt.marsweather;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.util.Log;
import android.widget.RemoteViews;

import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import orbyt.marsweather.models.picture.Photo;
import orbyt.marsweather.models.picture.PictureAPI;
import orbyt.marsweather.models.weather.Report;
import orbyt.marsweather.models.weather.WeatherAPI;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Implementation of App Widget functionality.
 */
public class MarsWeatherWidget extends AppWidgetProvider {

    private static final String WEATHER_URL = "http://marsweather.ingenology.com";
    public static final String PICTURE_URL = "https://api.nasa.gov";

    public static int[] mAppWidgetIds;

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        mAppWidgetIds = appWidgetIds;
        final int N = appWidgetIds.length;
        for (int i = 0; i < N; i++) {
            updateAppWidget(context, appWidgetManager, appWidgetIds[i]);
        }
    }

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.mars_weather_widget);

        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        Log.d("date", "current date: " + date + ", yesterdays date: " + getYesterdayDateString());

        updatePicture(context, views, date);
        updateWeather(views, appWidgetManager, appWidgetId);


        views.setTextViewText(R.id.msdValue, NumberFormat.getIntegerInstance().format((int) getCurrentMSD(views)));

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }


    public static void updatePicture(final Context context, final RemoteViews views, final String date) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PICTURE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PictureService pictureService = retrofit.create(PictureService.class);
        Call<PictureAPI> pictureAPICall = pictureService.getPhotos(date);
        pictureAPICall.enqueue(new Callback<PictureAPI>() {
            @Override
            public void onResponse(Response<PictureAPI> response, Retrofit retrofit) {

//                if (response.code() != 200) {
//                    Log.d("updatepicture", "Response code wasnt 200, it was" + response.code());
//                    return;
//                }

                if (response.body() != null) {

                    Log.d("weatherresponse", response.raw() + "");

                    List<Photo> photoList = response.body().getPhotos();
                    Log.d("weatherresponse", photoList.get(0).getImg_src());

                    Random random = new Random();
                    Photo currentPhoto = photoList.get(random.nextInt(photoList.size()));

                    Picasso.with(context)
                            .load(currentPhoto.getImg_src())
                            .into(views, R.id.pictureImageView, mAppWidgetIds);

                    views.setTextViewText(R.id.currentRover, currentPhoto.getRover().getName());
                    views.setTextViewText(R.id.currentCamera, currentPhoto.getCamera().getFullName());

                } else {
                    updatePicture(context, views, getYesterdayDateString());
                    Log.d("updatepicture", "else block executed");
                }

            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        });

    }

    public static void updateWeather(final RemoteViews views, final AppWidgetManager appWidgetManager,
                                     final int appWidgetId) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WEATHER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherService weatherService = retrofit.create(WeatherService.class);
        Call<WeatherAPI> weatherAPICall = weatherService.getReport();
        weatherAPICall.enqueue(new Callback<WeatherAPI>() {
            @Override
            public void onResponse(Response<WeatherAPI> response, Retrofit retrofit) {

                Log.d("response", response.body().getReport().getPressure() + "");
                Log.d("response", response.body().getReport().getMax_temp_fahrenheit() + "");
                Log.d("response", response.raw() + "");

                Report report = response.body().getReport();
                views.setTextViewText(R.id.minTempTextView, Double.toString(report.getMin_temp_fahrenheit()) + "\u2109");
                views.setTextViewText(R.id.maxTempTextView, Double.toString(report.getMax_temp_fahrenheit()) + "\u2109");
                views.setTextViewText(R.id.pressureTextView, Double.toString(report.getPressure()) + "Pa");
               // views.setTextViewText(R.id.lastUpdateTextView, "weather last updated: " + report.getTerrestrial_date());


                appWidgetManager.updateAppWidget(appWidgetId, views);

            }

            @Override
            public void onFailure(Throwable t) {

                t.printStackTrace();

            }
        });

    }

    private static String getYesterdayDateString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return dateFormat.format(cal.getTime());
    }

    private static double getCurrentMSD(RemoteViews views) {
        long millis = System.currentTimeMillis();

        double julianDate = 2440587.5 + (millis / 86400000);

        double julianDateTT = julianDate + (35 + 32.184)/86400;

        double j2000Epoch = julianDateTT - 2451545.0;

        double marsSolDate =((j2000Epoch - 4.5) / 1.027491252) + 44796 - 0.00096;

        return marsSolDate;
    }
}

