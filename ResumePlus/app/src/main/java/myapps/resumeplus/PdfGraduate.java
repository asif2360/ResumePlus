package myapps.resumeplus;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Acer on 02-07-2017.
 */

public class PdfGraduate extends AppCompatActivity {

    TextView t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22, t23, t24, t25, t26;
    ImageView i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13;
    String s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14,special;
    Button button_gen;
    SimpleDateFormat sdf;
    PdfDocument document;
    PdfDocument.PageInfo pageinfo;
    PdfDocument.Page page;
    View view1;
    Bitmap bm;
    int style=0,turn=0;
    SharedPreferences count,turn_count;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pdfgraduate);
try {
    count = getSharedPreferences("style", Context.MODE_PRIVATE);
    special = count.getString("STYLE", "");


    style = Integer.parseInt(special);
}
catch (Exception e){
    //Toast.makeText(this, ""+e, Toast.LENGTH_SHORT).show();
}

  try {
      turn_count = getSharedPreferences("MYPREF", Context.MODE_PRIVATE);
      String s1 = turn_count.getString("TURN", "");

      turn = Integer.parseInt(s1);


  }
  catch (Exception e){
     // Toast.makeText(this, ""+e, Toast.LENGTH_SHORT).show();
  }

        init();

        personneldetail();

        addressdetail();

        mainprofile();

        educationdetail();

        technicalskills();



       reference_and_declaration();

        time_and_date();

        strength();

        setThemeColor();


        try{
            project_1_detail();
        }
        catch (Exception e){
            //Toast.makeText(this, ""+e, Toast.LENGTH_SHORT).show();
        }

        button_gen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generate();
            }
        });


    }

    private void setThemeColor() {

        SharedPreferences prefernce=getSharedPreferences("pref", Context.MODE_PRIVATE);

        s1=prefernce.getString("THEME1","");
        int theme= Integer.parseInt(s1);

        if(theme==1){

            t3.setTextColor(getResources().getColor(R.color.theme1));
            t5.setTextColor(getResources().getColor(R.color.theme1));
            t7.setTextColor(getResources().getColor(R.color.theme1));
            t9.setTextColor(getResources().getColor(R.color.theme1));
            t11.setTextColor(getResources().getColor(R.color.theme1));
            t13.setTextColor(getResources().getColor(R.color.theme1));
            t15.setTextColor(getResources().getColor(R.color.theme1));
            t17.setTextColor(getResources().getColor(R.color.theme1));
            t19.setTextColor(getResources().getColor(R.color.theme1));
            t21.setTextColor(getResources().getColor(R.color.theme1));
            t23.setTextColor(getResources().getColor(R.color.theme1));
        }

        else if(theme==2){

            t3.setTextColor(getResources().getColor(R.color.theme2));
            t5.setTextColor(getResources().getColor(R.color.theme2));
            t7.setTextColor(getResources().getColor(R.color.theme2));
            t9.setTextColor(getResources().getColor(R.color.theme2));
            t11.setTextColor(getResources().getColor(R.color.theme2));
            t13.setTextColor(getResources().getColor(R.color.theme2));
            t15.setTextColor(getResources().getColor(R.color.theme2));
            t17.setTextColor(getResources().getColor(R.color.theme2));
            t19.setTextColor(getResources().getColor(R.color.theme2));
            t21.setTextColor(getResources().getColor(R.color.theme2));
            t23.setTextColor(getResources().getColor(R.color.theme2));
        }

        else if(theme==3){

            t3.setTextColor(getResources().getColor(R.color.theme3));
            t5.setTextColor(getResources().getColor(R.color.theme3));
            t7.setTextColor(getResources().getColor(R.color.theme3));
            t9.setTextColor(getResources().getColor(R.color.theme3));
            t11.setTextColor(getResources().getColor(R.color.theme3));
            t13.setTextColor(getResources().getColor(R.color.theme3));
            t15.setTextColor(getResources().getColor(R.color.theme3));
            t17.setTextColor(getResources().getColor(R.color.theme3));
            t19.setTextColor(getResources().getColor(R.color.theme3));
            t21.setTextColor(getResources().getColor(R.color.theme3));
            t23.setTextColor(getResources().getColor(R.color.theme3));
        }

        else if(theme==4){

            t3.setTextColor(getResources().getColor(R.color.theme4));
            t5.setTextColor(getResources().getColor(R.color.theme4));
            t7.setTextColor(getResources().getColor(R.color.theme4));
            t9.setTextColor(getResources().getColor(R.color.theme4));
            t11.setTextColor(getResources().getColor(R.color.theme4));
            t13.setTextColor(getResources().getColor(R.color.theme4));
            t15.setTextColor(getResources().getColor(R.color.theme4));
            t17.setTextColor(getResources().getColor(R.color.theme4));
            t19.setTextColor(getResources().getColor(R.color.theme4));
            t21.setTextColor(getResources().getColor(R.color.theme4));
            t23.setTextColor(getResources().getColor(R.color.theme4));
        }

        else if(theme==5){

            t3.setTextColor(getResources().getColor(R.color.theme5));
            t5.setTextColor(getResources().getColor(R.color.theme5));
            t7.setTextColor(getResources().getColor(R.color.theme5));
            t9.setTextColor(getResources().getColor(R.color.theme5));
            t11.setTextColor(getResources().getColor(R.color.theme5));
            t13.setTextColor(getResources().getColor(R.color.theme5));
            t15.setTextColor(getResources().getColor(R.color.theme5));
            t17.setTextColor(getResources().getColor(R.color.theme5));
            t19.setTextColor(getResources().getColor(R.color.theme5));
            t21.setTextColor(getResources().getColor(R.color.theme5));
            t23.setTextColor(getResources().getColor(R.color.theme5));
        }

        else if(theme==6){

            t3.setTextColor(getResources().getColor(R.color.theme6));
            t5.setTextColor(getResources().getColor(R.color.theme6));
            t7.setTextColor(getResources().getColor(R.color.theme6));
            t9.setTextColor(getResources().getColor(R.color.theme6));
            t11.setTextColor(getResources().getColor(R.color.theme6));
            t13.setTextColor(getResources().getColor(R.color.theme6));
            t15.setTextColor(getResources().getColor(R.color.theme6));
            t17.setTextColor(getResources().getColor(R.color.theme6));
            t19.setTextColor(getResources().getColor(R.color.theme6));
            t21.setTextColor(getResources().getColor(R.color.theme6));
            t23.setTextColor(getResources().getColor(R.color.theme6));
        }

        else {
            t3.setTextColor(getResources().getColor(R.color.black));
            t5.setTextColor(getResources().getColor(R.color.black));
            t7.setTextColor(getResources().getColor(R.color.black));
            t9.setTextColor(getResources().getColor(R.color.black));
            t11.setTextColor(getResources().getColor(R.color.black));
            t13.setTextColor(getResources().getColor(R.color.black));
            t15.setTextColor(getResources().getColor(R.color.black));
            t17.setTextColor(getResources().getColor(R.color.black));
            t19.setTextColor(getResources().getColor(R.color.black));
            t21.setTextColor(getResources().getColor(R.color.black));
            t23.setTextColor(getResources().getColor(R.color.black));
        }

    }

    private void init() {

        t1 = (TextView) findViewById(R.id.top_name_field);
        t3 = (TextView) findViewById(R.id.personnel);
        t4 = (TextView) findViewById(R.id.personnel_detail);
        t5 = (TextView) findViewById(R.id.project);
        t6 = (TextView) findViewById(R.id.project_detail);
        t7 = (TextView) findViewById(R.id.about_me);
        t8 = (TextView) findViewById(R.id.about_me_detail);
        t9 = (TextView) findViewById(R.id.education);
        t10 = (TextView) findViewById(R.id.education_detail);
        t11 = (TextView) findViewById(R.id.field_of_interest);
        t12 = (TextView) findViewById(R.id.foi_detail);
        t13 = (TextView) findViewById(R.id.skills);
        t14 = (TextView) findViewById(R.id.skills_detail);
        t15 = (TextView) findViewById(R.id.strength);
        t16 = (TextView) findViewById(R.id.strength_detail);
        t17 = (TextView) findViewById(R.id.achievements);
        t18 = (TextView) findViewById(R.id.achievements_details);
        t19 = (TextView) findViewById(R.id.carricular);
        t20 = (TextView) findViewById(R.id.carricular_detail);
        t21 = (TextView) findViewById(R.id.reference);
        t22 = (TextView) findViewById(R.id.reference_detail);
        t23 = (TextView) findViewById(R.id.declaration);
        t24 = (TextView) findViewById(R.id.declaration_detail);
        t25 = (TextView) findViewById(R.id.date_time);



        i1 = (ImageView) findViewById(R.id.imageViewLocation);
        i2 = (ImageView) findViewById(R.id.imageViewProject);
        i3 = (ImageView) findViewById(R.id.imageViewAboutMe);
        i4 = (ImageView) findViewById(R.id.imageViewField);
        i5 = (ImageView) findViewById(R.id.imageViewEducation);
        i6 = (ImageView) findViewById(R.id.imageViewSkills);
        i7 = (ImageView) findViewById(R.id.imageViewStrength);
        i8 = (ImageView) findViewById(R.id.imageViewAchievements);
        i9 = (ImageView) findViewById(R.id.imageViewCarricular);
        i10 = (ImageView) findViewById(R.id.imageViewReference);
        i11 = (ImageView) findViewById(R.id.imageViewDeclaration);
        i12 = (ImageView) findViewById(R.id.imageViewSign);
        i13 = (ImageView) findViewById(R.id.photo);


        button_gen= (Button) findViewById(R.id.button_gen_pdf);

    }


    private void personneldetail() {

        SharedPreferences prefernce = getSharedPreferences("pref", Context.MODE_PRIVATE);

        s1 = prefernce.getString("F_NAME", "");
        s2 = prefernce.getString("L_NAME", "");
        s3 = prefernce.getString("DATE", "");
        s4 = prefernce.getString("NATIONALITY", "");
        s5 = prefernce.getString("CONTACT", "");
        s6 = prefernce.getString("MARTIAL", "");
        s7 = prefernce.getString("EMAIL", "");


        t1.setText(s1 + " " + s2+"\n"+s5+"\n"+s7);



    }

    private void addressdetail() {




        SharedPreferences prefernce=getSharedPreferences("pref", Context.MODE_PRIVATE);

        s1=prefernce.getString("AREA","");
        s2=prefernce.getString("STREET","");
        s3=prefernce.getString("CITY","");
        s4=prefernce.getString("PINCODE","");
        s5=prefernce.getString("STATE","");

        s6=s1+"\n"+s2+", "+s3+"\n"+s4+", "+s5;


        t4.setText(s6);


    }

    private void mainprofile() {

        SharedPreferences prefernce = getSharedPreferences("pref", Context.MODE_PRIVATE);

        s1 = prefernce.getString("OBJECTIVE", "");

        s2 = prefernce.getString("IMAGE", "");

        s3=prefernce.getString("MAIN_IMAGE","");

        Bitmap bitmaps;



        if (!s2.equals("")) {
            bitmaps = decode(s2);
            try {
                bm = Bitmap.createScaledBitmap(bitmaps, 170, 45, true);
                i12.setImageBitmap(bm);
            } catch (Exception e) {
               // Toast.makeText(this, "" + e, Toast.LENGTH_SHORT).show();
            }







        }

        if(!s3.equals("")){
            bitmaps=decode(s3);

            try {
                bm = Bitmap.createScaledBitmap(bitmaps, 120, 120, true);
                i13.setImageBitmap(bm);
            } catch (Exception e) {
               // Toast.makeText(this, "" + e, Toast.LENGTH_SHORT).show();
            }
        }

        t8.setText(s1);
    }


    private void educationdetail() {

        SharedPreferences prefernce=getSharedPreferences("prefgarduate", Context.MODE_PRIVATE);

        s1=prefernce.getString("SCHOOL","");
        s2=prefernce.getString("PERCENT","");
        s3=prefernce.getString("BOARD","");
        s4=prefernce.getString("PASSING","");

        s5=prefernce.getString("SCHOOL12","");
        s6=prefernce.getString("PERCENT12","");
        s7=prefernce.getString("BOARD12","");
        s8=prefernce.getString("PASSING12","");


        s9=prefernce.getString("COLLEGE","");
        s10=prefernce.getString("COURSE","");
        s11=prefernce.getString("FIELD","");
        s12=prefernce.getString("DURATION","");
        s13=prefernce.getString("OVER_PERCENT","");


        String set="HIGH SCHOOL\n"+s1+"\n"+s2+"\n"+s3+"\n"+s4;

        String set12="SENIOR SECONDARY\n"+s5+"\n"+s6+"\n"+s7+"\n"+s8;

        String college="GRADUATION\n"+s9+"\n"+s10+"\n"+s11+"  "+s12+"\n"+s13;

        if(style==2&&turn==1){
            SharedPreferences prefernce2=getSharedPreferences("pref", Context.MODE_PRIVATE);

            s1=prefernce2.getString("SCHOOL","");
            s2=prefernce2.getString("PERCENT","");
            s3=prefernce2.getString("BOARD","");
            s4=prefernce2.getString("PASSING","");

            s5=prefernce2.getString("SCHOOL12","");
            s6=prefernce2.getString("PERCENT12","");
            s7=prefernce2.getString("BOARD12","");
            s8=prefernce2.getString("PASSING12","");

            String setstyle2="HIGH SCHOOL\n\n"+s1+"\n"+s2+"\n"+s3+"\n"+s4;

            String set12style2="SENIOR SECONDARY\n\n"+s5+"\n"+s6+"\n"+s7+"\n"+s8;

            t10.setText(setstyle2 + "\n\n" + set12style2);
        }
   else {
            t10.setText(set + "\n\n" + set12 + "\n\n" + college);
        }

    }



    private void technicalskills() {
        int turn=0;
        int intereset=0;

        SharedPreferences prefernce=getSharedPreferences("pref_new", Context.MODE_PRIVATE);

        s1=prefernce.getString("C","");
        s2=prefernce.getString("CPLUS","");
        s3=prefernce.getString("JAVA","");
        s4=prefernce.getString("HTML","");

        s5=prefernce.getString("CSS","");
        s6=prefernce.getString("SQL","");
        s7=prefernce.getString("ANDROID","");
        s8=prefernce.getString("JAVASCRIPT","");

        s9=prefernce.getString("SKILL1","");
        s10=prefernce.getString("SKILL2","");
        s11=prefernce.getString("SKILL3","");

        s12=prefernce.getString("FOI1","");
        s13=prefernce.getString("FOI2","");
        s14=prefernce.getString("FOI3","");

        String interes="";

        if(!s12.matches("")){
            interes="1."+s12;
            intereset++;

        }

        if(!s13.matches("")){
            if(intereset==0){
                interes="1."+s13;
            }
            else{
                interes=interes+"\n2."+s13;
            }
            intereset++;
        }


        if(!s14.matches("")){
            if(intereset==0){
                interes="1."+s14;
            }
            else if(intereset==1){
                interes=interes+"\n2."+s14;
            }
            else {
                interes=interes+"\n3."+s14;
            }
            intereset++;
        }


        t12.setText(interes);

        String set="";





        if(!s1.matches("")){
            set="1."+s1;
            turn++;
        }
        if(!s2.matches("")){
            if(turn==0){
                set="1."+s2;
            }
            else{
                set=set+"\t\t\t\t\t2."+s2;
            }
            turn++;
        }


        if(!s3.matches("")){
            if(turn==0){
                set="1."+s3;
            }
            else if(turn==1){
                set=set+"\t\t\t\t\t2."+s3;
            }
            else {
                set=set+"\t\t\t\t\t3."+s3;
            }
            turn++;
        }
        if(!s4.matches("")){
            if(turn==0){
                set="1."+s4;
            }
            else if(turn==1){
                set=set+"\t\t\t\t\t2."+s4;
            }
            else if(turn==2){
                set=set+"\t\t\t\t\t3."+s4;
            }
            else{
                set=set+"\t\t\t\t\t4."+s4;
            }
            turn++;
        }
        if(!s5.matches("")){
            if(turn==0){
                set="1."+s5;
            }
            else if(turn==1){
                set=set+"\t\t\t\t\t2."+s5;
            }
            else if(turn==2){
                set=set+"\t\t\t\t\t3."+s5;
            }
            else if(turn==3){
                set=set+"\t\t\t\t\t4."+s5;
            }
            else {
                set=set+"\t\t\t\t\t5."+s5;
            }
            turn++;
        }
        if(!s6.matches("")){
            if(turn==0){
                set="1."+s6;
            }
            else if(turn==1){
                set=set+"\t\t\t\t\t2."+s6;
            }
            else if(turn==2){
                set=set+"\t\t\t\t\t3."+s6;
            }
            else if(turn==3){
                set=set+"\t\t\t\t\t4."+s6;
            }
            else  if(turn==4){
                set=set+"\t\t\t\t\t5."+s6;
            }
            else {
                set=set+"\t\t\t\t\t6."+s6;
            }
            turn++;
        }
        if(!s7.matches("")){
            if(turn==0){
                set="1."+s7;
            }
            else if(turn==1){
                set=set+"\t\t\t\t\t2."+s7;
            }
            else if(turn==2){
                set=set+"\t\t\t\t\t3."+s7;
            }
            else if(turn==3){
                set=set+"\t\t\t\t\t4."+s7;
            }
            else  if(turn==4){
                set=set+"\t\t\t\t\t5."+s7;
            }
            else if(turn==5) {
                set=set+"\t\t\t\t\t6."+s7;
            }
            else {
                set=set+"\t\t\t\t\t7."+s7;
            }
            turn++;
        }
        if(!s8.matches("")){
            if(turn==0){
                set="1."+s8;
            }
            else if(turn==1){
                set=set+"\t\t\t\t\t2."+s8;
            }
            else if(turn==2){
                set=set+"\t\t\t\t\t3."+s8;
            }
            else if(turn==3){
                set=set+"\t\t\t\t\t4."+s8;
            }
            else  if(turn==4){
                set=set+"\t\t\t\t\t5."+s8;
            }
            else if(turn==5) {
                set=set+"\t\t\t\t\t6."+s8;
            }
            else if(turn==6)  {
                set=set+"\t\t\t\t\t7."+s8;
            }
            else {
                set=set+"\t\t\t\t\t8."+s8;

            }
            turn++;
        }




        if(!s9.matches("")){
            if(turn==0){
                set="1."+s9;
            }
            else if(turn==1){
                set=set+"\t\t\t\t\t2."+s9;
            }
            else if(turn==2){
                set=set+"\t\t\t\t\t3."+s9;
            }
            else if(turn==3){
                set=set+"\t\t\t\t\t4."+s9;
            }
            else  if(turn==4){
                set=set+"\t\t\t\t\t5."+s9;
            }
            else if(turn==5) {
                set=set+"\t\t\t\t\t6."+s9;
            }
            else if(turn==6)  {
                set=set+"\t\t\t\t\t7."+s9;
            }
            else if(turn==7){
                set=set+"\t\t\t\t\t8."+s9;

            }
            else {
                set=set+"\t\t\t\t\t9."+s9;
            }

            turn++;
        }
        if(!s10.matches("")){
            if(turn==0){
                set="1."+s10;
            }
            else if(turn==1){
                set=set+"\t\t\t\t\t2."+s10;
            }
            else if(turn==2){
                set=set+"\t\t\t\t\t3."+s10;
            }
            else if(turn==3){
                set=set+"\t\t\t\t\t4."+s10;
            }
            else  if(turn==4){
                set=set+"\t\t\t\t\t5."+s10;
            }
            else if(turn==5) {
                set=set+"\t\t\t\t\t6."+s10;
            }
            else if(turn==6)  {
                set=set+"\t\t\t\t\t7."+s10;
            }
            else if(turn==7){
                set=set+"\t\t\t\t\t8."+s10;

            }
            else if(turn==8) {
                set=set+"\t\t\t\t\t9."+s10;
            }
            else{
                set=set+"\t\t\t\t\t10."+s10;
            }

            turn++;
        }
        if(!s11.matches("")){
            if(turn==0){
                set="1."+s11;
            }
            else if(turn==1){
                set=set+"\t\t\t\t\t2."+s11;
            }
            else if(turn==2){
                set=set+"\t\t\t\t\t3."+s11;
            }
            else if(turn==3){
                set=set+"\t\t\t\t\t4."+s11;
            }
            else  if(turn==4){
                set=set+"\t\t\t\t\t5."+s11;
            }
            else if(turn==5) {
                set=set+"\t\t\t\t\t6."+s11;
            }
            else if(turn==6)  {
                set=set+"\t\t\t\t\t7."+s11;
            }
            else if(turn==7){
                set=set+"\t\t\t\t\t8."+s11;

            }
            else if(turn==8) {
                set=set+"\t\t\t\t\t9."+s11;
            }
            else if(turn==9) {
                set=set+"\t\t\t\t\t10."+s11;


            }
            else {
                set=set+"\t\t\t\t\t11."+s11;
            }


            turn++;
        }


        t14.setText(set);


    }

    private void project_1_detail() {



        SharedPreferences prefernce=getSharedPreferences("prefgrad", Context.MODE_PRIVATE);

        s1=prefernce.getString("TITLE","");
        s2=prefernce.getString("DES","");
        s3=prefernce.getString("TIME","");
        s4=prefernce.getString("ROLE","");
        s5=prefernce.getString("SIZE","");
        s6=prefernce.getString("SKIP","");

        int skip= Integer.parseInt(s6);




        String title1="TITLE :"+s1+"\n\nDESCRIPTION :"+s2+"\n\nTIME :"+s3+"\n\nROLE :"+s4+"\n\nSIZE :"+s5;


        s1=prefernce.getString("TITLE2","");
        s2=prefernce.getString("DES2","");
        s3=prefernce.getString("TIME2","");
        s4=prefernce.getString("ROLE2","");
        s5=prefernce.getString("SIZE2","");


        String title2="TITLE :"+s1+"\n\nDESCRIPTION :"+s2+"\n\nTIME :"+s3+"\n\nROLE :"+s4+"\n\nSIZE :"+s5;

        if(skip==1){
            t6.setText("PROJECT 1\n"+title1+"\n\nPROJECT 2\n"+title2);
        }
        else if(skip==0) {
            t6.setText("PROJECT 1 \n\n"+title1);
        }
        else {
            t5.setVisibility(View.GONE);
            t6.setVisibility(View.GONE);
            i2.setVisibility(View.GONE);

            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.RIGHT_OF, R.id.personnel);
            params.addRule(RelativeLayout.ALIGN_BOTTOM,R.id.personnel);
            params.setMargins(58,0,0,0);
            i7.setLayoutParams(params);

        }




    }


    private void reference_and_declaration() {

        SharedPreferences prefernce=getSharedPreferences("pref", Context.MODE_PRIVATE);

        s1=prefernce.getString("REFNAME","");
        s2=prefernce.getString("REFMOB","");
        s3=prefernce.getString("REFEMAIL","");



        s4=prefernce.getString("DEC","");


        s5=prefernce.getString("REFSKIP","");

        int skip= Integer.parseInt(s5);

        String set="NAME\t:\t"+s1+"\nMOB\t\t:\t\t"+s2+"\nEMAIL\t:\t"+s3;

        String ref="SELF GENERATED";
        if(skip==1){
            t22.setText(ref);

        }
        else{
            t22.setText(set);
        }

        t24.setText(s4);

    }



    private void time_and_date() {

        Calendar cal=Calendar.getInstance();
        sdf=new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        String  strDate=sdf.format(cal.getTime());



        sdf=new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        String strTime=sdf.format(cal.getTime());

        String set="DATE : "+strDate+"\nTIME : "+strTime;
        t25.setText(set);

    }


    private void strength() {
        int t1=0,t2=0,t3=0;

        if(style==2&&turn==1){

            SharedPreferences prefernce=getSharedPreferences("pref", Context.MODE_PRIVATE);

            s1=prefernce.getString("S1","");
            s2=prefernce.getString("S2","");
            s3=prefernce.getString("A1","");
            s4=prefernce.getString("A2","");
            s5=prefernce.getString("E1","");
            s6=prefernce.getString("E2","");

            String strength="";

            if(!s1.matches("")){
                strength="1."+s1;
                t1++;
            }
            if(!s2.matches("")){
                if(t1==0){
                    strength="1."+s2;
                }
                else{
                    strength=strength+"\n2."+s2;
                }

            }
            t16.setText(strength);

            String achieve="";

            if(!s3.matches("")){
                achieve="1."+s3;
                t2++;
            }
            if(!s4.matches("")){
                if(t2==0){
                    achieve="1."+s4;
                }
                else{
                    achieve=achieve+"\n2."+s4;
                }

            }

            t18.setText(achieve);

            String extra="";

            if(!s5.matches("")){
                extra="1."+s5;
                t3++;
            }
            if(!s6.matches("")){
                if(t3==0){
                    extra="1."+s6;
                }
                else{
                    extra=extra+"\n2."+s6;
                }

            }

            t20.setText(extra);
        }
else {
            SharedPreferences prefernce = getSharedPreferences("pref", Context.MODE_PRIVATE);

            s1 = prefernce.getString("S1", "");
            s2 = prefernce.getString("S2", "");
            s3 = prefernce.getString("S3", "");
            s4 = prefernce.getString("A1", "");
            s5 = prefernce.getString("A2", "");
            s6 = prefernce.getString("A3", "");
            s7 = prefernce.getString("E1", "");
            s8 = prefernce.getString("E2", "");
            s9 = prefernce.getString("E3", "");

            String strength = "";

            if (!s1.matches("")) {
                strength = "1." + s1;
                t1++;
            }
            if (!s2.matches("")) {
                if (t1 == 0) {
                    strength = "1." + s2;
                    t1++;
                } else {
                    strength = strength + "\n2." + s2;
                    t1++;
                }

            }
            if (!s3.matches("")) {
                if (t1 == 0) {
                    strength = "1. " + s3;
                } else if (t1 == 1) {
                    strength = strength + "\n2." + s3;
                } else {
                    strength = strength + "\n3." + s3;
                }
            }
            t16.setText(strength);

            String achieve = "";

            if (!s4.matches("")) {
                achieve = "1." + s4;
                t2++;
            }
            if (!s5.matches("")) {
                if (t2 == 0) {
                    achieve = "1." + s5;
                    t2++;
                } else {
                    achieve = achieve + "\n2." + s5;
                    t2++;
                }

            }

            if (!s6.matches("")) {
                if (t2 == 0) {
                    achieve = "1. " + s6;
                } else if (t2 == 1) {
                    achieve = achieve + "\n2." + s6;
                } else {
                    achieve = achieve + "\n3." + s6;
                }
            }

            t18.setText(achieve);

            String extra = "";

            if (!s7.matches("")) {
                extra = "1." + s7;
                t3++;
            }
            if (!s8.matches("")) {
                if (t3 == 0) {
                    extra = "1." + s8;
                    t3++;
                } else {
                    extra = extra + "\n2." + s8;
                    t3++;
                }

            }
            if (!s9.matches("")) {
                if (t3 == 0) {
                    extra = "1. " + s9;
                } else if (t3 == 1) {
                    extra = extra + "\n2." + s9;
                } else {
                    extra = extra + "\n3." + s9;
                }
            }

            t20.setText(extra);

        }

    }


    private void generate() {
        try {
            button_gen.setVisibility(View.GONE);

            view1 = findViewById(R.id.children1graduate);


            document = new PdfDocument();


            int noOfPages = (int) Math.floor(view1.getHeight() / 900 + 1);




                    pageinfo = new PdfDocument.PageInfo.Builder(view1.getWidth(), view1.getHeight(), 1).create();

                    page = document.startPage(pageinfo);

                    view1.draw(page.getCanvas());




                document.finishPage(page);


        }

        catch (Exception e){
           // Toast.makeText(this, ""+e, Toast.LENGTH_SHORT).show();
        }

        AlertDialog.Builder alert=new AlertDialog.Builder(PdfGraduate.this);
        alert.setTitle("FILE NAME");
        alert.setMessage("Enter file name");

        final EditText edittext=new EditText(PdfGraduate.this);
        RelativeLayout.LayoutParams rel=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        edittext.setLayoutParams(rel);

        alert.setView(edittext);
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String fetch=edittext.getText().toString();
                String storagepath= Environment.getExternalStorageDirectory().getAbsolutePath();
                String targetpdf=storagepath+"/DigitSign/"+fetch+".pdf";
                // String DIRECTORY = Environment.getExternalStorageDirectory().getPath() + "/DigitSign/";
                //String pic_name = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());*/
                // String StoredPath = DIRECTORY + fetch + ".pdf";
                File path=new File(targetpdf);
                try{

                    document.writeTo(new FileOutputStream(path));
                    document.close();
                    Toast.makeText(PdfGraduate.this, "Generated", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        final  AlertDialog alertDialog=alert.create();
        alertDialog.show();

        Button positive=alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
        positive.setTextColor(Color.GREEN);

      /*  String DIRECTORY = Environment.getExternalStorageDirectory().getPath() + "/DigitSign/";
        String pic_name = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        String StoredPath = DIRECTORY + pic_name + ".pdf";
        File path=new File(StoredPath);*/

    }


    public  static Bitmap decode(String input){
        byte[] decodebyte= Base64.decode(input,0);

        return BitmapFactory.decodeByteArray(decodebyte,0,decodebyte.length);
    }

}
