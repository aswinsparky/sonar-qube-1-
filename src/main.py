# Example Python code with typical code issues for SonarQube

import sys

def find_sum(numbers):
    # Unused variable
    total = 0

    # Magic number (should be a constant)
    threshold = 10

    # Unreachable code
    return sum(numbers)
    print("This code is unreachable")

def bad_naming():
    # Variable name not following PEP8 (should be snake_case)
    BadVariableName = 42
    return BadVariableName

def duplicate_code():
    # Duplicate logic
    result1 = 0
    for n in range(5):
        result1 += n

    result2 = 0
    for n in range(5):
        result2 += n

    return result1 + result2

def possible_bug():
    # Compare strings with 'is' instead of '=='
    a = "hello"
    b = "hello"
    if a is b:
        print("Bug: comparing strings with 'is'")
    # Access possibly undefined variable
    if False:
        x = 42
    print(x)  # Will trigger "undefined variable" warning

def small_function():
    return 1

def small_function():
    # Function with the same name, hides previous (duplicate function definition)
    return 2

# Long line issue (too many characters in a single line)
long_line = "This is a very long line that is intended to demonstrate a code smell for SonarQube, exceeding typical line length recommendations."

if __name__ == "__main__":
    find_sum([1, 2, 3])
    bad_naming()
    duplicate_code()
    possible_bug()
    print(small_function())
    print(long_line)