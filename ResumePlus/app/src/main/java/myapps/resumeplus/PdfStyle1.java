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
 * Created by Acer on 05-07-2017.
 */

public class PdfStyle1 extends AppCompatActivity {

    ImageView i1,i2,i3,i4,i5,i6,i7,i8;
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
    String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,special;
    SharedPreferences count,turn_count;
    int style=0,turn=0;
    SimpleDateFormat sdf;
    Button generator;
    PdfDocument document;
    PdfDocument.PageInfo pageinfo;
    PdfDocument.Page page;
    View view1;


    Bitmap bm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.pdfstyle1);

        count = getSharedPreferences("style", Context.MODE_PRIVATE);
        special = count.getString("STYLE", "");

        turn_count = getSharedPreferences("MYPREF", Context.MODE_PRIVATE);
        String s1 = turn_count.getString("TURN", "");

        turn = Integer.parseInt(s1);


        style = Integer.parseInt(special);


        init();

        personneldetail();

        addressdetail();

        mainprofile();

        educationdetail();

        technicalskills();

        project_1_detail();

        time_and_date();

        reference_and_declaration();

        generator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generate();
            }
        });



    }

    private void init() {

        t1= (TextView) findViewById(R.id.name_address_container);
        t2= (TextView) findViewById(R.id.address_left);
        t3= (TextView) findViewById(R.id.phone_email);
        t4= (TextView) findViewById(R.id.about_me_declare);
        t5= (TextView) findViewById(R.id.textView_education);
        t6= (TextView) findViewById(R.id.textView_skills);
        t7= (TextView) findViewById(R.id.textView_project);
        t8= (TextView) findViewById(R.id.textView_reference);
        t9= (TextView) findViewById(R.id.textView_declaration);
        t10= (TextView) findViewById(R.id.date_t);



        i1= (ImageView) findViewById(R.id.profile_photo);
        i2= (ImageView) findViewById(R.id.about_me_photo);
        i3= (ImageView) findViewById(R.id.imageView_education);
        i4= (ImageView) findViewById(R.id.imageView_Skill);
        i5= (ImageView) findViewById(R.id.imageView_Reference);
        i6= (ImageView) findViewById(R.id.imageView_Declaration);
        i7= (ImageView) findViewById(R.id.imageView_Project);
        i8= (ImageView) findViewById(R.id.signstyle1);


        generator= (Button) findViewById(R.id.btn_gen);
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


        t1.setText(s1 + " " + s2+"\n"+s3+", "+s4);

        t3.setText(s5+"\n"+s7);


    }

    private void addressdetail() {




        SharedPreferences prefernce=getSharedPreferences("pref", Context.MODE_PRIVATE);

        s1=prefernce.getString("AREA","");
        s2=prefernce.getString("STREET","");
        s3=prefernce.getString("CITY","");
        s4=prefernce.getString("PINCODE","");
        s5=prefernce.getString("STATE","");

        s6=s1+"\n"+s2+", "+s3+"\n"+s4+", "+s5;


        t2.setText(s6);


    }

    private void mainprofile() {

        SharedPreferences prefernce = getSharedPreferences("pref", Context.MODE_PRIVATE);

        s1 = prefernce.getString("OBJECTIVE", "");

        s2 = prefernce.getString("IMAGE", "");

        s3=prefernce.getString("MAIN_IMAGE","");

        Bitmap bitmaps;


        t4.setText(s1);


        if (!s2.equals("")) {
            bitmaps = decode(s2);
            try {
                bm = Bitmap.createScaledBitmap(bitmaps, 170, 45, true);
                i8.setImageBitmap(bm);
            } catch (Exception e) {
                //Toast.makeText(this, "" + e, Toast.LENGTH_SHORT).show();
            }

        }

        if(!s3.equals("")){
            bitmaps=decode(s3);

            try {
                bm = Bitmap.createScaledBitmap(bitmaps, 120, 120, true);
                i1.setImageBitmap(bm);
            } catch (Exception e) {
               // Toast.makeText(this, "" + e, Toast.LENGTH_SHORT).show();
            }
        }


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


        String set="HIGH SCHOOL\n"+s1+" \t\t\t"+s4+"\n"+s2+"\n"+s3;

        String set12="SENIOR SECONDARY\n"+s5+"\t\t\t"+s8+"\n"+s6+"\n"+s7;

        String college="GRADUATION\n"+s9+"\n"+s10+"\n"+s11+"\t\t"+s12+"\n"+s13;

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

            String setstyle2="HIGH SCHOOL\n\n"+s1+"\t\t\t"+s4+"\n"+s2+"\n"+s3;

            String set12style2="SENIOR SECONDARY\n\n"+s5+"\t\t\t"+s8+"\n"+s6+"\n"+s7;

            t5.setText(setstyle2 + "\n\n" + set12style2);
        }
        else {
            t5.setText(set + "\n\n" + set12 + "\n\n" + college);
        }

    }


    private void technicalskills() {
        int turn=0;

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


        t6.setText(set);


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
            t7.setText("PROJECT 1\n"+title1+"\n\nPROJECT 2\n"+title2);
        }
        else if(skip==0) {
            t7.setText("PROJECT 1 \n\n"+title1);
        }
        else {
            t7.setVisibility(View.GONE);
            i7.setVisibility(View.GONE);
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.BELOW, R.id.imageView_Skill);
            params.addRule(RelativeLayout.ALIGN_LEFT,R.id.imageView_Skill);
            params.addRule(RelativeLayout.ALIGN_RIGHT,R.id.imageView_Skill);
            i5.setLayoutParams(params);


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

        String set="NAME\t:\t"+s1+"\nMOB\t:\t\t"+s2+"\nEMAIL\t:\t"+s3;

        String ref="SELF GENERATED";
        if(skip==1){
            t8.setText(ref);

        }
        else{
            t8.setText(set);
        }

        t9.setText(s4);

    }



    private void time_and_date() {

        Calendar cal=Calendar.getInstance();
        sdf=new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        String  strDate=sdf.format(cal.getTime());



        sdf=new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        String strTime=sdf.format(cal.getTime());

        String set="DATE : "+strDate+"\nTIME : "+strTime;
        t10.setText(set);

    }


    private void generate() {
        try {
            generator.setVisibility(View.GONE);

            view1 = findViewById(R.id.childi1);


            document = new PdfDocument();





            pageinfo = new PdfDocument.PageInfo.Builder(view1.getWidth(), view1.getHeight(), 1).create();

            page = document.startPage(pageinfo);

            view1.draw(page.getCanvas());




            document.finishPage(page);


        }

        catch (Exception e){
          //  Toast.makeText(this, "ohh! "+e, Toast.LENGTH_SHORT).show();
        }

        AlertDialog.Builder alert=new AlertDialog.Builder(PdfStyle1.this);
        alert.setTitle("FILE NAME");
        alert.setMessage("Enter file name");

        final EditText edittext=new EditText(PdfStyle1.this);
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
                    Toast.makeText(PdfStyle1.this, "Generated", Toast.LENGTH_SHORT).show();
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
