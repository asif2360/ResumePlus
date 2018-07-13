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
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Acer on 17-06-2017.
 */

public class Strengths extends AppCompatActivity {
    private static final String MYPREFER ="pref" ;
    TextInputLayout textInputLayout1,textInputLayout2,textInputLayout3,textInputLayout4,textInputLayout5,textInputLayout6;
    EditText editText1,editText2,editText3,editText4,editText5,editText6;
    TextView textView1,textView2,textView3;
    ImageButton imageButton1,imageButton2,imageButton3;
    Button button_next;
    int turn1=0,turn2=0,turn3=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.strengths);
        Toolbar toolbar= (Toolbar) findViewById(R.id.myToolBar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.whitecolor));
        toolbar.setTitle(R.string.interest_and_skills);


        textView1= (TextView) findViewById(R.id.textViewstrength);
        textView2= (TextView) findViewById(R.id.textViewachievements);
        textView3= (TextView) findViewById(R.id.textViewextracarri);

        textInputLayout1= (TextInputLayout) findViewById(R.id.textInputLayoutstrength1);
        textInputLayout2= (TextInputLayout) findViewById(R.id.textInputLayoutstrength2);
        textInputLayout3= (TextInputLayout) findViewById(R.id.textInputLayoutachiev1);
        textInputLayout4= (TextInputLayout) findViewById(R.id.textInputLayoutachiev2);
        textInputLayout5= (TextInputLayout) findViewById(R.id.textInputLayoutextra1);
        textInputLayout6= (TextInputLayout) findViewById(R.id.textInputLayoutextra2);

        editText1= (EditText) findViewById(R.id.editTextstrength1);
        editText2= (EditText) findViewById(R.id.editTextstrength2);
        editText3= (EditText) findViewById(R.id.editTextachiev1);
        editText4= (EditText) findViewById(R.id.editTextachiev2);
        editText5= (EditText) findViewById(R.id.editTextextra1);
        editText6= (EditText) findViewById(R.id.editTextextra2);


        imageButton1= (ImageButton) findViewById(R.id.imageButtonstrengthexpand);
        imageButton2= (ImageButton) findViewById(R.id.imageButtonachieve);
        imageButton3= (ImageButton) findViewById(R.id.imageButtonextracarricular);

        button_next= (Button) findViewById(R.id.next_button);

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(turn1==0){
                    textInputLayout1.setVisibility(View.VISIBLE);
                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    params.addRule(RelativeLayout.BELOW, R.id.textInputLayoutstrength1);
                    params.addRule(RelativeLayout.CENTER_HORIZONTAL);
                    params.setMargins(0,20,0,0);
                    imageButton1.setLayoutParams(params);
                    turn1++;
                }
                else if(turn1==1){
                    textInputLayout2.setVisibility(View.VISIBLE);
                    imageButton1.setVisibility(View.GONE);
                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    params.addRule(RelativeLayout.BELOW, R.id.textInputLayoutstrength2);
                    params.addRule(RelativeLayout.ALIGN_LEFT, R.id.textInputLayoutstrength2);
                    textView2.setLayoutParams(params);
                    turn1++;
                }
                else{
                    Toast.makeText(Strengths.this, "Two attributes are enough as many attributes reduces the interest of employer", Toast.LENGTH_SHORT).show();
                }

            }
        });

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(turn2==0) {
                    textInputLayout3.setVisibility(View.VISIBLE);
                    if(turn1==1) {
                        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        params.addRule(RelativeLayout.BELOW, R.id.imageButtonstrengthexpand);
                        params.addRule(RelativeLayout.ALIGN_LEFT, R.id.textInputLayoutstrength2);
                        textView2.setLayoutParams(params);
                    }else if(turn1==2){
                        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        params.addRule(RelativeLayout.BELOW, R.id.textInputLayoutstrength2);
                        params.addRule(RelativeLayout.ALIGN_LEFT, R.id.textInputLayoutstrength2);
                        textView2.setLayoutParams(params);

                    }
                    else{
                        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        params.addRule(RelativeLayout.BELOW, R.id.imageButtonstrengthexpand);
                        params.addRule(RelativeLayout.ALIGN_LEFT, R.id.textInputLayoutstrength2);
                        textView2.setLayoutParams(params);

                    }
                    turn2++;
                }
                else if(turn2==1){
                    textInputLayout4.setVisibility(View.VISIBLE);
                    imageButton2.setVisibility(View.GONE);



                    turn2++;
                }
                else{
                    Toast.makeText(Strengths.this, "Two attributes are enough as many attributes reduces the interest of employer", Toast.LENGTH_SHORT).show();


                }

            }
        });


        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(turn3==0) {
                    textInputLayout5.setVisibility(View.VISIBLE);
                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    params.addRule(RelativeLayout.BELOW, R.id.imageButtonextracarricular);
                    params.addRule(RelativeLayout.ALIGN_LEFT,R.id.textInputLayoutextra1);
                    params.addRule(RelativeLayout.ALIGN_RIGHT,R.id.textInputLayoutextra1);
                    params.setMargins(0,0,0,5);
                    button_next.setLayoutParams(params);
                    ViewGroup.LayoutParams param=button_next.getLayoutParams();
                    param.height=55;
                    button_next.setLayoutParams(param);
                    turn3++;
                }
                else if(turn3==1){
                    textInputLayout6.setVisibility(View.VISIBLE);
                    imageButton3.setVisibility(View.GONE);
                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    params.addRule(RelativeLayout.BELOW, R.id.textInputLayoutextra2);
                    params.addRule(RelativeLayout.ALIGN_LEFT,R.id.textInputLayoutextra2);
                    params.addRule(RelativeLayout.ALIGN_RIGHT,R.id.textInputLayoutextra2);
                    params.setMargins(0,15,0,5);
                    button_next.setLayoutParams(params);
                   ViewGroup.LayoutParams param=button_next.getLayoutParams();
                    param.height=55;
                    button_next.setLayoutParams(param);
                    turn3++;
                }
                else{
                    Toast.makeText(Strengths.this, "Two attributes are enough as many attributes reduces the interest of employer", Toast.LENGTH_SHORT).show();


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
        String achiev1=editText3.getText().toString();
        String achiev2=editText4.getText().toString();
        String extra1=editText5.getText().toString();
        String extra2=editText6.getText().toString();


        SharedPreferences strength=getSharedPreferences(MYPREFER, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor=strength.edit();

        editor.putString("S1", strength1);
        editor.putString("S2", strength2);
        editor.putString("A1", achiev1);
        editor.putString("A2", achiev2);
        editor.putString("E1", extra1);
        editor.putString("E2", extra2);

        editor.apply();

        Intent intent=new Intent(Strengths.this,Refrenced.class);
        startActivity(intent);
    }
}
