package eu.tutorials.myapplicationretrofit.api

import eu.tutorials.myapplicationretrofit.adapter.DetailsMovieResponse
import retrofit2.Call
import eu.tutorials.myapplicationretrofit.response.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("movie/popular")
    fun getPopularMovie(@Query("page") page: Int): Call<MovieListResponse>

    @GET("movie/{movie_id}")
    fun getMoviedetails(@Path("movie_id") id:Int): Call<DetailsMovieResponse>



}
