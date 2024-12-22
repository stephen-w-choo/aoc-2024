import java.io.File
import java.lang.Math.abs

fun solution(input: String): String {
    val reports = parser(input)

    var res = 0

    for (report in reports) {
        val isValidReport = checkReport(report)

        if (isValidReport) res += 1
    }

    return res.toString()
}

enum class ReportType {
    INCREASING,
    DECREASING
}

fun checkReport(report: List<Int>): Boolean {
    if (report.size <= 1) return true

    var reportType: ReportType = when {
        report[0] > report[1] -> ReportType.DECREASING
        report[1] > report[0] -> ReportType.INCREASING
        else -> return false
    }


    for (i in report.indices) {
        if (i == 0) continue

        val prev = report[i - 1]
        val cur = report[i]

        val diff: Int = abs(prev - cur)

        if (diff == 0 || diff > 3) return false

        when (reportType) {
            ReportType.INCREASING -> if (prev > cur) return false
            ReportType.DECREASING -> if (cur > prev) return false
        }
    }

    return true
}

fun parser(input: String): List<List<Int>>{
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