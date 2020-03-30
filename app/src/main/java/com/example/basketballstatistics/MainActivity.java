package com.example.basketballstatistics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

        Button btnTeams;
        RequestQueue requestQueue;
    private ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (ProgressBar)findViewById(R.id.progressBar1);

        btnTeams = findViewById(R.id.btnTeams);
        Roster.teams = new ArrayList<>();

        requestQueue = Volley.newRequestQueue(this);

        loadRosterJson();
    }

    public void openTeams(View v){
        Intent intent = new Intent(MainActivity.this, TeamList.class);
        startActivity(intent);
    }

    public void loadRosterJson(){
        String url = "https://on-paper-sports.s3.us-east-2.amazonaws.com/basketball/NBA2019-20v4.json";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("teams");

                            for(int i=0; i<jsonArray.length(); i++){
                                JSONObject teamJson = jsonArray.getJSONObject(i);
                                String name = teamJson.getString("name");
                                String url = teamJson.getString("logoSrc");
                                int conference = teamJson.getInt("conferenceId");

                                Team team = new Team(name, url, conference);
                                JSONArray rosterArray = teamJson.getJSONArray("roster");
                                for(int j=0; j<rosterArray.length(); j++){
                                    JSONObject playerJson = rosterArray.getJSONObject(j);
                                    String playerName = playerJson.getString("name");
                                    String playerUrl =  playerJson.optString("faceSrc", "");
                                    int number = playerJson.getInt("number");
                                    int position = playerJson.getInt("position");

                                    team.addPlayer(new Player(playerName, playerUrl, position, number));
                                }

                                Roster.teams.add(team);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        spinner.setVisibility(View.GONE);
                        btnTeams.setVisibility(View.VISIBLE);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
requestQueue.add(request);

    }
}
