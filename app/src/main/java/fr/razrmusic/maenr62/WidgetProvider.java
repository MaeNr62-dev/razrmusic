package fr.razrmusic.maenr62;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class WidgetProvider extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int id : appWidgetIds) {
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_player);

            Intent intent = new Intent(context, PlayerService.class);
            PendingIntent pi = PendingIntent.getService(
                    context, 0, intent, PendingIntent.FLAG_IMMUTABLE);

            views.setOnClickPendingIntent(R.id.btnPlay, pi);
            appWidgetManager.updateAppWidget(id, views);
        }
    }
}
