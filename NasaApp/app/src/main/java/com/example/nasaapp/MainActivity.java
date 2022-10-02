package com.example.nasaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] country = { "India", "USA", "China", "Japan", "Other"};
    ImageButton btnInfraRed, btnLaunch, btnSound, btnVision, btnMicroWave, btnOther, btnInfo, btnChange;
    Dialog changeNimbus;
    TextView txtLocation, txtVehicle, txtName;

    // Animation for rocket
    Animation launchRocket, crashRocket;
    WebView webView;

    HashMap<String, Integer> map;

    // Button for all 7 nimbus
    ImageButton nb1, nb2, nb3, nb4, nb5, nb6, nb7;


    // Elements for Select tech
    Dialog techDialog;
    Technology selectedTech;
    EditText txtTechInfo;
    Spinner techSpinner;
    Button btnCloseTech;
    String selectedTechStr;
    TextView txtTechName;
    TextView txtTechHead;

    Dialog infoDialog;
    TextView txtHint;
    Button btnCloseHint;

    Nimbus nimbus;

    // mapping string
    String infrared = "Infrared";
    String microWave = "Microwave";
    String sounding = "sounding";
    String visibility = "Visibility";
    String other = "Other";

    int selectedNimbus = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.webview);
        webView.loadUrl("file:///android_asset/index.html");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.setBackgroundColor(Color.TRANSPARENT);

        launchRocket = AnimationUtils.loadAnimation(MainActivity.this, R.anim.launch_rocket);
        crashRocket = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rocket_crash);

        map = new HashMap<>();
        map.put(infrared, 0);
        map.put(microWave, 0);
        map.put(sounding, 0);
        map.put(visibility, 0);
        map.put(other, 0);

        // by default nimbus 1
        nimbus = new Nimbus_1();

        // initializing the info dialog
        infoDialog = new Dialog(this);
        infoDialog.setContentView(R.layout.show_hints);
        infoDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        txtHint = infoDialog.findViewById(R.id.txtHint);
        txtHint.setFocusable(false);
        btnCloseHint = infoDialog.findViewById(R.id.btnCloseHint);


        changeNimbus=new Dialog(this);
        changeNimbus.setContentView(R.layout.select_nimbus);
        changeNimbus.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        // Elements for tech dialog
        techDialog = new Dialog(this);
        techDialog.setContentView(R.layout.select_tech);
        techDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        btnCloseTech = techDialog.findViewById(R.id.btnCloseTech);
        techSpinner = techDialog.findViewById(R.id.techSpinner);
        techSpinner.setOnItemSelectedListener(this);
        txtTechInfo = techDialog.findViewById(R.id.txtTechInfo);
        txtTechInfo.setFocusable(false);
        txtTechHead = techDialog.findViewById(R.id.txtTechHead);

        // All dashboard buttons
        btnInfraRed = findViewById(R.id.btnInfrared);
        btnSound = findViewById(R.id.btnSound);
        btnMicroWave = findViewById(R.id.btnMicroWave);
        btnVision = findViewById(R.id.btnVision);
        btnOther = findViewById(R.id.btnOther);

        // Dashboard text view
        txtLocation = findViewById(R.id.txtLocation);
        txtVehicle = findViewById(R.id.txtVehicle);
        txtName = findViewById(R.id.txtName);


        // btn Launch
        btnLaunch = findViewById(R.id.btnLaunch);
        btnLaunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkStatus()){
                    Toast.makeText(MainActivity.this, "Launching Successfully.", Toast.LENGTH_LONG).show();
                    webView.startAnimation(launchRocket);

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable(){
                        @Override
                        public void run(){
                            String obj = "object";
                            // Start another intent and run rocket launch
                            Intent i = new Intent(MainActivity.this, RocketLaunch.class);
                            i.putExtra(obj, nimbus);
                            MainActivity.this.startActivity(i);
                            MainActivity.this.finish();
                        }
                    }, 2200);


