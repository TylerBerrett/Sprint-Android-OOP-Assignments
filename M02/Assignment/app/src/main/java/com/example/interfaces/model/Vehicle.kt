package com.example.interfaces.model

import java.io.Serializable

//Abstract class "Parent"
abstract class Vehicle(
    var id: String = "",
    var weight: Int = 0,
    var favorite: Boolean = false
): Serializable {
    abstract fun travel(): String
}

//Interfaces

interface AirTravel{
    fun fly(): String
}

interface WaterTravel{
    fun sail(): String
}

interface GroundTravel{
    fun drive(): String
}




//classes that inherit from Vehicle and implement from the interfaces

class Plane: Vehicle(), AirTravel {
    init {
        id = "Plane"
        weight = 2398475
    }
    override fun fly(): String {
        return "Wings"
    }

    override fun travel(): String {
        return "$id weighs $weight pound(s) and travels via ${fly()}"
    }
}

class Dragon: Vehicle(), AirTravel {
    init {
        id = "Dragon"
        weight = 1000000
    }

    override fun fly(): String {
        return "magic"
    }

    override fun travel(): String {
        return "$id weighs $weight pound(s) and travels via ${fly()}"
    }
}

class MasterCraft: Vehicle(), WaterTravel {
    init {
        id = "MasterCraft"
        weight = 234978
    }

    override fun sail(): String {
        return "motor"
    }

    override fun travel(): String {
        return "$id weighs $weight pound(s) and travels via ${sail()}"
    }
}
class Shark: Vehicle(), WaterTravel {
    init {
        id = "Shark"
        weight = 10
    }
    override fun sail(): String {
        return "fins"
    }

    override fun travel(): String {
        return "$id weighs $weight pound(s) and travels via ${sail()}"
    }
}

class Jeep: Vehicle(), GroundTravel {
    init {
        id = "Jeep"
        weight = 2345978
    }
    override fun drive(): String {
        return "engine"
    }

    override fun travel(): String {
        return "$id weighs $weight pound(s) and travels via ${drive()}"
    }
}
class Cheetah: Vehicle(), GroundTravel {
    init {
        id = "Cheetah"
        weight = 92
    }
    override fun drive(): String {
        return "feet"
    }

    override fun travel(): String {
        return "$id weighs $weight pound(s) and travels via ${drive()}"
    }
}


