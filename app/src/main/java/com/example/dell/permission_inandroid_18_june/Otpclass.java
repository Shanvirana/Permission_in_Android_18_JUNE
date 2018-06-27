package com.example.dell.permission_inandroid_18_june;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Dell on 26-06-2018.
 */

public class Otpclass extends AppCompatActivity {

    String check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otp_acativity);

        Button btn = findViewById(R.id.otp_submit);
        EditText otp = findViewById(R.id.otp);
       check  = otp.getText().toString();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if(check.equals("12012"))
            {
                Toast.makeText(Otpclass.this, "Correct OTP", Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(Otpclass.this, "WRONG OTP", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
