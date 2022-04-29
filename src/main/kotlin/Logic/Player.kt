package Logic

interface Player{
    val id: Int
    val mark: String
    val gameBoard: GameBoard
    fun play(): Coordinate
}