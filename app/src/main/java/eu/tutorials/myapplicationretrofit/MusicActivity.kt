package eu.tutorials.myapplicationretrofit

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import eu.tutorials.myapplicationretrofit.R

class MusicActivity : AppCompatActivity() {
    private lateinit var cardImg: ImageView
    private lateinit var music: MediaPlayer
    private lateinit var set: AnimatorSet
    private lateinit var playBtn: ImageView
    private var isPlaying = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music)

        cardImg = findViewById<ImageView>(R.id.cardimg)
        playBtn = findViewById<ImageView>(R.id.playbtn)

        val test1 = ObjectAnimator.ofFloat(cardImg, "rotation", 0f, 360f).setDuration(5000)
        val test2 = ObjectAnimator.ofFloat(cardImg, "rotation", 1f, 2f).setDuration(5000)

        set = AnimatorSet()
        set.playSequentially(test1, test2)


        playBtn.setOnClickListener { playMusic() }
    }

    private fun playMusic() {
        if (!isPlaying) {
            music.start()
            set.start()
            playBtn.setImageResource(R.drawable.pausebtn)
            isPlaying = true
        } else {
            music.pause()
            set.pause()
            playBtn.setImageResource(R.drawable.playbtn)
            isPlaying = false
        }
    }
}
