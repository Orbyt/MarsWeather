package orbyt.marsweather.settings;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RemoteViews;

import orbyt.marsweather.MarsWeatherWidget;
import orbyt.marsweather.R;

public class ConfigActivity extends AppCompatActivity {

    int mAppWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        displayDialog();

        Context context = this;
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.mars_weather_widget);
        ComponentName thisWidget = new ComponentName(context, MarsWeatherWidget.class);
        appWidgetManager.updateAppWidget(thisWidget, remoteViews);

        // Find the widget id from the intent.
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            mAppWidgetId = extras.getInt(
                    AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
        }

        // It is the responsibility of the configuration activity to update the app widget
        //AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        MarsWeatherWidget.updateAppWidget(context, appWidgetManager, mAppWidgetId);

    }

    public void displayDialog() {
        ConfigStartDialog configStartDialog = new ConfigStartDialog();
        configStartDialog.show(getFragmentManager(), "ConfigStartDialog");
    }
}
