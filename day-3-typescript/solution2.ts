import { runSolution } from './common'

const INPUT_FILE_PATH = 'input.txt'

function splitGroups(input: string): Array<string> {
    let res: Array<string> = []

    let splittingRegex = /(do\(\)|don't\(\))/

    res = input.split(splittingRegex)

    return res
}

function tallyGroup(input: string): number {
    const regex = /mul\((\d+),(\d+)\)/g

    let groups = input.matchAll(regex)

    let res = 0

    for (let nums of groups) {
        try {
            let str1 = nums[1]
            let str2 = nums[2]

            let num1 = parseInt(str1)
            let num2 = parseInt(str2)
            
            res += num1 * num2

        } catch {
            // not a valid number
        }
    }

    return res
}


function solution(input: string): string {
    let groups = splitGroups(input)

    console.log(groups)

    const DO = 'do()'
    const DONT = "don't()"

    let res = 0

    for (let i = 0; i < groups.length; i++) {
        try {
            if (groups[i] == DO) {
                res += tallyGroup(groups[i + 1])
            }
        } catch {
            // parsing error, ignore
        }
    }

    res += tallyGroup(groups[0])

    return res.toString()
}

runSolution(INPUT_FILE_PATH, solution)