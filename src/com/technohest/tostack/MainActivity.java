package com.technohest.tostack;

import android.support.v4.app.*;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity implements TodoDialogListener{
    private ArrayAdapter<String> adapter;
    private View view;
    private ArrayList<String> todoListItems;
    private ListView todoList;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        todoListItems = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, todoListItems);
        todoList = (ListView) findViewById(R.id.todolist);
        todoList.setAdapter(adapter);

        initButtons();

    }

    private void addToList(String text) {
        todoListItems.add(text);
        adapter.notifyDataSetChanged();
        toast("Stash");
    }
    private void removeItemFromList(){
        if(todoListItems.size()>0) {
            todoListItems.remove(0);
            adapter.notifyDataSetChanged();
            toast("POP!");
        }
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
        showEditDialog();
    }

    private void pop(View v) {
        removeItemFromList();
    }

    private void showEditDialog() {
        FragmentManager fm = getSupportFragmentManager();
        TodoDialog todoDialog = new TodoDialog();
        todoDialog.show(fm, "input");
    }

    @Override
    public void onFinishEditDialog(String inputText) {
        addToList(inputText);
    }

    /**
     * Displays text for few seconds in the bottom of application.
     */
    public void toast(String string){
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }
}