//                    webView.loadUrl("file:///android_asset/index_1.html");
//                    webView.getSettings().setJavaScriptEnabled(true);
//                    webView.setWebViewClient(new WebViewClient());
//                    webView.setBackgroundColor(Color.TRANSPARENT);
                }else{
                    // explode it.
                    webView.startAnimation(crashRocket);
                    Toast.makeText(MainActivity.this, "Mission failed.", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnInfraRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTechDialog(new InfraredImaging(), infrared, "InInfrared Imaging");
            }
        });
        btnSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTechDialog(new Sounding(), sounding, "Sounding System");
            }
        });
        btnMicroWave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTechDialog(new MicrowaveImaging(), microWave, "Microwave Imaging");
            }
        });
        btnVision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTechDialog(new VisibleImagery(), visibility, "Visible Imaginary");
            }
        });
        btnOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTechDialog(new Others(), other, "Others");
            }
        });


        // Defining all the ImageButtons
        btnInfraRed = (ImageButton) findViewById(R.id.btnInfrared);
        btnSound = (ImageButton) findViewById(R.id.btnSound);
        btnVision = (ImageButton) findViewById(R.id.btnVision);
        btnMicroWave = (ImageButton) findViewById(R.id.btnMicroWave);
        btnOther = (ImageButton) findViewById(R.id.btnOther);
        btnInfo = (ImageButton) findViewById(R.id.btnInfo);
        btnChange = (ImageButton) findViewById(R.id.btnChange);


        // ============   NO change area  =================

        // All button for nimbus
        nb1 = changeNimbus.findViewById(R.id.btnNimbus1);
        nb2 = changeNimbus.findViewById(R.id.btnNimbus2);
        nb3 = changeNimbus.findViewById(R.id.btnNimbus3);
        nb4 = changeNimbus.findViewById(R.id.btnNimbus4);
        nb5 = changeNimbus.findViewById(R.id.btnNimbus5);
        nb6 = changeNimbus.findViewById(R.id.btnNimbus6);
        nb7 = changeNimbus.findViewById(R.id.btnNimbus7);

        nb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeNimbusInformation(new Nimbus_1(), 1);
            }
        });
        nb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeNimbusInformation(new Nimbus_2(), 2);
            }
        });
        nb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeNimbusInformation(new Nimbus_3(), 3);
            }
        });
        nb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeNimbusInformation(new Nimbus_4(), 4);
            }
        });
        nb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeNimbusInformation(new Nimbus_5(), 5);
            }
        });
        nb6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeNimbusInformation(new Nimbus_6(), 6);
            }
        });
        nb7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeNimbusInformation(new Nimbus_7(), 7);
            }
        });

        //=================     no change area closed ======
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               changeNimbus.show();
            }
        });
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infoDialog.show();
            }
        });
        btnCloseHint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infoDialog.dismiss();
            }
        });
        // dismiss tech dialog
        btnCloseTech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                techDialog.dismiss();
            }
        });

        setInfomation(nimbus, selectedNimbus);  //
    }

    private void setInfomation(Nimbus nimbus, int nb){
        // set all information
        txtLocation.setText("Location:\n"+nimbus.getLaunchLocation());
        txtVehicle.setText("Vehicle:\n"+nimbus.getLaunchVehicle());
        txtName.setText(nimbus.getName());

        // adding the item to text hint
        txtHint.setText(nimbus.getHint());
        selectedNimbus = nb;
    }

    private void changeNimbusInformation(Nimbus nimbus, int nb){
        map.put(infrared, 0);
        map.put(microWave, 0);
        map.put(sounding, 0);
        map.put(visibility, 0);
        map.put(other, 0);
        //============
        changeNimbus.dismiss();
        setInfomation(nimbus, nb); // changing the information after changing the nimbus
    }
    private void showTechDialog(Technology tech, String selectedStr, String name){
//        Dialog techDialog;
//        Technology tech;
//        Spinner techSpinner;
//        Button btnCloseTech;
        selectedTech = tech;
        selectedTechStr = selectedStr;
        techDialog.show();

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item, tech.getList());
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        techSpinner.setAdapter(aa);
        techSpinner.setSelection(map.get(selectedStr));

        // set info about that
        // task to done here......
        txtTechInfo.setText(tech.getInfo(0));
        txtTechHead.setText(name);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        map.put(selectedTechStr, i);
        txtTechInfo.setText(selectedTech.getInfo(i));
        for(String ss : map.keySet()){
            System.out.println(ss + " " + map.get(ss));
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // do nothing
    }

    private boolean checkNimbus1(){
        if(map.get(visibility) != 1) return false;
        if(map.get(sounding) != 0) return false;
        if(map.get(infrared) != 1) return false;
        if(map.get(microWave) != 0) return false;
        if(map.get(other) != 0) return false;
        return true;
    }

    private boolean checkNimbus2(){
        if(map.get(visibility) != 1) return false;
        if(map.get(sounding) != 0) return false;
        if(map.get(infrared) != 1 && map.get(infrared) != 2) return false;
        if(map.get(microWave) != 0) return false;
        if(map.get(other) != 0) return false;
        return true;
    }
    private boolean checkNimbus3(){
        if(map.get(visibility) != 2) return false;
        if(map.get(sounding) != 2 && map.get(sounding) != 10) return false;
        if(map.get(infrared) != 1 && map.get(infrared) != 2) return false;
        if(map.get(microWave) != 0) return false;
        if(map.get(other) != 0) return false;
        return true;
    }
    private boolean checkNimbus4(){
        if(map.get(visibility) != 2) return false;
        if(map.get(sounding) != 2 && map.get(sounding) != 10 && map.get(sounding) != 9) return false;
        if(map.get(infrared) != 3) return false;
        if(map.get(microWave) != 0) return false;
        if(map.get(other) != 1) return false;
        return true;
    }
    private boolean checkNimbus5(){
        if(map.get(visibility) != 0) return false;
        if(map.get(sounding) != 5 && map.get(sounding) != 9) return false;
        if(map.get(infrared) != 0 ) return false;
        if(map.get(microWave) != 1) return false;
        if(map.get(other) != 5) return false;
        return true;
    }
    private boolean checkNimbus6(){
        if(map.get(visibility) != 0) return false;
        if(map.get(sounding) != 1 && map.get(sounding) != 4 && map.get(sounding) != 6 && map.get(sounding) != 8) return false;
        if(map.get(infrared) != 0) return false;
        if(map.get(microWave) != 1) return false;
        if(map.get(other) != 3 && map.get(other) != 7) return false;
        return true;
    }
    private boolean checkNimbus7(){
        if(map.get(visibility) != 0) return false;
        if(map.get(sounding) != 3 && map.get(sounding) != 7) return false;
        if(map.get(infrared) != 3) return false;
        if(map.get(microWave) != 2) return false;
        if(map.get(other) != 2 && map.get(other) != 3 && map.get(other) != 4 && map.get(other) != 6) return false;
        return true;
    }
    private boolean checkStatus(){
        switch(selectedNimbus){
            case 1:{
                return checkNimbus1();
            }
            case 2:{
                return checkNimbus2();
            }
            case 3:{
                return checkNimbus3();
            }
            case 4:{
                return checkNimbus4();
            }
            case 5:{
                return checkNimbus5();
            }
            case 6:{
                return checkNimbus6();
            }
            case 7:{
                return checkNimbus7();
            }
            default:{
                return false;
            }
        }
    }
}



//Getting the instance of Spinner and applying OnItemSelectedListener on it
//        Spinner spin = (Spinner) findViewById(R.id.spinner);
//        spin.setOnItemSelectedListener(this);

//Creating the ArrayAdapter instance having the country list
//        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
//        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spin.setAdapter(aa);


//    }

//Performing action onItemSelected and onNothing selected

//    @Override
//    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
//        Nimbus n=new Nimbus_1();
//        Toast.makeText(getApplicationContext(), n.getName(), Toast.LENGTH_LONG).show();
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> arg0) {
//        // TODO Auto-generated method stub
//    }