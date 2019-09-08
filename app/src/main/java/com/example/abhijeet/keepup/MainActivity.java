package com.example.abhijeet.keepup;

import android.app.AlarmManager;
import android.app.DialogFragment;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.hitomi.cmlibrary.OnMenuStatusChangeListener;
import com.ramotion.circlemenu.CircleMenuView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CircleMenu circleMenu = (CircleMenu) findViewById(R.id.circle_menu);
        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"), R.drawable.icon, R.drawable.coss)
                .addSubMenu(Color.parseColor("#258CFF"), R.drawable.divya)
                .addSubMenu(Color.parseColor("#30A400"), R.drawable.gujurat)
                .addSubMenu(Color.parseColor("#FF4B32"), R.drawable.ndtv)
                .addSubMenu(Color.parseColor("#8A39FF"), R.drawable.sandesh)
                .addSubMenu(Color.parseColor("#FF6A00"), R.drawable.times)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {

                    @Override
                    public void onMenuSelected(int index)
                    {
                        switch (index)
                        {
                            case 0:
                                Intent browser = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.divyabhaskar.co.in/"));
                                startActivity(browser);
                                break;
                            case 1:
                                Intent browser1 = new Intent(Intent.ACTION_VIEW,Uri.parse("http://gujaratsamacharepaper.com/"));
                                startActivity(browser1);
                                break;
                            case 2:
                                Intent browser2 = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.ndtv.com/topic/online-newspaper"));
                                startActivity(browser2);
                                break;
                            case 3:
                                Intent browser3 = new Intent(Intent.ACTION_VIEW,Uri.parse("https://sandeshepaper.in/"));
                                startActivity(browser3);
                                break;
                            case 4:
                                Intent browser4 = new Intent(Intent.ACTION_VIEW,Uri.parse("https://timesofindia.indiatimes.com/city/ahmedabad"));
                                startActivity(browser4);
                                break;
                        }
                    }

                }).setOnMenuStatusChangeListener(new OnMenuStatusChangeListener() {

            @Override
            public void onMenuOpened()
            {
                Toast.makeText(MainActivity.this,"Select your desired paper amigo",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onMenuClosed() {
                //Intent intent = new Intent(MainActivity.this, MainActivity.this);
                //start
            }

        });

    }

    //next two methods are for menu in action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu1, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        // We check what menu item was clicked and show a Toast
        if (id == R.id.about) {

            Intent intent = new Intent(this, About.class);
            startActivity(intent);
            return true;
        }
        else if(id == R.id.rate)
        {
            // A DialogFragment is a Fragment you can place over top
            // the current Activity. A Fragment is like an interface
            // block that you can place into an Activity.
            // The FrgamentManager allows you to interact with the
            // Fragment
            android.support.v4.app.DialogFragment dialog = new MyDialogFragment();
            dialog.show(getSupportFragmentManager(),"DIALOG");

            return true;
        }
        // If exit was clicked close the app
        else if (id == R.id.exit_app) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
