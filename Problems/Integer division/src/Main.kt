import java.lang.NumberFormatException

fun intDivision(x: String, y: String): Int {
    try {
        val xInt = x.toInt()
        val yInt = y.toInt()
        val res = xInt / yInt
        return res
    } catch (e: ArithmeticException) {
        println("Exception: division by zero!")
    } catch (e: NumberFormatException) {
        println("Read values are not integers.")
    }
    return 0
}

fun main() {
    val x = readLine()!!
    val y = readLine()!!
    println(intDivision(x, y))

}