package myapps.resumeplus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Acer on 13-06-2017.
 */

public class MyFragment3 extends Fragment {

    Activity context;
    ListView list;
    ArrayList<String> pdf_names=new ArrayList<String>();
    ArrayList<String> pdf_paths=new ArrayList<String>();
    String path;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.myfragment_3_layout, container, false);
        context = getActivity();

        SharedPreferences preferences = context.getSharedPreferences("tabcount", Context.MODE_PRIVATE);
        String s1 = preferences.getString("COUNT", "");
        int count = Integer.parseInt(s1);
        list = (ListView) view.findViewById(R.id.listView);


            try {

                fetchpdf();
            } catch (Exception e) {
                if(count==2) {
                    Toast.makeText(context, "NO PDf File found", Toast.LENGTH_SHORT).show();
                }
            }


            try {


                ArrayAdapter adapter = new ArrayAdapter(context, R.layout.simple_list_item, R.id.text1, pdf_names);
                list.setAdapter(adapter);

            } catch (Exception e) {
               // Toast.makeText(context, "" + e, Toast.LENGTH_SHORT).show();
            }


            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


                    String path = pdf_paths.get(position);
                    File file = new File(path);
                    try {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setDataAndType(Uri.fromFile(file), "application/pdf");
                        startActivity(intent);
                    } catch (Exception e) {
                        Toast.makeText(context, "No apps to open this file", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            return view;
        }




    private void fetchpdf() {

        path=Environment.getExternalStorageDirectory()+File.separator+"DigitSign";

        File directory=new File(path);

        File[] files=directory.listFiles();

        for(int i=0; i< files.length; i++){
            String file_name=files[i].getName();

            if(file_name.endsWith(".pdf")){
                pdf_names.add(file_name);
                pdf_paths.add(files[i].getPath());
            }
        }
    }


}
