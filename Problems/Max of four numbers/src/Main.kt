import kotlin.math.max
fun main() {
    // write your code here
    var f = readLine()!!.toInt()
    for (i in 1..3) {
        val s = readLine()!!.toInt()
        f = max(f, s)
    }
    println(f.toString())
}
