from csv import reader

def main():
    with open("outpu.csv", 'r') as output_file:
        for line in output_file:
            print(line)

main()