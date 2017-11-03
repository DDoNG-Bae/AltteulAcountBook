package org.androidtown.altteulacountbook;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static org.androidtown.altteulacountbook.R.id.container;

/**
 * Created by DASOM on 2017-11-03.
 */

public class Fragment1 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView= (ViewGroup) inflater.inflate(R.layout.fragment1, container, false);
        return rootView;
    }
}