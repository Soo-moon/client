package ProgramData;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Display;
import android.view.WindowManager;
import android.widget.VideoView;

public class mVideoView extends VideoView {


    public mVideoView(Context context) {
        super(context);
    }
    public mVideoView(Context context, AttributeSet attrs) {
        super(context,attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heigtMeasureSpec){
        Display dis = ((WindowManager)getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        setMeasuredDimension(dis.getWidth(),dis.getHeight());
    }
}
