package Logic

import IO.Input
import IO.Output

fun main(args: Array<String>) {
    val gameBoard = GameBoard(10, 1, 1, 5)
    val output = Output()
    val input = Input()
    val players = input.getGameSetup(gameBoard)
    while (true) {
        players.forEach {
            if (gameBoard.play(it.value.play(), it.value.id)) {
                output.victory(it.value)
                return
            }
            output.printGameBoard(gameBoard,players)
        }
    }
}