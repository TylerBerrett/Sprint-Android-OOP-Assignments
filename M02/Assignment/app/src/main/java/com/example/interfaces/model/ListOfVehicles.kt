package com.example.interfaces.model

object ListOfVehicles {
    val getVehicle: MutableMap<String, Vehicle> = HashMap()
    val list = arrayListOf<Vehicle>(
        Plane(),
        Dragon(),
        MasterCraft(),
        Shark(),
        Jeep(),
        Cheetah()
    )

    init {

        list.forEach {
            getVehicle[it.id] = it
        }
    }
}