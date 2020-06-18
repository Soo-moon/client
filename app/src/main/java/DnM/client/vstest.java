package DnM.client;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

public class vstest extends AppCompatActivity {
    public static boolean check =true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vs);



        ImageView load = findViewById(R.id.gif_image);
        GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(load);
        Glide.with(this).load(R.drawable.loading).into(gifImage);

        while (true){
            if (!check){
                break;
            }
        }

        Intent intent = new Intent(getApplicationContext() , vs.class);
        startActivity(intent);
        finish();
    }
}
