package DnM.client;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

public class Loading extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        ImageView load = findViewById(R.id.gif_image);
        GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(load);
        Glide.with(this).load(R.drawable.load).into(gifImage);

    }
}