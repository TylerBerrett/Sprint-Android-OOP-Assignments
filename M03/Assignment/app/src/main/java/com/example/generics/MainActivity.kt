package com.example.generics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class MainActivity : AppCompatActivity(), Callback<Movies> {
    override fun onFailure(call: Call<Movies>, t: Throwable) {

    }

    override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
        if (response.isSuccessful) { println(response.body()) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Task 1
        val mutableList = mutableListOf<String>()
        //The integer literal does not conform to the expected type String
        //mutableList.add(0, 1)

        //Task 2
        class human(isHuman: Boolean)
        //The integer literal does not conform to the expected type Boolean
        //human(3)

        //Task 3
        fun lizard(numberOfScales: Double){}
        //Type mismatch: inferred type is String but Double was expected
        //lizard("234.3")

        FakeApi.fakeMovieCall.enqueue(this)


    }

    //Task 4
    class myFavoriteNumber {
        companion object{
            fun favoriteNumber(): Int{
                return 12
            }
        }

    }

    //Task 5
    class taskFive<T>
    open class CellularService
    //class Phone<T: CellularService>

    //Task 6
    class Sprint: CellularService()
    class Verizon: CellularService()
    class Phone<S: Sprint, V: Verizon>

    //Task 7
    val intObservable = Observable.just(1,2, 3)
    //intObservable.subscribe { println(it) }

    //Task 8
    data class Actor(val actor: String)
    val ryanReynolds = Actor("Ryan Reynolds")
    val hughJackman = Actor("Hugh Jackman")

    val actorObservable = Observable.just(ryanReynolds, hughJackman)
    //actorObservable.subscribe { println(it) }






}
