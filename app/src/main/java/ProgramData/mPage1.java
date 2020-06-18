package ProgramData;

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

public class mPage1 extends Fragment {

    static ArrayList<Player> SearchPlayerList = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.page , container , false);
        SearchPlayerList = BuyorSell.SearchData;

        int id_arr[] = new int[]{R.id.shop_search_image, R.id.shop_search_image1, R.id.shop_search_image2, R.id.shop_search_image3
                , R.id.shop_search_image4, R.id.shop_search_image5, R.id.shop_search_image6, R.id.shop_search_image7,
                R.id.shop_search_image8};



        for (int i = 0; i < 9; i++) {
            if(SearchPlayerList.size() > i){
                Button btn = view.findViewById(id_arr[i]);
                btn.setVisibility(View.VISIBLE);
                btn.setBackground(BuyorSell.ImageSet(i));
                btn.setOnClickListener(new Click(BuyorSell.playerget(i)));
            }
        }
        return view;
    }
}
