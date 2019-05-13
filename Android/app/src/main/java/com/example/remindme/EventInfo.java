//package com.example.remindme;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.design.widget.NavigationView;
//import android.support.v4.view.GravityCompat;
//import android.support.v4.widget.DrawerLayout;
//import android.support.v7.app.ActionBarDrawerToggle;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.Button;
//import android.widget.Toast;
//
//import org.jetbrains.annotations.NotNull;
//
//public class EventInfo extends AppCompatActivity
//        implements NavigationView.OnNavigationItemSelectedListener {
//
//    private EventListAdapter item;
//
//    @Override
//    protected void onCreate ( Bundle savedInstanceState ) {
//        super.onCreate ( savedInstanceState );
//        setContentView ( R.layout.event );
//
//        Toolbar toolbar = ( Toolbar ) findViewById ( R.id.toolbar );
//        setSupportActionBar ( toolbar );
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();
//
//        NavigationView navigationView = ( NavigationView ) findViewById ( R.id.nav_view );
//        navigationView.setNavigationItemSelectedListener ( this );
//
//        String newString;
//        if (savedInstanceState == null) {
//            Bundle extras = getIntent ( ).getExtras ( );
//            if (extras == null) {
//                newString = null;
//            } else {
//                newString = extras.getString ( "Id" );
//            }
//        } else {
//            newString = ( String ) savedInstanceState.getSerializable ( "Id" );
//        }
//
//        final Button button = ( Button ) findViewById ( R.id.button );
//        button.setOnClickListener ( new View.OnClickListener ( ) {
//            public void onClick ( View v ) {
//
////                Intent intent = new Intent ( EventInfo.this, CalendarActivity.class );
////                startActivity ( intent );
////                Toast.makeText(getApplicationContext(), "Added To Calendar", Toast.LENGTH_SHORT).show();
////                intent.putExtra("message", "Select a date");
//            }
//        } );
//    }
//
//    @Override
//    public boolean onNavigationItemSelected(@NotNull MenuItem item) {
//        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//        Intent intent=null;
//
//        if (id == R.id.nav_profile) {
//            // Handle the camera action
//            intent = new Intent(getApplicationContext(), EventList.class);
//        } else if (id == R.id.nav_events) {
//            intent = new Intent(getApplicationContext(), EventList.class);
//        } else if (id == R.id.nav_calendar) {
//            intent = new Intent(getApplicationContext(), EventList.class);
//        } else if (id == R.id.nav_settings) {
//            intent = new Intent(getApplicationContext(), EventList.class);
//        }
//        startActivity(intent);
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
//    }
//}
