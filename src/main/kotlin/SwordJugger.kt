fun main() {
    var swordJugging: Int?= null
    val isJuggingProficient = (1..3).shuffled().last() == 3
    if (isJuggingProficient){
        swordJugging = 2
    }

    try {
        proficiencyCheck(swordJugging)
        swordJugging = swordJugging!!.plus(1)
    } catch (e: Exception){
        println(e)
    }
    println("You juggle $swordJugging swords")
}

fun proficiencyCheck(swordJugging: Int?){
    checkNotNull(swordJugging,{"PLAYER CAN NOT JUGGLE SWORDS"})
}

class  UnskilledSwordJugglerException(): IllegalStateException("PLAYER CAN NOT JUGGLE SWORDS")