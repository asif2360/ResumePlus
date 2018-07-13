package myapps.resumeplus;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Acer on 13-06-2017.
 */

public class MyFragment1 extends Fragment {

    ImageView imageView1,imageView2,imageView3;
    FloatingActionButton float_rate;

    private Activity context;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        context=getActivity();
        return inflater.inflate(R.layout.myfragment_1_layout,container,false);
    }

    @Override
    public void onStart() {
        super.onStart();
        imageView1= (ImageView) context.findViewById(R.id.image_top);
        imageView2= (ImageView) context.findViewById(R.id.image_build_resume);
        imageView3= (ImageView) context.findViewById(R.id.imageView_sample);
        float_rate= (FloatingActionButton) context.findViewById(R.id.rating_button);
        Bitmap bm= BitmapFactory.decodeResource(context.getResources(),R.drawable.ic_star_black_24dp);
        float_rate.setImageBitmap(bm);



        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,ResumeCategory.class);
                startActivity(intent);
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,Samples.class);
                startActivity(intent);
            }
        });

    }
}
