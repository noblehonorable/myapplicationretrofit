package eu.tutorials.myapplicationretrofit

import ApiClient
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import eu.tutorials.myapplicationretrofit.adapter.MovieAdapter
import eu.tutorials.myapplicationretrofit.api.Api
import eu.tutorials.myapplicationretrofit.databinding.ActivityMainBinding
import eu.tutorials.myapplicationretrofit.response.MovieListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val movieAdapter by lazy { MovieAdapter() }
    private val api: Api by lazy {
        ApiClient().getClient().create(Api::class.java)
    }
    private lateinit var imageSlider: ImageSlider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve reference to ImageSlider
        imageSlider = binding.imageSlider

        initImageList()

        binding.apply {
            prgbarmovie.visibility = View.VISIBLE

            val callMovieApi = api.getPopularMovie(1)
            callMovieApi.enqueue(object : Callback<MovieListResponse> {
                override fun onResponse(
                    call: Call<MovieListResponse>,
                    response: Response<MovieListResponse>

                ) {
                    prgbarmovie.visibility = View.INVISIBLE
                    when (response.code()) {
                        // Success
                        in 200..299 -> {
                            response.body()?.let { itBody ->
                                itBody.results?.let { itData ->
                                    if (itData.isNotEmpty()) {
                                        movieAdapter.differ.submitList(itData)
                                        rvMovie.apply {
                                            layoutManager =
                                                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
                                            adapter = movieAdapter
                                        }
                                    }
                                }
                            }
                        }
                        // Redirection
                        in 300..399 -> {
                            Log.d(
                                "Response Code",
                                "Redirection messages : ${response.code()}"
                            )
                        }
                        // Client error
                        in 400..499 -> {
                            Log.d(
                                "Response Code",
                                "Redirection messages : ${response.code()}"
                            )
                        }
                        // Service error
                        in 500..599 -> {
                            Log.d(
                                "Response Code",
                                "Redirection messages : ${response.code()}"
                            )
                        }
                    }
                }

                override fun onFailure(call: Call<MovieListResponse>, t: Throwable) {
                    binding.prgbarmovie.visibility = View.GONE
                    Log.e("onFailure", "Err : ${t.message}")
                }
            })

            // Bottom navigation buttons
            button1.setOnClickListener {

            }

            button2.setOnClickListener {
                // Start VideoActivity
                startActivity(Intent(this@MainActivity, VideoActivity::class.java))
            }

            button3.setOnClickListener({
                startActivity(Intent(this@MainActivity, MusicActivity::class.java))
            })

        }
    }

    private fun initImageList() {
        val imageList = arrayListOf<SlideModel>()
        imageList.add(SlideModel("https://cdn.theplaylist.net/wp-content/uploads/2023/05/03103744/Dune-part-Two-.jpg"))
        imageList.add(SlideModel("https://www.electricpalace.org.uk/wp-content/uploads/2024/03/kung-fu-panda-4-pg-2024-94-mins-1090x625.jpg"))
        imageList.add(SlideModel("https://occ-0-2794-2219.1.nflxso.net/dnm/api/v6/Qs00mKCpRvrkl3HZAN5KwEL1kpE/AAAABVXORjt_HAUCPaIyZSnUWnhXREn5vDjZlDsO3KSSd_m6GUzKsERFWMGmlZpbp1lj7QgsNAjqFps5zgEt6uOpWICy0hKeJim_sUq4.jpg?r=09c"))
        imageList.add(SlideModel("https://phantom-marca.unidadeditorial.es/4be0c0ff0fbca59dd8627f1ceec69949/resize/414/f/jpg/assets/multimedia/imagenes/2021/08/10/16286161657414.jpg"))

        // Set imageList to ImageSlider
        imageSlider.setImageList(imageList)
    }
}
