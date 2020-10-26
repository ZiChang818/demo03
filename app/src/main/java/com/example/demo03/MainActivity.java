package com.example.demo03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import android.widget.Toast;


public  class MainActivity extends AppCompatActivity {
    public String[] names = new String[] {"Lion", "Tiger", "Monkey", "Dog", "Cat", "Elephant"};
    public int[] images = new int[] {R.drawable.lion, R.drawable.tiger, R.drawable.monkey,
            R.drawable.dog, R.drawable.cat, R.drawable.elephant};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //输出内容
        List<Map<String, Object>> listitems = new ArrayList<>();
        for(int i=0;i<names.length;i++){
            Map<String,Object> listitem =new HashMap<>();
            listitem.put("animal_name",names[i]);
            listitem.put("animal_pic",images[i]);
            listitems.add(listitem);
        }
        final SimpleAdapter simpleAdapter =new SimpleAdapter(this, listitems, R.layout.simple_item,
                new String[]{"animal_name", "animal_pic"}, new int[]{R.id.animal_name, R.id.animal_pic});
        ListView listView = findViewById(R.id.mylist);
        listView.setAdapter(simpleAdapter);

        //点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //日志打印点击情况
                Log.i("-CRAZYIT-", names[position] + " clicked");
                Toast toast = Toast.makeText(MainActivity.this, names[position], Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}