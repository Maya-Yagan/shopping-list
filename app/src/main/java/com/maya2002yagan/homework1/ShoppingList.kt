package com.maya2002yagan.homework1

class ShoppingList {
    private var shoppingList = mutableListOf<Item>()
    private var menuChoice: Int = 0
    private var itemChoice: Int = 0

    fun displayMenu() {
        println("**** Welcome to Shopping List App ****")
        while(true){
            println("Make your choice : (1-2-3-4)")
            println("1. Add item\n2. Display item\n3. Delete item\n4. Exit")
            try{
                menuChoice = readln().toInt()
            }catch(e: Exception){
                println("Invalid input. Please enter a valid number.")
                println("-----------------------")
                continue
            }
            println("Your choice is: $menuChoice")
            when(menuChoice){
                1 -> {
                    addItem()
                    println("-----------------------")
                }
                2 -> {
                    displayItems()
                    println("-----------------------")
                }
                3 -> {
                    deleteItems()
                    println("-----------------------")
                }
                4 -> {
                    println("Exiting...")
                    break
                }
                else -> {
                    println("Invalid input. Please enter a valid number.")
                    println("-----------------------")
                }
            }
        }
    }

    private fun addItem(){
        println("Enter the item type you want to add (1 for Food, 2 for Clothes): ")
        while(true){
            try{
                itemChoice = readln().toInt()
            }catch(e: Exception){
                println("Invalid input. Please enter a valid number. (1 for Food, 2 for Clothes)")
                continue
            }
            when(itemChoice){
                1 -> {
                    val food = Food("", 0.0, "")
                    while(true){
                        println("Enter the food name you want to add: ")
                        food.name = readln()
                        if(food.name.isBlank()){
                            println("Please enter a food name. You cannot leave it empty.")
                            continue
                        }
                        else break
                    }
                    while(true){
                        try{
                            println("Enter the food price you want to add: ")
                            food.price = readln().toDouble()
                            break
                        }catch(e: Exception){
                            println("Please enter a valid price!")
                            continue
                        }
                    }
                    while(true){
                        println("Enter the food weight: ")
                        food.weight = readln()
                        if(food.weight.isBlank()){
                            println("Please enter the weight. You cannot leave it empty.")
                            continue
                        }
                        else if(food.weight.toDoubleOrNull() == null){
                            println("Invalid input.")
                            continue
                        }
                        else break
                    }
                    shoppingList.add(food)
                    println("${food.name} has been added successfully!")
                    break
                }
                2 -> {
                    val cloth = Cloth("", 0.0, "")
                    while(true){
                        println("Enter the cloth name you want to add: ")
                        cloth.name = readln()
                        if(cloth.name.isBlank()){
                            println("Please enter the cloth name. You cannot leave it empty.")
                            continue
                        }
                        else break
                    }
                    while(true){
                        try{
                            println("Enter the cloth price you want to add: ")
                            cloth.price = readln().toDouble()
                            break
                        }catch(e: Exception){
                            println("Please enter a valid price!")
                            continue
                        }
                    }
                    while(true){
                        println("Enter the cloth type: ")
                        cloth.type = readln()
                        if(cloth.type.isBlank()){
                            println("Please enter the type. You cannot leave it empty.")
                            continue
                        }
                        else break
                    }
                    shoppingList.add(cloth)
                    println("${cloth.name} has been added successfully!")
                    break
                }
                else -> println("Invalid input. Please enter a valid number. (1 for Food, 2 for Clothes)")
            }
        }
    }

    private fun displayItems(){
        if(shoppingList.isNotEmpty()){
            println("Your shopping list: ")
            shoppingList.forEach { println("${shoppingList.indexOf(it) + 1} $it") }
        }
        else{
            println("Your list is empty! You can start shopping now.")
        }
    }

    private fun deleteItems(){
        displayItems()
        if(shoppingList.isNotEmpty()){
            println("Enter the item number you want to delete: ")
            while(true){
                try{
                    val choice = readln().toInt()
                    val temp = shoppingList[choice - 1].name
                    shoppingList.removeAt(choice - 1)
                    println("$temp has been deleted successfully.")
                    break
                }catch(e: Exception){
                    println("Invalid input. Please enter a valid number.")
                    continue
                }
            }
        }
    }
}