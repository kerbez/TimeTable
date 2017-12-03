package com.example.kerbe.timetablee;

import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.graphics.Color;
        import android.graphics.drawable.ColorDrawable;
        import android.support.v7.app.ActionBar;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
import android.util.Log;
import android.view.View;
        import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
        import android.widget.GridView;
        import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NoteActivity extends AppCompatActivity {
    TextView slony_plus, muhi_plus;
    ImageView dv_n_i, wv_n_i, n_n_i, ex_n_i, fin_n_i;
    GridView gv_n_l, gv_n_b;
    List<String> little = new ArrayList<>();
    List<Integer> id_l = new ArrayList<>();
    List<Integer> id_b = new ArrayList<>();
    List<String> big = new ArrayList<>();
    ArrayAdapter<String> ad_l, ad_b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        slony_plus = (TextView) findViewById(R.id.slony_plus);
        dv_n_i = (ImageView) findViewById(R.id.dv_n_i);
        wv_n_i = (ImageView) findViewById(R.id.wv_n_i);
        n_n_i = (ImageView) findViewById(R.id.n_n_i);
        ex_n_i = (ImageView) findViewById(R.id.ex_n_i);
        fin_n_i = (ImageView) findViewById(R.id.fin_n_i);
        gv_n_l = (GridView) findViewById(R.id.gv_n_l);
        gv_n_b = (GridView) findViewById(R.id.gv_n_b);

        NoteActivity mA = (NoteActivity.this);
        mA.setActionBarColor(Color.parseColor("#A3D2E1"));
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);
        final NoteDatabaseHelper db = new NoteDatabaseHelper(this);
        try {
            List<Note> nts = db.getAllNote();
            Log.d("hey", db.getNoteCount() + "");
            Log.d("intry", "all nts taken");
            for (Note a : nts) {
                if(a.getType().equals("big aim")){
                    big.add(a.getDes());
                    id_b.add(a.getId());
                }
                else if(a.getType().equals("little aim")){
                    little.add(a.getDes());
                    id_l.add(a.getId());
                }




                //Log.d("infor", "here");
                String log = "id = " + a.getId() + ", des = " + a.getDes() + ", day = " + a.getType();
                Log.d("hey ::", log);
            }
            ad_l = new ArrayAdapter<String>(this, R.layout.item_notes, R.id.tx_n, little);
            gv_n_l.setAdapter(ad_l);
            ad_b = new ArrayAdapter<String>(this, R.layout.item_notes, R.id.tx_n, big);
            gv_n_b.setAdapter(ad_b);
            forGrid();

        }catch(SQLiteException e){
            //Toast toast = Toast.makeText(this, "error", Toast.LENGTH_SHORT);
            //toast.show();
        }
        gv_n_l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                db.delete(""+id_l.get(position));
                Intent in = new Intent(NoteActivity.this, NoteActivity.class);
                startActivity(in);
            }
        });
        gv_n_b.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                db.delete(""+id_b.get(position));
                Intent in = new Intent(NoteActivity.this, NoteActivity.class);
                startActivity(in);
            }
        });
        slony_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(NoteActivity.this, NotePlusActivity.class);
                startActivity(in);
            }
        });
        dv_n_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(NoteActivity.this, DayViewActivity.class);
                startActivity(in);

            }
        });
        wv_n_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(NoteActivity.this, WeekViewActivity.class);
                startActivity(in);

            }
        });
        n_n_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(NoteActivity.this, NoteActivity.class);
                startActivity(in);

            }
        });
        ex_n_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(NoteActivity.this, ExamActivity.class);
                startActivity(in);

            }
        });
        fin_n_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(NoteActivity.this, FinActivity.class);
                startActivity(in);

            }
        });
    }

    private void forGrid() {
        gv_n_l.setNumColumns(2);
        gv_n_l.setVerticalSpacing(5);
        gv_n_l.setHorizontalSpacing(5);

        gv_n_b.setNumColumns(2);
        gv_n_b.setVerticalSpacing(5);
        gv_n_b.setHorizontalSpacing(5);
    }

    public void setActionBarColor(int parsedColor) {
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setBackgroundDrawable(new ColorDrawable(parsedColor));
        mActionBar.setDisplayShowTitleEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(true);
    }

}
