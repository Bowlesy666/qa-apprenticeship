from csv import reader

# month_headings = []
companies = []
sales = []

with open("output.csv") as csvfile:
    reader = reader(csvfile)
    next(reader) # skip the headings line

    for row in reader:
        companies.append(row[0])
        sales.append([int(x.replace(',', "")) for x in row[1:]])

print(companies)
print(sales)


monthly_sum = [sum(x) for x in zip(*sales)]
print(monthly_sum)

yearly_sum = {}
for x in range(len(companies)):
    yearly_sum[companies[x]] = sum(sales[x])

for company, sales in yearly_sum.items():
    print(company, ":", sales)
