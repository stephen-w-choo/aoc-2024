import java.io.File

fun solution(input: String): String {
    // Your solution here
    // val parsedInput = parser(input)
}

fun parser(input: String): List<String> {
    return input.split("/n")
}

fun runSolution(inputFilePath: String, solutionFunction: (String) -> String) {
    val input = File(inputFilePath).readText()
    val res = solutionFunction(input)
    println(res)
}

runSolution("input.txt", ::solution)