package com.neversettle.statusdownloader.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import com.neversettle.statusdownloader.fragments.Instagram;
import com.neversettle.statusdownloader.fragments.Whatsapp;
import com.neversettle.statusdownloader.fragments.subfragments.NavigationDrawerFragment;
import com.neversettle.statusdownloader.R;
import com.neversettle.statusdownloader.model.NavigationDrawerItem;

import static androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private FragmentManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getSupportFragmentManager();
        manager.addOnBackStackChangedListener(new FragmentManagerListener());
        setUpToolbar();

        setUpDrawer();
        replaceByWhatsApp();


    }

    private void setUpToolbar() {

        toolbar =  findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.inflateMenu(R.menu.menu_main);
    }

    private void setUpDrawer() {

        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.nav_drwr_fragment);
        DrawerLayout drawerLayout =  findViewById(R.id.drawer_layout);
        assert drawerFragment != null;
        drawerFragment.setUpDrawer(R.id.nav_drwr_fragment, drawerLayout, toolbar);
        drawerFragment.setNavigationDrawerFragmentListener(new NavigationFragmentListener());
    }

    public void replaceByWhatsApp() {

        Whatsapp whatsapp = new Whatsapp();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, whatsapp, "fragWhatsApp");
//        transaction.addToBackStack("replaceByWhatsApp");
        transaction.commit();
    }

    public void replaceByInstagram() {

        Instagram instagram = new Instagram();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, instagram, "fragInstagram");
        transaction.addToBackStack("replaceByInstagram");
        transaction.commit();
    }

    public class NavigationFragmentListener implements NavigationDrawerFragment.NavigationDrawerFragmentListener {

        @Override
        public void onItemClick(NavigationDrawerItem item) {
            switch (item.getTitle()) {

                case "WhatsApp":

//                    Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                    replaceByWhatsApp();
                    break;

                case "Instagram":

                    replaceByInstagram();

                    break;
            }

        }
    }

    private static class FragmentManagerListener implements FragmentManager.OnBackStackChangedListener {

        @Override
        public void onBackStackChanged() {

        }
    }

    @Override
    public void onBackPressed() {

        if (manager.getBackStackEntryCount() > 0) {
            manager.popBackStack("replaceByInstagram",POP_BACK_STACK_INCLUSIVE);
         //   replaceByWhatsApp();
        } else {
            super.onBackPressed();
        }
    }

}