package com.example.myprac.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myprac.gallery.GalleryAdapter;
import com.example.myprac.MainActivity;
import com.example.myprac.R;
import com.example.myprac.gallery.GalleryData;


import java.util.ArrayList;

public class GalleryFrag extends Fragment {

    private View view;

    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;

    private GalleryAdapter galleryAdapter;
    private static ArrayList<GalleryData> gdList;

    /*
    private GalleryDataSet galleryDataSet;
    private Gallery_Database gallery_database;

    List<GalleryDataSet> galleryDataSets;*/

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.galleryfrag, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.account_recyclerview);
        gridLayoutManager = new GridLayoutManager(view.getContext(),3);
        recyclerView.setLayoutManager(gridLayoutManager);

        gdList = new ArrayList<>();

        /*
        gallery_database = gallery_database.getInstance(getContext());
        galleryDataSets = gallery_database.galleryDao().getGallery_All();

         */

        Button account_btn_add = (Button)view.findViewById(R.id.account_btn_add);
        account_btn_add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                MainActivity activity = (MainActivity) getActivity();
                activity.setFrag(6);
            }
        });

        /*
        if(galleryDataSets != null) {
            for (int i = 0; i < galleryDataSets.size(); i++) {
                gdList.add(new GalleryData(
                        galleryDataSets.get(i).getImgUri(),
                        galleryDataSets.get(i).getPreDiabets(),
                        galleryDataSets.get(i).getPostDiabets()));

            }
        }*/

        galleryAdapter = new GalleryAdapter(gdList, getContext());
        recyclerView.setAdapter(galleryAdapter);

        return view;
    }

    public static void addGalleryList(GalleryData gd) {
        gdList.add(gd);
    }
}