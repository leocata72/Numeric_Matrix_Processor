data class Client(val name: String, val age: Int, val balance: Int) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Client
        if (name == other.name && age == other.age) return true
        return false
    }
}

fun main() {
    val n1 = readLine()!!
    val a1 = readLine()!!.toInt()
    val b1 = readLine()!!.toInt()
    val cl1 = Client(n1, a1, b1)
    val n2 = readLine()!!
    val a2 = readLine()!!.toInt()
    val b2 = readLine()!!.toInt()
    val cl2 = Client(n2, a2, b2)
    println("${cl1.equals(cl2)}")
}
