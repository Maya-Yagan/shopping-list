package com.maya2002yagan.homework1

class Cloth(name: String, price: Double, var type: String): Item(name, price) {
    override fun toString(): String {
        return "$name $price$ $type"
    }
}