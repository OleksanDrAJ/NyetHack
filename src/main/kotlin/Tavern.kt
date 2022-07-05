import java.io.File
import kotlin.math.roundToInt

const val TAVERN_NAME = "Taernyl's Folly"


val patronList = mutableListOf("Eli", "Mordoc", "Sophie")
val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")
val uniquePatrons = mutableSetOf<String>()
val patronGold = mutableMapOf<String, Double>()
val menuList = File("data/tavern-menu-data.txt") .readText()
    .split("\n")



fun main() {
    //placeOrder("shandy,Dragon's Breath,5.91")
    //println(patronList[0])
//    if (patronList.contains("Eli")) {
//        println("The tavern master says: Eli's in the back playing cards. ")
//    }
//    else {
//        println("The tavern master says: Eli isn't here.")
//    }
//
//    if (patronList.containsAll(listOf("Eli", "Mordoc"))){
//        println("The tavern master says: Yea, they're seated by the stew kettle.")
//    } else{
//        println("The tavern master says: Nay, they departed hours ago.")
//    }

//    println(patronList)
//    patronList.remove("Eli")
//    patronList.add("Alex")
//    patronList.add(0, "Alex")
//    patronList[0] = "Alexis"


//    patronList.forEach{patron->
//        println("Good evening $patron")
//    }

    (0..9).forEach {
        val first = patronList.shuffled().first()
        val last = lastName.shuffled().first()
        val name = "$first $last"
        uniquePatrons +=name
    }

    uniquePatrons.forEach {
        patronGold[it] = 6.0
    }


//    var orderCount = 0
//    while (orderCount <= 9) {
//        placeOrder(uniquePatrons.shuffled().first(), menuList.shuffled().first())
//        orderCount++
//    }

    displayPatronBalance()
}

private fun displayPatronBalance(){
    patronGold.forEach{patron, balance->
        println("$patron, balance: ${"%.2f".format(balance)}")
    }
}


fun performPurchase(price: Double, patronName: String){
    val totalPurse = patronGold.getValue(patronName)
    patronGold[patronName] = totalPurse - price
}

private fun toDragonSpeak(phrase: String){
    phrase.replace(Regex("[aeiou]")) {
        when (it.value) { "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|" else -> it.value
        }
    }
}


private fun placeOrder(patronName: String, menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)

    println("$patronName speaks with $tavernMaster about their order.")
    val (type, name, price) = menuData.split(',')
//    val info = menuData.split(',')
//    val type = info[0]
//    val name = info[1]
//    val price = info[2]

    val message = "$patronName buys a $name ($type) for $price."
    println(message)
    performPurchase(price.toDouble(), patronName)

    val phrase = if (name == "Dragon's Breath") {

        "$patronName exclaims: ${toDragonSpeak("Ah, delicious $name!")}"
    } else {

        "$patronName says: Thanks for the $name."
    }
    println(phrase)
}