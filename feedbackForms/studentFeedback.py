# import os
# os.system(f"notepad 1{name}.txt")
import os
from feedbackText.feedback_templates import feedback_templates
import random


class Student:
    def __init__(self, name):
        self.name = name
        self.answers = {}

    def add_answer(self, question, answer):
        self.answers[question] = answer

    def __str__(self):
        return f"Student: {self.name}, Answers: {self.answers}"
    

class Question:
    def __init__(self):
        self.questions = [
            "Understanding level (1-5)",
            "Contribution level (1-5)",
            "Lab completion level (1-5)",
            "Engagement level (1-5)",
            "Punctuality level (1-5)",
            "Further-learning level (1-5)"
        ]

    def get_questions(self):
        return self.questions
    

class FeedbackGenerator:
    def __init__(self):
        self.students = []
        self.questions = Question().get_questions()
        self.feedback_templates = feedback_templates

    def add_student(self, student):
        self.students.append(student)

    def generate_feedback_text(self, question, score):
        templates = self.feedback_templates[question][score]
        return random.choice(templates)

    def generate_feedback(self, student):
        feedback = ""

        general_comments = f"General comments\n{student.name} "
        punctuality_engagement = f"Learner Punctuality and engagement\n{student.name} "
        further_learning = "Recommendations on further learning\n"

        for question, answer in student.answers.items():
            if student.name.lower() in ['david bowles']:
                answer = 5 # Easter egg ;)
            feedback_text = self.generate_feedback_text(question, answer)
            match question:
                case "Understanding level (1-5)":
                    general_comments += feedback_text + " "
                case "Contribution level (1-5)":
                    prefixed_text = self.generate_feedback_text("general_comments_prefix", 0) + feedback_text + " "
                    general_comments += prefixed_text
                case "Lab completion level (1-5)":
                    prefix = self.generate_feedback_text("general_comments_prefix", 1)
                    general_comments += prefix + feedback_text + " "
                case "Engagement level (1-5)":
                    punctuality_engagement += feedback_text + " "
                case "Punctuality level (1-5)":
                    prefix = self.generate_feedback_text("punctuality_engagement_prefix", 0)
                    punctuality_engagement += prefix + feedback_text + " "
                case "Further-learning level (1-5)":
                    prefix = self.generate_feedback_text("punctuality_engagement_prefix", 0)
                    further_learning += prefix + student.name  + " " + feedback_text

        feedback += f"\nFeedback for {student.name}:\n"
        feedback += general_comments.strip() + "\n\n"
        feedback += punctuality_engagement.strip() + "\n\n"
        feedback += further_learning.strip() + "\n"

        return feedback

    def confirm_feedback(self, feedback):
        print(feedback)
        confirm = input("\n\tIs this feedback acceptable? (y/n):\n\ttyping anything other than 'y' will generate again) >> ").lower()
        return confirm == 'y'

    def save_feedback(self, student_name, feedback):
        filename = f"StudentFeedbackFiles/{student_name}_feedback.txt"
        with open(filename, 'w') as file:
            file.write(feedback)


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

    def display_student_list_menu(self):
        menu = f"""
        {self.DASHES}
        \n\tHey Chris, How do you want to enter the names?
        \n\t1. Enter as comma seperated values
        \n\t2. Enter individual names

        {self.DASHES}
        """

        print(menu)

    DASHES = "\n-------------------------------------------------------------------------\n"

    def run_welcome_message(self):
        print(self.BANNER)

    def goodbye(self):
        """
        Berbye now!
        """
        print(self.DASHES)
        print("\n\n\tThanks for using my Feedback Cheat Sheet!\n\tDont forget I accept donations in the way of snacks, compliments and increased grades! :)\n\n")
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
            students_csv = input("\n\tEnter student names as comma-separated values: ")
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
            print("\n\tEnter student names one by one. Type 'done' or enter an empty name when finished.")
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
        if chosen_input_style == 1:
            student_names = self.get_students_as_csv()
        elif chosen_input_style == 2:
            student_names = self.get_students_individually()
        
        for name in student_names:
            self.feedback_generator.add_student(Student(name))
        
    def collect_student_answers(self):
        for student in self.feedback_generator.students:
            print(f"\n\tCollecting answers for {student.name}:")
            print("\t1. Poor | 2. Improvement needed | 3. Average | 4. Good | 5. Outstanding\n")
            for question in self.feedback_generator.questions:
                while True:
                    try:
                        answer = int(input(f"\t{question} >> ").strip())
                        if 1 <= answer <= 5:
                            student.add_answer(question, answer)  # Adding answer to the dictionary
                            break
                        else:
                            print("\tPlease enter a number between 1 and 5.")
                    except ValueError:
                        print("\tInvalid input. Please enter a number between 1 and 5.")
            # Generate and confirm feedback for the current student
            while True:
                feedback = self.feedback_generator.generate_feedback(student)
                if self.feedback_generator.confirm_feedback(feedback):
                    self.feedback_generator.save_feedback(student.name, feedback)
                    break
    
    def main(self):
        """
        This is the initial function that runs welcome message
        asks for list of users
        runs application
        exit message
        """
        self.run_welcome_message()
        self.get_student_list()
        self.collect_student_answers()
        
        self.goodbye()

if __name__ == "__main__":
    studentFeedbackGenerator = StudentFeedbackClass()
    studentFeedbackGenerator.main()
