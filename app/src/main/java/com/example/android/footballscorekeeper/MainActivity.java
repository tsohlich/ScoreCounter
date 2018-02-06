package com.example.android.footballscorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int goalsTeamA = 0;
    int goalsTeamB = 0;
    int penaltiesTeamA = 0;
    int penaltiesTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displaygoalTeamA(0);
        displaygoalTeamB(0);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        outState.putInt("GOALS_TEAM_A", goalsTeamA);
        outState.putInt("GOALS_TEAM_B", goalsTeamB);
        outState.putInt("penalties_TEAM_A", penaltiesTeamA);
        outState.putInt("penalties_TEAM_B", penaltiesTeamB);
    }

    /**
     * Saves scores if screen rewritten
     */
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);

        goalsTeamA = savedInstanceState.getInt("GOALS_TEAM_A");
        goalsTeamB = savedInstanceState.getInt("GOALS_TEAM_B");
        penaltiesTeamA = savedInstanceState.getInt("penalties_TEAM_A");
        penaltiesTeamB = savedInstanceState.getInt("penalties_TEAM_B");
        displaygoalTeamA(goalsTeamA);
        displaygoalTeamB(goalsTeamB);
        displaypenaltiesTeamA(penaltiesTeamA);
        displaypenaltiesTeamB(penaltiesTeamB);

    }


    /**
     * display info for Team A.
     */
    public void displaygoalTeamA(int score) {
        TextView scoreView = findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displaypenaltiesTeamA(int penalties) {
        TextView penaltiesView = findViewById(R.id.team_a_penalties);
        penaltiesView.setText("Penalties:" + String.valueOf(penalties));
    }

    /**
     * Add goal for team A
     */

    public void addOneForTeamA(View v) {
        goalsTeamA = goalsTeamA + 1;
        displaygoalTeamA(goalsTeamA);
    }

    /**
     * Add penalty for team A
     */

    public void addOnePenaltyTeamA(View v) {
        penaltiesTeamA = penaltiesTeamA + 1;
        goalsTeamA = goalsTeamA + 1;
        displaypenaltiesTeamA(penaltiesTeamA);
        displaygoalTeamA(goalsTeamA);
    }

    /**
     * display info for Team B.
     */
    public void displaygoalTeamB(int score) {
        TextView scoreView = findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displaypenaltiesTeamB(int penalties) {
        TextView scoreView = findViewById(R.id.team_b_penalties);
        scoreView.setText("Penalties:" + String.valueOf(penalties));
    }

    /**
     * Add goal for team B
     */

    public void addOneForTeamB(View v) {
        goalsTeamB = goalsTeamB + 1;
        displaygoalTeamB(goalsTeamB);
    }

    /**
     * Add penalty for team B
     */

    public void addOnePenaltyTeamB(View v) {
        penaltiesTeamB = penaltiesTeamB + 1;
        displaypenaltiesTeamB(penaltiesTeamB);
        goalsTeamB = goalsTeamB + 1;
        displaygoalTeamB(goalsTeamB);
    }

    /**
     * reset to 0
     */
    public void resetbutton(View v) {
        goalsTeamA = goalsTeamB = penaltiesTeamA = penaltiesTeamB = 0;
        displaygoalTeamA(goalsTeamA);
        displaygoalTeamB(goalsTeamB);
        displaypenaltiesTeamA(penaltiesTeamA);
        displaypenaltiesTeamB(penaltiesTeamB);

    }


}
