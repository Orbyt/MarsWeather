package orbyt.marsweather;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.widget.RemoteViews;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by orbyt on 12/16/2015.
 */
public class AlarmManagerBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "YOUR TAG");
        //Acquire the lock
        wl.acquire();

        //You can do the processing here update the widget/remote views.
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
                R.layout.mars_weather_widget);

     //   remoteViews.setTextViewText(R.id.mtcSolValue, getCurrentTime("hh:mm:ss a"));
        ComponentName thiswidget = new ComponentName(context, MarsWeatherWidget.class);


        AppWidgetManager manager = AppWidgetManager.getInstance(context);
        manager.updateAppWidget(thiswidget, remoteViews);
        //Release the lock

        AlarmManager am=(AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, intent, 0);
        //After after 3 seconds
        am.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+ 62700, pi);

        wl.release();
    }

    public static String getCurrentTime(String timeformat){
        Format formatter = new SimpleDateFormat(timeformat);
        return formatter.format(new Date());
    }

}
