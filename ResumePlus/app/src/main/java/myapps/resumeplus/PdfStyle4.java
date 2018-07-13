package myapps.resumeplus;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
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

/**
 * Created by Acer on 06-07-2017.
 */

public class PdfStyle4 extends AppCompatActivity {

    ImageView i1;
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20,t21,t22,t23;
    Bitmap bm;
    String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,special;
    SharedPreferences count,turn_count;
    int style=0,turn=0;
    Button btn_generate;
    PdfDocument document;
    PdfDocument.PageInfo pageinfo;
    PdfDocument.Page page;
    View view1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pdfstyle4);

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

        reference_and_declaration();

        strength();

        btn_generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              generate();
            }
        });

    }

    private void init() {

        i1= (ImageView) findViewById(R.id.photo4);


        t1= (TextView) findViewById(R.id.left_textview);
        t2= (TextView) findViewById(R.id.name4);
        t3= (TextView) findViewById(R.id.address4);
        t4= (TextView) findViewById(R.id.skill4);
        t5= (TextView) findViewById(R.id.skill_detail4);
        t6= (TextView) findViewById(R.id.achievements4);
        t7= (TextView) findViewById(R.id.achievements_detail4);
        t8= (TextView) findViewById(R.id.foi4);
        t9= (TextView) findViewById(R.id.foi_detail4);
        t10= (TextView) findViewById(R.id.carricular4);
        t11= (TextView) findViewById(R.id.carricular_detail4);
        t12= (TextView) findViewById(R.id.reference4);
        t13= (TextView) findViewById(R.id.reference_detail4);
        t14= (TextView) findViewById(R.id.education4);
        t15= (TextView) findViewById(R.id.education_detail4);
        t16= (TextView) findViewById(R.id.project4);
        t17= (TextView) findViewById(R.id.project_detail4);
        t18= (TextView) findViewById(R.id.declaration4);
        t19= (TextView) findViewById(R.id.declaration_detail4);
        t20= (TextView) findViewById(R.id.about_me4);
        t21= (TextView) findViewById(R.id.about_me_detail4);
        t22= (TextView) findViewById(R.id.declaration4_duplicate);
        t23= (TextView) findViewById(R.id.declaration_detail4_duplicate);

        btn_generate= (Button) findViewById(R.id.btn_pdf_generator);
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


        t2.setText(s1 + " " + s2+"\n"+s5+"\n"+s7);
        int star=s1.length()+s2.length()+s5.length()+3;
        Spannable spannable=new SpannableString(t2.getText());
        spannable.setSpan(new RelativeSizeSpan(0.7f),star,star+s7.length(),Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        t2.setText(spannable);

    }

    private void addressdetail() {


        SharedPreferences prefernce=getSharedPreferences("pref", Context.MODE_PRIVATE);

        s1=prefernce.getString("AREA","");
        s2=prefernce.getString("STREET","");
        s3=prefernce.getString("CITY","");
        s4=prefernce.getString("PINCODE","");
        s5=prefernce.getString("STATE","");

        s6=s1+"\n"+s2+", "+s3+"\n"+s4+", "+s5;


        t3.setText(s6);

    }


    private void mainprofile() {

        SharedPreferences prefernce = getSharedPreferences("pref", Context.MODE_PRIVATE);

        s1 = prefernce.getString("OBJECTIVE", "");

        s2 = prefernce.getString("IMAGE", "");

        s3=prefernce.getString("MAIN_IMAGE","");

        Bitmap bitmaps;


        t21.setText(s1);



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

        if(style==4&&turn==1){
            SharedPreferences prefernce2=getSharedPreferences("pref", Context.MODE_PRIVATE);

            s1=prefernce2.getString("SCHOOL","");
            s2=prefernce2.getString("PERCENT","");
            s3=prefernce2.getString("BOARD","");
            s4=prefernce2.getString("PASSING","");

            s5=prefernce2.getString("SCHOOL12","");
            s6=prefernce2.getString("PERCENT12","");
            s7=prefernce2.getString("BOARD12","");
            s8=prefernce2.getString("PASSING12","");

            String setstyle2="HIGH SCHOOL\n\n"+s1+" \t\t\t"+s4+"\n"+s2+"\n"+s3;

            String set12style2="SENIOR SECONDARY\n\n"+s5+"\t\t\t"+s8+"\n"+s6+"\n"+s7;

            t15.setText(setstyle2 + "\n\n" + set12style2);
        }
        else {
            t15.setText(set + "\n\n" + set12 + "\n\n" + college);
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


        t9.setText(interes);



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


        t5.setText(set);


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
       t18.setVisibility(View.GONE);
       t19.setVisibility(View.GONE);
       t22.setVisibility(View.VISIBLE);
       t23.setVisibility(View.VISIBLE);
       t17.setText("PROJECT 1 \n"+title1+"\n\n\nPROJECT 2\n"+title2);
   }

       else if(skip==0) {

            t17.setText("PROJECT 1 \n\n"+title1);
        }
        else {
            t17.setVisibility(View.GONE);
            t16.setVisibility(View.GONE);
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.BELOW, R.id.education_detail4);
            params.addRule(RelativeLayout.ALIGN_LEFT, R.id.education_detail4);
            t18.setLayoutParams(params);


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
            t13.setText(ref);

        }
        else{
            t13.setText(set);
        }

        t19.setText(s4);
        t23.setText(s4);

    }



    private void strength() {
        int t1=0,t2=0,t3=0;

        if(style==4&&turn==1){

            SharedPreferences prefernce=getSharedPreferences("pref", Context.MODE_PRIVATE);

            s1=prefernce.getString("S1","");
            s2=prefernce.getString("S2","");
            s3=prefernce.getString("A1","");
            s4=prefernce.getString("A2","");
            s5=prefernce.getString("E1","");
            s6=prefernce.getString("E2","");



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

            t7.setText(achieve);

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

            t11.setText(extra);
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

            t7.setText(achieve);

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

            t11.setText(extra);

        }

    }

    private void generate() {
        try {
            btn_generate.setVisibility(View.GONE);

            view1 = findViewById(R.id.childi4);


            document = new PdfDocument();





            pageinfo = new PdfDocument.PageInfo.Builder(view1.getWidth(), view1.getHeight(), 1).create();

            page = document.startPage(pageinfo);

            view1.draw(page.getCanvas());




            document.finishPage(page);


        }

        catch (Exception e){
          //  Toast.makeText(this, "ohh! "+e, Toast.LENGTH_SHORT).show();
        }

        AlertDialog.Builder alert=new AlertDialog.Builder(PdfStyle4.this);
        alert.setTitle("FILE NAME");
        alert.setMessage("Enter file name");

        final EditText edittext=new EditText(PdfStyle4.this);
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
                    Toast.makeText(PdfStyle4.this, "Generated", Toast.LENGTH_SHORT).show();
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
