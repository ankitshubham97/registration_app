package com.example.ankit.teamregistration;


import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.app.AlertDialog;
import android.text.Html;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String REGISTER_URL = "http://agni.iitd.ernet.in/cop290/assign0/register/";    //stores the url of the server
    final Context context = this;

    public static final String KEY_TEAMNAME = "teamname";       //stores the id of the fields
    public static final String KEY_NAME1 = "name1";
    public static final String KEY_NAME2 = "name2";
    public static final String KEY_NAME3 = "name3";
    public static final String KEY_ENTRY1 = "entry1";
    public static final String KEY_ENTRY2 = "entry2";
    public static final String KEY_ENTRY3 = "entry3";

    private EditText editTeamname;          //create variable of types EditText, Button, TextView for capturing the data from the field appearing in the app
    private EditText editName1;
    private EditText editName2;
    private EditText editName3;
    private EditText editEntry1;
    private EditText editEntry2;
    private EditText editEntry3;

    private Button buttonRegister;
    private Button buttonHelp;
    private Button buttonAboutUs;
    private Button buttonBack;

    private TextView textViewTeam;
    private TextView textViewName1;
    private TextView textViewName2;
    private TextView textViewName3;
    private TextView textViewEntry1;
    private TextView textViewEntry2;
    private TextView textViewEntry3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {        //onCreate method : to execute all the instruction enlisted inside it
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTeamname = (EditText) findViewById(R.id.editTeamname);      //capturing data from user to respective variables using findViewById
        editName1 = (EditText) findViewById(R.id.editName1);
        editName2 = (EditText) findViewById(R.id.editName2);
        editName3 = (EditText) findViewById(R.id.editName3);
        editEntry1 = (EditText) findViewById(R.id.editEntry1);
        editEntry2 = (EditText) findViewById(R.id.editEntry2);
        editEntry3 = (EditText) findViewById(R.id.editEntry3);
        textViewTeam= (TextView)findViewById(R.id.textViewTeam);
        textViewName1= (TextView)findViewById(R.id.textViewName1);
        textViewName2= (TextView)findViewById(R.id.textViewName2);
        textViewName3= (TextView)findViewById(R.id.textViewName3);
        textViewEntry1= (TextView)findViewById(R.id.textViewEntry1);
        textViewEntry2= (TextView)findViewById(R.id.textViewEntry2);
        textViewEntry3= (TextView)findViewById(R.id.textViewEntry3);


        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(this);                            //setting onClick event for Register button
                                                                            //setOnClickListener method to execute all the instruction enlisted
                                                                            //within itself
        buttonAboutUs = (Button) findViewById(R.id.buttonAboutUs);          //setting onClick event for About Us button
        buttonAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(   //AlertDialog.Builder creates an alert box
                        context);
                alertDialogBuilder.setTitle("About Us");              // setting the title
                alertDialogBuilder
                        .setMessage("We are team 'Crank!t' which comprises of three members, namely Ankit Shubham, Vishavjeet Singh and Raunak Lohiya.We are currently pursuing B.Tech from IIT Delhi.Click on fb icon in the intro page to know more about us.")
                                    //setting the message
                        .setCancelable(true);
                AlertDialog alertDialog = alertDialogBuilder.create(); //creating the alert box
                alertDialog.show();         //showing the alert box
            }
        });

        buttonHelp = (Button) findViewById(R.id.buttonHelp);      //setting onClick event for Help button
        buttonHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                // set title
                alertDialogBuilder.setTitle("Help");

                // set dialog message
                alertDialogBuilder
                        .setMessage("This is the registration area. Register your team which includes the teamname and entry numbers and names of the team members!")
                        .setCancelable(true);
                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }
        });

        buttonBack = (Button)findViewById(R.id.buttonBack);
        //setting onClick event for Register button
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();             //finish command to exit the page
            }
        });
        //Apart from text boxes, I created labels for each of them which are initially invisible. The code given below makes them visible when respective textboxes are touched.
        editTeamname = (EditText)findViewById(R.id.editTeamname);
        editTeamname.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                textViewTeam.setVisibility(View.VISIBLE);
                return false;

            }
        });
        editName1 = (EditText)findViewById(R.id.editName1);
        editName1.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                textViewName1.setVisibility(View.VISIBLE);
                return false;

            }
        });
        editName2 = (EditText)findViewById(R.id.editName2);
        editName2.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                textViewName2.setVisibility(View.VISIBLE);
                return false;

            }
        });
        editName3 = (EditText)findViewById(R.id.editName3);
        editName3.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                textViewName3.setVisibility(View.VISIBLE);
                return false;

            }
        });
        editEntry1 = (EditText)findViewById(R.id.editEntry1);
        editEntry1.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                textViewEntry1.setVisibility(View.VISIBLE);
                return false;

            }
        });
        editEntry2 = (EditText)findViewById(R.id.editEntry2);
        editEntry2.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                textViewEntry2.setVisibility(View.VISIBLE);
                return false;

            }
        });
        editEntry3 = (EditText)findViewById(R.id.editEntry3);
        editEntry3.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                textViewEntry3.setVisibility(View.VISIBLE);
                return false;

            }
        });


    }
    //registerUser is the function that gets executed when Register is tapped.
    private void registerUser(){

        final String teamname = editTeamname.getText().toString().trim();
        final String name1 = editName1.getText().toString().trim();
        final String name2 = editName2.getText().toString().trim();
        final String name3 = editName3.getText().toString().trim();
        final String entry1 = editEntry1.getText().toString().trim();
        final String entry2 = editEntry2.getText().toString().trim();
        final String entry3 = editEntry3.getText().toString().trim();

        //Variable stringRequest of Type StringRequest is created which encodes the data entered and the url and sends it to the server by POST method
        StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(MainActivity.this,response,Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                        Toast.makeText(MainActivity.this,"Error: Server may be down or the internet connection is lost.",Toast.LENGTH_LONG).show();
                    }
                })
        {

            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                /*params.put(KEY_USERNAME,username);
                params.put(KEY_PASSWORD,password);
                params.put(KEY_EMAIL, email);

                params.put(KEY_USERNAME1,username1);
                params.put(KEY_USERNAME2,username2);
                params.put(KEY_USERNAME3,username3);
                params.put(KEY_ENTRYNO1,entryno1);
                params.put(KEY_ENTRYNO2,entryno2);
                params.put(KEY_ENTRYNO3,entryno3);*/

                params.put(KEY_TEAMNAME,teamname);
                params.put(KEY_NAME1,name1);
                params.put(KEY_NAME2,name2);
                params.put(KEY_NAME3,name3);
                params.put(KEY_ENTRY1,entry1);
                params.put(KEY_ENTRY2,entry2);
                params.put(KEY_ENTRY3,entry3);


                return params;
            }

        };
        //using volley to perform the registration process:
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    @Override
    public void onClick(View v) {
        String line1 = editEntry1.getText().toString();
        String line2 = editEntry2.getText().toString();
        String line3 = editEntry3.getText().toString();
        String pattern = "^20[0-9]{2}[a-zA-Z]{2}[0-9]{5}$";

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m1 = r.matcher(line1);
        Matcher m2 = r.matcher(line2);
        Matcher m3 = r.matcher(line3);
        if(v == buttonRegister){
            if(editTeamname.getText().length()==0){
                editTeamname.setError(Html.fromHtml("<font color='yellow'>This field can't be left empty.</font>"));
            }
            else if(editName1.getText().length()==0){
                editName1.setError(Html.fromHtml("<font color='yellow'>This field can't be left empty.</font>"));
            }
            else if(editEntry1.getText().length()==0){
                editEntry1.setError(Html.fromHtml("<font color='yellow'>This field can't be left empty.</font>"));
            }
            else if(editEntry1.getText().length()!=11){
                editEntry1.setError(Html.fromHtml("<font color='yellow'>Invalid length.</font>"));
            }
            else if(editName2.getText().length()==0){
                editName2.setError(Html.fromHtml("<font color='yellow'>This field can't be left empty.</font>"));
            }
            else if(editEntry2.getText().length()==0){
                editEntry2.setError(Html.fromHtml("<font color='yellow'>This field can't be left empty.</font>"));
            }
            else if(editEntry2.getText().length()!=11){
                editEntry2.setError(Html.fromHtml("<font color='yellow'>Invalid length.</font>"));
            }
            else if(editEntry3.getText().length()!=11 && editEntry3.getText().length()!=0){
                editEntry3.setError(Html.fromHtml("<font color='yellow'>Invalid length or Entry No.</font>"));
            }
            else if(!m1.find()){
                editEntry1.setError(Html.fromHtml("<font color='yellow'>Invalid format.</font>"));
            }
            else if(!m2.find()){
                editEntry2.setError(Html.fromHtml("<font color='yellow'>Invalid format.</font>"));
            }
            else if(!m3.find() && editEntry3.getText().length()!=0){
                editEntry3.setError(Html.fromHtml("<font color='yellow'>Invalid format.</font>"));
            }
            else{
                registerUser();
            }
        }

    }
}