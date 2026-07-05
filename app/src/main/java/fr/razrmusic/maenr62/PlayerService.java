package fr.razrmusic.maenr62;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.media.app.NotificationCompat.MediaStyle;
import android.support.v4.media.session.MediaSessionCompat;

public class PlayerService extends Service {

    private MediaPlayer mediaPlayer;
    private MediaSessionCompat mediaSession;

    @Override
    public void onCreate() {
        super.onCreate();

        mediaSession = new MediaSessionCompat(this, "RazrMusicSession");

        // mediaPlayer = MediaPlayer.create(this, R.raw.sample); // musique test
        // TODO: Add sample.mp3 to app/src/main/res/raw/ directory

        Notification notification = new NotificationCompat.Builder(this, "razr_music")
                .setContentTitle("Razr Music")
                .setContentText("Lecture en cours")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setStyle(new MediaStyle().setMediaSession(mediaSession.getSessionToken()))
                .setOngoing(true)
                .build();

        startForeground(1, notification);
        // mediaPlayer.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        mediaSession.release();
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
