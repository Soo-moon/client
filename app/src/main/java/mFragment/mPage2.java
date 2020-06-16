package mFragment;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;

import DnM.client.BuyorSell;
import DnM.client.R;
import shared.Player;

public class mPage2 extends Fragment {
    ArrayList<Player> SearchPlayerList = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.page2 , container , false);
        SearchPlayerList = BuyorSell.SearchData;

        int id_arr[] = new int[]{ R.id.shop_search_image9, R.id.shop_search_image10, R.id.shop_search_image11
                , R.id.shop_search_image12, R.id.shop_search_image13, R.id.shop_search_image14, R.id.shop_search_image15,
                R.id.shop_search_image16, R.id.shop_search_image17};


        for (int i = 9; i < 18; i++) {
            if(SearchPlayerList.size() > i){
                Button btn = view.findViewById(id_arr[i-9]);
                btn.setVisibility(View.VISIBLE);
                btn.setBackground(BuyorSell.ImageSet(i));
                btn.setOnClickListener(new Click(BuyorSell.playerget(i)));
            }
        }
        return view;
    }
}
