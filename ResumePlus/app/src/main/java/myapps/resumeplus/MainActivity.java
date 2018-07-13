package myapps.resumeplus;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView1,imageView2;
    TextView textView1,textView2;
    private static int TIME_OUT=2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1= (ImageView) findViewById(R.id.imageBackground);
        imageView2= (ImageView) findViewById(R.id.imageLogo);

        textView1= (TextView) findViewById(R.id.textTagline);
        textView2= (TextView) findViewById(R.id.textcompanyinfo);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, MainPage.class);
                startActivity(intent);
                finish();
            }
        }, TIME_OUT);



    }
}
