package com.example.session1;
import androidx.fragment.app.Fragment;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.ActionBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Delete;
import com.facebook.stetho.Stetho;

import java.util.List;

public class MainActivity extends ListActivity {

    GridView gridView;
    ListView mainListActivity;
    String menuItems[] = {"Portal", "Settings", "Help", "About"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("test", "hello");
        //gridView = (GridView) findViewById(R.id.);

        Stetho.initializeWithDefaults(this);
        mainListActivity = getListView();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menuItems);
        mainListActivity.setAdapter(adapter);

        mainListActivity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // Toast.makeText(MainActivity.this, "Test " + adapter.getItem(position), Toast.LENGTH_SHORT).show();
                if (position == 0)
                {
                    Intent intent = new Intent(MainActivity.this,tabscreen.class);
                    startActivity(intent);
                }
            }
        });

       // setListAdapter(new ArrayAdapter<String>(this, android.R.layout.row, menuItems));

//        ActiveAndroid.initialize(this);
//
//        List<Post>storedPosts = Post.getAllPosts();
//        Post firstPost = storedPosts.get(0);
//        firstPost.title = "Cat";
//        firstPost.content = "British Shorthair";
//        firstPost.section = "Animals";
//        firstPost.imageDirectory = "current/animals/cats/british";
//        firstPost.save();
//
//        Post firstPost = storedPosts.get(4);
//        firstPost.title = "Catss";
//        firstPost.content = "British Shorthair";
//        firstPost.section = "Animals";
//        firstPost.imageDirectory = "current/animals/cats/british";
//        firstPost.save();

//        Post.delete(Post.class, 3);
//        new Delete().from(Post.class).where("title = ?", "Catss").execute();
        new Delete().from(Post.class).where("section = ?", "Animals").execute();
        Log.d("EA", "All Done!");


    }

    /*
    class MyAdapter extends ArrayAdapter<String>
    {
        Context context;
        String rMenuItems[];

        MyAdapter (Context c, String menuItems[])
        {
            super(c, R.layout.main_list_row, R.id.textview1, menuItems);
            this.context = c;
            this.rMenuItems = menuItems;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.main_list_row, parent,  false);
            TextView menuItems = row.findViewById(R.id.textView1);


            return super.getView(position, convertView, parent);
        }
    }
    */
    /*
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        TextView temp = (TextView) v;
        Toast.makeText(this, ""+temp.getText()+ " "+position, Toast.LENGTH_SHORT).show();
    }

     */
}
