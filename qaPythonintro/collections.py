books = {"author1": ["book1", "book2"], "author2": ["book3", "book4"], "author3": ["book5", "book6"]}

user_input = input("Enter an authers name: >> ")

print(f"You chose {user_input}")
author = books.get(user_input, [])
print(", ".join(author) or "Author not found")
