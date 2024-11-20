import math

BANNER = """
    ______   __  __     ______   __  __     ______     ______     ______     ______     ______     ______      
    /\\  == \\ /\\ \\_\\ \\   /\\__  _\\ /\\ \\_\\ \\   /\\  __ \\   /\\  ___\\   /\\  __ \\   /\\  == \\   /\\  __ \\   /\\  ___\\     
    \\ \\  _-/ \\ \\____ \\  \\/_\\ \\ \\/ \\ \\  __ \\  \\ \\  __ \\  \\ \\ \\__ \\  \\ \\ \\/\\ \\  \\ \\  __<   \\ \\  __ \\  \\ \\___  \\    
     \\ \\_\\    \\/\\_____\\    \\ \\_\\  \\ \\_\\ \\_\\  \\ \\_\\ \\_\\  \\ \\_____\\  \\ \\_____\\  \\ \\_\\ \\_\\  \\ \\_\\ \\_\\  \\/\\_____\\   
      \\/_/     \\/_____/     \\/_/   \\/_/\\/_/   \\/_/\\_/   \\/_____/   \\/_____/   \\/_/ /_/   \\/_/\\_/   \\/_____/   
                                                                                                            
     ______     ______     __         ______     __  __     __         ______     ______   ______     ______    
    /\\  ___\\   /\\  __ \\   /\\ \\       /\\  ___\\   /\\ \\/\\ \\   /\\ \\       /\\  __ \\   /\\__  _\\ /\\  __ \\   /\\  == \\   
    \\ \\ \\____  \\ \\  __ \\  \\ \\ \\____  \\ \\ \\____  \\ \\ \\_\\ \\  \\ \\ \\____  \\ \\  __ \\  \\/_/\\ \\/ \\ \\ \\/\\ \\  \\ \\  __<   
     \\ \\_____\\  \\ \\_\\ \\_\\  \\ \\_____\\  \\ \\_____\\  \\ \\_____\\  \\ \\_____\\  \\ \\_\\ \\_\\    \\ \\_\\  \\ \\_____\\  \\ \\_\\ \\_\\ 
      \\/_____/   \\/_/\\/_/   \\/_____/   \\/_____/   \\/_____/   \\/_____/   \\/_/\\/_/     \\/_/   \\/_____/   \\/_/ /_/ 
    """
DASHES = "\n-------------------------------------------------------------------------\n"

def run_welcome_message():
    print(BANNER)

def goodbye():
    """
    Berbye now!
    """
    print(DASHES)
    print("\n\n\tThanks for using my Pythagoras Calculator!\n\tDont forget I accept donations in the way of snacks and compliments :)\n\n")
    print(DASHES)

def get_user_name():
    """
    greeting and takes user name input
    """
    print(DASHES)
    print("\tHey and welcome to my super duper Pythagoras Calculator.\n\tLet's get started...\n\n")
    user_name = input("\twhat is your name? >> ")
    print(f"{DASHES}\n\tNice to meet you {user_name}")

def display_menu():
    """
    displays menu items to user
    """
    MENU = """
    \tPythagoras Calculator Menu

    \t1. Find the length of A given B and C
    \t2. Find the length of B given A and C
    \t3. Find the length of C given A and B

    \t>> What is your choice? (1,2,3):
    """
    print(MENU)

def get_user_menu_choice():
    """
    accepts user input choice 1, 2 or 3
    """
    menu_choices = {
        1: "1. Find the length of A given B and C",
        2: "2. Find the length of B given A and C",
        3: "3. Find the length of C given A and B"
    }

    while True:
        try:
            user_choice = int(input("\t>> "))
            if user_choice in [1, 2, 3]:
                print(f"\n\t>> You have chosen {menu_choices[user_choice]}")
                return user_choice
            else:
                print("\n\t>> You dont make it easy on me do you! Choose 1, 2 or 3!")
                continue
        except ValueError:
            print("\n\t>> You dont make it easy on me do you! Choose 1, 2 or 3!")

def run_length_c_sum(length1, length2):
    return ((length1**2) + (length2**2))

def run_length_a_or_b_sum(length1, length2):
    if length1**2 >= length2**2:
        return math.sqrt(length1**2 - length2**2)
    else:
        return math.sqrt(length2**2 - length1**2)

def run_calculation(menu_choice):
    """
    """
    while True:
        if menu_choice == 1:
            # Find length A
            length2 = 'B'
            length3 = 'C'
        elif menu_choice == 2:
            # Find length B
            length2 = 'A'
            length3 = 'C'
        elif menu_choice == 3:
            # Find length C
            length2 = 'A'
            length3 = 'B'

        try:
            length2_input = int(input(f"\n\t>> what is the known length of side {length2}\n\t>> "))
            length3_input = int(input(f"\n\t>> what is the known length of side {length3}\n\t>> "))
        except ValueError:
            print("\n\t>> Enter only whole numbers silly!\n")

        if menu_choice == 1 or menu_choice == 2:
            return run_length_a_or_b_sum(length2_input, length3_input)
        elif menu_choice == 3:
            return run_length_c_sum(length2_input, length3_input)

def display_calculation(menu_choice, calculated_side_length):
    """
    """
    length_to_find_choices = {
        1: "A",
        2: "B",
        3: "C"
    }

    display = f"""
    \t__________________________________________________________

    \t\tThe length of side '{length_to_find_choices[menu_choice]}' is {calculated_side_length}      
    \t__________________________________________________________
    
    """

    print(display)

def calculate_again():
    """
    accepts user input
    continue with app or close
    """
    while True:
        check_again_input = input(
            f"\t>> Do you want to create another calculation? (y/n)\n\t>> ").lower()
        if check_again_input not in ('y', 'n'):
            if len(check_again_input) >= 2:
                print("\t>> We're not writing an essay here, just use y or n...\n")
                continue
            else:
                print('\t>> Please use y or n ...its not difficult...\n')
                continue

        return True if check_again_input == 'y' else False

def run_calculator(user_name):
    """
    """
    while True:
        display_menu()
        menu_choice = get_user_menu_choice()
        calculated_side_length =run_calculation(menu_choice)
        display_calculation(menu_choice, calculated_side_length)

        if calculate_again():
            continue
        else:
            break

def main():
    """
    This is the initial function that runs welcome message
    asks for user name
    runs pythagoras calculator
    exit message
    """
    run_welcome_message()
    user_name = get_user_name()
    run_calculator(user_name)
    goodbye()

main()