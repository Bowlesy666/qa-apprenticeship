BANNER = """
      _____                __  __  U _____ u 
     |_ " _|     ___     U|' \\/ '|u\\| ___"|/ 
       | |      |_"_|    \\| |\\/| |/ |  _|"   
      /| |\\      | |      | |  | |  | |___   
     u |_|U    U/| |\\u    |_|  |_|  |_____|  
     _// \\\\_.-,_|___|_,-.<<,-,,-.   <<   >>  
    (__) (__)\\_)-' '-(_/  (./  \\.) (__) (__) 

       ____     _      _       ____  
    U /"___|U  /"\\  u |"|   U /"___| 
    \\| | u   \\/ _ \\/U | | u \\| | u   
     | |/__  / ___ \\ \\| |/__ | |/__  
      \\____|/_/   \\_\\ |_____| \\____| 
     _// \\\\  \\\\    >> //  \\\\ _// \\\\  
    (__)(__)(__)  (__)_")("_)__)(__) 
    """

DASHES = "\n-------------------------------------------------------------------------\n"

def run_welcome_message():
    print(BANNER)


def goodbye():
    """
    Berbye now!
    """
    print(DASHES)
    print("\n\n\tThanks for using my Time Calculator!\n\tDont forget I accept donations in the way of snacks and compliments :)\n\n")
    print(DASHES)


def get_user_name():
    """
    greeting and takes user name input
    """
    print(DASHES)
    print("\tHey and welcome to my super duper Time Calculator.\n\tLet's get started...\n\n")
    user_name = input("\tWhat is your name? >> ")
    print(f"{DASHES}\n\tNice to meet you {user_name}")


def display_menu():
    """
    displays menu items to user
    """
    MENU = f"""
    {DASHES}
    \tTime Calculator Menu

    \t1- Add 2 times
    \t2- Find the difference between 2 times
    \t3- Convert to Hours
    \t4- Convert to Minutes
    \t5- Convert Minutes to Time
    \t6- Convert Hours to Time
    \t7- Convert Days to Time
    \t8- Exit

    \t>> What is your choice? (1-8):
    """
    print(MENU)


def get_user_menu_choice():
    """
    accepts user input choice 1 through to 8
    """
    menu_choices = {
        1: "1. Add 2 times",
        2: "2. Find the difference between 2 times",
        3: "3. Convert to Hours",
        4: "4. Convert to Minutes",
        5: "5. Convert Minutes to Time",
        6: "6. Convert Hours to Time",
        7: "7. Convert Days to Time",
        8: "8. Exit",
    }

    while True:
        try:
            user_choice = int(input("\t>> "))
            if user_choice in [1, 2, 3, 4, 5, 6, 7, 8]:
                print(f"\n\t>> You have chosen {menu_choices[user_choice]}")
                return user_choice
            else:
                print("\n\t>> You dont make it easy on me do you! Choose options 1 up to 8!")
                continue
        except ValueError:
            print("\n\t>> You dont make it easy on me do you! Choose whole numbers 1 up to 8")


def normalise_raw_time_string(raw_time_string):
    """
    """
    # convert to string for below operations
    raw_time_string = str(raw_time_string)

    days = int(raw_time_string[:-4] or 0)
    hours = int(raw_time_string[-4:-2] or 0)
    minutes = int(raw_time_string[-2:])
    print(f"\n\t>> You entered - {days} Days, {hours} Hours and {minutes} Minutes")
    return [days, hours, minutes]


