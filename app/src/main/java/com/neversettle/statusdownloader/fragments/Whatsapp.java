package com.neversettle.statusdownloader.fragments;

import android.content.Intent;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.neversettle.statusdownloader.R;
import com.neversettle.statusdownloader.adapter.SelectionsPageAdapter;
import com.neversettle.statusdownloader.app.SavedGallery;
import com.neversettle.statusdownloader.utils.ListenableTabLayout;
import com.neversettle.statusdownloader.utils.TabIndicatorFollower;
import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.Util;

import java.util.ArrayList;


public class Whatsapp extends Fragment {
    private ViewPager mViewPager;
    private ListenableTabLayout mTabLayout;
    private SelectionsPageAdapter mSectionPageAdapter;
    ArrayList<Integer> imageIDList;
    ArrayList<String> titleList;
    private BoomMenuButton bmb;

    public Whatsapp() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_whatsapp, container, false);
        //setting up view pager
        setUpViewPager(view);


        return view;
    }

    private void setUpViewPager(View view) {
        //setting up view pager
        mViewPager = view.findViewById(R.id.viewPager);
        View triangle = view.findViewById(R.id.triangle);
        mSectionPageAdapter = new SelectionsPageAdapter(getActivity().getSupportFragmentManager());
        mViewPager.setAdapter(mSectionPageAdapter);
        bmb = view.findViewById(R.id.bmb);
        imageIDList = new ArrayList<>();
        titleList = new ArrayList<>();

        setInitialData();
        assert bmb != null;

        for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++) {

            final HamButton.Builder SavedGallery = new HamButton.Builder()
                    .normalImageRes(imageIDList.get(i))
                    .imageRect(new Rect(20, 15, Util.dp2px(50), Util.dp2px(50)))
                    .shadowEffect(true)
                    .normalText(titleList.get(i))
                    .typeface(Typeface.DEFAULT_BOLD)
                    .textSize(22)
                    .listener(new OnBMClickListener() {
                        @Override
                        public void onBoomButtonClick(int index) {
                            if (index == 0) {
                                Intent savedPictures = new Intent(getActivity(), SavedGallery.class);
                                ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), bmb, "fabTrans1");

                                startActivity(savedPictures, activityOptionsCompat.toBundle());

                            } else if (index == 1) {
                                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                                sharingIntent.setType("text/plain");
                                String shareBody = "Download WhatsApp Status Saver using https://play.google.com/store/apps/details?id=com.tripleastudio.whatsappstatussaver";
                                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Songs of Zion ");
                                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                                startActivity(Intent.createChooser(sharingIntent, "Share via"));
                            } else if (index == 2) {
//                                Intent i = new Intent(getActivity(), InfoActivity.class);
//                                ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), bmb, "fabTrans");
//
//                                startActivity(i, activityOptionsCompat.toBundle());
                            }
                        }
                    });

            bmb.addBuilder(SavedGallery);
        }

        mTabLayout = view.findViewById(R.id.main_tabs);
        mTabLayout.setupWithViewPager(mViewPager);
        TabIndicatorFollower.setupWith(mTabLayout, triangle);


    }

    private void setInitialData() {
        imageIDList.add(R.drawable.ic_image_black_24dp);
        imageIDList.add(R.drawable.ic_share_black_24dp);
        imageIDList.add(R.drawable.ic_error_outline_black_24dp);

        titleList.add("Saved Gallery");
        titleList.add("Share this App");
        titleList.add("About Us");


    }

}