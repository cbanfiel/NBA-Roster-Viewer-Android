package com.example.basketballstatistics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class PlayerList extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_list);


        final ArrayList<ExampleItem> exampleList = new ArrayList<>();

        for(Player player : Roster.selected.getRoster()){
            String subtitle = player.getPosition() + " #" + player.getNumber();
            exampleList.add(new ExampleItem(player.getUrl(), player.getName(), subtitle));
        }

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(exampleList, this);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                for(Player player: Roster.selected.getRoster()){
                    if(player.getName().equals(exampleList.get(position).getTitle())){
                        Roster.selectedPlayer = player;
                        Intent intent = new Intent(PlayerList.this, PlayerProfile.class);
                        startActivity(intent);
                        return;
                    }
                }
            }
        });
    }
}
