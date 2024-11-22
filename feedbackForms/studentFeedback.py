from studentClass import Student
from feedbackGeneratorClass import FeedbackGenerator
from questionClass import Question


class StudentFeedbackClass:
    def __init__(self):
        self.feedback_generator = FeedbackGenerator()
    
    BANNER = """
      ____  _          _     _   _____             _ _                _    
     / ___|| |__  _ __(_)___( ) |  ___|__  ___  __| | |__   __ _  ___| | __
    | |    | '_ \\| '__| / __|/  | |_ / _ \\/ _ \\/ _` | '_ \\ / _` |/ __| |/ /
    | |___ | | | | |  | \\__ \\   |  _|  __/  __/ (_| | |_) | (_| | (__|   < 
     \\____||_| |_|_|  |_|___/_  |_|__\\___|\\___|\\__,_|_.__/ \\__,_|\\___|_|\\_\\
     / ___|| |__   ___  __ _| |_/ ___|| |__   ___  ___| |_                 
    | |    | '_ \\ / _ \\/ _` | __\\___ \\| '_ \\ / _ \\/ _ \\ __|                
    | |___ | | | |  __/ (_| | |_ ___) | | | |  __/  __/ |_                 
     \\____||_| |_|\\___|\\__,_|\\__|____/|_| |_|\\___|\\___|\\__|                
    """
    GOODBYE_MESSAGE = """
        _           _____             __  __            _        
       / \\  __/\\__ |_   _|__  _ __   |  \\/  | __ _ _ __| | _____ 
      / _ \\ \\    /   | |/ _ \\| '_ \\  | |\\/| |/ _` | '__| |/ / __|
     / ___ \\/_  _\\   | | (_) | |_) | | |  | | (_| | |  |   <\\__ \\
    /_/   \\_\\ \\/     |_|\\___/| .__/  |_|  |_|\\__,_|_|  |_|\\_\\___/
                             |_|
    """

    def display_student_list_menu(self):
        menu = f"""
        {self.DASHES}
        \n\tHey Chris, How do you want to enter the names?
        \n\t1. Enter as comma seperated values
        \n\t2. Enter individual names

        """

        print(menu)

    DASHES = "\n-------------------------------------------------------------------------\n"

    def run_welcome_message(self):
        print(self.BANNER)

    def run_again(self):
        """
        accepts user input
        continue with app or close
        """
        while True:
            check_again_input = input(
                f"\n\t>> Do you want to complete more student feedback? (y/n)\n\t>> ").lower()
            if check_again_input not in ('y', 'n'):
                if len(check_again_input) >= 2:
                    print("\t>> We're not writing an essay here, just use y or n...\n")
                    continue
                else:
                    print('\t>> Please use y or n ...its not difficult...\n')
                    continue

            return True if check_again_input == 'y' else False

    def goodbye(self):
        """
        Berbye now!
        """
        print(self.DASHES)
        print("\n\n\tThanks for using my Feedback Cheat Sheet!\n\tDont forget I accept donations in the way of snacks, compliments and increased grades! :)\n\n")
        print(self.GOODBYE_MESSAGE)
        print(self.DASHES)

    def get_list_menu_choice(self):
        """
        accepts user input choice 1 or 2
        """
        while True:
            try:
                user_choice = int(input("\t>> "))
                if user_choice in [1, 2]:
                    return user_choice
                else:
                    print("\n\t>> You dont make it easy on me do you! Choose option 1 or 2!")
                    continue
            except ValueError:
                print("\n\t>> You dont make it easy on me do you! Choose option 1 or 2!")

    def get_students_as_csv(self):
        while True:
            students_csv = input("\n\tYou chose to enter student names as comma-separated values:\n\n\t** eg David Bowles, Chris Reeves, Donald Duck **\n")
            student_list = [name.strip().capitalize() for name in students_csv.split(',')]
            print(f"\n\tStudent names: {student_list}")
            confirm = input("\n\tIs this list correct? (y/n): ").lower()
            if confirm == 'y':
                return student_list
            else:
                print("\n\tSilly sausage! Let's try again.")

    def get_students_individually(self):
        while True:
            student_list = []
            print("\n\tYou chose to enter student names one by one.\n\n\t** Hit enter after each name **\n\t** Type 'done' or enter an empty string when finished. **\n")
            while True:
                student_name = input("\t>> ").strip().capitalize()
                if student_name.lower() == 'done' or student_name == '':
                    break
                student_list.append(student_name)
            
            print(f"\n\tStudent names: {student_list}")
            confirm = input("\n\tIs this list correct? (y/n): ").lower()
            if confirm == 'y':
                return student_list
            else:
                print("\n\tSilly sausage! Let's try again.")

    def get_student_list(self):
        self.display_student_list_menu()
        chosen_input_style = self.get_list_menu_choice()
        print(self.DASHES)

        if chosen_input_style == 1:
            student_names = self.get_students_as_csv()
        elif chosen_input_style == 2:
            student_names = self.get_students_individually()
        
        for name in student_names:
            self.feedback_generator.add_student(Student(name))
        
    def collect_student_answers(self):
        for student in self.feedback_generator.students:
            print(f"\n\tCollecting answers for {student.name}:")
            print("\t1. Poor | 2. Improvement needed | 3. Average | 4. Good | 5. Outstanding")
            print("\n\t** Use the legend above to help you rank the student for each question 1 to 5 **\n")
            for question in self.feedback_generator.questions:
                while True:
                    try:
                        answer = int(input(f"\t{question} >> ").strip())
                        if 1 <= answer <= 5:
                            student.add_answer(question, answer)
                            break
                        else:
                            print("\tPlease enter a number between 1 and 5.")
                    except ValueError:
                        print("\tInvalid input. Please enter a number between 1 and 5.")
            while True:
                print(self.DASHES)
                feedback = self.feedback_generator.generate_feedback(student)
                confirm_feedback = self.feedback_generator.confirm_feedback(feedback)
                if confirm_feedback:
                    self.feedback_generator.save_feedback(student.name, feedback)
                    if confirm_feedback[1] in ['edit', 'open']:
                        print("\n\n\t** Opening file on your system... **")
                        print("\n\n\t** Save and close the file to continue... **")
                        self.feedback_generator.open_feedback_file(student)
                    print(self.DASHES)
                    break
    
    def main(self):
        """
        This is the initial function that runs welcome message
        asks for list of users
        runs application
        exit message
        """
        self.run_welcome_message()
        while True:
            self.get_student_list()
            self.collect_student_answers()

            if self.run_again():
                continue
            else:
                break
        
        self.goodbye()

if __name__ == "__main__":
    studentFeedbackGenerator = StudentFeedbackClass()
    studentFeedbackGenerator.main()
