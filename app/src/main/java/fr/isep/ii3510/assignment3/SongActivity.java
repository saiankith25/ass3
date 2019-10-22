package fr.isep.ii3510.assignment3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fr.isep.ii3510.assignment3.model.Album;
import fr.isep.ii3510.assignment3.model.Band;
import fr.isep.ii3510.assignment3.model.Song;

public class SongActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Album album;

    private List<Song> songList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        album = (Album) getIntent().getSerializableExtra("songs");

        //Toast.makeText(getApplicationContext(),"click on item: "+album,Toast.LENGTH_LONG).show();

        getBandData();
        addRecyclerview();
    }

    private void addRecyclerview(){
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // specify an adapter (see also next example)
        mAdapter = new SongAdapter(songList,getApplicationContext());
        recyclerView.setAdapter(mAdapter);


    }

    private void getBandData() {


        List<String> songs = album.getSongs_list();
        for (String key : songs) {

            Song song = new Song(key);
            songList.add(song);
        }
        Log.d("Ankith","Albums--->"+songList.size());
        //mAdapter.notifyDataSetChanged();
    }
}



