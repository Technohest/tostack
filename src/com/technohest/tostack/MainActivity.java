package com.technohest.tostack;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private ArrayAdapter<String> adapter;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.todolist);
        ListView todolist = (ListView) findViewById(R.id.todolist);
        todolist.setAdapter(adapter);

        initButtons();
    }

    private void initButtons() {
        Button pop = (Button) findViewById(R.id.popbutton);
        pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop(v);
            }
        });
        Button stash = (Button) findViewById(R.id.stashbutton);
        stash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stash(v);
            }
        });
    }

    private void stash(View v) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        toast("Stash");
    }

    private void pop(View v) {
        toast("POP!");
    }

    public void toast(String string){
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }
}
