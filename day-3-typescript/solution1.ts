import { runSolution } from './common'

const INPUT_FILE_PATH = 'input.txt'

interface Pair {
    num1: Number
    num2: Number
}

function solution(input: string): string {
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

    return res.toString()
}

runSolution(INPUT_FILE_PATH, solution)