package myapps.resumeplus;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Acer on 15-06-2017.
 */

public class AddressDetail extends AppCompatActivity {
    private static final String MYPREFER ="pref" ;
    EditText editText1,editText2,editText3,editText4,editText5;
    Button button_next;
    SharedPreferences address;
    int turn;
    String area,street,city,pincode,state;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.addressdetail);


        Toolbar toolbar= (Toolbar) findViewById(R.id.myToolBar);

        editText1= (EditText) findViewById(R.id.editTextarea);
        editText2= (EditText) findViewById(R.id.editTextstreet);
        editText3= (EditText) findViewById(R.id.editTextcity);
        editText4= (EditText) findViewById(R.id.editTextpincodey);
        editText5= (EditText) findViewById(R.id.editTextstate);

        button_next= (Button) findViewById(R.id.next_button);

        SharedPreferences mypref=getSharedPreferences("MYPREF", Context.MODE_PRIVATE);

        String s1=mypref.getString("TURN","");

        turn = Integer.parseInt(s1);

        toolbar.setTitleTextColor(getResources().getColor(R.color.whitecolor));
        toolbar.setTitle(R.string.address_details);

        button_next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if(turn==1) {

                     area = editText1.getText().toString();
                     street = editText2.getText().toString();
                     city = editText3.getText().toString();
                     pincode = editText4.getText().toString();
                     state = editText5.getText().toString();


                    address = getSharedPreferences(MYPREFER, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = address.edit();


                    editor.putString("AREA", area);
                    editor.putString("STREET", street);
                    editor.putString("CITY", city);
                    editor.putString("PINCODE", pincode);
                    editor.putString("STATE", state);


                    editor.apply();


                    Intent intent = new Intent(AddressDetail.this, EducationDetail.class);
                    startActivity(intent);

                }

                if(turn==2){

                     area = editText1.getText().toString();
                     street = editText2.getText().toString();
                     city = editText3.getText().toString();
                     pincode = editText4.getText().toString();
                     state = editText5.getText().toString();


                    address = getSharedPreferences(MYPREFER, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = address.edit();


                    editor.putString("AREA", area);
                    editor.putString("STREET", street);
                    editor.putString("CITY", city);
                    editor.putString("PINCODE", pincode);
                    editor.putString("STATE", state);


                    editor.apply();

                    Intent intent = new Intent(AddressDetail.this, EducationDetailGraduate.class);
                    startActivity(intent);

                }

            }
        });

    }
}
