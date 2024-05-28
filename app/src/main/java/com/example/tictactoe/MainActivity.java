package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.tictactoe.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private final List<int[]> combination = new ArrayList<>();
    private int[] Positions = {0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0};
    private int activePlayer = 1;
    private int totalBoxes = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        combination.add(new int[] {0,1,2});
        combination.add(new int[] {3,4,5});
        combination.add(new int[] {6,7,8});
        combination.add(new int[] {0,3,6});
        combination.add(new int[] {1,4,7});
        combination.add(new int[] {2,5,8});
        combination.add(new int[] {2,4,6});
        combination.add(new int[] {0,4,8});

        String getPlayerOneName = getIntent().getStringExtra("userone");
        String getPlayerTwoName = getIntent().getStringExtra("usertwo");

        binding.playerOneName.setText(getPlayerOneName);
        binding.playerTwoName.setText(getPlayerTwoName);

        binding.image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selected_Box(0)){
                    performAction((ImageView) view, 0);
                }
            }
        });

        binding.image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selected_Box(1)){
                    performAction((ImageView) view, 1);
                }
            }
        });
        binding.image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selected_Box(2)){
                    performAction((ImageView) view, 2);
                }
            }
        });
        binding.image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selected_Box(3)){
                    performAction((ImageView) view, 3);
                }
            }
        });
        binding.image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selected_Box(4)){
                    performAction((ImageView) view, 4);
                }
            }
        });
        binding.image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selected_Box(5)){
                    performAction((ImageView) view, 5);
                }
            }
        });
        binding.image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selected_Box(6)){
                    performAction((ImageView) view, 6);
                }
            }
        });
        binding.image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selected_Box(7)){
                    performAction((ImageView) view, 7);
                }
            }
        });
        binding.image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selected_Box(8)){
                    performAction((ImageView) view, 8);
                }
            }
        });

    }

    private void performAction(ImageView  imageView, int selectedBoxPosition) {
        Positions[selectedBoxPosition] = activePlayer;

        if (activePlayer == 1) {
            imageView.setImageResource(R.drawable.ximage);
            if (result_Validation()) {
                Popup_dialog resultDialog = new Popup_dialog(MainActivity.this, binding.playerOneName.getText().toString()
                + " WINS THE GAME!", MainActivity.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            } else if(totalBoxes == 9) {
                Popup_dialog popupdialog = new Popup_dialog(MainActivity.this, "Match Draw", MainActivity.this);
                popupdialog.setCancelable(false);
                popupdialog.show();
            } else {
                changeTurn(2);
                totalBoxes++;
            }
        } else {
            imageView.setImageResource(R.drawable.oimage);
            if (result_Validation()) {
                Popup_dialog popupdialog = new Popup_dialog(MainActivity.this, binding.playerTwoName.getText().toString()
                        + " WINS THE GAME!", MainActivity.this);
                popupdialog.setCancelable(false);
                popupdialog.show();
            } else if(totalBoxes == 9) {
                Popup_dialog popupdialog = new Popup_dialog(MainActivity.this, "Match Draw", MainActivity.this);
                popupdialog.setCancelable(false);
                popupdialog.show();
            } else {
                changeTurn(1);
                totalBoxes++;
            }
        }
    }

    private void changeTurn(int currentPlayerTurn) {
        activePlayer = currentPlayerTurn;
        if (activePlayer == 1) {
            binding.playerOneLayout.setBackgroundResource(R.drawable.light_blue);
            binding.playerTwoLayout.setBackgroundResource(R.drawable.white_box);
        } else {
            binding.playerTwoLayout.setBackgroundResource(R.drawable.light_blue);
            binding.playerOneLayout.setBackgroundResource(R.drawable.white_box);
        }
    }

    private boolean result_Validation(){
        boolean response = false;
        for (int i = 0; i < combination.size(); i++){
            final int[] combination = this.combination.get(i);

            if (Positions[combination[0]] == activePlayer && Positions[combination[1]] == activePlayer &&
            Positions[combination[2]] == activePlayer) {
                response = true;
            }
        }
        return response;
    }

    private boolean selected_Box(int boxPosition) {
        boolean response = false;
        if (Positions[boxPosition] == 0) {
            response = true;
        }
        return response;
    }

    public void reset_game(){
        Positions = new int[] {0,0,0,0,0,0,0,0,0};
        activePlayer = 1;
        totalBoxes = 1;

        binding.image1.setImageResource(R.drawable.white_box);
        binding.image2.setImageResource(R.drawable.white_box);
        binding.image3.setImageResource(R.drawable.white_box);
        binding.image4.setImageResource(R.drawable.white_box);
        binding.image5.setImageResource(R.drawable.white_box);
        binding.image6.setImageResource(R.drawable.white_box);
        binding.image7.setImageResource(R.drawable.white_box);
        binding.image8.setImageResource(R.drawable.white_box);
        binding.image9.setImageResource(R.drawable.white_box);
    }
}