package com.example.ankit.teamregistration;

/**
 * Created by ANKIT on 17-Jan-16.
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
public class IntroActivity extends Activity{



    Button buttonProceed;
    Button buttonExit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        addListenerOnButton();
    }

    public void addListenerOnButton() {

        final Context context = this;

        buttonProceed = (Button) findViewById(R.id.buttonProceed);

        buttonProceed.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);

            }

        });
        buttonExit = (Button)findViewById(R.id.buttonExit);//Exit BUTTON
        buttonExit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button btnfb = (Button) findViewById(R.id.buttonfb); //fb button
        btnfb.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse("https://www.facebook.com/crankit.in/?fref=ts")); //link to crankit page
                startActivity(myWebLink);
            }
        });

    }

}

