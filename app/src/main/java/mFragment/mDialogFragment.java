package mFragment;

import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import DnM.client.BuyorSell;
import DnM.client.Main;
import DnM.client.R;
import shared.Player;

public class mDialogFragment extends DialogFragment {

    Context context = BuyorSell.mContext;
    Player player;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle SavedInstanceState) {
        View view = inflater.inflate(R.layout.playerinfo, container, false);

        Bundle args = getArguments();
        player = (Player) args.getSerializable("player");

        String name;
        String stat;

        if(player.position_type.equals("투수")){
            name= player.name;
            stat= "팀: "+player.teamname+"\n시즌: " + player.season+"\n체력: "+player.health + "\n제구: "+player.Control + "\n구속: "+player.ballspeed ;
        }
        else {
            name= player.name;
            stat= "팀: "+player.teamname+"\n시즌: " + player.season+"\n파워: "+player.power + "\n컨디션: "+player.Condition + "\n속도: "+player.speed;
        }


        TextView infoView = view.findViewById(R.id.info);
        infoView.setText(stat);

        TextView nameView = view.findViewById(R.id.name);
        nameView.setText(name);

        Button buybtn = view.findViewById(R.id.Dia_buy);
        buybtn.setOnClickListener(dia_buy);

        Button closebtn = view.findViewById(R.id.Dia_close);
        closebtn.setOnClickListener(dia_close);

        return view;
    }

    View.OnClickListener dia_buy = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("구매 재차확인");
            builder.setMessage("구매하시겠습니까?");
            builder.setPositiveButton("예",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(context, "예를 선택했습니다.", Toast.LENGTH_LONG).show();
                            Main.myteam.add(player);
                            Log.d("test","myteam 변경");

                        }
                    });
            builder.setNegativeButton("아니오",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(context, "아니오를 선택했습니다.", Toast.LENGTH_LONG).show();
                        }
                    });
            builder.show();
        }
    };

    View.OnClickListener dia_close = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dismiss();
        }
    };
}
