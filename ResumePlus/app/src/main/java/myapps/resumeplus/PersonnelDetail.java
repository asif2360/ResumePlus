package myapps.resumeplus;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Acer on 14-06-2017.
 */

public class PersonnelDetail extends AppCompatActivity{

    private static final String MYPREFER ="pref" ;
    EditText editText1,editText2,editText3,editText4,editText5,editText7;
    Button button_next;
    String s1,s2,s3,s4,s5,s6,s7;
    SharedPreferences personnel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.personneldetail);

        Toolbar toolbar= (Toolbar) findViewById(R.id.myToolBar);

        editText1= (EditText) findViewById(R.id.editTextfirstname);
        editText2= (EditText) findViewById(R.id.editTextlastnamee);
        editText3= (EditText) findViewById(R.id.editTextdate);
        editText4= (EditText) findViewById(R.id.editTextnationality);
        editText5= (EditText) findViewById(R.id.editTextcontact);
        editText7= (EditText) findViewById(R.id.editTextemail);

        button_next= (Button) findViewById(R.id.next_button);





        toolbar.setTitleTextColor(getResources().getColor(R.color.whitecolor));
        toolbar.setTitle(R.string.personnel_details);


        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                s1=editText1.getText().toString();





                String name1=editText1.getText().toString();
                String name2=editText2.getText().toString();
                String dat=editText3.getText().toString();
                String nationality=editText4.getText().toString();
                String cont=editText5.getText().toString();
                String email=editText7.getText().toString();

              personnel=getSharedPreferences(MYPREFER, Context.MODE_PRIVATE);

                SharedPreferences.Editor editor=personnel.edit();

                editor.putString("F_NAME", name1);
                editor.putString("L_NAME", name2);
                editor.putString("DATE", dat);
                editor.putString("CONTACT",cont);
                editor.putString("NATIONALITY", nationality);
                editor.putString("EMAIL",email);

                editor.apply();


                Intent intent=new Intent(PersonnelDetail.this,AddressDetail.class);
                startActivity(intent);
                }


        });
    }
}
