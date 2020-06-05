package com.example.session1;
import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.activeandroid.util.Log;

import java.util.List;


@Table(name = "Posts")
public class Post extends Model {
    @Column(name = "Title")
    public String title;

    @Column(name = "Content")
    public String content;

    @Column(name = "Section")
    public String section;

    @Column(name = "ImageDirectory")
    public String imageDirectory;

    public static List<Post>getAllPosts(){
        return new Select().from(Post.class).execute();
    }

    public static List<Post>getPosts(String tabName){
        Log.d("TabName", tabName);
        return new Select().from(Post.class).where("Section = ?", tabName).orderBy("Title ASC").execute();

    }
}
