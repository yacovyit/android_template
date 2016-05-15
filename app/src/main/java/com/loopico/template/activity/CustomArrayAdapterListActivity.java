package com.loopico.template.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.loopico.template.R;
import com.loopico.template.activity.model.User;

import java.util.ArrayList;

public class CustomArrayAdapterListActivity extends AppCompatActivity {

    private ListView customListView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_array_adapter_list);

        customListView = (ListView)findViewById(R.id.listViewCustom);
        ArrayList<User> users =  new ArrayList<>();
        users.add(new User("yacov" , "yitzhak"));
        users.add(new User("moshe" , "david"));
        users.add(new User("sasson" , "xxx"));

        CustomArrayAdapter adapter = new CustomArrayAdapter(this,users);
        customListView.setAdapter(adapter);

    }
}
