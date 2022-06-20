package UE02_LibraryHash;

import java.io.BufferedReader;
import java.io.FileReader;

public class LibraryHash {
    private String[] books;

    // Konstruktor
    public LibraryHash(int size) {
        books = new String[size];
    }

    // Bücher aus einer Textdatei einlesen
    public void addBooksFromFile() {
        String line;
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("books.txt"));

            while ((line = br.readLine()) != null) {
                add(line);
            }

            br.close();
        } catch (Exception | HashFullException e) {
            e.printStackTrace();
        }
    }

    // Ein Buch zur Hashtable hinzufügen
    public void add(String bookTitle) throws HashFullException {
//        int pos = bookTitle.hashCode() % books.length;
//        if (books[pos] == null) {
//            books[pos] = bookTitle;
//        } else {
//            while (books[pos] != null) {
//                pos = (bookTitle.hashCode() + 1) % books.length;
//            }
//        }
        int hashValue;
        for (int i = 0; i < books.length; i++) {
            hashValue = (Math.abs(bookTitle.hashCode()) + i) % books.length;
            //Ist mein berechter platz noch frei?
            if (books[hashValue] == null) {
                books[hashValue] = bookTitle;
                return;
            }

        }


    }

    // Ein Buch aus der Hashtable entfernen
    public Boolean remove(String bookTitle) {

        int hashValue = 0;
        for (int i = 0; i < books.length; i++) {
            // position per hash berechnen
            hashValue = Math.abs(bookTitle.hashCode() + i) % books.length;
            if (books[hashValue] == null) {
                return false;
            } else if (books[hashValue].equals(bookTitle)) {
                books[hashValue] = null;
                return true;
            }
        }
        return false;
    }

    // Abfrage, ob ein bestimmtes Buch in der Hashtable vorhanden ist
    public Boolean isBookInStock(String bookTitle) {
        int hashValue = 0;
        for (int i = 0; i < books.length; i++) {
            //position errechnen
            hashValue = (Math.abs(bookTitle.hashCode()) + i) % books.length;
            if (books[hashValue] == null)
                return false;
            //ist an der errechtneten position das gesuchte buch?
            if (books[hashValue].equals(bookTitle)) {
                return true;
            }
        }
        return false;
    }
}
