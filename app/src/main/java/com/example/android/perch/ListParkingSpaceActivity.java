package com.example.android.perch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class ListParkingSpaceActivity extends AppCompatActivity {

    private EditText mNameEditText, mAgeEditText, mAddressEditText, mEmailEditText, mPhoneEditText,
                        mHourlyEditText, mDailyEditText, mWeeklyEditText, mMonthlyEditText;
    private CheckBox mHourlyCheckBox, mDailyCheckBox, mWeeklyCheckBox, mMonthlyCheckBox;
    private Button mPostSpaceButton;
    private String sName, sAddress, sEmail, sPhone;
    private int age;
    private double dHourlyCost, dDailyCost, dWeeklyCost, dMonthlyCost;
    private boolean isHourly = false, isDaily = false, isWeekly = false, isMonthly = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_parking_space);

        mNameEditText = findViewById(R.id.nameText);
        mAgeEditText = findViewById(R.id.ageText);
        mAddressEditText = findViewById(R.id.addressText);
        mEmailEditText = findViewById(R.id.emailText);
        mPhoneEditText = findViewById(R.id.phoneText);
        mHourlyCheckBox = findViewById(R.id.hourly_price_boolean);
        mDailyCheckBox = findViewById(R.id.daily_price_boolean);
        mWeeklyCheckBox = findViewById(R.id.weekly_price_boolean);
        mMonthlyCheckBox = findViewById(R.id.monthly_price_boolean);
        mPostSpaceButton = findViewById(R.id.createParkingSpaceButton);
        mHourlyEditText = findViewById(R.id.hourly_price);
        mDailyEditText = findViewById(R.id.daily_price);
        mWeeklyEditText = findViewById(R.id.weekly_price);
        mMonthlyEditText = findViewById(R.id.monthly_price);

        mHourlyCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mHourlyCheckBox.isChecked())
                    mHourlyEditText.setVisibility(View.VISIBLE);
                else
                    mHourlyEditText.setVisibility(View.GONE);
            }
        });

        mDailyCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mDailyCheckBox.isChecked())
                    mDailyEditText.setVisibility(View.VISIBLE);
                else
                    mDailyEditText.setVisibility(View.GONE);
            }
        });

        mWeeklyCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mWeeklyCheckBox.isChecked())
                    mWeeklyEditText.setVisibility(View.VISIBLE);
                else
                    mWeeklyEditText.setVisibility(View.GONE);
            }
        });

        mMonthlyCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mMonthlyCheckBox.isChecked())
                    mMonthlyEditText.setVisibility(View.VISIBLE);
                else
                    mMonthlyEditText.setVisibility(View.GONE);
            }
        });

        mPostSpaceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sName = mNameEditText.getText().toString();
                age = Integer.parseInt(mAgeEditText.getText().toString());
                sAddress = mAddressEditText.getText().toString();
                sEmail = mEmailEditText.getText().toString();
                sPhone = mPhoneEditText.getText().toString();

                if(mHourlyCheckBox.isChecked()) {
                    isHourly = true;
                    dHourlyCost = Double.parseDouble(mHourlyEditText.getText().toString());
                }
                if(mDailyCheckBox.isChecked()) {
                    isDaily = true;
                    dDailyCost = Double.parseDouble(mDailyEditText.getText().toString());
                }
                if(mWeeklyCheckBox.isChecked()) {
                    isWeekly = true;
                    dWeeklyCost = Double.parseDouble(mWeeklyEditText.getText().toString());
                }
                if(mMonthlyCheckBox.isChecked()) {
                    isMonthly = true;
                    dMonthlyCost = Double.parseDouble(mMonthlyEditText.getText().toString());
                }

                createParkingSpace();
            }
        });
    }

    private void createParkingSpace() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        String id = UUID.randomUUID().toString();

        DatabaseReference myRef = database.getReference("Parking Spaces");
        ParkingSpace space = new ParkingSpace(id, sName, sAddress, sEmail, sPhone, 0, "",
                                        isHourly, isDaily, isWeekly, isMonthly,"ownerID",
                                        dHourlyCost, dDailyCost, dWeeklyCost, dMonthlyCost, age);
        myRef.setValue(space);
    }
}
