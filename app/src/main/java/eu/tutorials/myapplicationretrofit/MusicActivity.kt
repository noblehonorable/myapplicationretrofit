package eu.tutorials.myapplicationretrofit

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import eu.tutorials.myapplicationretrofit.R
import eu.tutorials.myapplicationretrofit.adapter.MusicAdapter
import eu.tutorials.myapplicationretrofit.api.MusicInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MusicActivity : AppCompatActivity() {

    lateinit var myRecyclerView: RecyclerView
    lateinit var musicAdapter: MusicAdapter
    lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music)

        myRecyclerView = findViewById(R.id.recyclerview)
        progressBar = findViewById(R.id.prgbarmusic)

        // Show progress bar
        progressBar.visibility = View.VISIBLE

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://deezerdevs-deezer.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MusicInterface::class.java)

        val retrofitData = retrofitBuilder.getData("Hans Zimmer")

        retrofitData.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                val dataList = response.body()?.data!!
                musicAdapter = MusicAdapter(this@MusicActivity, dataList)
                myRecyclerView.adapter = musicAdapter
                myRecyclerView.layoutManager = LinearLayoutManager(this@MusicActivity)
                // Hide progress bar
                progressBar.visibility = View.INVISIBLE
                Log.d("TAG: onResponse", "onResponse: " + response.body())
            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                // Hide progress bar in case of failure
                progressBar.visibility = View.INVISIBLE
                Log.d("TAG: onFailure", "onFailure" + t.message)
            }
        })
    }
}
