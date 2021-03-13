fun speedExceedingLimit(speed: Int, limit: Int = 60): Boolean {
    return speed > limit
}
fun main(args: Array<String>) {
    // write your code here
    val speed = readLine()!!.toInt()
    val limit = readLine()!!
    var limitInt = 60
    val exceeds  = when (limit) {
        "no limit" ->  speedExceedingLimit(speed)
        else -> {
            limitInt = limit.toInt()
            speedExceedingLimit(speed, limit.toInt())
        }
    }
    if (exceeds) {
        val diff = speed - limitInt
        println("Exceeds the limit by $diff kilometers per hour")
    } else {
        println("Within the limit")
    }
}
