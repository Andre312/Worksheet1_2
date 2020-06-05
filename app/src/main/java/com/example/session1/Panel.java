package com.example.session1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.activeandroid.ActiveAndroid;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class Panel extends Activity {
    String tabSelected;
    ImageView iv_photo;
    TextView tv_section_answer;
    EditText title, section, description;
    Uri imageUri;
    static final int REQUEST_IMAGE_GET = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        //int tabNumber = intent.getIntExtra("tabNumber", -1);
//        TabLayout tablayout = (TabLayout) findViewById(R.id.tablayout);
//        tablayout = tablayout.getTabAt(tabNumber);
          tabSelected = intent.getStringExtra("TabSeleted");
//        tv_section_answer = (TextView) findViewById(R.id.tv_section_answer);
//        tv_section_answer.setText(tabSelected);

        setContentView(R.layout.activity_panel);
        section = findViewById(R.id.et_postSection);
        title = findViewById(R.id.et_postTitle);
        description = findViewById(R.id.et_postDescription);
        iv_photo = findViewById(R.id.iv_photo);

    }

    public void iv_openExistingImage_Clicked(View v){
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_GET);
        }
    }

    public void btn_submit_post_Clicked(View v){
        ActiveAndroid.initialize(this);
        Post newPost = new Post();
        newPost.title = title.getText().toString();
        newPost.content = description.getText().toString();
        newPost.section = section.getText().toString();
       // newPost.section = tabSelected;
        newPost.imageDirectory= imageUri.toString();
        newPost.save();
        Intent intent = new Intent(Panel.this, tabscreen.class);
        startActivity(intent);

    }

    public void btn_cancel_post_Clicked(View v){
        Intent intent = new Intent(Panel.this, tabscreen.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_GET && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            //Bitmap imageBitmap = (Bitmap) extras.get("data");
            //iv_photo.setImageBitmap(imageBitmap);
            imageUri = data.getData();
            iv_photo.setImageURI(imageUri);
        }
    }

}
