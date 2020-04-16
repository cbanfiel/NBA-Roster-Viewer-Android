package com.example.basketballstatistics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class PlayerProfile extends AppCompatActivity {

    ImageView imageView, ivTeam;
    TextView tvName, tvAge, tvHeight, tvContract, tvPosition, tvTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_profile);
        tvName = findViewById(R.id.tvName);
        tvAge = findViewById(R.id.tvAge);
        tvHeight = findViewById(R.id.tvHeight);
        tvPosition = findViewById(R.id.tvPosition);
        tvContract = findViewById(R.id.tvContract);
        imageView = findViewById(R.id.imageView);
        ivTeam = findViewById(R.id.ivTeam);
        tvTeam = findViewById(R.id.tvTeam);


        try{
            tvName.setText(Roster.selectedPlayer.getName());
            tvAge.setText("Age: " + Roster.selectedPlayer.getAge() + "");
            tvHeight.setText("Height: " + Roster.selectedPlayer.getHeight() + "");
            tvContract.setText("Contract: " + Roster.selectedPlayer.getContract() + "");
            tvPosition.setText("Position: " + Roster.selectedPlayer.getPosition());
            Glide.with(this).load(Roster.selectedPlayer.getUrl()).into(imageView);
            Glide.with(this).load(Roster.selected.getUrl()).into(ivTeam);
            tvTeam.setText(Roster.selected.getName());

        }catch (Exception e){
            Log.e("UHH", e.toString());
        }

    }
}
