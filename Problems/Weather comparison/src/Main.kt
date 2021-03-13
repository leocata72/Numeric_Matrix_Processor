class City(val name: String) {
    var degrees: Int = 0
        get() = field
        set(value) {
            field = if (value < -92 || value > 57) {
                when (this.name) {
                    "Moscow" -> 5
                    "Hanoi" -> 20
                    "Dubai" -> 30
                    else -> value
                }
            } else {
                value
            }
        }
}


fun main() {
    val first = readLine()!!.toInt()
    val second = readLine()!!.toInt()
    val third = readLine()!!.toInt()
    val firstCity = City("Dubai")
    firstCity.degrees = first
    val secondCity = City("Moscow")
    secondCity.degrees = second
    val thirdCity = City("Hanoi")
    thirdCity.degrees = third

    //implement comparing here
    var coldest = if (firstCity.degrees < secondCity.degrees) {
            firstCity
        } else {
            secondCity
        }
    coldest = if (coldest.degrees < thirdCity.degrees ) {
            coldest
        } else {
            thirdCity
        }
    if (firstCity.degrees == secondCity.degrees  ||  firstCity.degrees == thirdCity.degrees || secondCity.degrees == thirdCity.degrees ) {
        println("neither")
    } else {
        print( coldest.name)
    }
}