package myapps.resumeplus;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Acer on 01-07-2017.
 */

public class StrengthsGraduate extends AppCompatActivity{

    private static final String MYPREFER ="pref" ;
    TextInputLayout textInputLayout1,textInputLayout2,textInputLayout3,textInputLayout4,textInputLayout5,textInputLayout6;
    TextInputLayout textInputLayout7,textInputLayout8,textInputLayout9;
    EditText editText1,editText2,editText3,editText4,editText5,editText6,editText7,editText8,editText9;
    TextView textView1,textView2,textView3;
    ImageButton imageButton1,imageButton2,imageButton3;
    Button button_next;
    int turn1=0,turn2=0,turn3=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.strengthsgraduate);

        Toolbar toolbar= (Toolbar) findViewById(R.id.myToolBar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.whitecolor));
        toolbar.setTitle(R.string.interest_and_skills);


        textView1= (TextView) findViewById(R.id.textViewstrength);
        textView2= (TextView) findViewById(R.id.textViewachievements);
        textView3= (TextView) findViewById(R.id.textViewextracarri);

        textInputLayout1= (TextInputLayout) findViewById(R.id.textInputLayoutstrength1);
        textInputLayout2= (TextInputLayout) findViewById(R.id.textInputLayoutstrength2);
        textInputLayout3= (TextInputLayout) findViewById(R.id.textInputLayoutstrength3);
        textInputLayout4= (TextInputLayout) findViewById(R.id.textInputLayoutachiev1);
        textInputLayout5= (TextInputLayout) findViewById(R.id.textInputLayoutachiev2);
        textInputLayout6= (TextInputLayout) findViewById(R.id.textInputLayoutachiev3);
        textInputLayout7= (TextInputLayout) findViewById(R.id.textInputLayoutextra1);
        textInputLayout8= (TextInputLayout) findViewById(R.id.textInputLayoutextra2);
        textInputLayout9= (TextInputLayout) findViewById(R.id.textInputLayoutextra3);

        editText1= (EditText) findViewById(R.id.strength1);
        editText2= (EditText) findViewById(R.id.strength2);
        editText3= (EditText) findViewById(R.id.strength3);
        editText4= (EditText) findViewById(R.id.achiev1);
        editText5= (EditText) findViewById(R.id.achiev2);
        editText6= (EditText) findViewById(R.id.achiev3);
        editText7= (EditText) findViewById(R.id.extra1);
        editText8= (EditText) findViewById(R.id.extra2);
        editText9= (EditText) findViewById(R.id.extra3);

        imageButton1= (ImageButton) findViewById(R.id.imageButtonstrengthexpand);
        imageButton2= (ImageButton) findViewById(R.id.imageButtonachieve);
        imageButton3= (ImageButton) findViewById(R.id.imageButtonextracarricular);

        button_next= (Button) findViewById(R.id.next_button);

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(turn1==0) {
                    textInputLayout2.setVisibility(View.VISIBLE);
                    turn1 = 1;
                }
                else {
                    textInputLayout3.setVisibility(View.VISIBLE);
                    imageButton1.setVisibility(View.GONE);
                }
            }
        });

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(turn2==0) {
                    textInputLayout5.setVisibility(View.VISIBLE);
                    turn2 = 1;
                }
               else {
                    textInputLayout6.setVisibility(View.VISIBLE);
                    imageButton2.setVisibility(View.GONE);
                }
            }
        });

        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(turn3==0) {
                    textInputLayout8.setVisibility(View.VISIBLE);
                    turn3 = 1;
                }
                else {
                    textInputLayout9.setVisibility(View.VISIBLE);
                    imageButton3.setVisibility(View.GONE);
                }
            }
        });

        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newpage();

            }
        });

    }

    private void newpage() {

        String strength1=editText1.getText().toString();
        String strength2=editText2.getText().toString();
        String strength3=editText3.getText().toString();
        String achiev1=editText4.getText().toString();
        String achiev2=editText5.getText().toString();
        String achiev3=editText6.getText().toString();
        String extra1=editText7.getText().toString();
        String extra2=editText8.getText().toString();
        String extra3=editText9.getText().toString();


        SharedPreferences strength=getSharedPreferences(MYPREFER, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor=strength.edit();

        editor.putString("S1", strength1);
        editor.putString("S2", strength2);
        editor.putString("S3", strength3);
        editor.putString("A1", achiev1);
        editor.putString("A2", achiev2);
        editor.putString("A3", achiev3);
        editor.putString("E1", extra1);
        editor.putString("E2", extra2);
        editor.putString("E3", extra3);

        editor.apply();


        Intent intent=new Intent(StrengthsGraduate.this,Refrenced.class);
        startActivity(intent);
    }
}
