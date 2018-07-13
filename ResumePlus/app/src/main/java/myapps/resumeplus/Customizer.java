package myapps.resumeplus;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Acer on 18-06-2017.
 */

public class Customizer extends AppCompatActivity {

    private static final String MYPREFER ="pref" ;
    int theme=0,turn=0;
    TextView textView1,textView2,textView3,textView4,textView5,textView6;
    TextView textView7,textView8,textView9,textView10,textView11,textView12,textView13;
    int style=0;

    SharedPreferences count;

    SharedPreferences.Editor editor_local;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customizer);

        Toolbar toolbar= (Toolbar) findViewById(R.id.myToolBar);

        count=getSharedPreferences("style", Context.MODE_PRIVATE);

        toolbar.setTitleTextColor(getResources().getColor(R.color.whitecolor));
        toolbar.setTitle(R.string.customizer);


        SharedPreferences mypref=getSharedPreferences("MYPREF", Context.MODE_PRIVATE);
        editor_local=count.edit();

        String s1=mypref.getString("TURN","");

        turn = Integer.parseInt(s1);


        textView1= (TextView) findViewById(R.id.textViewtwocolor);
        textView2= (TextView) findViewById(R.id.theme1);
        textView3= (TextView) findViewById(R.id.theme2);
        textView4= (TextView) findViewById(R.id.theme3);
        textView5= (TextView) findViewById(R.id.theme4);
        textView6= (TextView) findViewById(R.id.theme5);
        textView7= (TextView) findViewById(R.id.theme6);
        textView8= (TextView) findViewById(R.id.textViewattractivestyle);
        textView9= (TextView) findViewById(R.id.style1);
        textView10= (TextView) findViewById(R.id.style2);
        textView11= (TextView) findViewById(R.id.style3);
        textView12= (TextView) findViewById(R.id.style4);
        textView13= (TextView) findViewById(R.id.textViewblackandwhite);




        SharedPreferences count=getSharedPreferences(MYPREFER, Context.MODE_PRIVATE);

        final SharedPreferences.Editor editor=count.edit();
        textView12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(turn==1){
                    style=4;
                }
                else {
                    style=1;
                }

                editor_local.putString("STYLE", String.valueOf(style));

                editor_local.apply();

                Intent intent = new Intent(Customizer.this, PdfStyle4.class);
                startActivity(intent);
            }
        });

        textView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(turn==1){
                    style=3;
                }
                else {
                    style=1;
                }

                editor_local.putString("STYLE", String.valueOf(style));

                editor_local.apply();

                Intent intent = new Intent(Customizer.this, PdfStyle3.class);
                startActivity(intent);
            }
        });


        textView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              if(turn==1){
                  style=2;
              }
              else {
                  style=1;
              }

                editor_local.putString("STYLE", String.valueOf(style));

                editor_local.apply();


                Intent intent = new Intent(Customizer.this, PdfStyle1.class);
                startActivity(intent);

            }
        });



        textView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                style=2;



                editor_local.putString("STYLE", String.valueOf(style));

                editor_local.apply();
                 try {
                     theme=6;
                     editor.putString("THEME1", String.valueOf(theme));

                     editor.apply();

                     Intent intent = new Intent(Customizer.this, PdfGraduate.class);
                     startActivity(intent);
                 }
                 catch (Exception e){

                    // Toast.makeText(Customizer.this, ""+e, Toast.LENGTH_SHORT).show();
                 }
            }
        });



        textView13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    theme=0;
                    editor.putString("THEME1", String.valueOf(theme));

                    editor.apply();
                    if(turn==1){
                    Intent intent = new Intent(Customizer.this,Pdf.class);
                    startActivity(intent);
                    }
                    else{
                        Intent intent = new Intent(Customizer.this,PdfGraduate.class);
                        startActivity(intent);
                    }

                }
                catch (Exception e){
                   // Toast.makeText(Customizer.this, ""+e, Toast.LENGTH_SHORT).show();
                }

            }
        });



        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    theme=1;
                    editor.putString("THEME1", String.valueOf(theme));

                    editor.apply();
                    if(turn==1) {
                        Intent intent = new Intent(Customizer.this, Pdf.class);
                        startActivity(intent);
                    }
                    else{
                        Intent intent = new Intent(Customizer.this,PdfGraduate.class);
                        startActivity(intent);
                    }
                }
                catch (Exception e){
                   // Toast.makeText(Customizer.this, ""+e, Toast.LENGTH_SHORT).show();
                }

            }
        });

        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    theme=2;
                    editor.putString("THEME1", String.valueOf(theme));

                    editor.apply();
                    if(turn==1) {
                        Intent intent = new Intent(Customizer.this, Pdf.class);
                        startActivity(intent);
                    }
                    else{
                        Intent intent = new Intent(Customizer.this,PdfGraduate.class);
                        startActivity(intent);
                    }
                }
                catch (Exception e){
                   // Toast.makeText(Customizer.this, ""+e, Toast.LENGTH_SHORT).show();
                }

            }
        });

        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    theme=3;
                    editor.putString("THEME1", String.valueOf(theme));

                    editor.apply();

                    if(turn==1) {
                        Intent intent = new Intent(Customizer.this, Pdf.class);
                        startActivity(intent);
                    }
                    else{
                        Intent intent = new Intent(Customizer.this,PdfGraduate.class);
                        startActivity(intent);
                    }
                }
                catch (Exception e){
                    //Toast.makeText(Customizer.this, ""+e, Toast.LENGTH_SHORT).show();
                }

            }
        });

        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    theme=4;
                    editor.putString("THEME1", String.valueOf(theme));

                    editor.apply();
                    if(turn==1) {
                        Intent intent = new Intent(Customizer.this, Pdf.class);
                        startActivity(intent);
                    }
                    else{
                        Intent intent = new Intent(Customizer.this,PdfGraduate.class);
                        startActivity(intent);
                    }
                }
                catch (Exception e){
                   // Toast.makeText(Customizer.this, ""+e, Toast.LENGTH_SHORT).show();
                }

            }
        });

        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    theme=5;
                    editor.putString("THEME1", String.valueOf(theme));

                    editor.apply();
                    if(turn==1) {
                        Intent intent = new Intent(Customizer.this, Pdf.class);
                        startActivity(intent);
                    }
                    else{
                        Intent intent = new Intent(Customizer.this,PdfGraduate.class);
                        startActivity(intent);
                    }
                }
                catch (Exception e){
                    //Toast.makeText(Customizer.this, ""+e, Toast.LENGTH_SHORT).show();
                }

            }
        });

        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    theme=6;
                    editor.putString("THEME1", String.valueOf(theme));

                    editor.apply();
                    if(turn==1) {
                        Intent intent = new Intent(Customizer.this, Pdf.class);
                        startActivity(intent);
                    }
                    else{
                        Intent intent = new Intent(Customizer.this,PdfGraduate.class);
                        startActivity(intent);
                    }
                }
                catch (Exception e){
                   // Toast.makeText(Customizer.this, ""+e, Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
