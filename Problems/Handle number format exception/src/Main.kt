import java.lang.Exception

fun parseCardNumber(cardNumber: String): Long {
    var numbersOfSpace = 0
    if (cardNumber.length > 19) {
        throw Exception("exception when the card number is incorrect: address length > 19")
    }
    for (x in cardNumber) {
        if (x.equals(' ')) {
            numbersOfSpace++
            } else if (x.isLetter() || !x.isLetterOrDigit()) {
                throw Exception("exception when the card number is incorrect: there are inconsistent simbol or letter")
        }
    }
    if (numbersOfSpace != 3) {
        throw Exception("exception when the card number is incorrect: format invalid")
    }
    val st = cardNumber.filter({ c -> c.isDigit() })
    return st.toLong()
}
