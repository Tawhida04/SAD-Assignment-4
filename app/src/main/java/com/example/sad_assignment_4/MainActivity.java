package com.example.sad_assignment_4;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView customListView;
    private ExpandableListView expandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Custom ListView
        customListView = findViewById(R.id.customListView);
        List<String> customListItems = new ArrayList<>();
        customListItems.add("Item 1");
        customListItems.add("Item 2");
        customListItems.add("Item 3");
        customListItems.add("Item 4");

        CustomAdapter customAdapter = new CustomAdapter(this, customListItems);
        customListView.setAdapter(customAdapter);

        // Expandable ListView
        expandableListView = findViewById(R.id.expandableListView);

        // Grouped Data for Expandable ListView
        List<String> groupList = new ArrayList<>();
        groupList.add("Group 1");
        groupList.add("Group 2");
        groupList.add("Group 3");

        HashMap<String, List<String>> childList = new HashMap<>();
        List<String> group1Children = new ArrayList<>();
        group1Children.add("Item 1.1");
        group1Children.add("Item 1.2");

        List<String> group2Children = new ArrayList<>();
        group2Children.add("Item 2.1");
        group2Children.add("Item 2.2");

        List<String> group3Children = new ArrayList<>();
        group3Children.add("Item 3.1");
        group3Children.add("Item 3.2");

        childList.put(groupList.get(0), group1Children);
        childList.put(groupList.get(1), group2Children);
        childList.put(groupList.get(2), group3Children);

        ExpandableListAdapter expandableListAdapter = new ExpandableListAdapter(this, groupList, childList);
        expandableListView.setAdapter(expandableListAdapter);
    }
}
