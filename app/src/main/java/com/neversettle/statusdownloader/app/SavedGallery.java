package com.neversettle.statusdownloader.app;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.neversettle.statusdownloader.R;
import com.neversettle.statusdownloader.adapter.SavedGalleryAdapter;
import com.neversettle.statusdownloader.utils.ListenableTabLayout;
import com.neversettle.statusdownloader.utils.TabIndicatorFollower;


public class SavedGallery extends AppCompatActivity {

    private Toolbar mToolBar;
    private ViewPager mViewPager;
    private ListenableTabLayout mTabLayout;
    private SavedGalleryAdapter mSavedGalleryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_gallery);

        mToolBar = (Toolbar) findViewById(R.id.saved_gallery_toolbar);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setTitle("Saved Gallery");


        //setting up view pager
        mViewPager = findViewById(R.id.saved_gallery_viewPager);
        View triangle = findViewById(R.id.triangle);

        mSavedGalleryAdapter = new SavedGalleryAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mSavedGalleryAdapter);

        mTabLayout = findViewById(R.id.saved_gallery_tabs);
        mTabLayout.setupWithViewPager(mViewPager);
        TabIndicatorFollower.setupWith(mTabLayout, triangle);


    }
}
