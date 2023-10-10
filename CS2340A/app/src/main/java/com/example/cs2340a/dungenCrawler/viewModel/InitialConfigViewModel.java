package com.example.cs2340a.dungenCrawler.viewModel;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.cs2340a.R;
import com.example.cs2340a.dungenCrawler.model.CharSprite;
import com.example.cs2340a.dungenCrawler.model.GameConfig;
import com.example.cs2340a.dungenCrawler.model.Player;

public class InitialConfigViewModel extends AppCompatActivity {

    private int avatar; //del when working

    //viewModel elements
    private EditText playerNameInput;
    private RadioGroup difficultyRadioGroup;
    private RadioGroup characterRadioGroup;
    private Button exitbtn;
    private Button startGameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_config_activty);

        //viewModel elements
        playerNameInput = (EditText) findViewById(R.id.playerNameInput_id); //for gathering playerName
        difficultyRadioGroup = findViewById(R.id.difficultyRadioGroup_id); //Radio button for difficulty
        characterRadioGroup = findViewById(R.id.characterSelectRadioGroup_id); //Radio button for CharSprite
        exitbtn = (Button) findViewById(R.id.exitbtn); //exit btn
        startGameButton = (Button) findViewById(R.id.startGameButton_id); //startGame btn

        //exit button functionality
        //Button exitbtn = (Button) findViewById(R.id.exitbtn);
        exitbtn.setOnClickListener(v -> {
            Intent exit = new Intent(Intent.ACTION_MAIN);
            exit.addCategory(Intent.CATEGORY_HOME);
            exit.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(exit);
        });

        startGameButton.setOnClickListener(v -> {

            //gather data entered.  1.playerName  2.difficulty  3.characterSprite  4.currentRoom

            //  1   gathering entered player name
            String playerName = playerNameInput.getText().toString();

            ///  2   gathering difficulty selection
            double difficulty = 1.0; //default value = 1.0
            switch (difficultyRadioGroup.getCheckedRadioButtonId()) {
            case R.id.radioEasy_id:
                difficulty = 1.0;
                break;
            case R.id.radioMedium_id:
                difficulty = 0.75;
                break;
            case R.id.radioHard_id:
                difficulty = 0.5;
                break;
            default:
                difficulty = 1.0;
                break;
            }
            //health points
            int hp = (int) (100 * difficulty);



            /*      ****** NEW WAY THAT ISNT WORKING YET *********
            //  3   gathering Character Sprite selection (i.create object  ii.assign value)
            //      i   Create CharSprite object
            CharSprite avatar = new CharSprite(R.drawable.player1, "Char1"); //default Sprite is
            // Char1, player1.png

            //      ii   Assign CharSprite object Resource Id and Sprite Name, based on selected sprite
            switch (characterRadioGroup.getCheckedRadioButtonId()) {
            case R.id.character1:
                avatar.setSpriteResId(R.drawable.player1);
                avatar.setSpriteName("Char1");
                break;
            case R.id.character2:
                avatar.setSpriteResId(R.drawable.player2);
                avatar.setSpriteName("Char2");
                break;
            case R.id.character3:
                avatar.setSpriteResId(R.drawable.player3);
                avatar.setSpriteName("Char3");
                break;
            }
            */
            //the next line is still part of the old way, but
            CharSprite avAtar = new CharSprite(R.drawable.player1, "Char1");

            //****** OLD WAY ********
            //  3   gathering Character Sprite selection
            avatar = 1;
            switch (characterRadioGroup.getCheckedRadioButtonId()) {
            case R.id.character1:
                avatar = 1;
                break;
            case R.id.character2:
                avatar = 2;
                break;
            case R.id.character3:
                avatar = 3;
                break;
            default:
                avatar = 1;
                break;
            }

            //  4   Determine current room based on selected difficulty
            // ******* not yet done. leave for a later sprint | commented during Sprint2
            //          for now currentRoomId is set to 1     | commented during Sprint2


            //check if player name is valid and if sprite selected
            if (checkAllFields(playerName)) {
                //create Player and GameConfig objects with entered data
                Player player = new Player(playerName, avAtar, 1, difficulty, hp);
                GameConfig gameConfig = new GameConfig(playerName, difficulty, avAtar, 1);

                Intent game = new Intent(InitialConfigViewModel.this, GameRoom1ViewModel.class);
                // next line is the Old way to pass avatar, but I can't git it to work
                game.putExtra("avatar", avatar);

                //pass Player and GameConfig objects (using Parcable)
                game.putExtra("player", player);
                game.putExtra("gameConfig", gameConfig);
                startActivity(game);
            }
        });
    }

    private boolean checkAllFields(String playerName) {
        return (checkPlayerName(playerName) && checkCharPicked() && checkDifficultyPicked());
    }

    private boolean checkPlayerName(String playerName) {
        if (playerName == null || playerName.trim().isEmpty()) {
            playerNameInput.setError("Must input a player name.");
            return false;
        }
        return true;
    }

    private boolean checkCharPicked() {
        RadioGroup characterRadioGroup = findViewById(R.id.characterSelectRadioGroup_id);
        if (characterRadioGroup.getCheckedRadioButtonId() == 0) {
            return false;
        }
        return true;
    }

    private boolean checkDifficultyPicked() {
        RadioGroup difficultyRadioGroup = findViewById(R.id.difficultyRadioGroup_id);
        if (difficultyRadioGroup.getCheckedRadioButtonId() == 0) {
            return false;
        }
        return true;
    }


}