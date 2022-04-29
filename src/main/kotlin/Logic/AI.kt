package Logic


class AI(override val id: Int, override val mark: String, override val gameBoard: GameBoard) : Player{
    override fun play(): Coordinate {
        while(true){
            val x = gameBoard.size/2
            val shootAt = Coordinate((-x until x).random(), (-x until x).random())
            if(gameBoard.map[shootAt] == null) return shootAt
        }
    }
}