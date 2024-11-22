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
