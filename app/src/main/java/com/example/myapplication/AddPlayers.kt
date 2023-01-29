package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class AddPlayers : AppCompatActivity() {

    private lateinit var player_1:EditText
    private lateinit var player_2:EditText
    private lateinit var start_game_button:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_players)
        player_1=findViewById(R.id.player_1)
        player_2=findViewById(R.id.player_2)
        start_game_button=findViewById(R.id.start_game_button)

        start_game_button.setOnClickListener {
            @Override
            fun onClick(view: View){
                var getname_1=player_1.text.toString()
                var getname_2=player_2.text.toString()

                if(getname_1.isEmpty() || getname_2.isEmpty()){
                    Toast.makeText(this,"Please enter name", Toast.LENGTH_SHORT).show()
                }
                else{
                    intent= Intent(this,MainActivity::class.java)
                    intent.putExtra("player_1",getname_1)
                    intent.putExtra("player_2",getname_2)
                    startActivity(intent)
                }
            }
        }

    }



}