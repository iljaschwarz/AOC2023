fun main() {
    fun part1(input: List<String>): Any {
        var sum = 0
        for (line in input) {
            val stripped = line.replace("[^\\d.]".toRegex(), "")
            val firstnumber = stripped.substring(0, 1).toInt()
            val secondnumber = stripped.substring(stripped.length - 1).toInt()
            sum += firstnumber * 10 + secondnumber
        }
        return sum
    }

    fun part2(input: List<String>): Any {
        var sum = 0
        for (line in input) {
            val digits = ArrayList<Int>()
            for (pos in line.indices) {
                when {
                    line[pos].isDigit() -> digits.add(line[pos].toString().toInt())
                    line.substring(pos).startsWith("zero") -> digits.add(0)
                    line.substring(pos).startsWith("one") -> digits.add(1)
                    line.substring(pos).startsWith("two") -> digits.add(2)
                    line.substring(pos).startsWith("three") -> digits.add(3)
                    line.substring(pos).startsWith("four") -> digits.add(4)
                    line.substring(pos).startsWith("five") -> digits.add(5)
                    line.substring(pos).startsWith("six") -> digits.add(6)
                    line.substring(pos).startsWith("seven") -> digits.add(7)
                    line.substring(pos).startsWith("eight") -> digits.add(8)
                    line.substring(pos).startsWith("nine") -> digits.add(9)
                }
            }
            sum += digits.first() * 10 + digits.last()
        }
        return sum
    }



val input = readInput("Day01")
part1(input).println()
part2(input).println()
}
