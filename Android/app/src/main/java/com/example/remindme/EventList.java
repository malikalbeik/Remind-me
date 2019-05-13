package com.example.remindme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.NavigationView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class EventList extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static ArrayList<EventElement> events;
    private ListView listView;
    private EventListAdapter listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        initialize();
        fillArrayList(events);
    }

    private void initialize() {
        events = new ArrayList<EventElement>();
        listView = (ListView) findViewById(R.id.eventList);
        listViewAdapter = new EventListAdapter(getApplicationContext(),events);
        listView.setAdapter(listViewAdapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(), "Event Selected", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(getApplicationContext(), EventInfo.class);
//                intent.putExtra("Id", events.get(position).getId());
//                startActivity(intent);
//            }
//        });
    }

    private void fillArrayList(ArrayList<EventElement>elements){
//        for (int index = 0; index < 20; index++) {
//            elements.add(new EventElement((index + 1) + ")" + " Event Name", "Locatoin", "Date"));
//        }

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NotNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent intent=null;

        if (id == R.id.nav_profile) {
            // Handle the camera action
            intent = new Intent(getApplicationContext(), EventList.class);
        } else if (id == R.id.nav_events) {
            intent = new Intent(getApplicationContext(), EventList.class);
        } else if (id == R.id.nav_calendar) {
            intent = new Intent(getApplicationContext(), EventList.class);
        } else if (id == R.id.nav_settings) {
            intent = new Intent(getApplicationContext(), EventList.class);
        }
        startActivity(intent);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
