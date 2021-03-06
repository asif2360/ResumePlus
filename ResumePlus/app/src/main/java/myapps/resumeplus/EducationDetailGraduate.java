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
import android.widget.TextView;

/**
 * Created by Acer on 01-07-2017.
 */

public class EducationDetailGraduate extends AppCompatActivity{

    private static final String MYPREFER ="prefgarduate" ;
    TextView textView1,textView2;
    EditText editText1,editText2,editText3,editText4,editText5,editText6,editText7,editText8;
    EditText editText9,editText10,editText11,editText12,editText13;
    Button button_next;
    String school,school12,percent,percent12,board,board12,passing,passing12;
    String college,course,field,duration,percentage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.educationdetailgraduate);

        Toolbar toolbar= (Toolbar) findViewById(R.id.myToolBar);

        textView1= (TextView) findViewById(R.id.textView);
        textView2= (TextView) findViewById(R.id.textViewsecondary);

        editText1= (EditText) findViewById(R.id.schoolname);
        editText2= (EditText) findViewById(R.id.percentage);
        editText3= (EditText) findViewById(R.id.board);
        editText7= (EditText) findViewById(R.id.passing);
        editText4= (EditText) findViewById(R.id.school12);
        editText5= (EditText) findViewById(R.id.percentage12);
        editText6= (EditText) findViewById(R.id.board12);
        editText8= (EditText) findViewById(R.id.passing12);


        editText9= (EditText) findViewById(R.id.graduatecollege);
        editText10= (EditText) findViewById(R.id.graduatecourse);
        editText11= (EditText) findViewById(R.id.graduatefield);
        editText12= (EditText) findViewById(R.id.graduateduration);
        editText13= (EditText) findViewById(R.id.graduateoverpercent);


        button_next= (Button) findViewById(R.id.next_button);

        toolbar.setTitleTextColor(getResources().getColor(R.color.whitecolor));
        toolbar.setTitle(R.string.educational_details);


        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                 school=editText1.getText().toString();
                 percent=editText2.getText().toString();
                 board=editText3.getText().toString();
                 passing=editText7.getText().toString();


                 school12=editText4.getText().toString();
                 percent12=editText5.getText().toString();
                 board12=editText6.getText().toString();
                 passing12=editText8.getText().toString();

                 college=editText9.getText().toString();
                 course=editText10.getText().toString();
                 field=editText11.getText().toString();
                 duration=editText12.getText().toString();
                 percentage=editText13.getText().toString();


                SharedPreferences educational=getSharedPreferences(MYPREFER, Context.MODE_PRIVATE);

                SharedPreferences.Editor editor=educational.edit();

                editor.putString("SCHOOL", school);
                editor.putString("PERCENT", percent);
                editor.putString("BOARD", board);
                editor.putString("PASSING", passing);

                editor.putString("SCHOOL12", school12);
                editor.putString("PERCENT12", percent12);
                editor.putString("BOARD12", board12);
                editor.putString("PASSING12", passing12);

                editor.putString("COLLEGE", college);
                editor.putString("COURSE", course);
                editor.putString("FIELD", field);
                editor.putString("DURATION", duration);
                editor.putString("OVER_PERCENT", percentage);

                editor.apply();



                Intent intent=new Intent(EducationDetailGraduate.this,TechnicalSkills.class);
                startActivity(intent);
            }
        });
    }
}
