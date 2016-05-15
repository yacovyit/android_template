package com.loopico.template.activity;




import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.loopico.template.R;
import com.loopico.template.fragments.BinData;
import com.loopico.template.fragments.RetainFragmentForData;

import java.util.Date;

public class RetainFragmentActivity extends AppCompatActivity {

    private RetainFragmentForData fragmentForData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retain_fragment);
        TextView tv = (TextView)findViewById(R.id.textViewDestroyAt);

        FragmentManager fm = getFragmentManager();
        fragmentForData = (RetainFragmentForData)fm.findFragmentByTag("data");

        if (fragmentForData==null){
            fragmentForData = new RetainFragmentForData();
            fm.beginTransaction().add(fragmentForData, "data").commit();

        }else{
            tv.setText(fragmentForData.getBinData().getData().toString());
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        fragmentForData.setBinData(new BinData("destroy activity at " + new Date().toGMTString()));
    }
}
