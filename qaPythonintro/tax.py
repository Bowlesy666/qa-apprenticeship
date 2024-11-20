def getIncomeTax(salary):
    if salary <= 11850:
        return 0
    elif salary > 11850:
        amount_to_tax = salary - 11850

        if salary <= 34500:
            return amount_to_tax * 0.2
        elif salary <= 150000:
            return amount_to_tax * 0.4
        else:
            return amount_to_tax * 0.45

print(getIncomeTax(11900))
