package com.activity.mobcom.Activity.Activities;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.activity.mobcom.R;

import java.util.Calendar;

public class RegForm extends AppCompatActivity {

    private EditText username, email, password, confirmPassword, birthdate, phone, birthtime;
    private AutoCompleteTextView country;
    private Spinner state;
    private RadioGroup gender;
    private CheckBox agree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regform);

        // Initialize Views
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        //confirmPassword = findViewById(R.id.confirm_password);
        phone = findViewById(R.id.phone);
        country = findViewById(R.id.country);
        state = findViewById(R.id.state);
        birthdate = findViewById(R.id.birthdate);
        birthtime = findViewById(R.id.birthtime);
        gender = findViewById(R.id.gender);
        agree = findViewById(R.id.agree);
        Button submitBtn = findViewById(R.id.submitBtn);

        // Set up AutoCompleteTextView for Country
        String[] countries = {"Africa", "Hongkong", "Singapore", "Philippines",};
        ArrayAdapter<String> countryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, countries);
        country.setAdapter(countryAdapter);

        // Set up Spinner for State
        String[] states = {"Choose Region", "Region I", "Region II", "Region III", "Region IV-A", "Region IV-B", "Region V", "Region VI", "Region VII", "Region VIII", "Region IX", "Region X", "Region XI", "Region XII", "NCR", "CAR", "ARMM", "CARAGA"};
        ArrayAdapter<String> stateAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, states);
        stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        state.setAdapter(stateAdapter);

        // Date Picker for Birthdate
        birthdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });

        birthtime.setOnClickListener(v -> showTimePicker());

        // Submit Button Click Listener
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validateInput()) {
                    return;
                }
                // Check if passwords match
                //if (!password.getText().toString().equals(confirmPassword.getText().toString())) {
                //  Toast.makeText(MainActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                //return;
                //}

                if (!agree.isChecked()) {
                    Toast.makeText(RegForm.this, "Please agree to the terms and conditions", Toast.LENGTH_SHORT).show();
                    return;
                }
                // Successful form submission
                Toast.makeText(RegForm.this, "Submitted Successfully!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Validation Method for Input Fields
    private boolean validateInput() {
        int selectedGenderId = gender.getCheckedRadioButtonId();
        boolean isGenderSelected = selectedGenderId != -1;

        // Check if all required fields are filled
        if (username.getText().toString().isEmpty() ||
                email.getText().toString().isEmpty() ||
                password.getText().toString().isEmpty() ||
                //confirmPassword.getText().toString().isEmpty() ||
                phone.getText().toString().isEmpty() ||
                country.getText().toString().isEmpty() ||
                state.getSelectedItem().toString().isEmpty() ||
                birthdate.getText().toString().isEmpty() ||
                birthtime.getText().toString().isEmpty() ||
                !isGenderSelected) {
            Toast.makeText(RegForm.this, "Please fill all the fields.", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    // Date Picker Dialog for Birthdate
    private void showDatePicker() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(RegForm.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
                        birthdate.setText(selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear);
                    }
                }, year, month, day);
        datePickerDialog.show();
    }

    private void showTimePicker(){
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(RegForm.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                String period = (selectedHour >= 120) ? "PM" : "AM";

                int hourFormat = (selectedHour > 12) ? selectedHour - 12 : selectedHour;
                if (hourFormat == 0){
                    hourFormat = 12;
                }

                String formattedTime = String.format("%02d:%02d %s",hourFormat, selectedMinute, period);
                birthtime.setText(formattedTime);
            }
        }, hour, minute, false);
        timePickerDialog.show();
    }
}

