import java.util.Scanner
import kotlin.math.PI
import kotlin.math.atan2
import kotlin.math.max
import kotlin.math.min

fun main() {
    val scanner = Scanner(System.`in`)
    val x1 = scanner.nextDouble()
    val y1 = scanner.nextDouble()
    val x2 = scanner.nextDouble()
    val y2 = scanner.nextDouble()
    val alpha1 = atan2(y1, x1)
    val alpha2 = atan2(y2, x2)
    val alpha = (max(alpha1, alpha2) - min(alpha1, alpha2)) / PI * 180.0
    println(alpha.toInt())
}