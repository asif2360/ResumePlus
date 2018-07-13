package myapps.resumeplus;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.Toast;

/**
 * Created by Acer on 13-06-2017.
 */

public class MainPage extends AppCompatActivity {

     TabLayout tabLayout;
    ViewPager viewPager;
    SharedPreferences.Editor edit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage_layout);



        Toolbar toolbar = (Toolbar) findViewById(R.id.myToolBar);

        tabLayout= (TabLayout) findViewById(R.id.tab_layout);

        viewPager= (ViewPager) findViewById(R.id.viewpager);

        setSupportActionBar(toolbar);
        
   //The below line shos an arrow at top left corner in toolbar
      //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setTitleTextColor(getResources().getColor(R.color.whitecolor));
        toolbar.setTitle(R.string.app_name);


        tabLayout.addTab(tabLayout.newTab().setText("Build"));
        tabLayout.addTab(tabLayout.newTab().setText("Tips"));
        tabLayout.addTab(tabLayout.newTab().setText("Saved"));



        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);



        SharedPreferences preferences=getSharedPreferences("tabcount", Context.MODE_PRIVATE);

         edit=preferences.edit();



       MyPageAdapter adapter=new MyPageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());

       viewPager.setAdapter(adapter);


      viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));




        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                int count=tab.getPosition();

                edit.putString("COUNT", String.valueOf(count));

                edit.apply();


                viewPager.setCurrentItem(tab.getPosition());
  }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {


            }
        });






    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        //this code is used to set the icon in toolbar
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        
        int id=item.getItemId();
        if(id==R.id.userSign){
            usersignin();
        }
        return super.onOptionsItemSelected(item);
    }

    private void usersignin() {
        Toast.makeText(this, "This feature will be added soon", Toast.LENGTH_SHORT).show();

    }
}
