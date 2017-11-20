package org.androidtown.altteulacountbook;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import static org.androidtown.altteulacountbook.R.id.container;

/**
 * Created by DASOM on 2017-11-03.
 */

public class Fragment1 extends Fragment {
    DBManager manager;
    ExpandableListView expandableListView;
    ArrayList<String> dayList;
    ArrayList<ArrayList<Entry>> childList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView= (ViewGroup) inflater.inflate(R.layout.fragment1, container, false);

        manager = new DBManager(getActivity());
        dayList = manager.queryDate("2017-01-01","2017-12-31");
        childList = manager.queryItemByDate(dayList);

        MyExpandableAdapter adapter = new MyExpandableAdapter(getActivity(),dayList,childList);

        expandableListView = (ExpandableListView)rootView.findViewById(R.id.expendable);
        expandableListView.setAdapter(adapter);





        return rootView;

    }


}