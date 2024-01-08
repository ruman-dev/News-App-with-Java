package com.rumanweb.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class WebView extends AppCompatActivity {

    ImageView coverImg;
    TextView newsTitle,newsDesc;
    FloatingActionButton fabButton;

    TextToSpeech textToSpeech;

    public static String TITLE = "";
    public static String DESC = "";
    public static Bitmap MY_BITMAP = null;

    boolean isSpeaking = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        coverImg = findViewById(R.id.coverImg);
        newsTitle = findViewById(R.id.newsTitle);
        newsDesc = findViewById(R.id.newsDesc);
        fabButton = findViewById(R.id.fabButton);


        textToSpeech = new TextToSpeech(WebView.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

            }
        });

        newsTitle.setText(TITLE);
        newsDesc.setText(DESC);

        if (MY_BITMAP!= null) coverImg.setImageBitmap(MY_BITMAP);

        //initially isSpeaking is false

        fabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newsText = newsDesc.getText().toString(); // Replace with your news text

                if (textToSpeech.isSpeaking()) {
                    textToSpeech.stop();
                    fabButton.setImageResource(R.drawable.baseline_keyboard_voice_24); // Change to play icon
                } else {
// Implement your text-to-speech logic here
                    String text = newsDesc.getText().toString();
                    textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
                    fabButton.setImageResource(R.drawable.volume_up_24px); // Change to stop icon
                }
            }
        });
    }

}