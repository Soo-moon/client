package DnM.client;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import java.io.ObjectOutputStream;
import java.util.Timer;
import java.util.TimerTask;

import Network.Network;


public class vs extends AppCompatActivity {
    VideoView videoView;
    FrameLayout frameLayout;
    TextView resultview;

    public static String result="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vsvideo);


        frameLayout = findViewById(R.id.videoview_frame);
        videoView = findViewById(R.id.videoView);
        resultview = findViewById(R.id.videotext);

        try {
            Uri videofile = Uri.parse("android.resource://" + getPackageName() + "/raw/successvideo");

            videoView.setVideoURI(videofile);
            videoView.start();
            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Log.d("test", "결과값: "+ result);
                            resultview.setText(result);
                        }
                    });

                    Handler mHandler = new Handler();
                    mHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Log.d("test", "vs액티비티 종료");
                            finish();
                        }
                    },2000);
                }
            });
        } catch (Exception ex) {
            Log.d(getClass().getName(), "Video failed:'" + ex + "");
            ex.printStackTrace();
        }
    }
}
