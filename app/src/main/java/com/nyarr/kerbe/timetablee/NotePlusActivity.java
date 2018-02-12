package com.nyarr.kerbe.timetablee;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class NotePlusActivity extends AppCompatActivity {
    Spinner n_type;
    EditText des_n_ET;
    Button plus_n_ADD;
    String[] types = {"little aim", "big aim"};
    String[] types2 = {"task", "exam"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_plus);

        NotePlusActivity mA = (NotePlusActivity.this);
        mA.setActionBarColor(Color.parseColor("#A3D2E1"));
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);
        n_type = (Spinner) findViewById(R.id.n_type);
        des_n_ET = (EditText) findViewById(R.id.des_n_ET);
        plus_n_ADD = (Button) findViewById(R.id.plus_n_ADD);
        final NoteDatabaseHelper db = new NoteDatabaseHelper(this);
        String k = getIntent().getStringExtra("a");
        if(k.equals("0")) {

            ArrayAdapter<String> from_adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, types);
            from_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            n_type.setAdapter(from_adapter);

            plus_n_ADD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    db.insertTT(n_type.getSelectedItem().toString(), des_n_ET.getText().toString());
                    Toast.makeText(getBaseContext(), "successfully added", Toast.LENGTH_SHORT);
                    Intent in = new Intent(NotePlusActivity.this, NoteActivity.class);
                    startActivity(in);
                }
            });
        }
        else{
            ArrayAdapter<String> from_adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, types2);
            from_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            n_type.setAdapter(from_adapter);

            plus_n_ADD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    db.insertTT(n_type.getSelectedItem().toString(), des_n_ET.getText().toString());
                    Toast.makeText(getBaseContext(), "successfully added", Toast.LENGTH_SHORT);
                    Intent in = new Intent(NotePlusActivity.this, ExamActivity.class);
                    startActivity(in);
                }
            });

        }
    }

    public void setActionBarColor(int parsedColor) {
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setBackgroundDrawable(new ColorDrawable(parsedColor));
        mActionBar.setDisplayShowTitleEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(true);
    }

}
