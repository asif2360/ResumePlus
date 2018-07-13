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
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by Acer on 17-06-2017.
 */

public class ProjectDetails extends AppCompatActivity {

    private static final String MYPREFER ="prefgrad" ;

    EditText editText1,editText2,editText3,editText4,editText5;
    Button button_add,button_skip,button_next;
    TextInputLayout textInputLayout;
    int skip=0,turn=0;
    int project=0;
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.projectdetails);

        toolbar= (Toolbar) findViewById(R.id.myToolBar);

        editText1= (EditText) findViewById(R.id.editTextprojecttitle);
        editText2= (EditText) findViewById(R.id.ediTextdescription);
        editText3= (EditText) findViewById(R.id.edittexttime);
        editText4= (EditText) findViewById(R.id.edittextrole);
        editText5= (EditText) findViewById(R.id.editTextsize);

        textInputLayout= (TextInputLayout) findViewById(R.id.textInputlayoutsize);

        button_add= (Button) findViewById(R.id.buttonplus);
        button_skip= (Button) findViewById(R.id.buttonskip);
        button_next= (Button) findViewById(R.id.next_button);

        toolbar.setTitleTextColor(getResources().getColor(R.color.whitecolor));
        toolbar.setTitle(R.string.project_details);

        SharedPreferences mypref=getSharedPreferences("MYPREF", Context.MODE_PRIVATE);

        String s1=mypref.getString("TURN","");

        turn = Integer.parseInt(s1);

        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                project=1;
                toolbar.setTitle(R.string.project_details2);

                String title = editText1.getText().toString();
                String description = editText2.getText().toString();
                String time = editText3.getText().toString();
                String role = editText4.getText().toString();
                String size = editText5.getText().toString();
                String check = String.valueOf(skip);

                if(description.length()>160){
                    editText2.setError("You have cross the char limit");
                    return;
                }


                SharedPreferences project = getSharedPreferences(MYPREFER, Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = project.edit();

                editor.putString("TITLE", title);
                editor.putString("DES", description);
                editor.putString("TIME", time);
                editor.putString("ROLE", role);
                editor.putString("SIZE", size);


                editor.putString("SKIP", check);


                editor.apply();

                editText1.setText("");
                editText2.setText("");
                editText3.setText("");
                editText4.setText("");
                editText5.setText("");
                button_add.setVisibility(View.GONE);
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                params.addRule(RelativeLayout.BELOW, R.id.textInputlayoutsize);
                params.addRule(RelativeLayout.ALIGN_LEFT, R.id.textInputlayoutsize);
                params.addRule(RelativeLayout.ALIGN_RIGHT, R.id.textInputlayoutsize);

                button_skip.setLayoutParams(params);
                ViewGroup.LayoutParams param=button_skip.getLayoutParams();
                param.height=55;
                button_skip.setLayoutParams(param);



            }
        });

        button_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(project==0){
                    skip=2;
                }
                else {
                   skip=0;
                }


                String check= String.valueOf(skip);

                SharedPreferences project=getSharedPreferences(MYPREFER, Context.MODE_PRIVATE);

                SharedPreferences.Editor editor=project.edit();

                editor.putString("SKIP",check);


                editor.apply();

                if(turn==1) {

                    Intent intent = new Intent(ProjectDetails.this, Strengths.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(ProjectDetails.this, "You must have at least one project", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ProjectDetails.this, Strengths.class);
                    startActivity(intent);

                }

            }
        });

        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                    if(project==0) {
                        skip = 0;
                        String title = editText1.getText().toString();
                        String description = editText2.getText().toString();
                        String time = editText3.getText().toString();
                        String role = editText4.getText().toString();
                        String size = editText5.getText().toString();
                        String check = String.valueOf(skip);

                        if(description.length()>160){
                            editText2.setError("You have cross the char limit");
                            return;
                        }


                        SharedPreferences project = getSharedPreferences(MYPREFER, Context.MODE_PRIVATE);

                        SharedPreferences.Editor editor = project.edit();

                        editor.putString("TITLE", title);
                        editor.putString("DES", description);
                        editor.putString("TIME", time);
                        editor.putString("ROLE", role);
                        editor.putString("SIZE", size);


                        editor.putString("SKIP", check);


                        editor.apply();

                    }
                    else{
                        skip = 1;
                        String title = editText1.getText().toString();
                        String description = editText2.getText().toString();
                        String time = editText3.getText().toString();
                        String role = editText4.getText().toString();
                        String size = editText5.getText().toString();
                        String check = String.valueOf(skip);

                        if(description.length()>160){
                            editText2.setError("You have cross the char limit");
                            return;
                        }


                        SharedPreferences project = getSharedPreferences(MYPREFER, Context.MODE_PRIVATE);

                        SharedPreferences.Editor editor = project.edit();

                        editor.putString("TITLE2", title);
                        editor.putString("DES2", description);
                        editor.putString("TIME2", time);
                        editor.putString("ROLE2", role);
                        editor.putString("SIZE2", size);


                        editor.putString("SKIP", check);


                        editor.apply();

                    }

                if (turn == 1) {
                    Intent intent = new Intent(ProjectDetails.this, Strengths.class);
                    startActivity(intent);
                }

                else {

                    Intent intent = new Intent(ProjectDetails.this, StrengthsGraduate.class);
                    startActivity(intent);

                }
            }


        });

    }
}
