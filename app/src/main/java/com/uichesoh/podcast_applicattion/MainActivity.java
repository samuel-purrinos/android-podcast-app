package com.uichesoh.podcast_applicattion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends FragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_podcast_list);

    }

    public List<ItunesResponse.Welcome> getPodcasts() {
        return null;
    }
}