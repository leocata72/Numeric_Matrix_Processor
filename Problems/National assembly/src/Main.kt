import kotlin.math.pow  kotlin.math.floor
import java.util.Scanner
fun main() {
    // write your code here
    val scanner = Scanner(System.`in`)
    val pop = scanner.nextInt()
    val popD = pop.toDouble()
    val esp = 1.0 / 3.0
    val ass = floor(popD.pow(esp) + 0.000000001)
    println(ass.toInt())
}
