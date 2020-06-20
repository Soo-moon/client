package DnM.client;

import android.content.Intent;
import android.media.Image;
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
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import Network.Network;


public class vs extends AppCompatActivity {
    VideoView videoView;
    FrameLayout frameLayout;
    ImageView imageView;
    TextView textView;

    public static String result="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vsvideo);

        imageView = findViewById(R.id.gif_image);
        frameLayout = findViewById(R.id.videoview_frame);
        textView = findViewById(R.id.videoview_text);
        videoView = findViewById(R.id.videoView);
        
        int num = new Random().nextInt(2);
        Handler mHandler = new Handler();

        switch (num) {
            //성공 영상
            case 0:
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
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
                                            textView.setText(result);
                                            //이미지뷰에 성공 gif 표시
//                                            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(imageView);
//                                            Glide.with(this).load(R.drawable.vssuccess).into(gifImage);
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
                }, 1500);
                break;

            //실패 영상
            case 1:
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Uri videofile = Uri.parse("android.resource://" + getPackageName() + "/raw/failvideo");

                            videoView.setVideoURI(videofile);
                            videoView.start();
                            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mediaPlayer) {
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Log.d("test", "결과값: "+ result);
                                            textView.setText(result);
                                            //이미지뷰에 실패 gif 표시
//                                            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(imageView);
//                                            Glide.with(this).load(R.drawable.vsfail).into(gifImage);
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
                }, 1500);
                break;
        }
    }
}
