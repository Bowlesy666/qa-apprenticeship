import random

BANNER = """
     ____            _                   
    |  _ \\ ___   ___| | __               
    | |_) / _ \\ / __| |/ /               
    |  _ < (_) | (__|   <                
    |_|_\\_\\___/ \\___|_|\\_\\               
    |  _ \\ __ _ _ __   ___ _ __          
    | |_) / _` | '_ \\ / _ \\ '__|         
    |  __/ (_| | |_) |  __/ |            
    |_|   \\__,_| .__/ \\___|_|            
     ____      |_|                       
    / ___|  ___(_)___ ___  ___  _ __ ___ 
    \\___ \\ / __| / __/ __|/ _ \\| '__/ __|
     ___) | (__| \\__ \\__ \\ (_) | |  \\__ \\
    |____/ \\___|_|___/___/\\___/|_|  |___/
    """

ROCK = """
    _______
---'   ____)
      (_____)
      (_____)
      (____)
---.__(___)
"""

PAPER = """
    _______
---'   ____)____
          ______)
          _______)
         _______)
---.__________)
"""

SCISSORS = """
    _______         
---'   ____)____
          ______)
       __________)
      (____)
---.__(___)
"""

RPS = """

    _______         _______             _______  
---'   ____)    ---'   ____)____    ---'   ____)____
      (_____)             ______)             ______)
      (_____)             _______)         __________)
      (____)             _______)         (____)
---.__(___)     ---.__________)     ---.__(___)

"""

DASHES = "\n-------------------------------------------------------------------------\n"

USER_SCORE = 0
OPPONENT_SCORE = 0

def run_welcome_message():
    print(BANNER)
    print(RPS)


def goodbye():
    """
    Berbye now!
    """
    print(DASHES)
    print("\n\n\tThanks for using my Rock Paper Scissors Game!\n\tDont forget I accept donations in the way of snacks and compliments :)\n\n")
    print(DASHES)


def get_user_name():
    """
    greeting and takes user name input
    """
    print(DASHES)
    print("\tHey and welcome to my super duper Rock Paper Scissors Game.\n\tLet's get started...\n\n")
    user_name = input("\tWhat is your name? >> ").capitalize()
    print(f"{DASHES}\n\tNice to meet you {user_name}")

    return user_name


def get_user_menu_choice():
    """
    accepts user input choice 1 through to 3
    """
    while True:
        try:
            user_choice = int(input("\t>> "))
            if user_choice in [1, 2, 3]:
                return user_choice
            else:
                print("\n\t>> You dont make it easy on me do you! Choose options 1 up to 3!")
                continue
        except ValueError:
            print("\n\t>> You dont make it easy on me do you! Choose whole numbers 1 up to 3")


def run_again():
    """
    accepts user input
    continue with app or close
    """
    while True:
        check_again_input = input(
            f"\n\t>> Do you want to play again? (y/n)\n\t>> ").lower()
        if check_again_input not in ('y', 'n'):
            if len(check_again_input) >= 2:
                print("\t>> We're not writing an essay here, just use y or n...\n")
                continue
            else:
                print('\t>> Please use y or n ...its not difficult...\n')
                continue

        return True if check_again_input == 'y' else False
    

def display_menu():
    """
    displays menu items to user
    """
    MENU = f"""
    {DASHES}
    {RPS}
    \tGame Play Menu

    \t1- Rock
    \t2- Paper
    \t3- Scissors

    \t>> What is your choice? (1-3):
    """
    print(MENU)


def display_choice(user, choice):
    choices = {
        1: "Rock",
        2: "Paper",
        3: "Scissors"
    }
    if choice == 1:
        choice_icon = ROCK
    elif choice == 2:
        choice_icon = PAPER
    elif choice == 3:
        choice_icon = SCISSORS

    print(f"{user} chose {choices[choice]}!")
    print(choice_icon)


def check_for_winner(user_choice, computer_choice):
    """
    """
    if user_choice == computer_choice:
        return "It's a Tie!"
    elif ((user_choice == 1 and computer_choice == 3) or 
         (user_choice == 2 and computer_choice == 1) or 
         (user_choice == 3 and computer_choice == 2)):
        return "You win!"
    else:
        return "Computer wins!"


def update_score(game_result):
    global USER_SCORE, OPPONENT_SCORE

    if game_result == "You win!":
        USER_SCORE += 1
    elif game_result == "Computer wins!":
        OPPONENT_SCORE += 1
    
    print(game_result)
    

def display_scoreboard(user_name):
    global USER_SCORE, OPPONENT_SCORE

    scoreboard = f"""
    {DASHES}
    \tScoreboard:
    \t+----------------+-------+--------+
    \t| Name           | Wins  | Losses |
    \t+----------------+-------+--------+
    \t| {user_name:<14} | {USER_SCORE:<5} | {OPPONENT_SCORE:<6} |
    \t| Your opponent  | {OPPONENT_SCORE:<5} | {USER_SCORE:<6} |
    \t+----------------+-------+--------+
    {DASHES}
    """

    print(scoreboard)


def get_computer_choice():
    return random.choice([1,2,3])


def gameplay(user_name):
    while True:
        display_menu()
        user_choice = get_user_menu_choice()
        computer_choice = get_computer_choice()
        display_choice("You", user_choice)
        display_choice("Your opponent", computer_choice)
        update_score(check_for_winner(user_choice, computer_choice))
        display_scoreboard(user_name)

        if run_again():
            continue
        else:
            break

def main():
    """
    This is the initial function that runs welcome message
    asks for user name
    runs game
    exit message
    """
    run_welcome_message()
    user_name = get_user_name()
    gameplay(user_name)
    goodbye()

main()