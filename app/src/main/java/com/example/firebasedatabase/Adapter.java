package com.example.firebasedatabase;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.core.DatabaseConfig;

import java.util.List;

public class Adapter extends ArrayAdapter<DB_Model> {
    private final Activity context;
    private final List<DB_Model> userList;

    public Adapter(Activity context, List<DB_Model> userList) {
        super(context,R.layout.activity_details, userList);
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //That will Inflate the Sample Layout...
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.list__semple,null,false);

        //Gating The List
        DB_Model db_model = userList.get(position);

        //Gating Touch to The XML
        TextView name = view.findViewById(R.id.name);
        TextView age = view.findViewById(R.id.age);

        //Setting Up Text Into The XML
        name.setText(db_model.getName());
        age.setText(db_model.getAge());

        return view;
    }
}
