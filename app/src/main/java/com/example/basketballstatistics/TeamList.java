package com.example.basketballstatistics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;

public class TeamList extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_list);


        final ArrayList<ExampleItem> exampleList = new ArrayList<>();

        for(Team team : Roster.teams){
            exampleList.add(new ExampleItem(team.getUrl(), team.getName(), team.getConference()));
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
                for(Team team: Roster.teams){
                    if(team.getName().equals(exampleList.get(position).getTitle())){
                        Roster.selected = team;
                        Intent intent = new Intent(TeamList.this, PlayerList.class);
                        startActivity(intent);
                        return;
                    }
                }
            }
        });
    }
}
