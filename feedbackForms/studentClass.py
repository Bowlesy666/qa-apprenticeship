class Student:
    def __init__(self, name):
        self.name = name
        self.answers = {}

    def add_answer(self, question, answer):
        self.answers[question] = answer

    def __str__(self):
        return f"Student: {self.name}, Answers: {self.answers}"
