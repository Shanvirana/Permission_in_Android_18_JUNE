package com.example.dell.permission_inandroid_18_june;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button submit;
    EditText Mob;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit = (Button) findViewById(R.id.submit);
        Mob = (EditText) findViewById(R.id.MobNo);


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) !=
                PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Permission Not Granted !", Toast.LENGTH_SHORT).show();
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 123);
           // submit.setEnabled(false);
        } else {
            Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
            //submit.setEnabled(true);
        }


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(Mob.getText().toString(),null,"12012",null,null);
                Intent intent = new Intent(MainActivity.this, Otpclass.class);
                startActivity(intent);
            }
        });

    }
        @Override
        public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
        @NonNull int[] grantResults){
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);

            if (requestCode == 123) {
                if (grantResults.length > 0 &&
                        grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permission has been jj granted",
                            Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(this, "Permission has been Not granted",
                            Toast.LENGTH_SHORT).show();
                }
            }
        }

}
