package com.example.myprac.gallery;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myprac.MainActivity;
import com.example.myprac.R;
import com.example.myprac.navigation.GalleryFrag;

public class GalleryAddFrag extends Fragment {

    private View view;

    private static ImageView galleryImg;

    private EditText editText1;
    private EditText editText2;

    private String preDiabet;
    private String postDiabet;

    private static Uri imageUri;

    //private Gallery_Database gallery_database;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.gallery_add_page, container, false);

        Button selectBtn =  view.findViewById(R.id.button);
        Button uploadBtn = view.findViewById(R.id.button2);

        galleryImg = view.findViewById(R.id.gallery_img);
        editText1 = view.findViewById(R.id.prediabet);
        editText2 = view.findViewById(R.id.postdiabet);

        selectBtn.setOnClickListener(new View.OnClickListener() { //이미지 선택 버튼 클릭
            @Override
            public void onClick(View view) {
                MainActivity activity = (MainActivity) getActivity();
                activity.GalleryAdd();
            }
        });

        uploadBtn.setOnClickListener(new View.OnClickListener() { //업로드 버튼 클릭
            @Override
            public void onClick(View view) {
                preDiabet = editText1.getText().toString();
                postDiabet = editText2.getText().toString();


                GalleryData gd = new GalleryData(imageUri, preDiabet, postDiabet);
                GalleryFrag.addGalleryList(gd);
                editText1.setText(null);
                editText2.setText(null);
                galleryImg.setImageResource(R.drawable.ic_launcher_foreground);


                MainActivity activity = (MainActivity)getActivity();
                activity.setFrag(3);
            }
        });

        return view;
    }
    public static void setGalleryImg(Uri uri) {
        galleryImg.setImageURI(uri);
        imageUri = uri;
    }
}
