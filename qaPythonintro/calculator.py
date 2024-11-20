DASHES = "\n-------------------------------------------------------------------------\n"
def get_player_name():
    """
    greeting and takes user name input
    """
    print(DASHES)
    print("\tHey and welcome to my super duper calculator.\n\tLet's get started...\n\n")
    player_name = input("\twhat is your name? >> ")
    print(f"{DASHES}\n\tNice to meet you {player_name}")

def get_first_number():
    """
    takes users first number
    repeats prompt if input is not as expected
    """
    while True:
        try:
            first_num = float(input(f'{DASHES}\tWhat is your first number? >> '))
            return first_num
        except ValueError:
            print("Enter only numbers silly!")
            continue

def get_math_symbol():
    """
    takes users maths symbol input
    repeats prompt if input is not as expected
    """
    while True:
        symbol = input(f'{DASHES}\tWhat calculation do you want to make?\n\t(+,-,*,/,s="square") >> ')
        if symbol in ['+','-','*','/','s', 'S']:
            return symbol
        else:
            print("Enter correct maths symbol!")
            continue

def get_second_number():
    """
    takes users second number
    repeats prompt if input is not as expected
    """
    while True:
        try:
            second_num = float(input(f'{DASHES}\tWhat is your second number? >> '))
            return second_num
        except ValueError:
            print("Enter only numbers silly!")
            continue

def display_calculator_image(user_sum):
    """
    prints calculator image to user
    includes the current sum displayed inside calculator
    """
    display_value = f"{user_sum:>17}"

    calculator_image = f"""
   \t _____________________
   \t|  _________________  |
   \t| |{display_value}| |
   \t| |_________________| |
   \t|  ___ ___ ___   ___  |
   \t| | 7 | 8 | 9 | | + | |
   \t| |___|___|___| |___| |
   \t| | 4 | 5 | 6 | | - | |
   \t| |___|___|___| |___| |
   \t| | 1 | 2 | 3 | | x | |
   \t| |___|___|___| |___| |
   \t| | . | 0 | = | | / | |
   \t| |___|___|___| |___| |
   \t|_____________________|
    """
    print(calculator_image)


def run_calculator(player_name):
    """
    runs the calculator functionality
    asks user for numbers and calculation symbol
    displays calculator with input at each stage

    """
    while True:
        # Blank calculator screen
        calc_screen_display = ""
        display_calculator_image(calc_screen_display)
        
        first_number = get_first_number()
        calc_screen_display += str(first_number)
        display_calculator_image(calc_screen_display)

        math_symbol = get_math_symbol()
        calc_screen_display += " " + math_symbol
        display_calculator_image(calc_screen_display)

        if math_symbol.lower() != "s": 
            second_number = get_second_number()
            calc_screen_display += " " + str(second_number)
            display_calculator_image(calc_screen_display)
            print(f"\tLets calculate {calc_screen_display}\n")
        else:
            print(f"\tLets calculate {first_number} Squared\n")


        if (math_symbol == '+'):
            calc_screen_display = first_number + second_number
        elif (math_symbol == '-'):
            calc_screen_display = first_number - second_number
        elif (math_symbol == '*'):
            calc_screen_display = first_number * second_number
        elif (math_symbol == '/'):
            calc_screen_display = first_number / second_number
        elif (math_symbol == 's' or math_symbol == 'S'):
            calc_screen_display = first_number * first_number
        else:
            calc_screen_display = "ERROR"

        display_calculator_image(calc_screen_display)
        print(f"\n\tThe total of your sum is {calc_screen_display}\n")
        print(DASHES)
        run_more_calculations = input("\n\tDo you want to make more calculations?\n\t('n for no, anything else to continue..) >> ")
        if run_more_calculations.lower() == 'n':
            break
        else:
            print(f"Oh cool, good choice {player_name}")
            continue



def main():
    """
    This is the initial function that runs welcome message
    asks for user name
    then runs game passing in player name
    when calculations are finished, we beg for snacks and lovely compliments
    """
    player_name = get_player_name()
    run_calculator(player_name)
    print("\tThanks for using my calculator!\n\tDont forget I accept donations in the way of snacks and compliments :)")

main()
