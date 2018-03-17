package com.example.munira.notebooklist;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;



public class Argent_list extends AppCompatActivity {


    //Main page for object create

    private EditText ArgentTitleInputET;
    private EditText ArgentAmountInputET;
    private ListView myArgentList;
    private List<Item> ArgentListItem;
    private BaseAdapter adapter;
    FloatingActionButton floatArgentListButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_argent_list);


        //casting for main page activity_main xml value generate

        ArgentTitleInputET = (EditText) findViewById(R.id.argent_item_title);
        ArgentAmountInputET = (EditText) findViewById(R.id.input_argent_amount);
        myArgentList = (ListView) findViewById(R.id.viewB_argent_list);
        floatArgentListButton=findViewById(R.id.fab_argent_button);

        ArgentListItem = new ArrayList<Item>( );
        adapter = new BaseAdapter( ) {
            LayoutInflater Inflater = (LayoutInflater) getBaseContext( ).getSystemService(LAYOUT_INFLATER_SERVICE);

            @Override
            public int getCount() {
                return ArgentListItem.size();
            }

            @Override
            public Object getItem(int position) {
                return ArgentListItem.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {


                if(convertView == null){
                    convertView = Inflater.inflate(R.layout.activity_argent_list,null);

                }
                TextView wishTextViewTitle=(TextView)convertView.findViewById(R.id.item_title);
                TextView wishTextViewAmount=(TextView)convertView.findViewById(R.id.item_amount_description);
                TextView wishTextViewDate=(TextView)convertView.findViewById(R.id.item_wishlistDateTextView);

                wishTextViewTitle.setText(ArgentListItem.get(position).getWishString());
                wishTextViewAmount.setText(ArgentListItem.get(position).getAmountInteger());

                String date=ArgentListItem.get(position).getNoteDate();
                wishTextViewDate.setText(date);


                return convertView;
            }
        };


        //collection of  data show by database
        final DatabaseHelper helper = new DatabaseHelper(getBaseContext());
        ArgentListItem = helper.getAllData();
        myArgentList.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        floatArgentListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Date dateObj = Calendar.getInstance().getTime();
                String IncomeTitle=ArgentTitleInputET.getText().toString();
                String  finalString= ArgentAmountInputET.getText().toString();
                String dateString="";

                SimpleDateFormat curFormater = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    dateObj = curFormater.parse(dateString);

                } catch (ParseException e) {
                    e.printStackTrace();
                }


                dateString = curFormater.format(dateObj);
                Item item=new Item(IncomeTitle,finalString,dateString);
                item.setWishString("Item:" + ArgentListItem.size( ));

                    /*step:14 collection of  data show by database*/
                item.setWishString("Item:" + ArgentListItem.size( ));
                item.setWishString(ArgentTitleInputET.getText( ).toString( ));

                item.setAmountInteger("Item:" + ArgentListItem.size( ));
                item.setAmountInteger(ArgentAmountInputET.getText( ).toString( ));
                ArgentListItem.add(item);

                myArgentList.setAdapter(adapter);
                adapter.notifyDataSetChanged( );


                /*data set and clear*/
                ArgentTitleInputET.setText("");
                ArgentAmountInputET.setText("");

                    /* data type end and keyboard hide*/
                InputMethodManager inputMethodManager= (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(ArgentTitleInputET.getWindowToken(),0);
                inputMethodManager.hideSoftInputFromWindow(ArgentAmountInputET.getWindowToken(),0);

                    /*add and small notification sms show*/
                Toast.makeText(getBaseContext(),"New Income Addad to List",Toast.LENGTH_SHORT).show();

            }
        });

         /*step:13 press on data and delete item */
        myArgentList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //Database data
                DatabaseHelper helper = new DatabaseHelper(getBaseContext());
                /*data delete */
                ArgentListItem.remove(position);
                adapter.notifyDataSetChanged();
                Toast.makeText(getBaseContext(),"One Item Remove",Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }
}
