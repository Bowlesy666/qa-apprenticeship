while (True):
    try:
        person = int(input("What is your age? >> "))
        break
    except ValueError:
        print("Enter only digits.")
        continue


if (person >= 18):
    print("You are in category A!")

if (person >= 16):
    print("You are in category B!")

if (person < 16):
    print("You are in category C!")

print("\n---------------------------\n")
print("\nNot ideal huh!\n")
print("\n---------------------------\n")

while (True):
    try:
        personElif = int(input("What is your age? >> "))
        break
    except ValueError:
        print("Enter only digits.")
        continue

if (personElif >= 18):
    print("You are in category A!")
elif (personElif >= 16):
    print("You are in category B!")
else:
    print("You are in category C!")

print("\n---------------------------\n")
