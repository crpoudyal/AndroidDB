package com.example.labexample;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SqLiteActivity extends AppCompatActivity {
    EditText edtId, edtName, edtAddress;
    TextView txt;
    Button insert, show,update;
    DBHelper dbHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqlite_example);

        dbHelper = new DBHelper(this);

        edtId = findViewById(R.id.id);
        edtName = findViewById(R.id.name);
        edtAddress = findViewById(R.id.address);
        insert = findViewById(R.id.insert);
        show = findViewById(R.id.show);
        update = findViewById(R.id.update);
        txt = findViewById(R.id.txt);


        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(edtId.getText().toString());
                String name = edtName.getText().toString();
                String address = edtAddress.getText().toString();
                dbHelper.insertData(id, name, address);

                Toast.makeText(getApplicationContext(), "Data Inserted", Toast.LENGTH_SHORT).show();

            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(edtId.getText().toString());
                String name = edtName.getText().toString();
                String address = edtAddress.getText().toString();

                dbHelper.updateData(id,name,address);

                Toast.makeText(getApplicationContext(), "Data Updated", Toast.LENGTH_SHORT).show();

            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                int id = 0;
                String name = "", address = "";
                Cursor cursor = dbHelper.selectData();
                while (cursor.moveToNext()) {
                    id = cursor.getInt(0);
                    name = cursor.getString(1);
                    address = cursor.getString(2);
                }
                txt.setText("ID = " + id
                        + "\n Name = " + name + "\n address = " + address);
            }
        });
    }
}
