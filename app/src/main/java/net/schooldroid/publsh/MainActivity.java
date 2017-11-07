package net.schooldroid.publsh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import net.schooldroid.sbottomnavigationlib.sBottomNavFrag;
import net.schooldroid.sdatelib.sDate;
import net.schooldroid.ssetting.Setting.SqliteSetting;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sBottomNavFrag sBottomNavFrag = new sBottomNavFrag();
        getSupportFragmentManager().beginTransaction().replace(R.id.content,sBottomNavFrag).commit();

    }
}
