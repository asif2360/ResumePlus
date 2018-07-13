package myapps.resumeplus;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Acer on 09-07-2017.
 */

public class Samples extends AppCompatActivity {

    TextView textView;
    ImageView imageView1,imageView2,imageView3,imageView4;
    Bitmap bitmap;
    ByteArrayOutputStream bout;
    File file;
    FileOutputStream fo;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.samples);

        textView= (TextView) findViewById(R.id.textView_resume);


        imageView1= (ImageView) findViewById(R.id.r1);
        imageView2= (ImageView) findViewById(R.id.r2);
        imageView3= (ImageView) findViewById(R.id.r3);
        imageView4= (ImageView) findViewById(R.id.r4);



        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.r1);


                bout=new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG,100,bout);
                file=new File(Environment.getExternalStorageDirectory()+File.separator+"r1.png");

                try{
                    file.createNewFile();
                  fo=new FileOutputStream(file);
                    fo.write(bout.toByteArray());
                    fo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Uri uri=Uri.fromFile(file);
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setDataAndType(uri,"image/*");
                startActivity(intent);
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.r2);


                bout=new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG,100,bout);
                file=new File(Environment.getExternalStorageDirectory()+File.separator+"r2.png");

                try{
                    file.createNewFile();
                    fo=new FileOutputStream(file);
                    fo.write(bout.toByteArray());
                    fo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Uri uri=Uri.fromFile(file);
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setDataAndType(uri,"image/*");
                startActivity(intent);
            }
        });


        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.r3);


                bout=new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG,100,bout);
                file=new File(Environment.getExternalStorageDirectory()+File.separator+"r3.png");

                try{
                    file.createNewFile();
                    fo=new FileOutputStream(file);
                    fo.write(bout.toByteArray());
                    fo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Uri uri=Uri.fromFile(file);
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setDataAndType(uri,"image/*");
                startActivity(intent);
            }
        });

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.r4);


                bout=new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG,100,bout);
                file=new File(Environment.getExternalStorageDirectory()+File.separator+"r4.png");

                try{
                    file.createNewFile();
                    fo=new FileOutputStream(file);
                    fo.write(bout.toByteArray());
                    fo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Uri uri=Uri.fromFile(file);
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setDataAndType(uri,"image/*");
                startActivity(intent);
            }
        });







    }
}
