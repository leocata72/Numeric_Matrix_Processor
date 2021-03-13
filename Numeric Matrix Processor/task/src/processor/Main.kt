package processor

import java.lang.Exception
import java.util.Scanner

fun getMatrix(text: String): Array<Array<Double>> {
    val scanner = Scanner(System.`in`)
    println("Enter size of $text matrix:")
    var n = scanner.nextInt()
    var m = scanner.nextInt()
    println("Enter $text matrix:")
    var matrix = arrayOf<Array<Double>>()
    for (row in 1..n) {
        val tmpArr = Array<Double>(m, { 0.0 })
        for (col in 1..m) {
            tmpArr[col - 1] = scanner.nextDouble()
        }
        matrix += tmpArr
    }
    return matrix
}

fun printMatrix(matrix: Array<Array<Double>>) {
    for (row in matrix) {
        var str = ""
        for (el in row) {
            str += "$el "
        }
        println(str) //.substring(0, str.length - 1))
    }
}

fun addMatrix(A: Array<Array<Double>>, B: Array<Array<Double>>): Array<Array<Double>> {
    val n = A.size
    val m = A[0].size
    val C = Array(n, { Array<Double>(m, { 0.0 }) })
    for (i in 0..n - 1) {
        for (j in 0..m - 1) {
            C[i][j] = A[i][j] + B[i][j]
        }
    }
    //println("n:$n m:$m size of "+)
    return C
}

fun multiplyByConstant(matrix: Array<Array<Double>>, x: Double): Array<Array<Double>> {
    val n = matrix.size
    val m = matrix[0].size
    val C = Array(n, { Array<Double>(m, { 0.0 }) })
    for (i in 0..n - 1) {
        for (j in 0..m - 1) {
            C[i][j] = (matrix[i][j]) * x
        }
    }
    return C
}

fun menu(): Unit {
    println("1. Add matrices ")
    println("2. Multiply matrix by a constant")
    println("3. Multiply matrices")
    println("4. Transpose matrix")
    println("5. Calculate a determinant")
    println("6. Inverse matrix")
    println("0. Exit")
    println("Your choice: ")
}

fun multiplayByMatrix(A: Array<Array<Double>>, B: Array<Array<Double>>): Array<Array<Double>> {
    val n = A.size - 1
    val m = A[0].size - 1
    val p = B[0].size - 1
    val C = Array(n + 1, { Array<Double>(p + 1, { 0.0 }) })
    for (i in 0..n) {
        for (t in 0..p) {
            var res = 0.0
            for (j in 0..m) {
                res += A[i][j] * B[j][t]
            }
            C[i][t] = res
        }
    }
    return C
}

fun readMatrix(): Array<Array<Double>> {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val m = scanner.nextInt()
    var matrix = Array(n) { Array(m) { 0.0 } }
    for (i in 0 until n) {
        for (j in 0 until m) {
            matrix[i][j] = scanner.nextDouble()
        }
    }
    return matrix;
}

fun mainDiagolTraspose(matrix: Array<Array<Double>>): Array<Array<Double>> {
    val n = matrix.size
    val m = matrix[0].size
    val trasposte = Array(m) { Array(n) { 0.0 } }
    for (i in 0 until n) {
        for (j in 0 until m) {
            trasposte[j][i] = matrix[i][j]
        }
    }
    return trasposte
}

fun transposeMatrix() {
    val scanner = Scanner(System.`in`)
    println("1. Main diagonal")
    println("2. Side diagonal")
    println("3. Vertical line")
    println("4. Horizontal line")
    print("Your choice: ")
    val choice = readLine()!!.toInt()
    print("Enter matrix size: ")
    val n = scanner.nextInt()
    val m = scanner.nextInt()
    val matrix = Array(n) { Array(m) { 0.0 } }
    println("Enter matrix:")
    for (row in 0..n - 1) {
        for (col in 0..m - 1) {
            matrix[row][col] = scanner.nextDouble()
        }
    }
    when (choice) {
        1 -> {
            val trasposte = mainDiagolTraspose(matrix)
            println("The result is:")
            printMatrix(trasposte)
        }
        2 -> {
            val trasposte = Array(m) { Array(n) { 0.0 } }
            for (i in 0 until n) {
                for (j in 0 until m) {
                    trasposte[m - 1 - j][n - 1 - i] = matrix[i][j]
                }
            }
            println("The result is:")
            printMatrix(trasposte)
        }
        3 -> {
            val trasposte = Array(m) { Array(n) { 0.0 } }
            for (i in 0 until n) {
                for (j in 0 until m) {
                    trasposte[i][m - 1 - j] = matrix[i][j]
                }
            }
            println("The result is:")
            printMatrix(trasposte)
        }
        4 -> {
            val trasposte = Array(m) { Array(n) { 0.0 } }
            for (i in 0 until n) {
                for (j in 0 until m) {
                    trasposte[n - 1 - i][j] = matrix[i][j]
                }
            }
            println("The result is:")
            printMatrix(trasposte)
        }

    }
}

