package com.neversettle.statusdownloader.adapter;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.neversettle.statusdownloader.fragments.subfragments.PictureFragment;
import com.neversettle.statusdownloader.fragments.subfragments.VideosFragment;

public class SelectionsPageAdapter extends FragmentPagerAdapter {
    public SelectionsPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                PictureFragment pictureFragment = new PictureFragment();
                return pictureFragment;
            case 1:
                VideosFragment videosFragment = new VideosFragment();
                return videosFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "PICTURES";
            case 1:
                return "VIDEOS";
            default:
                return null;
        }
    }
}