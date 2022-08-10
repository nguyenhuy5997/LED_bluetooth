package com.example.control_led;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;

public class ModeActivity extends AppCompatActivity {
    ListView listViewEffect;
    ArrayList<String> textEffect;
    Modeadapter modeadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode);
        Anhxa();
        //modeadapter = new Modeadapter(this, R.layout.listvieweffect,textEffect);
//        listViewEffect.setAdapter(modeadapter);
//        listViewEffect.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(ModeActivity.this, MainActivity.class);
//                startActivity(intent);
//            }
//        });
        }


        private void Anhxa() {
        //VideoView videoView = (VideoView) findViewById(R.id.videoView);
        listViewEffect = (ListView) findViewById(R.id.listvieweffect);
        textEffect = new ArrayList<>();
        textEffect.add("Hiệu ứng 1");
        textEffect.add("Hiệu ứng 2");
        textEffect.add("Hiệu ứng 3");
        textEffect.add("Hiệu ứng 4");
        textEffect.add("Hiệu ứng 5");
        textEffect.add("Hiệu ứng 6");
        textEffect.add("Hiệu ứng 7");
        textEffect.add("Hiệu ứng 8");
        textEffect.add("On");
        textEffect.add("Off");
    }
}

class Modeadapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<String> Effect;
    private TextView textView;
    private Dialog dialog;

    public Modeadapter(Context context, int layout, List<String> effect, TextView textView, Dialog dialog) {
        this.context = context;
        this.layout = layout;
        Effect = effect;
        this.textView = textView;
        this.dialog = dialog;
    }

    @Override
    public int getCount() {
        return Effect.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(layout,null);
        ImageButton playButton = (ImageButton) convertView.findViewById(R.id.playbutton);
        TextView effectText = (TextView) convertView.findViewById(R.id.effecttext);
        Button pickbutton = (Button) convertView.findViewById(R.id.pickbutton);

        String effect = Effect.get(position);
        effectText.setText(effect);
        if(position!=9) {
            playButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog(position);
                }
            });
        }
        pickbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(position+1+"");
                dialog.dismiss();
            }
        });
        return convertView;
    }
    private void dialog(int position){
        ArrayList<Integer> arrayVideo = new ArrayList<>();
        arrayVideo.add(R.raw.ef1);
        arrayVideo.add(R.raw.ef2);
        arrayVideo.add(R.raw.ef3);
        arrayVideo.add(R.raw.ef4);
        arrayVideo.add(R.raw.ef5);
        arrayVideo.add(R.raw.ef6);
        arrayVideo.add(R.raw.ef7);
        arrayVideo.add(R.raw.ef8);
        arrayVideo.add(R.raw.ef9);
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_mode);
        VideoView videoView;
        dialog.show();
        videoView = (VideoView) dialog.findViewById(R.id.videoView2);
        videoView.setVideoURI(Uri.parse("android.resource://"+context.getPackageName()+"/"+arrayVideo.get(position)));
        videoView.start();
    }

}
