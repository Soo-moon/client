package mFragment;


import android.app.DialogFragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;

import DnM.client.BuyorSell;
import shared.Player;


public class Click implements View.OnClickListener {

    String[] data;
    FragmentManager fm;
    Player player;

    public Click(String[] data){
        this.data=data;
        fm = BuyorSell.fm;
    }

    public Click(Player player){
        this.player = player;
        fm = BuyorSell.fm;
    }

    @Override
    public void onClick(View v) {
        Bundle args = new Bundle();
        //args.putStringArray("data" , data);
        args.putSerializable("player",player);
        DialogFragment dialogFragment = new mDialogFragment();
        dialogFragment.setArguments(args);
        dialogFragment.show(fm,"tt");
    }

}
