package com.example.cs2340a.dungenCrawler.viewModel;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.cs2340a.R;
import com.example.cs2340a.dungenCrawler.model.GameConfig;
import com.example.cs2340a.dungenCrawler.model.Background;
import com.example.cs2340a.dungenCrawler.model.DifficultyEnum;
import com.example.cs2340a.dungenCrawler.model.Room;
import com.example.cs2340a.dungenCrawler.model.RoomOne;

public class InitialConfigViewModel extends AppCompatActivity {

    private int avatar; //del when working

    // make a BASE class in ViewModel that references everything

    //viewModel elements
    private EditText playerNameInput;
    private RadioGroup difficultyRadioGroup;
    private RadioGroup characterRadioGroup;
    private Button exitbtn;
    private Button startGameButton;
    //private GameConfig gameConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_config_activty);
        System.out.println("in initialConfig onCreate");

        //viewModel elements
        playerNameInput = (EditText) findViewById(R.id.playerNameInput_id); //for gathering
        // playerName
        difficultyRadioGroup = findViewById(R.id.difficultyRadioGroup_id); //Radio button for
        // difficulty
        characterRadioGroup = findViewById(R.id.characterSelectRadioGroup_id); //Radio button for
        // CharSprite
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

            ///  1   gathering entered player name
            String playerName = playerNameInput.getText().toString();

            ///  2   gathering difficulty selection
            double difficulty = 1.0; //default value = 1.0
            DifficultyEnum difficultyE = DifficultyEnum.EASY;
            //temp object to hold chosen difficulty
            switch (difficultyRadioGroup.getCheckedRadioButtonId()) {
            case R.id.radioMedium_id:
                difficultyE = DifficultyEnum.MEDIUM;
                difficulty = 0.75;
                break;
            case R.id.radioHard_id:
                difficultyE = DifficultyEnum.HARD;
                difficulty = 0.5;
                break;
            default: //case R.id.radioEasy_id
                difficultyE = DifficultyEnum.EASY;
                difficulty = 1.0;
                break;
            }
            //health points
            //int hp = (int) (100 * difficulty);


            ///  3   gathering Character Sprite selection
            avatar = 1;
            switch (characterRadioGroup.getCheckedRadioButtonId()) {
            case R.id.character2:
                avatar = R.drawable.player2;
                break;
            case R.id.character3:
                avatar = R.drawable.player3;
                break;
            default: //case R.id.character1
                avatar = R.drawable.player1;
                break;
            }

            ///  4   Determine current room based on selected difficulty
            // ******* not yet done. leave for a later sprint | commented during Sprint2
            //          for now currentRoomId is set to 1     | commented during Sprint2


            //check if player name is valid and if sprite selected
            if (checkAllFields(playerName)) {
                //create Player and GameConfig objects with entered data
                Point point = new Point();
                getWindowManager().getDefaultDisplay().getSize(point);



                // Set all valid information in GameConfigTest Static Class

                //  set resource - Bitmap source
                GameConfig.setRes(getResources());
                //  set chosen difficulty > and creates proper EnemyFactor
                GameConfig.setDifficulty(difficultyE);
                //  set chosen avatar
                GameConfig.setAvatar(avatar);
                //  call createPlayer to create singleton instance of player in GameConfigTest
                GameConfig.createPlayer(playerName, point.x, point.y, getResources());
                //create a Background > then pass it to GameConfigTest
                Background bg = new Background(point, getResources(), R.drawable.room1);
                GameConfig.setBackground(bg);

                //create room 1 > pass it to GameConfigTest for currRoom
                Room room = new RoomOne(1200, 540,  bg, 1);
                GameConfig.setCurrRoom(room);

                //use switchEnemies() to set the first two enemies for room1
                GameConfig.switchEnemies(0);
                GameConfig.switchPowerUps(0);

                //switching screens/activities to the GameRoom1ViewModel
                Intent game = new Intent(InitialConfigViewModel.this, GameRoom1ViewModel.class);

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
        return characterRadioGroup.getCheckedRadioButtonId() != 0;
    }

    private boolean checkDifficultyPicked() {
        RadioGroup difficultyRadioGroup = findViewById(R.id.difficultyRadioGroup_id);
        return difficultyRadioGroup.getCheckedRadioButtonId() != 0;
    }


}