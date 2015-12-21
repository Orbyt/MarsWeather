package orbyt.marsweather;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ConfigActivity extends AppCompatActivity {

    int mAppWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        displayDialog();

        final Context context = ConfigActivity.this;

        // Find the widget id from the intent.
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            mAppWidgetId = extras.getInt(
                    AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
        }

        // It is the responsibility of the configuration activity to update the app widget
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        MarsWeatherWidget.updateAppWidget(context, appWidgetManager, mAppWidgetId);

        // Make sure we pass back the original appWidgetId
        Intent resultValue = new Intent();
        resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, mAppWidgetId);
        setResult(RESULT_OK, resultValue);
        //finish();
    }

    public void displayDialog() {
        ConfigStartDialog configStartDialog = new ConfigStartDialog();
        configStartDialog.show(getFragmentManager(), "ConfigStartDialog");

    }
}
