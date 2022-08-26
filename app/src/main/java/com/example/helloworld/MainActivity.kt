package com.example.helloworld

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var play=findViewById<Button>(R.id.play)
        play.setText("Play")
        var stop=findViewById<Button>(R.id.stop)
        stop.setText("Stop")
        var mp=MediaPlayer()
        play.setOnClickListener {
            mp.setDataSource(this, Uri.parse("android.resource://"+this.packageName+"/"+R.raw.didi))
            mp.prepare()
            mp.start()
        }

        stop.setOnClickListener {
            mp.stop()
            mp.release()
            mp=MediaPlayer()
        }

        val button: Button = findViewById(R.id.mongol)
        button.setOnClickListener {
            val intent = Intent(this, mongolPeach::class.java)
            startActivity(intent)
        }

    }

}