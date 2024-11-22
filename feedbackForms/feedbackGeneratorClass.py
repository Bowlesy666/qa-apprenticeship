import os
from feedbackText.feedback_templates import feedback_templates
from questionClass import Question
import random


class FeedbackGenerator:
    def __init__(self):
        self.students = []
        self.questions = Question().get_questions()
        self.feedback_templates = feedback_templates
        self.feedback_dir = "StudentFeedbackFiles"
        if not os.path.exists(self.feedback_dir):
            os.makedirs(self.feedback_dir)

    def add_student(self, student):
        self.students.append(student)

    def generate_feedback_text(self, question, score):
        templates = self.feedback_templates[question][score]
        return random.choice(templates)

    def generate_feedback(self, student):
        feedback = ""

        general_comments = f"General comments:\n{student.name} "
        punctuality_engagement = f"Learner Punctuality and engagement:\n{student.name} "
        further_learning = "Recommendations on further learning:\n"

        for question, answer in student.answers.items():
            if student.name.lower() in ['david bowles', 'david b', 'david', 'bowles', 'bowlesy']:
                answer = 5 # Easter egg ;)
            feedback_text = self.generate_feedback_text(question, answer)
            match question:
                case "Understanding level (1-5)":
                    general_comments += feedback_text
                case "Contribution level (1-5)":
                    prefixed_text = self.generate_feedback_text("general_comments_prefix", 0) + feedback_text
                    general_comments += prefixed_text
                case "Lab completion level (1-5)":
                    prefix = self.generate_feedback_text("general_comments_prefix", 1)
                    general_comments += prefix + feedback_text
                case "Engagement level (1-5)":
                    punctuality_engagement += feedback_text
                case "Punctuality level (1-5)":
                    prefix = self.generate_feedback_text("punctuality_engagement_prefix", 0)
                    punctuality_engagement += prefix + feedback_text
                case "Further-learning level (1-5)":
                    prefix = self.generate_feedback_text("further_learning_prefix", 0)
                    further_learning += prefix + student.name  + " " + feedback_text

        feedback += f"Feedback for {student.name}:\n\n"
        feedback += general_comments.strip() + "\n\n"
        feedback += punctuality_engagement.strip() + "\n\n"
        feedback += further_learning.strip() + "\n"

        return feedback

    def confirm_feedback(self, feedback):
        print(feedback)
        confirm = input("\n\tIs this feedback acceptable? (y/n):\n\ttyping anything other than 'y' yes edit open will generate again) >> ").lower()

        if confirm in ['y', 'yes', 'edit', 'open']:
            return True, confirm

    def save_feedback(self, student_name, feedback):
        filename = f"StudentFeedbackFiles/{student_name}_feedback.txt"
        with open(filename, 'w') as file:
            file.write(feedback)
        print(f"\n\n\t** File successfully saved for {student_name} as {filename} **")

    def open_feedback_file(self, student_name):
        filename = os.path.join(self.feedback_dir, f"{student_name.name}_feedback.txt")
        absolute_path = os.path.abspath(filename)
        print(absolute_path)
        os.system(f"notepad {absolute_path}")
