data class Product(var price: Int) {
    var totalPrice: Double = 0.0
    var description: String = ""
        get() = field
        set(value) {
            this.totalPrice = when (value) {
                "headphones" -> price.toDouble() * 1.11
                "smartphone" -> price.toDouble() * 1.15
                "tv" -> price.toDouble() * 1.17
                "laptop" -> price.toDouble() * 1.19
                else -> price.toDouble()
            }
            field = value
        }
    }


fun totalPrice(prodotto: Product): String {
    val str: String = prodotto.totalPrice.toInt().toString() 
    return str
}

fun main() {
    val productType = readLine()!!
    val price = readLine()!!.toInt()
    val product = Product(price)
    product.description = productType
    println(totalPrice(product))
}
