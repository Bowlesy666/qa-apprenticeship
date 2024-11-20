DASHES = "\n-------------------------------------------------------------------------\n"
def get_user_name():
    """
    greeting and takes user name input
    """
    print(DASHES)
    print("\tHey and welcome to my super duper exam grade checker.\n\tLet's get started...\n\n")
    user_name = input("\twhat is your name? >> ")
    print(f"{DASHES}\n\tNice to meet you {user_name}")

def get_exam_mark():
    """
    takes user input for exam marks
    accepts integer between 1 and 100
    """
    while True:
        try:
            exam_mark = int(input("\t>> what is the students exam mark?\n\t>> "))
            if exam_mark < 1 or exam_mark > 100:
                print("\n\t>> Lets stick to the script here, between 1 and 100 please!\n")
                continue
            else:
                return exam_mark
        except ValueError:
            print("\n\t>> Enter only whole numbers silly!\n")
            continue

def check_exam_grade(exam_mark):
    """
    returns grade related to exam mark
    """
    if exam_mark < 50:
        return "Fail"
    elif exam_mark < 60:
        return "Pass"
    elif exam_mark < 70:
        return "Merit"
    elif exam_mark <= 100:
        return "Distinction"
    else:
        return "ERROR!"

def display_grade(exam_mark, exam_grade):
    """
    display exam mark and grade in table format
    """
    marks_value = f"{exam_mark:^14}"
    grade_value = f"{exam_grade:^14}"

    display = f"""
    \t______________________________
    \t|  Exam Marks  |  Exam Grade  |
    \t______________________________
    \t|{marks_value}|{grade_value}|
    \t______________________________
    """

    print(display)

def check_another_grade():
    """
    accepts user input
    continue with app or close
    """
    while True:
        check_again_input = input(
            f"\t>> Do you want to check another grade? (y/n)\n\t>> ").lower()
        if check_again_input not in ('y', 'n'):
            if len(check_again_input) >= 2:
                print("\t>> We're not writing an essay here, just use y or n...\n")
                continue
            else:
                print('\t>> Please use y or n ...its not difficult...\n')
                continue

        return True if check_again_input == 'y' else False

def run_exam_checker(user_name):
    """
    runs main functions of the exam checker
    """
    while True:
        exam_mark = get_exam_mark()
        exam_grade = check_exam_grade(exam_mark)
        display_grade(exam_mark, exam_grade)

        if check_another_grade():
           print(DASHES)
           continue
        else:
            break

def goodbye():
    """
    Berbye now!
    """
    print(DASHES)
    print("\n\n\tThanks for using my exam grade checker!\n\tDont forget I accept donations in the way of snacks and compliments :)\n\n")
    print(DASHES)

    
def main():
    """
    This is the initial function that runs welcome message
    asks for user name
    runs exam grade checker
    exit message
    """
    user_name = get_user_name()
    run_exam_checker(user_name)
    goodbye()

main()
