package com.example.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
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

    int y1,y2,m1,m2,d1,d2,diff;


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

                if (TextUtils.isEmpty(checkindate.getText())) {
                    checkindate.setText("Please enter check in Date ");
                    return;
                }
                else if (TextUtils.isEmpty(checkoutdate.getText())) {
                    checkoutdate.setText("Please enter checked out date ");
                    return;
                }

                //calculate number of days

                Calendar cal1 = Calendar.getInstance();
                Calendar cal2 = Calendar.getInstance();
                cal1.set(y1, m1, d1);
                cal2.set(y2, m2, d2);
                long millis1 = cal1.getTimeInMillis();
                long millis2 = cal2.getTimeInMillis();
                long diff = millis2 - millis1;
                long diffDays = (diff / (86400000));
               // noOfroom.setText("Number of Rooms : "+ etroomno.getText().toString());


                int  numRoom = Integer.parseInt(etroomno.getText().toString());

                //calculate net total

                double roomprice,totalprice;
                double vat,servicecharge,nettotal;
                 String roomtype=spinRoomTYpe.getSelectedItem().toString();

                 if(roomtype=="Deluxe"){
                     roomprice=2500;
                     totalprice=roomprice*numRoom*diffDays;
                     vat=(0.13*totalprice) + totalprice;

                     nettotal=servicecharge=(0.10*vat) +vat;

                     tvtotalcost.setText("Total cost is:"+totalprice);
                     tvvat.setText("Price after VAT inclusion:"+vat);
                     tvsc.setText("Price after Service Cherge inclusion:"+servicecharge);
                     tvnettotal.setText("Net Total:"+nettotal);
                 }

                 else if(roomtype=="Suite"){
                     roomprice=2000;
                     totalprice=roomprice*numRoom*diffDays;
                     vat=(0.13*totalprice) + totalprice;
                     nettotal=servicecharge=(0.10*vat) +vat;

                     tvtotalcost.setText("Total cost is:"+totalprice);
                     tvvat.setText("Price after VAT inclusion:"+vat);
                     tvsc.setText("Price after Service Cherge inclusion:"+servicecharge);
                     tvnettotal.setText("Net Total:"+nettotal);
                 }

                 else if(roomtype=="King size"){
                     roomprice=2200;
                     totalprice=roomprice*numRoom*diffDays;
                     vat=(0.13*totalprice) + totalprice;

                     nettotal=servicecharge=(0.10*vat) +vat;
                     tvtotalcost.setText("Total cost is:"+totalprice);
                     tvvat.setText("Price after VAT inclusion:"+vat);
                     tvsc.setText("Price after Service Cherge inclusion:"+servicecharge);
                     tvnettotal.setText("Net Total:"+nettotal);
                 }

                 else if(roomtype=="Double Bed"){
                     roomprice=1800;
                     totalprice=roomprice*numRoom*diffDays;
                     vat=(0.13*totalprice) + totalprice;
                     nettotal=servicecharge=(0.10*vat) +vat;

                     tvtotalcost.setText("Total cost is:"+totalprice);
                     tvvat.setText("Price after VAT inclusion:"+vat);
                     tvsc.setText("Price after Service Cherge inclusion:"+servicecharge);
                     tvnettotal.setText("Net Total:"+nettotal);
                 }





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
                y1=year;
                m1=month;
                d1=dayOfMonth;

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

                y2=year;
                m2=month;
                d2=dayOfMonth;

                checkoutdate.setText(date);
            }
        },year,month,day);
        datePickerDialog.show();
    }


}
