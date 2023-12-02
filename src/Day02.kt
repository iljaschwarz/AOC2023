fun main() {
    fun part1(input: List<String>): Any {
        var sum = 0
        input.forEach { game ->
            val (gameId, rest) = game.split(":")
            val id = gameId.replace("Game ", "").toInt()
            rest.split(";").let { row ->
                var problem = false
                for (drawing in row) {
                    drawing.split(",").let {
                        for (draw in it) {
                            draw.trim().split(" ").let { (number, color) ->
                                when (color) {
                                    "blue" -> if (number.toInt() > 14) problem = true
                                    "green" -> if (number.toInt() > 13) problem = true
                                    "red" -> if (number.toInt() > 12) problem = true
                                }
                            }
                        }
                    }
                }
                if (!problem) {
                    sum += id
                }
            }
        }
        return sum
    }

    fun part2(input: List<String>): Any {
        var sum = 0
        input.forEach { game ->
            val (gameId, rest) = game.split(":")
            val id = gameId.replace("Game ", "").toInt()
            rest.split(";").let { row ->
                var redMax = 0
                var greenMax = 0
                var blueMax = 0
                for (drawing in row) {
                    drawing.split(",").let {
                        for (draw in it) {
                            draw.trim().split(" ").let { (number, color) ->
                                val currentNumber = number.toInt()
                                when (color) {
                                    "blue" -> if (currentNumber > blueMax) blueMax = currentNumber
                                    "green" -> if (currentNumber > greenMax) greenMax = currentNumber
                                    "red" -> if (currentNumber > redMax) redMax = currentNumber
                                }
                            }
                        }
                    }
                }
                sum += redMax * blueMax * greenMax
            }
        }
        return sum
    }

    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}
