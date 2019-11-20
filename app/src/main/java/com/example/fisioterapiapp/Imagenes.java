package com.example.fisioterapiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Imagenes  extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener,YouTubePlayer.PlaybackEventListener {

    String claveYoutube = "AIzaSyA_Imq3R746AZ9UVts423LqnSB2l9ciVl8";
    YouTubePlayerView youTubePlayerView;

    public int[] imagenes = {R.drawable.unouno /*[pos0 = 1.1]*/, R.drawable.unodos/*[pos1 = 1.2]*/,R.drawable.unotres/*[pos2 = 1.3]*/,
    R.drawable.dosuno/*[pos3 = 2.1]*/, R.drawable.dosdos/*[pos4 = 2.2]*/,R.drawable.tresuno/*[pos5 = 3.1]*/, R.drawable.tresdos/*[pos6 = 3.2]*/,
    R.drawable.cuatrouno/*[pos7 = 4.1]*/, R.drawable.cuatrodos/*[pos8 = 4.2]*/, R.drawable.cuatrotres/*[pos9 = 4.3]*/, R.drawable.cuatrocuatro/*[pos10 = 4.4]*/,
    R.drawable.cuatrocinco/*[pos11 = 4.5]*/, R.drawable.cincouno/*[pos12 = 5.1]*/, R.drawable.cincodos/*[pos13 = 5.2]*/, R.drawable.cincotres/*[pos14 = 5.3]*/,
    R.drawable.cincocuatro/*[pos15 = 5.4]*/,R.drawable.cincocinco/*[pos16 = 5.5]*/, R.drawable.cincoseis/*[pos17 = 5.6]*/, R.drawable.cincosiete/*[pos18 = 5.7]*/,
    R.drawable.seisuno/*[pos19 = 6.1]*/,R.drawable.seisdos/*[pos20 = 6.2]*/, R.drawable.seistres/*[pos21 = 6.3]*/};


    public int imagenNum;
    public String d1;
    public String d2;
    public String d3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagenes);

        youTubePlayerView=(YouTubePlayerView)findViewById(R.id.youtube_view1);
        youTubePlayerView.initialize(claveYoutube,this);

        recibirDatos();
        cambiarImagen();
        cambiarTextos();
        //cambiarVideo();
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

        if(!b){
            youTubePlayer.cueVideo("hJLtXVO9k24");
            //youTubePlayer2.cueVideo("lWIQ7QCxp8Q");
            //youTubePlayer3.cueVideo("DAmyax6EZD8");
            //youTubePlayer4.cueVideo("qDXp-oMwkug");
            //youTubePlayer5.cueVideo("5-mq5C4Vx4o");
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

        if(youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(this,1).show();

        }else {
            String error = "error al iniciar youtube" + youTubeInitializationResult.toString();
            Toast.makeText(getApplication(),error,Toast.LENGTH_SHORT).show();
        }
    }

    protected void onActivityResult (int requestCode, int resultCode, Intent data){
        if(requestCode == 1){

            getYoutubePlayerProvider().initialize(claveYoutube,this);
        }
    }

    protected YouTubePlayer.Provider getYoutubePlayerProvider(){
        return youTubePlayerView;

    }

    @Override
    public void onPlaying() {

    }

    @Override
    public void onPaused() {

    }

    @Override
    public void onStopped() {

    }

    @Override
    public void onBuffering(boolean b) {

    }

    @Override
    public void onSeekTo(int i) {

    }

    public void recibirDatos(){
        Bundle extras = getIntent().getExtras();
        imagenNum = Integer.parseInt(extras.getString("dato00"));
        d1 = extras.getString("dato01");
        d2 = extras.getString("dato02");
        d3 = extras.getString("dato03");
    }

    public void cambiarImagen(){
        ImageView imagen =(ImageView)findViewById(R.id.imagen);
        imagen.setImageResource(imagenes[imagenNum]);
    }



    public void cambiarTextos(){

        TextView txtSaludo = (TextView)findViewById(R.id.textoSaludo);
        txtSaludo.setText("Hola" );

        TextView txtRecomendacion = (TextView)findViewById(R.id.textoRecomendacion);
        txtRecomendacion.setText(""+d2);

        TextView txtEjercicio = (TextView)findViewById(R.id.textoEjercicio);
        txtEjercicio.setText(""+d3);
    }




}
