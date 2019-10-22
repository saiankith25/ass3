package fr.isep.ii3510.assignment3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fr.isep.ii3510.assignment3.model.Album;
import fr.isep.ii3510.assignment3.model.Band;

public class AlbumActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Resources resources;
    private Band bands;

    private List<Album> albumList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        bands = (Band) getIntent().getSerializableExtra("albums");

        //Toast.makeText(getApplicationContext(),"click on item: "+bands,Toast.LENGTH_LONG).show();

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
        mAdapter = new AlbumAdapter(albumList,getApplicationContext());
        recyclerView.setAdapter(mAdapter);


    }

    private void getBandData() {


        HashMap<String,ArrayList<String>> albumSongs = bands.getAlbumSongs();
        for (String key : albumSongs.keySet()) {
            String albumName = key;
            List<String> songs = albumSongs.get(key);
            Album album = new Album(albumName,songs);
            albumList.add(album);
        }
        Log.d("Ankith","Albums--->"+albumList.size());
        //mAdapter.notifyDataSetChanged();
    }
}

