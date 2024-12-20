# Harder challenge (stretch goal): 

#       Create a Book class and BookShelf class that can be used to manage a collection of books. 
#       Create a Book class that has the following attributes: 
#       title (str), author (str), publisher (str), publication year (int). 
#       The class should also have a str method that returns the book's information in a 
#       formatted string. 
#       Create a BookShelf class that has the following attributes: 
#       capacity (int), list of books (list). 
#       The class should have the following methods: 
#       - add_book: adds a book to the list of books if the shelf is not full 
#       - remove_book: removes a book from the list of books if it exists on the shelf 
#       - find_book_by_title: searches for a book by its title 
#       and returns the book object if found 
#       - find_books_by_author: searches for books by a specific author 
#       and returns a list of book objects if found 
#       The class should also have a str method that returns a string representation 
#       of the books on the shelf. 

#Create four Book objects and add them to a BookShelf object with a capacity of three. 
#Test the BookShelf object by adding, removing, and finding books by title and author.
#Print the BookShelf object after each action.

class BookClass:
    def __init__(self, title: str, author: str, publisher: str, publication_year: int):
        self.title = title
        self.author = author
        self.publisher = publisher
        self.publication_year = publication_year

    def __str__(self):
        return f"{self.title}, by author: {self.author}, published by:{self.publisher} in {self.publication_year}"


class BookShelfClass:
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.book_list = []

    def add_book(self, book):
        if book not in self.book_list:
            if len(self.book_list) < self.capacity:
                self.book_list.append(book)
                print(f"Added {book.title} to shelf")
            else:
                print(f"Oops youve reached book shelf capacity: {self.capacity}")
        else:
            print(f"{book.title} is already on the shelf")

    def remove_book(self, book):
        if book in self.book_list:
            self.book_list.remove(book)
            print(f"Added {book.title} to shelf")
        else:
            print(f"{book.title} was not found on the shelf!")
    
    def find_book_by_title(self, book_title):
        for book in self.book_list:
            if book_title == book.title:
                return f"Book found! {book}"
        return "Book not found!"
    
    def find_book_by_author(self, book_author):
        books_by_author = [book for book in self.book_list if book_author == book.author]
        # for book in self.book_list:
        #     if book_author == book.author:
        #         books_by_author.append(book)
        
        if len(books_by_author) >= 1:
            return f"Books found by author {book_author} are {', '.join(str(book) for book in books_by_author)}"
        else:
            return "No books found by this author!"
        
    def __str__(self):
        return f"Book shelf capacity: {self.capacity}: {', '.join(str(book) for book in self.book_list)}"
    
book1 = BookClass("1984", "George Orwell", "Secker & Warburg", 1949)
book2 = BookClass("To Kill a Mockingbird", "Harper Lee", "J.B. Lippincott & Co.", 1960)
book3 = BookClass("The Great Gatsby", "F. Scott Fitzgerald", "Charles Scribner's Sons", 1925)
book4 = BookClass("Moby Dick", "Herman Melville", "Harper & Brothers", 1851)

print("\n\n\nBook Shelf 1\n")
shelf = BookShelfClass(3)
shelf.add_book(book1)
shelf.add_book(book2)
shelf.add_book(book3)
shelf.add_book(book4)


book5 = BookClass("The Expanse: Leviathan Wakes", "James S.A. Corey", "Orbit", 2011)
book6 = BookClass("The Expanse: Caliban's War", "James S.A. Corey", "Orbit", 2012)
book7 = BookClass("The Hollow Chocolate Bunnies of the Apocalypse", "Robert Rankin", "Gollancz", 2002)
book8 = BookClass("John Dies at the End", "David Wong", "Thomas Dunne Books", 2007)

shelf2 = BookShelfClass(3)
shelf2.add_book(book5)
shelf2.add_book(book6)
shelf2.add_book(book7)
shelf2.add_book(book8)
print("\n\n")

print(shelf2)
print("\n\n")

shelf2.remove_book(book2)
print(shelf2)
print("\n\n")

print(shelf2.find_book_by_title("The Expanse: Leviathan Wakes"))
print(shelf2.find_book_by_title("Unknown Book"))
print("\n\n")

print(shelf2.find_book_by_author("James S.A. Corey"))
print(shelf2.find_book_by_author("Unknown Author"))
print("\n\n")

print(shelf2)
    