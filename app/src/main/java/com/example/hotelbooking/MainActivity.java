package com.example.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Spinner spinLocation;
    private Spinner spinRoomTYpe;
   EditText adultnum,childnum,etroomno;
  Button btncalculate;
  TextView checkindate,checkoutdate,roomcost,totaldays,tvtotalcost,tvvat,tvsc,tvnettotal,noOfroom;

    int diff,a,b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

spinLocation=findViewById(R.id.splocation);
spinRoomTYpe=findViewById(R.id.sproomtype);
checkindate=findViewById(R.id.checkindate);
checkoutdate=findViewById(R.id.checkoutdate);
adultnum=findViewById(R.id.adultno);
childnum=findViewById(R.id.childno);
etroomno=findViewById(R.id.etroomnum);
totaldays=findViewById(R.id.totaldays);

btncalculate=findViewById(R.id.btncalculate);

//output data binding

      roomcost=findViewById(R.id.roomcost);
      totaldays=findViewById(R.id.totaldays);
      tvtotalcost=findViewById(R.id.totalcost);
      tvvat=findViewById(R.id.tvvat);
      tvsc=findViewById(R.id.tvsc);
      tvnettotal=findViewById(R.id.tvnettotal);
      noOfroom=findViewById(R.id.roomno);




//passing array to location in spinner
        String location[]={"Kathmandu","Bhaktapur","Patan","Lalitpur"};
        ArrayAdapter adapter=new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,location
        );

        spinLocation.setAdapter(adapter);

//passing array to room type spinner

        String roomType[]={"Deluxe","Suite","King size","Double Bed"};
            ArrayAdapter adapter1=new ArrayAdapter<>(
                    this,
                    android.R.layout.simple_list_item_1,roomType
            );
spinRoomTYpe.setAdapter(adapter1);

spinRoomTYpe.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(parent.getItemAtPosition(position).equals("Deluxe")){
            roomcost.setText(" "+ 2500);

        }
        else if(parent.getItemAtPosition(position).equals("Suite") ){
            roomcost.setText(" "+ 2000);
        }

        else if(parent.getItemAtPosition(position).equals("King size") ){
            roomcost.setText(" "+ 2000);
        }
        else if(parent.getItemAtPosition(position).equals("Double Bed") ){
            roomcost.setText(" "+ 1500);

        }
        else{
            //do nothing
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
});



//setting onclick event to check in date
      checkindate.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        loadDatePicker();
    }
      });
      //setting onclick to check out date
      checkoutdate.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        loadDate();
    }
   });


      //button to calculate total

        btncalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int  noofroom;



                noOfroom.setText("Number of Rooms : "+ etroomno.getText().toString());



              diff=(R.id.checkoutdate)-(R.id.checkindate);
              totaldays.setText("Number of days:"+diff);

               roomcost.setVisibility(View.VISIBLE);
                roomcost.setText("Total room cost:"+ (roomcost.getText().toString()));




            }
        });

    }








    private  void loadDatePicker(){
        final Calendar c=Calendar.getInstance();
        int year=c.get(Calendar.YEAR);
        int month=c.get(Calendar.MONTH);
        int day=c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String date = "CheckIn Date : " +year +"/"+month+"/"+dayOfMonth;
                checkindate.setText(date);
            }
        },year,month,day);
        datePickerDialog.show();
    }


    private  void loadDate(){
        final Calendar ca=Calendar.getInstance();
        int year=ca.get(Calendar.YEAR);
        int month=ca.get(Calendar.MONTH);
        int day=ca.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String date = "CheckOut Date : " +year +"/"+month+"/"+dayOfMonth;
                checkoutdate.setText(date);
            }
        },year,month,day);
        datePickerDialog.show();
    }


}
