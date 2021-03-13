fun greets(name: String = "HIDDEN"): String {
    if (name == "" || name == "HIDDEN") {
        return "secret user"
    } else {
        return name
    }
}

fun main() {
    // write your code here
    val name = readLine()!!
    print("Hello, ${greets(name)}!")
}
