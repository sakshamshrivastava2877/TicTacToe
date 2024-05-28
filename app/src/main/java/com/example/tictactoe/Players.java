package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Players extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);

        EditText userone = findViewById(R.id.playerOne);
        EditText usertwo = findViewById(R.id.playerTwo);
        Button gamestartbtn = findViewById(R.id.startGameButton);

        gamestartbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String getUserone = userone.getText().toString();
                String getUsertwo = usertwo.getText().toString();

                if (getUserone.isEmpty() || getUsertwo.isEmpty()) {
                    Toast.makeText(Players.this, "Please enter player name", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(Players.this, MainActivity.class);
                    intent.putExtra("userone", getUserone);
                    intent.putExtra("usertwo", getUsertwo);
                    startActivity(intent);
                }
            }
        });

    }
}