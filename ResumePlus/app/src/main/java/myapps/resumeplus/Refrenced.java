package myapps.resumeplus;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.lang.ref.Reference;
import java.sql.Ref;

/**
 * Created by Acer on 17-06-2017.
 */

public class Refrenced extends AppCompatActivity{

    private static final String MYPREFER ="pref" ;
    TextInputLayout textInputLayout1,textInputLayout2,textInputLayout3;
    EditText editText1,editText2,editText3,editTextdelare;
    TextView textView1,textView2;
    Button button_pdf,button_skip;
    SharedPreferences reference;
    SharedPreferences.Editor editor;
    int skip=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.refrenced);

        Toolbar toolbar= (Toolbar) findViewById(R.id.myToolBar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.whitecolor));

        toolbar.setTitle(R.string.reference);

        textInputLayout1= (TextInputLayout) findViewById(R.id.textInputLayoutreferencename);
        textInputLayout2= (TextInputLayout) findViewById(R.id.textInputLayoutmobile);
        textInputLayout3= (TextInputLayout) findViewById(R.id.textInputLayoutemail);

        editText1= (EditText) findViewById(R.id.editTextreferencename);
        editText2= (EditText) findViewById(R.id.editTextmobile);
        editText3= (EditText) findViewById(R.id.editTextemail);
        editTextdelare= (EditText) findViewById(R.id.editText);

        textView1= (TextView) findViewById(R.id.textViewreference);
        textView2= (TextView) findViewById(R.id.textViewDeclaration);

        button_pdf= (Button) findViewById(R.id.button_pdf);
        button_skip= (Button) findViewById(R.id.button_skip);

        button_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                skip=1;
                editText2.setVisibility(View.GONE);
                editText3.setVisibility(View.GONE);
                button_skip.setVisibility(View.GONE);
              textInputLayout1.setHint("");

              editText1.setText("SELF GENERATED");
                editText1.setFocusable(false);



                reference=getSharedPreferences(MYPREFER, Context.MODE_PRIVATE);

                editor=reference.edit();

                editor.putString("REFSKIP", String.valueOf(skip));

                editor.apply();




            }
        });

        button_pdf.setOnClickListener(new View.OnClickListener() {

            String name,mob,email,declaration;
            @Override
            public void onClick(View view) {
                if(skip==0){
                    skip=0;
                     name=editText1.getText().toString();
                     mob=editText2.getText().toString();
                     email=editText3.getText().toString();

                     declaration=editTextdelare.getText().toString();


                    reference=getSharedPreferences(MYPREFER, Context.MODE_PRIVATE);

                    editor=reference.edit();

                    editor.putString("REFNAME", name);
                    editor.putString("REFMOB", mob);
                    editor.putString("REFEMAIL", email);
                    editor.putString("DEC",declaration);

                    editor.putString("REFSKIP", String.valueOf(skip));


                    editor.apply();

                }
                else {

                    skip=1;
                     name=editText1.getText().toString();
                     mob=editText2.getText().toString();
                     email=editText3.getText().toString();

                     declaration=editTextdelare.getText().toString();


                    reference=getSharedPreferences(MYPREFER, Context.MODE_PRIVATE);

                    editor=reference.edit();

                    editor.putString("REFNAME", name);
                    editor.putString("REFMOB", mob);
                    editor.putString("REFEMAIL", email);
                    editor.putString("DEC",declaration);

                    editor.putString("REFSKIP", String.valueOf(skip));


                    editor.apply();




                }
                if(declaration.length()>160){
                    int len=declaration.length();
                    editTextdelare.setError("Max lenght :160\nCurrent length :"+len);
                    return;
                }


                Intent intent=new Intent(Refrenced.this,Customizer.class);
                startActivity(intent);
            }




        });

    }
}
