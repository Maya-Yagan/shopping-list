package com.maya2002yagan.homework1

class Food(name: String, price: Double, var weight: String): Item(name, price) {
    override fun toString(): String {
        return "$name $price$ ${weight}kg"
    }
}