package com.example.polytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.poly.polyos.PolyOsListener;
import com.poly.polyos.PolyOsManager;
import com.poly.polyos.app.IPolyAppCallBacks_Proxy;

public class MainActivity extends AppCompatActivity {

    Button startButton;

    private PolyOsListener listener =  new PolyOsListener() {
        @Override
        public void onConnectionChanged(boolean b) {
            Log.i("PolyOsManager","onConnectionChanged:"+b);
        }
    };

    private PolyOsManager polyOsManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = findViewById(R.id.hello);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startHome();
            }
        });

        findViewById(R.id.mute).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mute();
            }
        });

        findViewById(R.id.unmute).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unmute();
            }
        });

        polyOsManager = new PolyOsManager(getApplicationContext(),null,listener);

    }

    void startHome(){
        Model m = new Model();
        m.i = 0;
        m.s = "";
        Intent i = new Intent(this,HomeActivity.class);
        i.putExtra("b",m);
        startActivity(i);
    }

    private void mute(){
        if(polyOsManager.isConnected()) {
            Log.i("PolyOsManager","isConnected mute");
            polyOsManager.getAudioService().muteMicrophone(true);
        }else{
            Log.i("PolyOsManager","is Not Connected!!");
        }
    }

    private void unmute(){
        if(polyOsManager.isConnected()) {
            Log.i("PolyOsManager","isConnected unmute");
            polyOsManager.getAudioService().muteMicrophone(false);
        }else{
            Log.i("PolyOsManager","is Not Connected!!");
        }
    }
}