fun readSquareMatrix(): Array<Array<Double>> {
    println("Enter matrix size: ")
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val m = scanner.nextInt()
    println("Enter matrix: ")
    var matrix = Array(n) { Array(m) { 0.0 } }
    for (i in 0 until n) {
        for (j in 0 until m) {
            matrix[i][j] = scanner.nextDouble()
        }
    }
    return matrix;
}

// Function to get cofactor of mat[p][q] in temp[][]. n is
// current dimension of mat[][]
//void getComplement(int mat[N][N], int temp[N][N], int p,
//int q, int n)
fun getComplement(mat: Array<Array<Double>>, p: Int, q: Int): Array<Array<Double>> {
    val n = mat.size
    val m = mat[0].size
    var matrix = Array(n - 1) { Array(m - 1) { 0.0 } }
    var i = 0
    for (row in 0 until n) {
        if (row == p) {
            continue
        } else {
            var j = 0
            for (col in 0 until m) {
                if (col == q) {
                    continue
                } else {
                    matrix[i][j] = mat[row][col]
                    ++j
                }
            }
        }
        ++i
    }
    return matrix
}


///* Recursive function for finding determinant of matrix.
//   n is current dimension of mat[][]. */
//int determinantOfMatrix(int mat[N][N], int n)
//{
fun determinatOfMatrix(mat: Array<Array<Double>>): Double {
    if (mat.size != mat[0].size) throw Exception("This isn't a square matrix")
    val n = mat.size // size matrix
    var D = 0.0 // Initialize result
    //  Base case : if matrix contains single element
    if (n == 1) return mat[0][0]
    //var temp = Array(n - 1) { Array(n - 1) { 0.0 } }
    var sign = 1.0
    for (f in 0 until n) {
        // Getting Cofactor of mat[0][f]
        val temp = getComplement(mat, 0, f)
        D += sign * mat[0][f] * determinatOfMatrix(temp);
        // terms are to be added with alternate sign
        sign = -sign;

    }
    return D
}

fun sign(i: Int): Int {
    var s = -1
    repeat(i - 1){
        s *=-1
    }
    return s
}

fun cofactorMatrix(mat: Array<Array<Double>>): Array<Array<Double>> {
    val n = mat.size
    val m = mat[0].size
    if (n != m) {
        throw Exception("This isn't a square matrix!")
    } else {
        val c = Array(n) {Array(m) {0.0} }
        for (i in 0 until n) {
            for (j in 0 until m){
                c[i][j] = sign(i + j + 2) * determinatOfMatrix(getComplement(mat,i,j))
            }
        }
    return c
    }
}


fun main() {
    var fine = false
    while (!fine) {
        menu()
        val choice = readLine()!!.toInt()
        when (choice) {
            1 -> {
                val firstMatrix = getMatrix("first")
                val secondMatrix = getMatrix("second")
                println("The result is:")
                printMatrix(addMatrix(firstMatrix, secondMatrix))
            }
            2 -> {
                val matrix = getMatrix("")
                println("Enter constant: ")
                printMatrix(multiplyByConstant(matrix, readLine()!!.toDouble()))
            }
            3 -> {
                val firstMatrix = getMatrix("first")
                val secondMatrix = getMatrix("second")
                println("The result is:")
//                The number of columns of the 1st matrix must be equal to the number of rows of the 2nd matrix.
//                And the result will have the same number of rows as the 1st matrix, and the same number of columns as the 2nd matrix.
                if (firstMatrix[0].size == secondMatrix.size) {
                    printMatrix(multiplayByMatrix(firstMatrix, secondMatrix))
                } else {
                    println("The operation cannot be performed.")
                }
            }
            4 -> {
                transposeMatrix()
            }
            5 -> {
                val mat = readSquareMatrix()
                println("The result is: \n${determinatOfMatrix(mat)}")
            }
            6 -> {
                val mat = readSquareMatrix()
//                val mat = arrayOf( arrayOf(0.396796, -0.214938, 0.276735),
//                                    arrayOf(5.19655, -2.06983, -0.388886),
//                                    arrayOf(-3.3797, 1.50219, 0.159794))

                val det = determinatOfMatrix(mat)
                //println("Det: $det")
                if (det != 0.0) {
                    val inverse = multiplyByConstant(mainDiagolTraspose(cofactorMatrix(mat)), 1.0 / det)
                    printMatrix(inverse)

                } else {
                    println("This matrix doesn't have an inverse.")
                }

            }
            0 -> fine = true
        }
    }
}