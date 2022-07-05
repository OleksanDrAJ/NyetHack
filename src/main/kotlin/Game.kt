fun main() {
    val name = "Madrigal"
    var healthPoints =74
    val isBlessed = true
    val isImmortal = false
    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)
    val race = "Gnome"
    val fraction = when(race){
        "Dwarf"->"Keepers of mines"
        "Gnome"->"Keepers of mines"
        "Orc"->"Free people of Rolling Hills"
        "Human"-> "Free people of Rolling Hills"
        else -> "Unknown race"
    }

    val player = Player()
    player.castFireball()

    val healthStatus = formatHealthStatus(healthPoints, isBlessed)

    printPlayerStatus(auraColor, isBlessed, name, healthStatus)


}

private fun printPlayerStatus(
    auraColor: String,
    isBlessed: Boolean,
    name: String,
    healthStatus: String
) {
    println(
        "(Aura: $auraColor) " +
                "(Blessed: ${if (isBlessed) "YES" else "NO"})"
    )
    println("$name $healthStatus")

    //println(auraColor + "\n" + name + " " + healthStatus)
}

private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean)=
    if (isBlessed && healthPoints > 50 || isImmortal) "GREEN" else "NONE"
    //return auraColor


private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) =
    when (healthPoints) {
        100 -> "has an excellent health condition"
        in 90..99 -> "has a few scratches"
        in 75..89 -> if (isBlessed) "is blessed, his health is regenerating pretty fast" else "is in normal condition"
        in 15 until 75 -> "looks pretty heart"
        else -> "is in awful condition"
    }
    //return healthStatus





/*
    val healthStatus = if (healthPoints == 100)"An excellent health condition"
    else if (healthPoints in 90..99) "has a few scratches"
    else if (healthPoints in 75..89){
        if (isBlessed) "is blessed, his health is regenerating pretty fast"
        else "is in normal condition"
    } else if (healthPoints in 15..74)
        "Player looks pretty heart"
    else "Player is in awful condition"


    //Aura
//    if (auraVisible){
//        println("GREEN")
//    }else{
//        println("NONE")
//    }

    println(auraColor + "\n" + name + " " + healthStatus)

    if (healthPoints == 100){
        println("Player $name has excellent health condition")
    } else if (healthPoints >= 90){
        println("Player $name has a few scratches")
    } else if (healthPoints >= 75){
        if (isBlessed){
            println("Player $name is blessed, his health is regenerating pretty fast")
        } else{
            println("Player $name is in normal condition")
        }
    } else if (healthPoints >= 15){
        println("Player $name looks pretty heart")
    } else {
        println("Player $name is in awful condition")
    }

     */