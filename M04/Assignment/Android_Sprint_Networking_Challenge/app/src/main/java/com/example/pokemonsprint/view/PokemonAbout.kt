package com.example.pokemonsprint.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.pokemonsprint.model.PassPokemon
import com.example.pokemonsprint.R
import com.example.pokemonsprint.databinding.ActivityMainBinding
import com.example.pokemonsprint.databinding.ActivityPokemonAboutBinding
import com.example.pokemonsprint.model.Pokemon
import com.example.pokemonsprint.viewmodel.ViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_pokemon_about.*

class PokemonAbout : AppCompatActivity() {

    companion object {
        val pokemonList = ArrayList<PassPokemon>()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding = DataBindingUtil.setContentView<ActivityPokemonAboutBinding>(this, R.layout.activity_pokemon_about)
        activityMainBinding.viewModel = ViewModel(this)
        activityMainBinding.executePendingBindings()



        val pokemon = intent.getSerializableExtra(MainActivity.POKEMON_INTENT_KEY) as PassPokemon

        val type = pokemon.type.toString().replace("[", "").replace("]", "")
        val ability = pokemon.ability.toString().replace("[", "").replace("]", "")

        Picasso.get().load(pokemon.sprites).into(about_pokemon_image)
        //about_pokemon_name.text =    "Name: ${pokemon.name}"
        about_pokemon_id.text =      "Pokedex Location: ${pokemon.id}"
        about_pokemon_ability.text = "Abilities: $ability"
        about_pokemon_type.text =    "Type(s): $type"

        /*about_pokemon_button.setOnClickListener {
            pokemonList.add(pokemon)
            startActivity(Intent(this, MainActivity::class.java))
        }*/

    }
}
