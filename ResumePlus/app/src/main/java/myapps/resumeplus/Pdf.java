package myapps.resumeplus;

import android.app.Activity;
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
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static android.R.attr.button;
import static android.R.attr.elegantTextHeight;
import static android.R.attr.path;

/**
 * Created by Acer on 20-06-2017.
 */

public class Pdf extends Activity{

    private static final String MYPREFER ="pref" ;
    PdfDocument document;
    PdfDocument.PageInfo pageinfo;
    PdfDocument.Page page;
    View view1;
    Button button;
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18;
    TextView t19,t20,t21,t22,t23,t24,t25,t26,t27,t28,t29,t30;
    TextView t31,t32,t33,t34,t35,t36,t37;
    ImageView imageView_sign;
    RadioButton radioButton1,radioButton2,radioButton3,radioButton4;
    SimpleDateFormat sdf;
    String strDate;

    String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pdflayout);


        init();


        personneldetail();

        addressdetail();

        mainprofile();

        educationdetail();
        
        technicalskills();




        reference_and_declaration();


        strength();

        setThemeColor();

        time_and_date();


        try{

            project_1_detail();
        }
        catch (Exception e){
           // Toast.makeText(this, ""+e, Toast.LENGTH_SHORT).show();
        }




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    generate();
                }
                catch (Exception e){
                   // Toast.makeText(Pdf.this, ""+e, Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private void time_and_date() {

        Calendar cal=Calendar.getInstance();
        sdf=new SimpleDateFormat("dd-MM-yyyy",Locale.getDefault());
        String  strDate=sdf.format(cal.getTime());



        sdf=new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        String strTime=sdf.format(cal.getTime());

        String set="DATE : "+strDate+"\nTIME : "+strTime;
        t30.setText(set);

    }

    private void setThemeColor() {

        SharedPreferences prefernce=getSharedPreferences("pref", Context.MODE_PRIVATE);

        s1=prefernce.getString("THEME1","");
        int theme= Integer.parseInt(s1);


      if(theme==1) {
          t1.setBackgroundColor(getResources().getColor(R.color.theme1));
          t8.setBackgroundColor(getResources().getColor(R.color.theme1));
          t10.setBackgroundColor(getResources().getColor(R.color.theme1));
          t13.setBackgroundColor(getResources().getColor(R.color.theme1));
          t15.setBackgroundColor(getResources().getColor(R.color.theme1));
          t18.setBackgroundColor(getResources().getColor(R.color.theme1));
          t20.setBackgroundColor(getResources().getColor(R.color.theme1));
          t22.setBackgroundColor(getResources().getColor(R.color.theme1));
          t24.setBackgroundColor(getResources().getColor(R.color.theme1));
          t26.setBackgroundColor(getResources().getColor(R.color.theme1));
          t28.setBackgroundColor(getResources().getColor(R.color.theme1));
          t31.setBackgroundColor(getResources().getColor(R.color.theme1));
          t33.setBackgroundColor(getResources().getColor(R.color.theme1));
          t35.setBackgroundColor(getResources().getColor(R.color.theme1));

          button.setBackgroundColor(getResources().getColor(R.color.theme1));

          radioButton1.setTextColor(getResources().getColor(R.color.theme1));
          radioButton2.setTextColor(getResources().getColor(R.color.theme1));
          radioButton3.setTextColor(getResources().getColor(R.color.theme1));
          radioButton4.setTextColor(getResources().getColor(R.color.theme1));
      }
      else  if(theme==2){

          t1.setBackgroundColor(getResources().getColor(R.color.theme2));
          t8.setBackgroundColor(getResources().getColor(R.color.theme2));
          t10.setBackgroundColor(getResources().getColor(R.color.theme2));
          t13.setBackgroundColor(getResources().getColor(R.color.theme2));
          t15.setBackgroundColor(getResources().getColor(R.color.theme2));
          t18.setBackgroundColor(getResources().getColor(R.color.theme2));
          t20.setBackgroundColor(getResources().getColor(R.color.theme2));
          t22.setBackgroundColor(getResources().getColor(R.color.theme2));
          t24.setBackgroundColor(getResources().getColor(R.color.theme2));
          t26.setBackgroundColor(getResources().getColor(R.color.theme2));
          t28.setBackgroundColor(getResources().getColor(R.color.theme2));
          t31.setBackgroundColor(getResources().getColor(R.color.theme2));
          t33.setBackgroundColor(getResources().getColor(R.color.theme2));
          t35.setBackgroundColor(getResources().getColor(R.color.theme2));

          button.setBackgroundColor(getResources().getColor(R.color.theme2));

          radioButton1.setTextColor(getResources().getColor(R.color.theme2));
          radioButton2.setTextColor(getResources().getColor(R.color.theme2));
          radioButton3.setTextColor(getResources().getColor(R.color.theme2));
          radioButton4.setTextColor(getResources().getColor(R.color.theme2));
  }

      else if(theme==3){

          t1.setBackgroundColor(getResources().getColor(R.color.theme3));
          t8.setBackgroundColor(getResources().getColor(R.color.theme3));
          t10.setBackgroundColor(getResources().getColor(R.color.theme3));
          t13.setBackgroundColor(getResources().getColor(R.color.theme3));
          t15.setBackgroundColor(getResources().getColor(R.color.theme3));
          t18.setBackgroundColor(getResources().getColor(R.color.theme3));
          t20.setBackgroundColor(getResources().getColor(R.color.theme3));
          t22.setBackgroundColor(getResources().getColor(R.color.theme3));
          t24.setBackgroundColor(getResources().getColor(R.color.theme3));
          t26.setBackgroundColor(getResources().getColor(R.color.theme3));
          t28.setBackgroundColor(getResources().getColor(R.color.theme3));
          t31.setBackgroundColor(getResources().getColor(R.color.theme3));
          t33.setBackgroundColor(getResources().getColor(R.color.theme3));
          t35.setBackgroundColor(getResources().getColor(R.color.theme3));

          button.setBackgroundColor(getResources().getColor(R.color.theme3));

          radioButton1.setTextColor(getResources().getColor(R.color.theme3));
          radioButton2.setTextColor(getResources().getColor(R.color.theme3));
          radioButton3.setTextColor(getResources().getColor(R.color.theme3));
          radioButton4.setTextColor(getResources().getColor(R.color.theme3));

      }

      else if(theme==4){

          t1.setBackgroundColor(getResources().getColor(R.color.theme4));
          t8.setBackgroundColor(getResources().getColor(R.color.theme4));
          t10.setBackgroundColor(getResources().getColor(R.color.theme4));
          t13.setBackgroundColor(getResources().getColor(R.color.theme4));
          t15.setBackgroundColor(getResources().getColor(R.color.theme4));
          t18.setBackgroundColor(getResources().getColor(R.color.theme4));
          t20.setBackgroundColor(getResources().getColor(R.color.theme4));
          t22.setBackgroundColor(getResources().getColor(R.color.theme4));
          t24.setBackgroundColor(getResources().getColor(R.color.theme4));
          t26.setBackgroundColor(getResources().getColor(R.color.theme4));
          t28.setBackgroundColor(getResources().getColor(R.color.theme4));
          t31.setBackgroundColor(getResources().getColor(R.color.theme4));
          t33.setBackgroundColor(getResources().getColor(R.color.theme4));
          t35.setBackgroundColor(getResources().getColor(R.color.theme4));

          button.setBackgroundColor(getResources().getColor(R.color.theme4));

          radioButton1.setTextColor(getResources().getColor(R.color.theme4));
          radioButton2.setTextColor(getResources().getColor(R.color.theme4));
          radioButton3.setTextColor(getResources().getColor(R.color.theme4));
          radioButton4.setTextColor(getResources().getColor(R.color.theme4));

      }

      else if(theme==5){

          t1.setBackgroundColor(getResources().getColor(R.color.theme5));
          t8.setBackgroundColor(getResources().getColor(R.color.theme5));
          t10.setBackgroundColor(getResources().getColor(R.color.theme5));
          t13.setBackgroundColor(getResources().getColor(R.color.theme5));
          t15.setBackgroundColor(getResources().getColor(R.color.theme5));
          t18.setBackgroundColor(getResources().getColor(R.color.theme5));
          t20.setBackgroundColor(getResources().getColor(R.color.theme5));
          t22.setBackgroundColor(getResources().getColor(R.color.theme5));
          t24.setBackgroundColor(getResources().getColor(R.color.theme5));
          t26.setBackgroundColor(getResources().getColor(R.color.theme5));
          t28.setBackgroundColor(getResources().getColor(R.color.theme5));
          t31.setBackgroundColor(getResources().getColor(R.color.theme5));
          t33.setBackgroundColor(getResources().getColor(R.color.theme5));
          t35.setBackgroundColor(getResources().getColor(R.color.theme5));

          button.setBackgroundColor(getResources().getColor(R.color.theme5));

          radioButton1.setTextColor(getResources().getColor(R.color.theme5));
          radioButton2.setTextColor(getResources().getColor(R.color.theme5));
          radioButton3.setTextColor(getResources().getColor(R.color.theme5));
          radioButton4.setTextColor(getResources().getColor(R.color.theme5));

      }

      else if(theme==6){

          t1.setBackgroundColor(getResources().getColor(R.color.theme6));
          t8.setBackgroundColor(getResources().getColor(R.color.theme6));
          t10.setBackgroundColor(getResources().getColor(R.color.theme6));
          t13.setBackgroundColor(getResources().getColor(R.color.theme6));
          t15.setBackgroundColor(getResources().getColor(R.color.theme6));
          t18.setBackgroundColor(getResources().getColor(R.color.theme6));
          t20.setBackgroundColor(getResources().getColor(R.color.theme6));
          t22.setBackgroundColor(getResources().getColor(R.color.theme6));
          t24.setBackgroundColor(getResources().getColor(R.color.theme6));
          t26.setBackgroundColor(getResources().getColor(R.color.theme6));
          t28.setBackgroundColor(getResources().getColor(R.color.theme6));
          t31.setBackgroundColor(getResources().getColor(R.color.theme6));
          t33.setBackgroundColor(getResources().getColor(R.color.theme6));
          t35.setBackgroundColor(getResources().getColor(R.color.theme6));

          button.setBackgroundColor(getResources().getColor(R.color.theme6));

          radioButton1.setTextColor(getResources().getColor(R.color.theme6));
          radioButton2.setTextColor(getResources().getColor(R.color.theme6));
          radioButton3.setTextColor(getResources().getColor(R.color.theme6));
          radioButton4.setTextColor(getResources().getColor(R.color.theme6));

      }
      else {

          t1.setBackgroundColor(getResources().getColor(R.color.black));
          t8.setBackgroundColor(getResources().getColor(R.color.black));
          t10.setBackgroundColor(getResources().getColor(R.color.black));
          t13.setBackgroundColor(getResources().getColor(R.color.black));
          t15.setBackgroundColor(getResources().getColor(R.color.black));
          t18.setBackgroundColor(getResources().getColor(R.color.black));
          t20.setBackgroundColor(getResources().getColor(R.color.black));
          t22.setBackgroundColor(getResources().getColor(R.color.black));
          t24.setBackgroundColor(getResources().getColor(R.color.black));
          t26.setBackgroundColor(getResources().getColor(R.color.black));
          t28.setBackgroundColor(getResources().getColor(R.color.black));
          t31.setBackgroundColor(getResources().getColor(R.color.black));
          t33.setBackgroundColor(getResources().getColor(R.color.black));
          t35.setBackgroundColor(getResources().getColor(R.color.black));

          button.setBackgroundColor(getResources().getColor(R.color.black));
          button.setTextColor(Color.WHITE);

          radioButton1.setTextColor(getResources().getColor(R.color.black));
          radioButton2.setTextColor(getResources().getColor(R.color.black));
          radioButton3.setTextColor(getResources().getColor(R.color.black));
          radioButton4.setTextColor(getResources().getColor(R.color.black));

      }

    }

    private void strength() {
        int t1=0,t2=0,t3=0;

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
        t23.setText(strength);

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

       t21.setText(achieve);

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

        t25.setText(extra);
    }

    private void reference_and_declaration() {

        SharedPreferences prefernce=getSharedPreferences("pref", Context.MODE_PRIVATE);

        s1=prefernce.getString("REFNAME","");
        s2=prefernce.getString("REFMOB","");
        s3=prefernce.getString("REFEMAIL","");



        s4=prefernce.getString("DEC","");


        s5=prefernce.getString("REFSKIP","");

        int skip= Integer.parseInt(s5);

        String set="NAME :"+s1+"\nMOB :"+s2+"\nEMAIL :"+s3;

        String ref="SELF GENERATED";
        if(skip==1){
            t27.setText(ref);
        }
        else{
            t27.setText(set);
        }




        t29.setText(s4);
    }

    private void project_1_detail() {



        SharedPreferences prefernce=getSharedPreferences("prefgrad", Context.MODE_PRIVATE);

         s1=prefernce.getString("TITLE","");
         s2=prefernce.getString("DES","");
         s3=prefernce.getString("TIME","");
         s4=prefernce.getString("ROLE","");
         s5=prefernce.getString("SIZE","");

           s6=prefernce.getString("SKIP","");




        String title1="PROJECT TITLE :"+s1+"\n\nDESCRIPTION :"+s2+"\n\nTIME :"+s3+"\n\nROLE :"+s4+"\n\nSIZE :"+s5;

        int skip= Integer.parseInt(s6);
        if(skip==0){
            t16.setText(title1);
            t31.setVisibility(View.GONE);
            t32.setVisibility(View.GONE);
            t33.setVisibility(View.GONE);
            t34.setVisibility(View.GONE);
            t35.setVisibility(View.GONE);
            t36.setVisibility(View.GONE);

        }
        else{
            t16.setVisibility(View.GONE);
            radioButton3.setVisibility(View.GONE);
            t15.setVisibility(View.GONE);
            t18.setVisibility(View.GONE);
            t19.setVisibility(View.GONE);
            t20.setVisibility(View.GONE);
            t21.setVisibility(View.GONE);
            t22.setVisibility(View.GONE);
            t23.setVisibility(View.GONE);


            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

            params.addRule(RelativeLayout.ALIGN_RIGHT,R.id.signimage);

            params.addRule(RelativeLayout.ALIGN_LEFT,R.id.date_and_time);

            t24.setLayoutParams(params);

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


        t19.setText(interes);

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

    private void educationdetail() {

        SharedPreferences prefernce=getSharedPreferences("pref", Context.MODE_PRIVATE);

        s1=prefernce.getString("SCHOOL","");
        s2=prefernce.getString("PERCENT","");
        s3=prefernce.getString("BOARD","");
        s4=prefernce.getString("PASSING","");

        s5=prefernce.getString("SCHOOL12","");
        s6=prefernce.getString("PERCENT12","");
        s7=prefernce.getString("BOARD12","");
        s8=prefernce.getString("PASSING12","");


       String set="\t\t\t"+s1+"\n\t\t\t"+s2+"\n\t\t\t"+s3+"\n\t\t\t"+s4;

        String set12="\t\t\t"+s5+"\n\t\t\t"+s6+"\n\t\t\t"+s7+"\n\t\t\t"+s8;

        t11.setText(set);
        t12.setText(set12);
    }

    private void mainprofile() {

        SharedPreferences prefernce=getSharedPreferences("pref", Context.MODE_PRIVATE);

        s1=prefernce.getString("OBJECTIVE","");

        s2=prefernce.getString("IMAGE","");

        Bitmap bitmaps ;

        if(!s2.equals("")){
            bitmaps=decode(s2);
            try {
                Bitmap bm = Bitmap.createScaledBitmap(bitmaps, 140, 40, true);
                imageView_sign.setImageBitmap(bm);
            }
            catch (Exception e){
               // Toast.makeText(this, ""+e, Toast.LENGTH_SHORT).show();
            }

        }


        t9.setText(s1);


    }

    private void addressdetail() {




        SharedPreferences prefernce=getSharedPreferences("pref", Context.MODE_PRIVATE);

        s1=prefernce.getString("AREA","");
        s2=prefernce.getString("STREET","");
        s3=prefernce.getString("CITY","");
        s4=prefernce.getString("PINCODE","");
        s5=prefernce.getString("STATE","");


        t3.setText(s1);
        t5.setText(s3+", "+s2);
        t7.setText(s5+", "+s4);


    }

    private void personneldetail() {

        SharedPreferences prefernce=getSharedPreferences("pref", Context.MODE_PRIVATE);

        s1=prefernce.getString("F_NAME","");
        s2=prefernce.getString("L_NAME","");
        s3=prefernce.getString("DATE","");
        s4=prefernce.getString("NATIONALITY","");
        s5=prefernce.getString("CONTACT","");
        s6=prefernce.getString("MARTIAL","");
        s7=prefernce.getString("EMAIL","");


        t2.setText(s1+" "+s2);
        t4.setText(s5);
        t6.setText(s7);



    }

    private void init() {

        t1= (TextView) findViewById(R.id.container);
        t2= (TextView) findViewById(R.id.name);
        t3= (TextView) findViewById(R.id.area_flat);
        t4= (TextView) findViewById(R.id.mob);
        t5= (TextView) findViewById(R.id.city_road);
        t6= (TextView) findViewById(R.id.email);
        t7= (TextView) findViewById(R.id.state_pin);
        t8= (TextView) findViewById(R.id.objective);
        t9= (TextView) findViewById(R.id.objective_details);
        t10= (TextView) findViewById(R.id.education);

        radioButton1= (RadioButton) findViewById(R.id.radio_high_school);
        radioButton2= (RadioButton) findViewById(R.id.radio_senior_secondary);
        radioButton3= (RadioButton) findViewById(R.id.radio_project_1);
        radioButton4= (RadioButton) findViewById(R.id.radio_project_2);




        t11= (TextView) findViewById(R.id.high_school_detail);
        t12= (TextView) findViewById(R.id.senior_secondary_detail);
        t13= (TextView) findViewById(R.id.technical_skills);
        t14= (TextView) findViewById(R.id.technical_skills_detail);
        t15= (TextView) findViewById(R.id.project_work);
        t16= (TextView) findViewById(R.id.project_1_detail);
        t17= (TextView) findViewById(R.id.project_2_detail);
        t18= (TextView) findViewById(R.id.field_of_interest);
        t19= (TextView) findViewById(R.id.field_of_interest_detal);
        t20= (TextView) findViewById(R.id.achievements);


        t21= (TextView) findViewById(R.id.achievements_details);
        t22= (TextView) findViewById(R.id.strength);
        t23= (TextView) findViewById(R.id.strength_detail);
        t24= (TextView) findViewById(R.id.extra_carricular);
        t25= (TextView) findViewById(R.id.extra_carricular_detail);
        t26= (TextView) findViewById(R.id.reference);
        t27= (TextView) findViewById(R.id.reference_detail);
        t28= (TextView) findViewById(R.id.declaration);
        t29= (TextView) findViewById(R.id.declaration_detail);
        t30= (TextView) findViewById(R.id.date_and_time);

        button= (Button) findViewById(R.id.pdfgen);

        imageView_sign= (ImageView) findViewById(R.id.signimage);

        t31= (TextView) findViewById(R.id.field_of_interest_child1);
        t32= (TextView) findViewById(R.id.field_of_interest_detal_child1);
        t33= (TextView) findViewById(R.id.achievements_child1);


        t34= (TextView) findViewById(R.id.achievements_details_child1);
        t35= (TextView) findViewById(R.id.strength_child1);
        t36= (TextView) findViewById(R.id.strength_detail_child1);

    }







    private void generate() {
try {
    button.setVisibility(View.GONE);

    view1 = findViewById(R.id.children1);


    document = new PdfDocument();


    int noOfPages = (int) Math.floor(view1.getHeight() / 870);


    for (int i = 1; i <= noOfPages; i++) {
        if (i == 1) {


            pageinfo = new PdfDocument.PageInfo.Builder(view1.getWidth(), view1.getHeight(), i).create();

            page = document.startPage(pageinfo);

            view1.draw(page.getCanvas());


        } else {

            //  view1=null;
            view1 = findViewById(R.id.children2);
            pageinfo = new PdfDocument.PageInfo.Builder(view1.getWidth(), view1.getHeight(), i).create();

            page = document.startPage(pageinfo);

            view1.draw(page.getCanvas());
        }

        document.finishPage(page);

    }
}

       catch (Exception e){
       // Toast.makeText(this, ""+e, Toast.LENGTH_SHORT).show();
    }

       AlertDialog.Builder alert=new AlertDialog.Builder(Pdf.this);
        alert.setTitle("FILE NAME");
        alert.setMessage("Enter file name");

        final EditText edittext=new EditText(Pdf.this);
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
                    Toast.makeText(Pdf.this, "Generated", Toast.LENGTH_SHORT).show();
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
