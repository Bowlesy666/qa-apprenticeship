print("Hey and welcome to my rectangle calculator.\nLet's get started...\n\n")
while(True):
    try:
        length = int(input('What is the length of the rectangle? >> '))
        break
    except ValueError:
        print("Enter only digits.")
        continue

while(True):
    try:
        width = int(input('what is the width of the rectangle: >> '))
        break
    except ValueError:
        print("Enter only digits.")
        continue

perimter = (length * 2) + (width * 2)
area = length * width

print("\n---------------------------\n")
print("The perimeter of your rectangle is being calculated...")
print(f"the perimter is {perimter} in whatever metric you used")

print("\n---------------------------\n")
print("The area of your rectangle is being calculated...")
print(f"the perimter is {area} in whatever metric you used")

print("")
print("---------------------------")
print("End of project")
