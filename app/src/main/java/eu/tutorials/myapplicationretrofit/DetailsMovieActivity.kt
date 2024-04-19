package eu.tutorials.myapplicationretrofit

import ApiClient
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import coil.load
import coil.size.Scale
import eu.tutorials.myapplicationretrofit.adapter.DetailsMovieResponse
import eu.tutorials.myapplicationretrofit.api.Api
import eu.tutorials.myapplicationretrofit.databinding.ActivityDetailsMovieBinding
import eu.tutorials.myapplicationretrofit.utils.Constants.POSTER_BASEURL
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsMovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsMovieBinding
    private val api : Api by lazy {
        ApiClient().getClient().create(Api::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailsMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val movieId = intent.getIntExtra("id", 1)
        binding.apply{
            val callDetailsMovieApi = api.getMoviedetails(movieId)
            callDetailsMovieApi.enqueue(object : Callback<DetailsMovieResponse>{
                override fun onResponse(
                    call: Call<DetailsMovieResponse>,
                    response: Response<DetailsMovieResponse>
                ) {
                    when(response.code()){
                        in 200..299 -> {
                            response.body().let{itBody->
                                val imagePoster =POSTER_BASEURL + itBody!!.poster_path
                                moviePoster.load(imagePoster){
                                    crossfade(true)
                                    placeholder(R.drawable.placeholder)
                                    scale(Scale.FILL)
                                }
                                backgroundImage.load(imagePoster){
                                    crossfade(true)
                                    placeholder(R.drawable.placeholder)
                                    scale(Scale.FILL)
                                }
                                movieName.text=itBody.title
                                tagline.text=itBody.tagline
                                releaseDate.text=itBody.release_date
                                rating.text=itBody.vote_average.toString()
                                runtime.text=itBody.runtime.toString()
                                overview.text=itBody.overview



                            }
                        }
                        in 300..399 ->{
                            Log.d("Response Code", "Redirection Messages : ${response.code()}")
                        }
                        in 400..499 ->{
                            Log.d("Response Code", "Client error responses : ${response.code()}")
                        }
                        in 500..599  ->{
                            Log.d("Response Code", "Server error responses : ${response.code()}")
                        }

                    }
                }

                override fun onFailure(call: Call<DetailsMovieResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })


        }
    }
}