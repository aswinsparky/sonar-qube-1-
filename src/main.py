def main():
    # Good variable naming and all variables are used
    numbers = [1, 2, 3, 4, 5]
    result = sum(numbers)
    print(f"Sum is: {result}")

    # Safe logic: no dangerous eval, proper try/except
    try:
        computation = 10 / 2
        print(f"Computation: {computation}")
    except ZeroDivisionError as e:
        print(f"Error: {e}")

    user_input = "hello"
    if user_input == "hello":
        print("User input matches!")

    # Demonstrate clean code with no unreachable code or duplicate definitions
    if len(numbers) > 0:
        print("The list is not empty.")

    x = "string1"
    y = "string2"
    if x == y:
        print("Strings are equal.")
    else:
        print("Strings are not equal.")

if __name__ == "__main__":
    main()
