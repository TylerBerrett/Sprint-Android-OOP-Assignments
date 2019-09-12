package com.example.pokemonsprint.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokemonsprint.*
import com.example.pokemonsprint.databinding.ActivityMainBinding
import com.example.pokemonsprint.model.PassPokemon
import com.example.pokemonsprint.model.Pokemon
import com.example.pokemonsprint.viewmodel.ViewModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), Callback<Pokemon> {
    companion object{
        var PokemonNameNumber = ""
        val POKEMON_INTENT_KEY = "treecko"
        val POKEMON_EDIT = "nice"
        var pokemonViewModel: PassPokemon? = null
    }

    override fun onFailure(call: Call<Pokemon>, t: Throwable) {
        println(t)
        Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show()
    }

    override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
        if (response.isSuccessful){

            val pokemon = response.body() as Pokemon

            val pokemonAbility = ArrayList<String>()
            pokemon.abilities.forEach {
                pokemonAbility.add(it.ability.name)
            }

            val pokemonType = ArrayList<String>()
            pokemon.types.forEach{
                pokemonType.add(it.type.name)
            }

            val passPokemon = PassPokemon(
                pokemon.name,
                pokemon.sprites.front_default,
                pokemon.id,
                pokemonAbility,
                pokemonType
            )

            val intent = Intent(this, PokemonAbout::class.java)
            pokemonViewModel = passPokemon
            intent.putExtra(POKEMON_INTENT_KEY, passPokemon)
            startActivity(intent)
        } else {
            print(response)
            Toast.makeText(this, "Please enter a valid id or name", Toast.LENGTH_LONG).show()
        }
    }

    val callback: Callback<Pokemon> = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        activityMainBinding.viewModel = ViewModel(this)
        activityMainBinding.executePendingBindings()

        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = PokemonRecycler(PokemonAbout.pokemonList)



        search_bar.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                PokemonNameNumber = search_bar.query.toString()
                PokemonObject.getPokemon().enqueue(callback)
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return true
            }


        })
    }


}
