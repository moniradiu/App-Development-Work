package com.example.munira.wishapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //Main page for object create

    private EditText input_wish_data;
    private Button addButton;
    private ListView myList;
    private List<Item> listItem;
    private BaseAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //casting for main page activity_main xml value generate

        input_wish_data=(EditText)findViewById(R.id.input_wish);
        addButton=(Button)findViewById(R.id.addbtn);
        myList=(ListView)findViewById(R.id.listView);



        listItem=new ArrayList<Item>();
        adapter=new BaseAdapter( ) {
            LayoutInflater Inflater= (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);

            @Override
            public int getCount() {
                return listItem.size();
            }

            @Override
            public Object getItem(int position ) {
                return listItem.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                if (convertView==null)
                {

                    convertView=Inflater.inflate(R.layout.child_layout,null);

                }

                TextView iteamHeading=(TextView)convertView.findViewById(R.id.heading);
                TextView itemWishText=(TextView)convertView.findViewById(R.id.wishText);
                
                iteamHeading.setText(listItem.get(position).getHeadText());
                itemWishText.setText(listItem.get(position).getWiseText());
                return convertView;
            }
        };

        addButton.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {


                Item item=new Item();
                item.setHeadText("Item:" + listItem.size());
                item.setWiseText(input_wish_data.getText().toString());
                listItem.add(item);

                myList.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                
            }
        });

            myList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //one click and show  this name notifications
                String name=listItem.get(position).getWiseText();
                Toast.makeText(MainActivity.this, name, Toast.LENGTH_LONG).show();

                //toast use alert sms.length.long time show like 1 mint.

                }
            } );




        };


    }

