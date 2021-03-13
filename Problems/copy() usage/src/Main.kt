// do not change this data class
data class Box(val height: Int, val length: Int, val width: Int)

fun main() {
    val h = readLine()!!.toInt()
    val l1 = readLine()!!.toInt()
    val l2 = readLine()!!.toInt()
    val w = readLine()!!.toInt()
    val box1 = Box(h, l1, w)
    val box2 = box1.copy(length = l2)
    println("Box(height=${box1.height}, length=${box1.length}, width=${box1.width})")
    println("Box(height=${box2.height}, length=${box2.length}, width=${box2.width})")
}
