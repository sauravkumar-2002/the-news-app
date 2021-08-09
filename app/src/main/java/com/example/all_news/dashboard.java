package com.example.all_news;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;


import com.example.all_news.covid.covid_home;
import com.example.all_news.databinding.ActivityDashboardBinding;
import com.google.android.material.navigation.NavigationView;

public class dashboard extends AppCompatActivity {
ActivityDashboardBinding binding;

ActionBarDrawerToggle toggle;
String languageselected="en",abouturl="https://newsapi.org/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityDashboardBinding.inflate(getLayoutInflater());
        View v=binding.getRoot();
        setContentView(v);
       // Log.v("saurav","activityoncrteate");

        setSupportActionBar(binding.toolbar);
        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.homecontainer,new home()).commit();

toggle=new ActionBarDrawerToggle(this,binding.drawer,binding.toolbar,R.string.open,R.string.close);
binding.drawer.addDrawerListener(toggle);
toggle.syncState();

       /* ArrayList<String>languagelist=new ArrayList<>();
        languagelist.add("gg");
        languagelist.add("gg");
        languagelist.add("ggkjhg");
        languagelist.add("ghj");
        languagelist.add("hh");



        */
      String languagelist[]={"ar","en","at","d","ae","dhh","d","e","dhh","d","e","dhh","d","e","dhh"};
        ArrayAdapter<String> adapter=new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,languagelist);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        binding.spinndfghj.setAdapter(adapter);
        binding.spinndfghj.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               languageselected = parent.getItemAtPosition(position).toString();
               // Toast.makeText(parent.getContext(), "Selected: " +languageselected, Toast.LENGTH_LONG).show();
               // Log.v("xx","ddddddd0");
                getSupportFragmentManager().beginTransaction().replace(R.id.homecontainer,new home()).commit();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
binding.navmenu1.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
       switch(item.getItemId()){
           case R.id.covid:
               getSupportFragmentManager().beginTransaction().replace(R.id.homecontainer,new covid_home()).commit();
               binding.drawer.closeDrawer(GravityCompat.START);
               break;
           case R.id.allnews:
               getSupportFragmentManager().beginTransaction().replace(R.id.homecontainer,new home()).commit();
               binding.drawer.closeDrawer(GravityCompat.START);
               break;
           case R.id.recentsearches:
               Toast.makeText(getApplicationContext(),"recent searches",Toast.LENGTH_SHORT).show();
               binding.drawer.closeDrawer(GravityCompat.START);
               break;
           case R.id.aboutus:
               Intent intent=new Intent(getApplicationContext(),webview.class);
               intent.putExtra("url",abouturl);
               startActivity(intent);
               binding.drawer.closeDrawer(GravityCompat.START);
               break;

       }
       return true;
    }
});















   }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.searchtoolbar,menu);
        MenuItem menuItem=menu.findItem(R.id.actiosearch);
        SearchView searchView=(SearchView)menuItem.getActionView();
        searchView.setQueryHint("Type here to Search");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
    public String getMydata(){
        return languageselected;
    }
}