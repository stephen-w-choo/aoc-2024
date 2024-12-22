import java.io.File
import java.lang.Math.abs

fun solution(input: String): String {
    val reports = parser(input)

    var res = 0

    for (report in reports) {
        val isValidReport = checkReport(
            report = report,
            increasing = true,
            failedOnce = false
        ) || checkReport(
            report = report,
            increasing = false,
            failedOnce = false
        )

        if (!isValidReport) println(report)
        if (isValidReport) res += 1
    }

    return res.toString()
}

fun checkReport(report: List<Int>, increasing: Boolean, failedOnce: Boolean): Boolean {
    fun retryWithoutIndex(index: Int): Boolean {
        if (failedOnce) return false

        return checkReport(
            report = report.toMutableList().apply { removeAt(index) },
            increasing = increasing,
            failedOnce = true
        )
    }

    if (report.size <= 1) return true

    for (i in report.indices) {
        if (i == 0) continue

        val prev = report[i - 1]
        val cur = report[i]

        val diff: Int = abs(prev - cur)

        if (diff == 0 || diff > 3) {
            val res = retryWithoutIndex(i - 1) || retryWithoutIndex(i)
            return res
        }

        when {
            increasing -> if (prev > cur) {
                val res = retryWithoutIndex(i - 1) || retryWithoutIndex(i)
                return res
            }
            !increasing -> if (cur > prev) {
                val res = retryWithoutIndex(i - 1) || retryWithoutIndex(i)
                return res
            }
        }
    }

    return true
}

fun parser(input: String): List<List<Int>> {
    return input.split("\n")
        .map {
            it.split(" ")
                .map {
                    it.toInt()
                }
        }
}

fun runSolution(inputFilePath: String, solutionFunction: (String) -> String) {
    val input = File(inputFilePath).readText()
    val res = solutionFunction(input)
    println(res)
}

runSolution("input.txt", ::solution)