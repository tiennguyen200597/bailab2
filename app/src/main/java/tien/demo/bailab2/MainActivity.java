package tien.demo.bailab2;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import tien.demo.lab2.R;

public class MainActivity extends AppCompatActivity {
    private EditText editEt;
    private Button button;
    private EditText editcheckma;
    private Button btncheck;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //bai1----------------------------------------------------
        MyBr myBr=new MyBr();
        final IntentFilter filter = new IntentFilter("android.intent.action.PHONE_STATE");
        registerReceiver(myBr, filter);
       /* NetworkChangeReceiver receiver = new NetworkChangeReceiver();
        final IntentFilter filter1 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(receiver, filter1);*/
        //bai2----------------------------------------------------------
        editEt = (EditText) findViewById(R.id.editEt);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("name",editEt.getText().toString());
                intent.setAction("fpoly.android.CUSTOM_INTENT");
                sendBroadcast(intent);
            }
        });
        TestBr testBr=new TestBr();
        final IntentFilter filter3 = new IntentFilter("fpoly.android.CUSTOM_INTENT");
        registerReceiver(testBr, filter3);
        //bai2---------------------------------------------------
        editcheckma = (EditText) findViewById(R.id.editcheckma);
        btncheck = (Button) findViewById(R.id.btncheck);
        btncheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("code",editcheckma.getText().toString());
                intent.setAction("tien.android.CHECK_CODE");
                sendBroadcast(intent);
            }
        });
        checkBroadcast checkBroadcast=new checkBroadcast();
        final IntentFilter filter4 = new IntentFilter("tien.android.CHECK_CODE");
        registerReceiver(checkBroadcast, filter4);
    }

    public void click(View view) {
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
            // viet 1 doan code yeu cau cap quyen
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_PHONE_STATE}, 999);

            Toast.makeText(this, "da cap quyen", Toast.LENGTH_SHORT).show();
        }
    }
}
