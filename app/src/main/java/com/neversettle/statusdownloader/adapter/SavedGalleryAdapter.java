package com.neversettle.statusdownloader.adapter;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.neversettle.statusdownloader.fragments.subfragments.SavedPictureFragment;
import com.neversettle.statusdownloader.fragments.subfragments.SavedVideoFragment;

public class SavedGalleryAdapter extends FragmentPagerAdapter {
    public SavedGalleryAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                SavedPictureFragment pictureFragment = new SavedPictureFragment();
                return pictureFragment;
            case 1:
                SavedVideoFragment videosFragment = new SavedVideoFragment();
                return videosFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "PICTURES";
            case 1:
                return "VIDEOS";
            default:
                return null;
        }
    }
}
