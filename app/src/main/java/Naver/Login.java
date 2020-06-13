package Naver;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.util.Log;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.nhn.android.naverlogin.OAuthLogin;
import com.nhn.android.naverlogin.OAuthLoginHandler;
import com.nhn.android.naverlogin.ui.view.OAuthLoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import DnM.client.Main;
import Network.Network;
import DnM.client.R;
import shared.UserData;


public class Login extends Activity {

    private RelativeLayout RelativeLayout;
    private OAuthLoginButton mOAuthLoginButton;

    private static String OAUTH_CLIENT_ID = "_PF2b5B23VyiuqJpCOEq";
    private static String OAUTH_CLIENT_SECRET = "dAbgX3EhUq";
    private static String OAUTH_CLIENT_NAME = "네이버 아이디로 로그인";

    private static OAuthLogin mOAuthLoginInstance;
    public static Context mContext;

    public static String personalid  = null;

    public static UserData userData = new UserData();
    public static Network network = new Network();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.naveroauthlogin_sample_main);

        ImageView load = findViewById(R.id.gif_image);
        GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(load);
        Glide.with(this).load(R.drawable.maingif).into(gifImage);


        mContext = this;

        initData();
        initView();
    }

    private void initData() {
        mOAuthLoginInstance = OAuthLogin.getInstance();

        mOAuthLoginInstance.showDevelopersLog(true);
        mOAuthLoginInstance.init(mContext, OAUTH_CLIENT_ID, OAUTH_CLIENT_SECRET, OAUTH_CLIENT_NAME);
    }

    private void initView() {

        mOAuthLoginButton = (OAuthLoginButton) findViewById(R.id.buttonOAuthLoginImg);
        mOAuthLoginButton.setOAuthLoginHandler(mOAuthLoginHandler);
    }

    @SuppressLint("HandlerLeak")
    private OAuthLoginHandler mOAuthLoginHandler = new OAuthLoginHandler() {
        @Override
        public void run(boolean success) {
            if (success) {
                new Login.RequestApiTask().execute();
                Intent intent = new Intent(getApplicationContext(), Main.class);
                intent.putExtra("id",personalid);
                startActivity(intent);
                finish();
            } else {
                String errorCode = mOAuthLoginInstance.getLastErrorCode(mContext).getCode();
                String errorDesc = mOAuthLoginInstance.getLastErrorDesc(mContext);
                Toast.makeText(mContext, "errorCode:" + errorCode + ", errorDesc:" + errorDesc, Toast.LENGTH_SHORT).show();
            }
        }

    };

    private class RequestApiTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            String url = "https://openapi.naver.com/v1/nid/me";
            String at = mOAuthLoginInstance.getAccessToken(mContext);
            return mOAuthLoginInstance.requestApi(mContext, at, url);
        }

        protected void onPostExecute(String content) {
            try {

                JSONObject jsonObject =new JSONObject(content);
                JSONObject response = jsonObject.getJSONObject("response");
                String t=response.getString("email");
                personalid = t.substring(0,t.lastIndexOf("@"));
                Login.userData.setid(personalid);
                Log.d("test",personalid);

                Intent intent = new Intent(mContext, Main.class);


                network.start();
                try {
                    network.join();

                } catch (InterruptedException e) {
                    Log.d("error", "접속 오류" + e.getClass().getName() + ": " + e.getMessage());
                }


                startActivity(intent);
                finish();

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }



}
