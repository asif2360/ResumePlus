package myapps.resumeplus;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.Toast;

/**
 * Created by Acer on 13-06-2017.
 */

public class MyPageAdapter extends FragmentStatePagerAdapter{

    int numberoftabs;
    Activity contex;



    public MyPageAdapter(FragmentManager fm, int numofTabs) {

        super(fm);
        this.numberoftabs=numofTabs;
    }

    @Override
    public Fragment getItem(int position) {


        switch (position){
            case 0:
                return new MyFragment1();
            case 1:

                return new MyFragment2();
            case 2:

                return new MyFragment3();

            default:
                return null;
        }


    }

    @Override
    public int getCount() {
        return numberoftabs;
    }
}
