package com.loopico.template.fragments;

import android.os.Bundle;
import android.app.Fragment;

/**
 * Created by yacovyitzhak on 11/05/2016.
 */
public class RetainFragmentForData  extends Fragment {
    private BinData binData;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //retain fragment
        this.setRetainInstance(true);
    }

    public BinData getBinData() {
        return binData;
    }

    public void setBinData(BinData binData) {
        this.binData = binData;
    }
}
