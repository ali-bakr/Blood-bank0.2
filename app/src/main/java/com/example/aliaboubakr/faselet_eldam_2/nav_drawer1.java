package com.example.aliaboubakr.faselet_eldam_2;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.aliaboubakr.faselet_eldam_2.ContactWithUs.CommunicateWithUsFragment;
import com.example.aliaboubakr.faselet_eldam_2.MyInformation.MyinfoFragment;
import com.example.aliaboubakr.faselet_eldam_2.Report.EblaghFragment;
import com.example.aliaboubakr.faselet_eldam_2.favourite.FavouriteFragment;

public class nav_drawer1 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawer;

  //  FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_nav_drawer1);

        drawer =  findViewById(R.id.drawer_layout);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       // floatingActionButton =findViewById(R.id.fab_1);
        /*/-------------------------------------------------
        floatingActionButton =findViewById(R.id.fab_1);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              //  OrdesForm ordesForm=new OrdesForm();
               // getSupportFragmentManager()
                 //       .beginTransaction().replace(R.id.frag_container,ordesForm).commit();

            }
        });
*/
     /*   TabLayout taps=findViewById(R.id.viewPager_taps_id);
        ViewPager vpager=findViewById(R.id.viewPager_taps);
    TabPagerAdaptor tpAdaptor=new TabPagerAdaptor(getSupportFragmentManager());
    vpager .setAdapter(tpAdaptor);
    taps.setupWithViewPager(vpager);
*/

       /*    FloatingActionButton fab = findViewById(R.id.fab_1);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
             //           .setAction("Action", null).show();

          //      getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,
            //           new OrdesForm()).commit();

            }
        });

*/
////mypy som mistiack her between 43*35 lines
        NavigationView navigationView =  findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

///////
if (savedInstanceState==null) {
    getSupportFragmentManager().beginTransaction().add(R.id.frag_container,
            new HomeFragment()).commit();
    navigationView.setCheckedItem(R.id.home_at_menu);
}


    }

    @Override
    public void onBackPressed() {

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_drawer1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_myinfo) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,
new MyinfoFragment()).commit();
            // Handle the camera action


        } else if (id == R.id.nav_notification_setting) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,
                    new NotificationSettingFragment()).commit();


        }

        else if (id == R.id.nav_favourit_at_menu) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,
                    new FavouriteFragment()).commit();


        } else if (id == R.id.home_at_menu) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,
                    new HomeFragment()).commit();
            Toast.makeText(this, "wtf fragment", Toast.LENGTH_SHORT).show();

        }

        else if (id == R.id.nav_user_instruction) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,
                    new UserInstructionFragment()).commit();

        }

        else if (id == R.id.nav_eblagh) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,
                    new EblaghFragment()).commit();
        }


        else if (id == R.id.nav_cominicat_with_us) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,
                    new CommunicateWithUsFragment()).commit();
        }

        else if (id == R.id.nav_about_app) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,
                    new AboutAppFragment()).commit();
        }

        else if (id == R.id.nav_rate) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,
                    new RateFragment()).commit();
        }

        else if (id == R.id.nav_logout) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,
                    new LogoutFragment()).commit();
        }


        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void taplayout1(View view) {


    }




}

    //   public void DisplayFragment (Fragment fragment) {

    /*    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.,fragment);
        fragmentTransaction.commit();
    }
*/



