package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class Win(dialog: MainActivity) :AppCompatActivity(){
    lateinit var message:String
    lateinit var mainActivity:MainActivity
    public fun Winp(context: Context, message: String, mainActivity: MainActivity) {
            this.message=message
            this.mainActivity=mainActivity

        }
    private lateinit var messageText:TextView
    private lateinit var startAgainButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.win_layout)
        messageText=findViewById(R.id.message_text)
        startAgainButton=findViewById(R.id.start_again_button)
        messageText.text=messageText.toString()
        startAgainButton.setOnClickListener{
            fun onClick(view : View){
                mainActivity.restart()

            }
        }
    }

    fun show(n:Any): Any {
        return n
    }


}

