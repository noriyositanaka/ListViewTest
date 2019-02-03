package com.example.listviewtest;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WindowManager windowManager = getWindowManager();
        Display display =  windowManager.getDefaultDisplay();
        String[] cars = {"succeed","escude","wagonr"};

        Resources resources = getResources();

        int i = 0;
        int j = 0;

        List<Item> list = new ArrayList<>();
        for(i=0;i<cars.length;i++) {
            Map<String,String> map = new HashMap<>();


            System.out.println(cars[i].length());
            int identifier = getResources().getIdentifier(cars[i], "array", getPackageName());
            String[] c;
            c = resources.getStringArray(identifier);
            map.put("syamei",cars[i]);
            map.put("maker",c[0]);
            map.put("spec",c[1]);
            map.put("drive",c[2]);
            Item item = new Item(map);
            list.add(item);
        }


        ListView listView;
        listView = (ListView)findViewById(R.id.listView);


        MyAdapter myAdapter = new MyAdapter(getApplication(),R.layout.layout_list_view,list);
        listView.setAdapter(myAdapter);
//        SimpleAdapter simpleAdapter = new SimpleAdapter(this,list,android.R.layout.simple_list_item_2,new String[]{"syamei","maker"},new int[]{android.R.id.text1,android.R.id.text2});

//        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(),Integer.toString(view.getId()),Toast.LENGTH_LONG).show();

            }
        });

    }
}
