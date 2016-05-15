package com.loopico.template.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.loopico.template.MainActivity;
import com.loopico.template.R;

public class ListActivity extends AppCompatActivity {

    private ListView lv ;
    private String[] actions = {"2 Fragments Simple","Custom List","Http Get downloader","Download Image","Retain Fragment Data","Cursor loader fragment"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        lv =(ListView)findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,actions);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = null;
                switch (position){
                    case 0:
                        i = new Intent(ListActivity.this, MainActivity.class);
                        break;
                    case 1:
                        i = new Intent(ListActivity.this, CustomArrayAdapterListActivity.class);
                        break;
                    case 2:
                        i = new Intent(ListActivity.this, JsonDownloadActivity.class);
                        break;
                    case 3:
                        i = new Intent(ListActivity.this, DownloadImageFromUrlActivity.class);
                        break;
                    case 4:
                        i = new Intent(ListActivity.this, RetainFragmentActivity.class);
                        break;
                    case 5:
                        i = new Intent(ListActivity.this, CursorLoaderListFragmentActivity.class);
                        break;
                    default:
                        break;
                }
                if (i!=null){
                    ListActivity.this.startActivity(i);
                }

            }
        });
    }
}
