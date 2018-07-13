package myapps.resumeplus;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Acer on 15-06-2017.
 */

public class TechnicalSkills extends AppCompatActivity{

    private static final String MYPREFER ="pref_new" ;
    TextInputLayout textInputLayout1,textInputLayout2,textInputLayout3,textInputLayout4,textInputLayout5,textInputLayout6;
    EditText editText1,editText2,editText3,editText4,editText5,editText6;
    ImageButton imageButton1,imageButton2;
    TextView textView,textView2,textViewspecify;
    RelativeLayout layout;
    int turn=0,turn2=0;
    Button button_next;
    String s9,s10,s11,s12,s13,s14;
    CheckBox checkBox1c,checkBox2cplus,checkBox3java,checkBox4html,checkBox5css,checkBox6sql,checkBox7android,checkBox8javascript;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.technicalskills);

        Toolbar toolbar= (Toolbar) findViewById(R.id.myToolBar);

        layout= (RelativeLayout) findViewById(R.id.relativelayout);

        textView= (TextView) findViewById(R.id.textViewfieldofinterest);
        textView2= (TextView) findViewById(R.id.textViewtechnicalskill);
        textViewspecify= (TextView) findViewById(R.id.textView3);

        textInputLayout1= (TextInputLayout) findViewById(R.id.textInputLayoutinterest1);
        textInputLayout2= (TextInputLayout) findViewById(R.id.textInputLayoutinterest2);
        textInputLayout3= (TextInputLayout) findViewById(R.id.textInputLayoutinterest3);
        textInputLayout4= (TextInputLayout) findViewById(R.id.textInputLayoutskills1);
        textInputLayout5= (TextInputLayout) findViewById(R.id.textInputLayoutskills2);
        textInputLayout6= (TextInputLayout) findViewById(R.id.textInputLayoutskills3);




        editText1= (EditText) findViewById(R.id.editTextinterest1);
        editText2= (EditText) findViewById(R.id.editTextinterest2);
        editText3= (EditText) findViewById(R.id.editTextinterest3);

        editText4= (EditText) findViewById(R.id.editTextskills1);
        editText5= (EditText) findViewById(R.id.editTextskills2);
        editText6= (EditText) findViewById(R.id.editTextskills3);


        imageButton1= (ImageButton) findViewById(R.id.imageButtonexpand);
        imageButton2= (ImageButton) findViewById(R.id.imageButton3);

        button_next= (Button) findViewById(R.id.next_button);

        checkBox1c= (CheckBox) findViewById(R.id.checkBox);
        checkBox2cplus= (CheckBox) findViewById(R.id.checkBox2);
        checkBox3java= (CheckBox) findViewById(R.id.checkBox3);
        checkBox4html= (CheckBox) findViewById(R.id.checkBox4);
        checkBox5css= (CheckBox) findViewById(R.id.checkBox5);
        checkBox6sql= (CheckBox) findViewById(R.id.checkBox6);
        checkBox7android= (CheckBox) findViewById(R.id.checkBox8);
        checkBox8javascript= (CheckBox) findViewById(R.id.checkBox9);



        toolbar.setTitleTextColor(getResources().getColor(R.color.whitecolor));
        toolbar.setTitle(R.string.interest_and_skills);


        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(turn==0){
                    try {
                         textInputLayout2.setVisibility(View.VISIBLE);
                       /* RelativeLayout.LayoutParams lparams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        lparams.addRule(RelativeLayout.BELOW,R.id.textInputLayoutinterest2);
                       lparams.addRule(RelativeLayout.CENTER_IN_PARENT);
                        imageButton1.setLayoutParams(lparams);
                        view.setLayoutParams(lparams);*/

                         turn++;

                    }
                    catch (Exception e){
                        Toast.makeText(TechnicalSkills.this, ""+e, Toast.LENGTH_SHORT).show();
                    }


                }
                else{
                    imageButton1.setVisibility(View.GONE);
                    textInputLayout3.setVisibility(View.VISIBLE);





                }
            }
        });

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(turn2==0){
                    textInputLayout4.setVisibility(View.VISIBLE);
                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    params.addRule(RelativeLayout.BELOW, R.id.textInputLayoutskills1);
                    //imageButton1.setLayoutParams(params);
                    params.addRule(RelativeLayout.CENTER_IN_PARENT);
                    imageButton2.setLayoutParams(params);
                    turn2++;
                }
                else  if(turn2==1){
                    textInputLayout5.setVisibility(View.VISIBLE);
                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    params.addRule(RelativeLayout.BELOW, R.id.textInputLayoutskills2);
                    //imageButton1.setLayoutParams(params);
                    params.addRule(RelativeLayout.CENTER_IN_PARENT);
                    imageButton2.setLayoutParams(params);
                    turn2++;
                }
                else {
                    imageButton2.setVisibility(View.INVISIBLE);
                    textInputLayout6.setVisibility(View.VISIBLE);
                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    params.addRule(RelativeLayout.BELOW, R.id.textInputLayoutskills3);
                    params.addRule(RelativeLayout.ALIGN_LEFT, R.id.textInputLayoutskills3);
                    params.addRule(RelativeLayout.ALIGN_RIGHT, R.id.textInputLayoutskills3);
                    params.setMargins(0,20,0,5);
                    //imageButton1.setLayoutParams(params);
                   // button_next.setHeight(40);
                   // button_next.setWidth(200);
                    button_next.setLayoutParams(params);
                    ViewGroup.LayoutParams param=button_next.getLayoutParams();
                    param.height=55;
                    button_next.setLayoutParams(param);

                }

            }
        });

        button_next.setOnClickListener(

                new View.OnClickListener() {
            @Override


            public void onClick(View view) {

                SharedPreferences skills=getSharedPreferences(MYPREFER, Context.MODE_PRIVATE);



                SharedPreferences.Editor editor_new=skills.edit();

                editor_new.clear() ;

                if(checkBox1c.isChecked()){
                    String s1=checkBox1c.getText().toString();
                    editor_new.putString("C",s1);
               }
                if(checkBox2cplus.isChecked()){
                    String s2=checkBox2cplus.getText().toString();
                    editor_new.putString("CPLUS",s2);
                }
                if(checkBox3java.isChecked()){
                    String s3=checkBox3java.getText().toString();
                    editor_new.putString("JAVA",s3);
                }
                if(checkBox4html.isChecked()){
                    String s4=checkBox4html.getText().toString();
                    editor_new.putString("HTML",s4);
                }
                if(checkBox5css.isChecked()){
                    String s5=checkBox5css.getText().toString();
                    editor_new.putString("CSS",s5);
                }
                if(checkBox6sql.isChecked()){
                    String s6=checkBox6sql.getText().toString();
                    editor_new.putString("SQL",s6);

                }
                if(checkBox7android.isChecked()){
                    String s7=checkBox7android.getText().toString();
                    editor_new.putString("ANDROID",s7);
                }
                if(checkBox8javascript.isChecked()){
                    String s8=checkBox8javascript.getText().toString();
                    editor_new.putString("JAVASCRIPT",s8);
                }

                s9=editText4.getText().toString();

                if(!s9.matches("")){
                    editor_new.putString("SKILL1",s9);


                }

                s10=editText5.getText().toString();

                if(!s10.matches("")){

                    editor_new.putString("SKILL2",s10);
                }

                s11=editText6.getText().toString();

                if(!s11.matches("")){

                    editor_new.putString("SKILL3",s11);


                }

                s12=editText1.getText().toString();

                if(!s12.matches("")){
                    editor_new.putString("FOI1",s12);


                }

                s13=editText2.getText().toString();

                if(!s13.matches("")){

                    editor_new.putString("FOI2",s13);
                }

                s14=editText3.getText().toString();

                if(!s14.matches("")){

                    editor_new.putString("FOI3",s14);


                }


                editor_new.apply();


                Intent intent=new Intent(TechnicalSkills.this,ProjectDetails.class);
                startActivity(intent);
            }
        });
    }
}
