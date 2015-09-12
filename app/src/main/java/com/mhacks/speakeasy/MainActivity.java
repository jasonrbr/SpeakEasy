package com.mhacks.speakeasy;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;
import com.parse.ParseObject;

import at.markushi.ui.CircleButton;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Parse Testing
//        ParseObject testObject = new ParseObject("TestObject");
//        testObject.put("foo", "bar");
//        testObject.saveInBackground();

        //Toolbar Code
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //MaterialDrawer setup
        new DrawerBuilder().withActivity(this)
                .withToolbar(toolbar)
                .withActionBarDrawerToggleAnimated(true)
                .addDrawerItems(
                        new PrimaryDrawerItem()
                                .withName(R.string.name_record)
                                .withIcon(FontAwesome.Icon.faw_microphone)
                                .withIdentifier(1)
                ).addStickyDrawerItems(
                new SecondaryDrawerItem().withName(R.string.name_about)
                        .withIcon(FontAwesome.Icon.faw_question_circle)
                        .withIdentifier(10)
        )       .withOnDrawerItemClickListener(
                new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int i, IDrawerItem iDrawerItem) {
                        if (iDrawerItem != null && iDrawerItem instanceof Nameable) {
                            getSupportActionBar().setTitle(((Nameable) iDrawerItem).getName().getTextRes());
                            Fragment fragment = null;
                            switch (iDrawerItem.getIdentifier()) {
                                case 1:
                                    fragment = AudioRecordFragment.newInstance(getResources()
                                            .getString(((Nameable) iDrawerItem).getName().getTextRes()));
                                    getSupportFragmentManager().beginTransaction()
                                            .replace(R.id.fragment_container, fragment).commit();
                                    return false;
                                default:
                                    fragment = AudioRecordFragment.newInstance(getResources()
                                            .getString(((Nameable) iDrawerItem).getName().getTextRes()));
                                    getSupportFragmentManager().beginTransaction()
                                            .replace(R.id.fragment_container, fragment).commit();
                                    return false;

                            }
                        }
                        return false;
                    }
                })
                .withFireOnInitialOnClick(true)
                .withSavedInstance(savedInstanceState)
                .build();



    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    }*/
}
