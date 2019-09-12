package com.example.pokemonsprint.viewmodel

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.pokemonsprint.PokemonObject
import com.example.pokemonsprint.model.PassPokemon
import com.example.pokemonsprint.model.Pokemon
import com.example.pokemonsprint.view.MainActivity
import com.example.pokemonsprint.view.PokemonAbout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModel(context: Context): BaseObservable(), Callback<Pokemon>{
    val context = context


    override fun onFailure(call: Call<Pokemon>, t: Throwable) {
        println("fail")}

    override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
        if (response.isSuccessful){
            println(response.body()?.name + "nice")

        } else { print(response) }
    }

    // I have to use MainActivity.pokemonViewModel because I am not adding the main
    // activity to this file so I can get the pokemon class from the enqueue

    fun addPokemonButton(){
        PokemonAbout.pokemonList.add(MainActivity.pokemonViewModel!!)
        println(MainActivity.pokemonViewModel)
        startActivity(context, Intent(context, MainActivity::class.java), null)
    }

    @Bindable
    fun getPokemonName(): String?{
        return MainActivity.pokemonViewModel?.name
    }

    @Bindable
    fun getPokemonId(): String?{
        val id = MainActivity.pokemonViewModel?.id.toString()
        return "Pokedex Location: $id"
    }



}