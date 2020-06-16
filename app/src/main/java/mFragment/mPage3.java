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

public class mPage3 extends Fragment {
    ArrayList<Player> SearchPlayerList = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.page3 , container , false);
        SearchPlayerList = BuyorSell.SearchData;

        int id_arr[] = new int[]{ R.id.shop_search_image18, R.id.shop_search_image19
                , R.id.shop_search_image20, R.id.shop_search_image21, R.id.shop_search_image22, R.id.shop_search_image23};


        for (int i = 18; i < 24; i++) {
            if(SearchPlayerList.size() > i){
                Button btn = view.findViewById(id_arr[i-18]);
                btn.setVisibility(View.VISIBLE);
                btn.setBackground(BuyorSell.ImageSet(i));
                btn.setOnClickListener(new Click(BuyorSell.playerget(i)));
            }
        }
        return view;
    }
}
