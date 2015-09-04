package com.technohest.tostack;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.*;

public class MainActivity extends Activity {
    private ArrayAdapter<String> adapter;
    private View view;

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

    private void addToList(Editable text) {
        adapter.add(text.toString());
        adapter.notifyDataSetChanged();
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
        setContentView(R.layout.input);
        toast("Stash");
    }

    private void pop(View v) {
        toast("POP!");
    }

    /**
     * Displays text for few seconds in the bottom of application.
     */
    public void toast(String string){
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }
}
