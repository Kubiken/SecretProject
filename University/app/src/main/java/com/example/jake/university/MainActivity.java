package com.example.jake.university;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
<<<<<<< HEAD
import android.view.View;
import android.widget.TextView;
=======
>>>>>>> parent of 640b9fd... mini fix

import com.example.jake.university.API.ScheduleAlarms;
import com.example.jake.university.exams.FragmentExamsAndArrears;
import com.example.jake.university.news.FragmentNews;
import com.example.jake.university.payment.FragmentPayment;
import com.example.jake.university.profile.FragmentProfile;
<<<<<<< HEAD
import com.example.jake.university.profile.Singleton;
import com.example.jake.university.ranked.FragmentRanked;
=======
>>>>>>> parent of 640b9fd... mini fix
import com.example.jake.university.scholarships.FragmentScholarships;
import com.example.jake.university.timetable.FragmentLecturerSchedule;
import com.example.jake.university.timetable.FragmentTimetable;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONException;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerlayout;
    private ActionBarDrawerToggle mToggle;
    private FragmentTransaction ftrans;
    private HashMap<Integer, Integer> times;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        times.put(8,0);
        times.put(10,0);
        times.put(11,50);
        times.put(13,40);
        times.put(15,30);
        times.put(17,20);
        times.put(19,10);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerlayout = findViewById(R.id.drawer);
        NavigationView navigationView = findViewById(R.id.nav_view);
<<<<<<< HEAD
        try {
        View headView = navigationView.getHeaderView(0);
        TextView tvHeaderName = (TextView) headView.findViewById(R.id.tvHeaderName);
        tvHeaderName.setText(Singleton.getInstance("").getProfileInfo().getFIO());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
            e.printStackTrace();
        } catch (JSONException e) {
        }
=======
>>>>>>> parent of 640b9fd... mini fix
        navigationView.setNavigationItemSelectedListener(this);
        mToggle = new ActionBarDrawerToggle(this, mDrawerlayout, R.string.open, R.string.close);
        mDrawerlayout.addDrawerListener(mToggle);
        mToggle.syncState();
        ScheduleAlarms.getInstance().startAlarm(this, "12", "55", 100); //генерируем алларм на 12 55
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setCheckedItem(R.id.nav_news);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new FragmentNews()).commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if(mDrawerlayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerlayout.closeDrawer(GravityCompat.START);
        }
        else {
            if(getSupportFragmentManager().getBackStackEntryCount()==0) {
                new AlertDialog.Builder(this)
                        .setTitle("Выйти из приложения?")
                        .setMessage("Вы действительно хотите выйти?")
                        .setNegativeButton(android.R.string.no, null)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface arg0, int arg1) {
                                //SomeActivity - имя класса Activity для которой переопределяем onBackPressed();
                                MainActivity.super.onBackPressed();
                            }
                        }).create().show();
            }
            else {
                super.onBackPressed();
            }
        }
    }
    
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        ftrans = getSupportFragmentManager().beginTransaction();
        switch (id) {
            case R.id.nav_news:
                ftrans.replace(R.id.fragment_container, new FragmentNews()).addToBackStack(null).commit();
                break;
            case R.id.nav_profile:
                try {
                    ftrans.replace(R.id.fragment_container, new FragmentProfile()).addToBackStack(null).commit();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.nav_ranked:
                try {
                    ftrans.replace(R.id.fragment_container, new FragmentRanked()).addToBackStack(null).commit();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.nav_arrears:
                ftrans.replace(R.id.fragment_container, new FragmentExamsAndArrears()).addToBackStack(null).commit();
                break;
            case R.id.nav_payment:
                ftrans.replace(R.id.fragment_container, new FragmentPayment()).addToBackStack(null).commit();
                break;
            case R.id.nav_scholarships:
                try {
                    ftrans.replace(R.id.fragment_container, new FragmentScholarships()).addToBackStack(null).commit();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.nav_timetable:
                try {
                    ftrans.replace(R.id.fragment_container, new FragmentTimetable()).addToBackStack(null).commit();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.nav_timetable_lec:
                ftrans.replace(R.id.fragment_container, new FragmentLecturerSchedule()).addToBackStack(null).commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
