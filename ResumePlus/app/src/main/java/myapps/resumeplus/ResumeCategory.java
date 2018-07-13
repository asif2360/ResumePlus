package myapps.resumeplus;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Acer on 14-06-2017.
 */

public class ResumeCategory extends AppCompatActivity  {
    ImageView imageView1,imageView2,imageView3,imageView4;
    int turn=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.resumecategory);

        Toolbar toolbar= (Toolbar) findViewById(R.id.myToolBar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.whitecolor));
        toolbar.setTitle(R.string.resume_type);


        imageView1= (ImageView) findViewById(R.id.imageView);
        imageView2= (ImageView) findViewById(R.id.coolege_student);
        imageView3= (ImageView) findViewById(R.id.graduate);
        imageView4= (ImageView) findViewById(R.id.experienced);

        SharedPreferences mypref=getSharedPreferences("MYPREF", Context.MODE_PRIVATE);
        final SharedPreferences.Editor edit=mypref.edit();



        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    turn=1;

                    edit.putString("TURN", String.valueOf(turn));

                    edit.apply();

                    Intent intent=new Intent(ResumeCategory.this,MainProfile.class);
                    startActivity(intent);
                }
                catch (Exception e){
                   // Toast.makeText(ResumeCategory.this, ""+e, Toast.LENGTH_SHORT).show();
                }
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    turn=2;

                    edit.putString("TURN", String.valueOf(turn));

                    edit.apply();


                    Intent intent=new Intent(ResumeCategory.this,MainProfile.class);
                    startActivity(intent);
                }
                catch (Exception e){
                   // Toast.makeText(ResumeCategory.this, ""+e, Toast.LENGTH_SHORT).show();
                }
            }
        });
        
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ResumeCategory.this, "Keep calm,This feature will be added in next version", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
