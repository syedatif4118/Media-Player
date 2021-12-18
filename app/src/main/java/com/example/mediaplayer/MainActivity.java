package com.example.mediaplayer;
import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void play(View view) {
        if(player == null){
            player = MediaPlayer.create(this,R.raw.tremor);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
            {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }
        player.start();
    }
    private void stopPlayer() {
        if(player != null){
            player.release();
            player = null;
            Toast.makeText(this,"Media Playee Released",Toast.LENGTH_SHORT).show();
        }
    }
    public void pause(View view) {
        if(player != null){
            player.pause();
        }
    }
    public void stop(View view) {
        stopPlayer();
    }
    @Override
    protected void onStop(){
        super.onStop();
        stopPlayer();
    }
}
