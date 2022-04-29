package IO

import Logic.*
import java.util.*


class Input {
    val scanner = Scanner(System.`in`)

    fun getCoordinate(gameBoard: GameBoard): Coordinate {

        var isValid = false
        var input: String
        var coo = Coordinate(0,0)
        while(!isValid){
            input = scanner.nextLine()
            coo = Coordinate(input.split(":").first().toInt(),input.split(":").last().toInt())
            isValid = gameBoard.isValidInput(coo)
        }
        return coo
    }

    fun getGameSetup(gameBoard: GameBoard): Map<Int,Player>{
        val players: MutableMap<Int,Player> = mutableMapOf()
        println("How many players do you want to play the game?")
        val playerCount = scanner.nextLine().toInt()
        for(x in 1..playerCount){
            println("a = AI     h = Human")
            val type = scanner.nextLine()
            println("enter player's mark")
            if(type == "h"){
                players[x] = Human(x, scanner.nextLine(), gameBoard)
            } else if(type == "a") {
                players[x] = AI(x, scanner.nextLine(),gameBoard)
            }
        }
        println("done")
        return players
    }
}