package IO

import Logic.*

class Output {
    fun printGameBoard(gameBoard: GameBoard, players: Map<Int, Player>) {
        var size = gameBoard.size
        for (x in -size / 2 until size / 2) {
            for (y in -size / 2 until size / 2) {
                when (gameBoard.map[Coordinate(y,-x)]) {
                    null -> print(".")
                    else -> print(players[gameBoard.map[Coordinate(y,-x)]]!!.mark)
                }
            }
            println()
        }
    }

    fun victory(player: Player) {
        println("player: ${player.mark} wins!")
    }
}

