package Logic

import IO.Input

class Human(override val id: Int, override val mark: String, override val gameBoard: GameBoard) : Player{
    private val input = Input()

    override fun play(): Coordinate {
        return input.getCoordinate(gameBoard)
    }
}