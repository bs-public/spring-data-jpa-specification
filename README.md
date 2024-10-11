# spring-data-jpa-specification

Dynamic filtering with JPA Specifications


http://localhost:8080/books?title=1984

    [
        {
            "title": "1984",
            "author": {
                "firstName": "George",
                "lastName": "Orwell",
                "nationality": "British",
                "biography": "George Orwell was an English novelist, essayist, journalist and critic."
            },
            "publishedDate": "1949-06-08",
            "isbn": "9780451524935",
            "pages": 328,
            "language": "English",
            "publisher": "Secker & Warburg",
            "genre": "Dystopian"
        }
    ]

http://localhost:8080/books?language=English&genre=Adventure

    [
        {
            "title": "Adventures of Huckleberry Finn",
            "author": {
                "firstName": "Mark",
                "lastName": "Twain",
                "nationality": "American",
                "biography": "Mark Twain was an American writer, humorist, entrepreneur, publisher, and lecturer."
            },
            "publishedDate": "1884-12-10",
            "isbn": "9780486280615",
            "pages": 366,
            "language": "English",
            "publisher": "Chatto & Windus",
            "genre": "Adventure"
        }
    ]
