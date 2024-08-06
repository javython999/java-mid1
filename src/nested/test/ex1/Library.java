package nested.test.ex1;

public class Library {

    private int bookCount;
    private Book[] bookList;

    public Library(int size) {
        this.bookCount = 0;
        this.bookList = new Book[size] ;
    }

    public void addBook(String title, String author) {

        if (bookCount >= bookList.length) {
            System.out.println("도서관 저장 공간이 부족합니다.");
            return;
        }

        bookList[bookCount++] = new Book(title, author);
    }

    public void showBooks() {
        System.out.println("== 책 목록 출력 ==");
        for (int i = 0; i < bookCount; i++) {
            System.out.println("도서 제목: " +bookList[i].title + ", 저자: " + bookList[i].author);
        }
    }

    private static class Book {
        String title;
        String author;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }
    }

}
