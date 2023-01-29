package com.example.myapplication

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var player_1_name: TextView
    private lateinit var player_2_name: TextView
    private lateinit var player_1_layout_layout: LinearLayout
    private lateinit var player_2_layout_layout: LinearLayout
    private lateinit var image_1:ImageView
    private lateinit var image_2:ImageView
    private lateinit var image_3:ImageView
    private lateinit var image_4:ImageView
    private lateinit var image_5:ImageView
    private lateinit var image_6:ImageView
    private lateinit var image_7:ImageView
    private lateinit var image_8:ImageView
    private lateinit var image_9:ImageView
    var list_collect = arrayOf(intArrayOf(0, 1, 2), intArrayOf(3, 4, 5),intArrayOf(6, 7, 8), intArrayOf(0, 3, 6), intArrayOf(1, 4, 7), intArrayOf(2, 5, 8), intArrayOf(2, 4, 6), intArrayOf(0, 4, 8))

    //var list_collect=ArrayList<Int>()
    var boxPositions_list= arrayListOf<Int>(0,0,0,0,0,0,0,0,0)
    var turn_play=1
    var totalSelectedBoxes=1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        player_1_name=findViewById(R.id.player_1_name)
        player_2_name=findViewById(R.id.player_2_name)
        player_1_layout_layout=findViewById(R.id.player_1_layout_layout)
        player_2_layout_layout=findViewById(R.id.player_2_layout_layout)
        image_1=findViewById(R.id.image_1)
        image_2=findViewById(R.id.image_2)
        image_3=findViewById(R.id.image_3)
        image_4=findViewById(R.id.image_4)
        image_5=findViewById(R.id.image_5)
        image_6=findViewById(R.id.image_6)
        image_7=findViewById(R.id.image_7)
        image_8=findViewById(R.id.image_8)
        image_9=findViewById(R.id.image_9)


        var getPlayer_1_name=intent.getStringArrayExtra("player_1")
        var getPlayer_2_name=intent.getStringArrayExtra("player_2")

        player_1_name.text=getPlayer_1_name.toString()
        player_2_name.text=getPlayer_2_name.toString()


        image_1.setOnClickListener {
            @Override
            fun onClick(view: View){
                if(isBoxSelected(0)){
                    perfromAction(view as ImageView,0)
                }
            }
        }
        image_2.setOnClickListener {
            @Override
            fun onClick(view: View){
                if(isBoxSelected(1)){
                    perfromAction(view as ImageView,1)
                }

            }
        }
        image_3.setOnClickListener {
            @Override
            fun onClick(view: View){
                if(isBoxSelected(2)){
                    perfromAction(view as ImageView,2)
                }
            }
        }
        image_4.setOnClickListener {
            @Override
            fun onClick(view: View){
                if(isBoxSelected(3)){
                    perfromAction(view as ImageView,3)
                }
            }
        }
        image_5.setOnClickListener {
            @Override
            fun onClick(view: View){
                if(isBoxSelected(4)){
                    perfromAction(view as ImageView,4)
                }
            }
        }
        image_6.setOnClickListener {
            @Override
            fun onClick(view: View){
                if(isBoxSelected(5)){
                    perfromAction(view as ImageView,5)
                }
            }
        }
        image_7.setOnClickListener {
            @Override
            fun onClick(view: View){
                if(isBoxSelected(6)){
                    perfromAction(view as ImageView,6)
                }
            }
        }
        image_8.setOnClickListener {
            @Override
            fun onClick(view: View){
                if(isBoxSelected(7)){
                    perfromAction(view as ImageView,7)
                }
            }
        }
        image_9.setOnClickListener {
            @Override
            fun onClick(view: View){
                if(isBoxSelected(8)){
                    perfromAction(view as ImageView,8)
                }
            }
        }




    }

    private fun perfromAction(imageView: ImageView, selectedBoxPosition:Int){
        boxPositions_list[selectedBoxPosition]=turn_play

        if(turn_play==1){
            imageView.setImageResource(R.drawable.x)
            if (CheckPlayer_Win()){
               /* var win_dialog=win_C.Winp(this, player_1_name.text.toString()+" has won the match", this)
                win_C.show(win_dialog)*/
                val builder: AlertDialog.Builder = AlertDialog.Builder(this@MainActivity)
                builder.setMessage(player_1_name.text.toString()+" has won the match")
                builder.setCancelable(false)
                builder.show()
            }
            else if(totalSelectedBoxes==9){
                val builder: AlertDialog.Builder = AlertDialog.Builder(this@MainActivity)
                builder.setMessage("It is a draw!")
                builder.setCancelable(false)
                builder.show()
            }
            else{
                changePlayerTurn(2)
                totalSelectedBoxes++
            }
        }
        else{
            imageView.setImageResource(R.drawable.o)
            if(CheckPlayer_Win()){
                val builder: AlertDialog.Builder = AlertDialog.Builder(this@MainActivity)
                builder.setMessage(player_2_name.text.toString()+" has won the match")
                builder.setCancelable(false)
                builder.show()
            }
            else if(selectedBoxPosition==9){
                val builder: AlertDialog.Builder = AlertDialog.Builder(this@MainActivity)
                builder.setMessage("It is a draw!")
                builder.setCancelable(false)
                builder.show()
            }
            else{
                changePlayerTurn(1)
                totalSelectedBoxes++
            }
        }
    }



    private fun changePlayerTurn(currentPLayerTurn:Int){
        turn_play=currentPLayerTurn
        if(turn_play==1 ){
            player_1_layout_layout.setBackgroundColor(R.drawable.round_border)
            player_2_layout_layout.setBackgroundColor(R.drawable.round)
        }
        else{
            player_2_layout_layout.setBackgroundColor(R.drawable.round_border)
            player_1_layout_layout.setBackgroundColor(R.drawable.round)
        }
    }

    private fun CheckPlayer_Win():Boolean{
        var responce = false
        for(i in 0 ..  list_collect.size-1){
            var combination=list_collect.get(i)
            if(boxPositions_list[combination[0]]==turn_play && boxPositions_list[combination[1]]==turn_play && boxPositions_list[combination[2]]==turn_play){
                responce=true
            }
        }
        return responce
    }
    private fun isBoxSelected(boxPosition:Int):Boolean{
        var response:Boolean=false


        if(boxPositions_list[boxPosition]==0){
            response=true
        }
        return response
    }

    public fun restart(){
        boxPositions_list= arrayListOf<Int>(0,0,0,0,0,0,0,0,0)
        turn_play=1
        totalSelectedBoxes=1
        image_1.setImageResource(R.drawable.white_img)
        image_2.setImageResource(R.drawable.white_img)
        image_3.setImageResource(R.drawable.white_img)
        image_4.setImageResource(R.drawable.white_img)
        image_5.setImageResource(R.drawable.white_img)
        image_6.setImageResource(R.drawable.white_img)
        image_7.setImageResource(R.drawable.white_img)
        image_8.setImageResource(R.drawable.white_img)
        image_9.setImageResource(R.drawable.white_img)
    }
}


