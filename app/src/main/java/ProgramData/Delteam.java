package ProgramData;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;



import DnM.client.Main;
import shared.Player;

public class Delteam implements AdapterView.OnItemClickListener {

    Context mContext;
    ArrayAdapter adapter;

    public Delteam(Context context, ArrayAdapter adapter){
        this.mContext=context;
        this.adapter =adapter;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("방출 확인");
        builder.setMessage("방출하시겠습니까?");
        builder.setPositiveButton("예",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(mContext, "방출 했습니다.", Toast.LENGTH_LONG).show();

                        Player player = (Player) adapter.getItem(position);
                        Main.myteam.remove(player);

                        adapter.remove(player);
                        adapter.notifyDataSetChanged();
                        Log.d("test","myteam 변경");
                    }
                });
        builder.setNegativeButton("아니오",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(mContext, "취소 했습니다.", Toast.LENGTH_LONG).show();
                    }
                });
        builder.show();
    }
}
