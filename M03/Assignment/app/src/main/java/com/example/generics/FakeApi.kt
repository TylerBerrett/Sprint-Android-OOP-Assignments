package com.example.generics

import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//Task 8

data class Movies(
    val releaseYear: Int,
    val title: String,
    val rating: Double,
    val isGoodMove: Boolean
)

val batman = Movies(1, "batman", 10.0, true)
val batman2 = Movies(2, "batman2", 10.1, true)
val batman3 = Movies(3, "batman3", 10.0, true)
val batman4 = Movies(4, "batman4", 10.0, false)

val myMovies = listOf<Movies>(batman, batman2, batman3, batman4)
object FakeApi{
    val fakeMovieCall = object : Call<Movies> {
        override fun enqueue(callback: Callback<Movies>) {
            myMovies.forEach{
                val response = Response.success(it)
                callback.onResponse(this, response)
            }

        }

        override fun isExecuted(): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun clone(): Call<Movies> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun isCanceled(): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun cancel() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun execute(): Response<Movies> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun request(): Request {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }
}