def normalise_timestring_to_(time, user_input):
    """
    """
    user_input = normalise_raw_time_string(user_input)

    if time == "hours":
        return (user_input[0] * 24) + user_input[1] + (user_input[2] // 60)
    if time == "minutes":
        return ((user_input[0] * 24) * 60) + (user_input[1] * 24) + user_input[2]


def normalise_result(raw_result):
    """
    """
    days, hours, minutes = raw_result

    if minutes >= 60:
        hours += int(minutes/60)
        minutes = minutes % 60
    elif minutes < 0:
        hours -= int(minutes/60) + 1
        minutes = minutes % 60

    if hours >= 24:
        days += int(hours/24)
        hours = hours % 24
    elif hours < 0:
        days -= 1
        hours = hours % 24

    return [days, hours, minutes]


def normalise_time_component(time_component, user_integer_input):
    """
    """
    if time_component == "minutes":
        return [(user_integer_input // (24 * 60)), ((user_integer_input % (24 * 60)) // 60), (user_integer_input % 60)]
    if time_component == "hours":
        return [(user_integer_input // 24), (user_integer_input % 24), 0]
    if time_component == "days":
        return [user_integer_input, 0, 0]


def get_time_string_input(input_count, operation):
    """
    """
    while True:
        try:
            return int(input(f"\n\t>> What is your {input_count}time string to {operation}?\n\t>> "))
        except ValueError:
            print("\n\t>> You dont make it easy on me do you! Expected timestring is in numbers only")
            print("\n\n\t\tEG. 12 days, 14 hours and 10 minutes")
            print("\t\t\tShould be 121410\n\n\tTry again please\n")


def get_integer_input(time_component):
    """
    """
    while True:
        try:
            return int(input(f"\n\t>> How many {time_component} do you want to convert to a timestring?\n\t>> "))
        except ValueError:
            print("\n\t>> You dont make it easy on me do you! I expected whole numbers only")
            print("\t\t\tTry again please\n")


def display_timestring_total(days_hours_minutes):
    """
    """
    days = days_hours_minutes[0]
    hours = days_hours_minutes[1]
    minutes = days_hours_minutes[2]
    print(f"\n\t>> The total is {days}:{hours}:{minutes} - {days} Days, {hours} Hours and {minutes} Minutes")


def display_specific_total(time_component, converted_time):
    """
    """
    print(f"\n\t>> The total is - {converted_time} {time_component}")


def add_times():
    """
    """
    time_string1 = normalise_raw_time_string(get_time_string_input("first ", "add"))
    time_string2 = normalise_raw_time_string(get_time_string_input("second ", "add"))

    raw_result = [(time_string1[0] + time_string2[0]), (time_string1[1] + time_string2[1]), (time_string1[2] + time_string2[2])]
    result = normalise_result(raw_result)

    return result


def subtract_times():
    """
    """
    time_string1 = normalise_raw_time_string(get_time_string_input("first ", "find the difference"))
    time_string2 = normalise_raw_time_string(get_time_string_input("second ", "find the difference"))

    raw_result = [(time_string1[0] - time_string2[0]), (time_string1[1] - time_string2[1]), (time_string1[2] - time_string2[2])]
    result = normalise_result(raw_result)

    return result


def convert_to_(time_component):
    """
    """
    if time_component == "hours":
        return normalise_timestring_to_("hours", get_time_string_input("", "convert to hours"))
    elif time_component == "minutes":
        return normalise_timestring_to_("minutes", get_time_string_input("", "convert to minutes"))
    elif time_component == "minutes to time":
        return normalise_time_component("minutes", get_integer_input("minutes"))
    elif time_component == "hours to time":
        return normalise_time_component("hours", get_integer_input("hours"))
    elif time_component == "days to time":
        return normalise_time_component("days", get_integer_input("days"))


def run_again():
    """
    accepts user input
    continue with app or close
    """
    while True:
        check_again_input = input(
            f"\n\t>> Do you want to run another calculation? (y/n)\n\t>> ").lower()
        if check_again_input not in ('y', 'n'):
            if len(check_again_input) >= 2:
                print("\t>> We're not writing an essay here, just use y or n...\n")
                continue
            else:
                print('\t>> Please use y or n ...its not difficult...\n')
                continue

        return True if check_again_input == 'y' else False


def main():
    """
    This is the initial function that runs welcome message
    asks for user name
    runs Time Calculator
    exit message
    """
    run_welcome_message()
    user_name = get_user_name()
    while True:
        display_menu()
        menu_choice = get_user_menu_choice()

        if menu_choice == 1:
            display_timestring_total(add_times())
        elif menu_choice == 2:
            display_timestring_total(subtract_times())
        elif menu_choice == 3:
            display_specific_total("hours", convert_to_("hours"))
        elif menu_choice == 4:
            display_specific_total("minutes", convert_to_("minutes"))
        elif menu_choice == 5:
            display_timestring_total(convert_to_("minutes to time"))
        elif menu_choice == 6:
            display_timestring_total(convert_to_("hours to time"))
        elif menu_choice == 7:
            display_timestring_total(convert_to_("days to time"))
        elif menu_choice == 8:
            break

        if run_again():
            continue
        else:
            break

    goodbye()

main()
