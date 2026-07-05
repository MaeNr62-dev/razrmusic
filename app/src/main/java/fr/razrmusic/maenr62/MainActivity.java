package fr.razrmusic.maenr62;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lance le service audio (Spotify-like)
        Intent intent = new Intent(this, PlayerService.class);
        startService(intent);
    }
}
