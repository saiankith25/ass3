package fr.isep.ii3510.assignment3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fr.isep.ii3510.assignment3.model.Band;
import fr.isep.ii3510.assignment3.utils.CSVReader;

public class BandActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Resources resources;

    private List<Band> bandList = new ArrayList<>();
    HashMap<String,HashMap<String,ArrayList<String>>> bands = new HashMap<String,HashMap<String,ArrayList<String>>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_band);
        resources = getResources();
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        try {
            getBandData();
            addRecyclerview();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addRecyclerview(){
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // specify an adapter (see also next example)
        mAdapter = new BandAdapter(bandList,getApplicationContext());
        recyclerView.setAdapter(mAdapter);


    }

    private void getBandData() throws IOException {
        InputStream inputStream = getResources().openRawResource(R.raw.library);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(inputStream));
        String line = "";
        List<String[]> liness = new ArrayList<String[]>();
        try {
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                liness.add(tokens);
            }
        }
        catch (IOException e1) {
        Log.e("MainActivity", "Error" + line, e1);
        e1.printStackTrace();
        }
        for(String[] s : liness)
        {
            if(bands.containsKey(s[0]))
            {
                HashMap<String,ArrayList<String>> album = bands.get(s[0]);
                if(album.containsKey(s[1])){
                    ArrayList<String> songs = album.get(s[1]);
                    if(songs.contains(s[2])){
                        break;
                    }
                    else{
                        songs.add(s[2]);
                    }
                }else {
                    ArrayList<String> songs = new ArrayList<String>();
                    songs.add(s[2]);
                    album.put(s[1],songs);
                }
            }
            else {
                HashMap<String,ArrayList<String>> album = new HashMap<String,ArrayList<String>>() ;
                ArrayList<String> songs = new ArrayList<String>();
                songs.add(s[2]);
                album.put(s[1],songs);
                bands.put(s[0],album);
            }
        }
        for (String key : bands.keySet()) {
            String bandName = key;
            HashMap<String,ArrayList<String>> album = bands.get(key);
            Band band = new Band(bandName,album);
            bandList.add(band);
        }
        Log.d("Ankith","--->"+bandList.size());
        //mAdapter.notifyDataSetChanged();
    }
}
