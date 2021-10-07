package com.example.aplikasipolije;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String[] MAJOR = new String[]{
            "Kue Tar", "Kue Nampan", "Kue Basah", "Kue Kering", "Kue Kotakan"
    };

    Spinner spinner;

    ListView listView;

//    ListView listViewMajor;
//    String[] major;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Kodingan AutoCompleteTextView
        AutoCompleteTextView editText = findViewById(R.id.actv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, MAJOR);
        editText.setAdapter(adapter);

        //Kodingan Spiner
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.major, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String jurusan = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Anda klik Kue" + jurusan, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //Kodingan listViewMajor
        listView = findViewById(R.id.ListView);
        String[] values = new String[]{
                "Kue Tar", "Kue Nampan", "Kue Basah", "Kue Kering", "Kue Kotakan"
        };

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                android.R.id.text1, values);

        listView.setAdapter(adapter2);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Anda klik Kue:" + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}