import os
from runner import run_solution

YOUR_OUTPUT_FILE_NAME ="output.txt"

def format_input(input_data: list[str]) -> tuple[list[int], list[int]]:
    list1: list[int] = []
    list2: list[int] = []
    
    for line in input_data:
        num1, num2 = line.split("   ")
        list1.append(int(num1))
        list2.append(int(num2))

    return (list1, list2)

def solution(input_data: list[str]) -> list[str]:
    list1, list2 = format_input(input_data)

    list1.sort()
    list2.sort()

    res = 0
    
    for i in range(len(list1)):
        res += abs(list1[i] - list2[i])
    
    return [str(res)]


if __name__ == "__main__":
    run_solution(YOUR_OUTPUT_FILE_NAME, solution)