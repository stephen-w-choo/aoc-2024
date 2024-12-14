import os
from runner import run_solution

YOUR_OUTPUT_FILE_NAME ="output.txt"

"""
Parses list1 as a list but list2 as a frequency dict for comparisons
"""
def format_input(input_data: list[str]) -> tuple[list[int], dict[int, int]]:
    list1: list[int] = []
    freq2: dict[int, int] = {}
    
    for line in input_data:
        num1, num2 = line.split("   ")
        num1 = int(num1)
        num2 = int(num2)
        list1.append(int(num1))
        
        if num1 not in freq2:
            freq2[num1] = 0
        
        if num2 not in freq2:
            freq2[num2] = 0

        freq2[num2] += 1

    return (list1, freq2)

def solution(input_data: list[str]) -> list[str]:
    list1, freq2 = format_input(input_data)

    similarity = 0
    
    for num in list1:
        similarity += num * freq2[num]
    
    return [str(similarity)]

if __name__ == "__main__":
    run_solution(YOUR_OUTPUT_FILE_NAME, solution)