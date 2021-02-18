package com.mrkazofficial.kpreference;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mrkazofficial.kpreferencelib.KPreference;


public class MainActivity extends AppCompatActivity {

    private TextView txtName, txtNickName, txtAge;
    private EditText editTextName, editTextNickName, editTextAge;

    private final String KeyName = "Pref_Name";
    private final String KeyNickName = "Pref_NickName";
    private final String KeyAge = "Pref_Age";

    Button btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        KPreference.Initiate(this);

        final String getName = KPreference.getInstance().GetString(KeyName, "");
        final String getNickName = KPreference.getInstance().GetString(KeyNickName, "");
        final String getAge = KPreference.getInstance().GetString(KeyAge, "");

        txtName = findViewById(R.id.txtName);
        txtNickName = findViewById(R.id.txtNickName);
        txtAge = findViewById(R.id.txtAge);

        editTextName = findViewById(R.id.editTextName);
        editTextNickName = findViewById(R.id.editTextNickName);
        editTextAge = findViewById(R.id.editTextAge);

        btnClear = findViewById(R.id.btnClear);

        btnClear.setEnabled(getName.length() > 0);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restart();

                KPreference.getInstance().ClearSession();
                Toast.makeText(
                        MainActivity.this,
                        "Data Cleared! ",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

        this.findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String getEditTxtName = editTextName.getText().toString();
                String getEditTxtNickName = editTextNickName.getText().toString();
                String getEditTxtAge =  editTextAge.getText().toString();

                KPreference.getInstance().PutString(KeyName, getEditTxtName);
                KPreference.getInstance().PutString(KeyNickName, getEditTxtNickName);
                KPreference.getInstance().PutString(KeyAge, getEditTxtAge);

                if (getEditTxtName.isEmpty() || getEditTxtNickName.isEmpty() | getEditTxtAge.isEmpty()){

                    Toast.makeText(
                            MainActivity.this,
                            "Please fill the all the text boxes down below!",
                            Toast.LENGTH_SHORT
                    ).show();


                } else {

                    Toast.makeText(
                            MainActivity.this,
                            "Name -  " + getEditTxtName + " \n" + "Nick Name -  " + getEditTxtNickName
                                    + " \n" + "Age -  " + getEditTxtAge,
                            Toast.LENGTH_SHORT).show();

                    txtName.setText(getEditTxtName);
                    txtNickName.setText(getEditTxtNickName);
                    txtAge.setText(getEditTxtAge);

                    Log.d("Set Name", getEditTxtName);
                    Log.d("Set Nick Name", getEditTxtNickName);
                    Log.d("Set Age", getEditTxtAge);

                    btnClear.setEnabled(getName.length() > 0);

                    recreate();
                }


            }
        });


        this.findViewById(R.id.btnLoad).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (getName.isEmpty() || getNickName.isEmpty()|| getAge.isEmpty()){

                    Toast.makeText(
                            MainActivity.this,
                            "No data to found to load!",
                            Toast.LENGTH_SHORT
                    ).show();

                } else {

                    txtName.setText(getName);
                    txtNickName.setText(getNickName);
                    txtAge.setText(getAge);

                    Log.i("Load Data", "{ Name -> " + getName + " }"
                            + "{ Nick Name -> " + getNickName + " }"
                            + "{ Age -> " + getAge + " }");

                    Toast.makeText(
                            MainActivity.this,
                            "Name - " +  getName + "\n" + "Nick Name - " + getNickName + "\n" + "Age - " + getAge,
                            Toast.LENGTH_SHORT
                    ).show();

                }
            }
        });
    }


    private void restart(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            finishAffinity();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        } else {
            ActivityCompat.finishAffinity(MainActivity.this);
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
    }
}