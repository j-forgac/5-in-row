package Logic

import kotlin.math.abs

class GameBoard(
    initialSize: Int = 10,
    private val expandAt: Int = 2,
    private val expansionDist: Int = 2,
    private val inRowForWin: Int = 5
) {

    var map = mutableMapOf<Coordinate, Int?>()
        get() = field

    var size = initialSize
        get() = field

    init {
        expandBy(0)
    }

    fun play(coordinate: Coordinate, id: Int): Boolean {
        map[coordinate] = id
        if (checkWin(coordinate.x, coordinate.y, id)) return true
        if (shouldExpand(coordinate.x, coordinate.y)) expandBy(expansionDist * 2)
        return false
    }

    fun isValidInput(coordinate: Coordinate): Boolean =
        map[coordinate] == null
        && coordinate.x < size/2 && coordinate.x >= -size/2
        && coordinate.y < size/2 && coordinate.y >= -size/2

    private fun shouldExpand(x: Int, y: Int): Boolean = abs(x) + expandAt >= size / 2 || abs(y) + expandAt >= size / 2

    private fun expandBy(expansion: Int) {
        size += expansion
        for (x in -size / 2 until size / 2) {
            for (y in -size / 2 until size / 2) {
                if (!map.containsKey(Coordinate(x, y))) map[Coordinate(x, y)] = null
            }
        }
    }

    private fun checkWin(x: Int, y: Int, id: Int): Boolean {
        for (xChange in -1..1) {
            for (yChange in -1..1) {
                if ((xChange != 0 || yChange != 0) && checkRow(xChange, yChange, x, y, id)) return true
            }
        }
        return false
    }

    private fun checkRow(xChange: Int, yChange: Int, x: Int, y: Int, id: Int): Boolean {
        for (i in 0 until inRowForWin) {
            if (map[Coordinate(x + i * xChange, y + i * yChange)] != id) {
                return false
            }
        }
        return true
    }
}

data class Coordinate(val x: Int, val y: Int)