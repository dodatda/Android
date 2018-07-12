package technology.dxc.preferencefragmentexample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView txtHello;
    private OnSharedPreferenceChangeListener preferenceChange = new OnSharedPreferenceChangeListener() {
        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            if (key.equals("color_setting")) {
                String color = sharedPreferences.getString(key, null);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtHello = (TextView) findViewById(R.id.txtHello);
        txtHello.setTextColor(Color.BLACK);

        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
        SharedPreferences share_preference = PreferenceManager.getDefaultSharedPreferences(this);
        share_preference.registerOnSharedPreferenceChangeListener(preferenceChange);
    }

    public void setHelloColor(String color){
        txtHello.setTextColor(Color.parseColor(color));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent preferenceIntent = new Intent(this, SettingActivity.class);
        startActivity(preferenceIntent);
        return super.onOptionsItemSelected(item);
    }
}
