import random

class RpsGameClass:

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

    def __init__(self):
        self.user_score = 0
        self.opponent_score = 0
        self.game_counter = 0
        self.user_name = ""

    def run_welcome_message(self):
        print(self.BANNER)
        print(self.RPS)


    def goodbye(self):
        """
        Berbye now!
        """
        print(self.DASHES)
        print("\n\n\tThanks for using my Rock Paper Scissors Game!\n\tDont forget I accept donations in the way of snacks and compliments :)\n\n")
        print(self.DASHES)


    def get_user_name(self):
        """
        greeting and takes user name input
        """
        print(self.DASHES)
        print("\tHey and welcome to my super duper Rock Paper Scissors Game.\n\tLet's get started...\n\n")
        self.user_name = input("\tWhat is your name? >> ").capitalize()
        print(f"{self.DASHES}\n\tNice to meet you {self.user_name}")


    def get_user_menu_choice(self):
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


    def run_again(self):
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
        

    def display_menu(self):
        """
        displays menu items to user
        """
        MENU = f"""
        {self.DASHES}
        {self.RPS}
        \tGame Play Menu

        \t1- Rock
        \t2- Paper
        \t3- Scissors

        \t>> What is your choice? (1-3):
        """
        print(MENU)


    def display_choice(self, user, choice):
        choices = {
            1: "Rock",
            2: "Paper",
            3: "Scissors"
        }
        if choice == 1:
            choice_icon = self.ROCK
        elif choice == 2:
            choice_icon = self.PAPER
        elif choice == 3:
            choice_icon = self.SCISSORS

        print(f"{user} chose {choices[choice]}!")
        print(choice_icon)


    def check_for_winner(self, user_choice, computer_choice):
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


    def update_score(self, game_result):
        if game_result == "You win!":
            self.user_score += 1
        elif game_result == "Computer wins!":
            self.opponent_score += 1
        
        self.game_counter += 1
        
        print(game_result)
        

    def display_scoreboard(self):
        overall_winner_message = f"{self.user_name} you are the overall winner so far!" if self.user_score > self.opponent_score else ""

        scoreboard = f"""
        {self.DASHES}
        \tScoreboard: {self.game_counter} games played!
        \t+----------------+-------+--------+
        \t| Name           | Wins  | Losses |
        \t+----------------+-------+--------+
        \t| {self.user_name:<14} | {self.user_score:<5} | {self.opponent_score:<6} |
        \t| Your opponent  | {self.opponent_score:<5} | {self.user_score:<6} |
        \t+----------------+-------+--------+
        
        \t{overall_winner_message}
        {self.DASHES}
        """

        print(scoreboard)


    def get_computer_choice(self):
        return random.choice([1,2,3])


    def gameplay(self):
        while True:
            self.display_menu()
            user_choice = self.get_user_menu_choice()
            computer_choice = self.get_computer_choice()
            self.display_choice("You", user_choice)
            self.display_choice("Your opponent", computer_choice)
            self.update_score(self.check_for_winner(user_choice, computer_choice))
            self.display_scoreboard()

            if self.run_again():
                continue
            else:
                break

    def main(self):
        """
        This is the initial function that runs welcome message
        asks for user name
        runs game
        exit message
        """
        self.run_welcome_message()
        self.get_user_name()
        self.gameplay()
        self.goodbye()

# main()
if __name__ == "__main__":
    game = RpsGameClass()
    game.main()