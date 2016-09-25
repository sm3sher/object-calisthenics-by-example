package pl.timbercode.books_and_bits.before;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import static java.lang.String.format;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

// FIXME Rule 7. Keep All Entities Small (84 lines - 19 FIXME comments = 65 lines > max 50 lines allowed)
// FIXME Rule 3. Wrap All Primitives And Strings
class BooksAndBits {

    // FIXME Rule 4. First Class Collections
    private Map<String, Set<Book>> books = new HashMap<>();

    // FIXME Rule 3. Wrap All Primitives And Strings
    void registerReader(String reader) {
        books.put(reader, new TreeSet<>());
    }

    // FIXME Rule 3. Wrap All Primitives And Strings
    public Set<String> getBooksOfReader(String reader) {
        Set<Book> readerBooks = books.get(reader);
        if (readerBooks != null) {
            return readerBooks.stream()
                              // FIXME Rule 6. Don’t Abbreviate
                              .map(b -> format("%s [%s/5]", b.getTitle(), b.getRating()))
                              .collect(toSet());
        } else {
            // FIXME Rule 2. Don’t Use The ELSE Keyword
            throw new ReaderNotFoundException(reader);
        }
    }

    // FIXME Rule 3. Wrap All Primitives And Strings
    // FIXME meaningless method name
    public void addReaderBookRating(String reader, String bookTitle, int rating) {
        Set<Book> books2 = books.get(reader);
        if (books2 != null) {
            Optional<Book> existingBook = books2.stream()
                                                // FIXME Rule 5. One Dot Per Line
                                                // FIXME Rule 6. Don’t Abbreviate
                                                .filter(b -> b.getTitle().equals(bookTitle))
                                                .findAny();
            // FIXME Rule 1. Only One Level Of Indentation Per Method
            if (existingBook.isPresent()) {
                // FIXME Rule 5. One Dot Per Line
                existingBook.get().setRating(rating);
            } else {
                // FIXME Rule 2. Don’t Use The ELSE Keyword
                books2.add(new Book(bookTitle, rating));
            }
        } else {
            throw new ReaderNotFoundException(reader);
        }
    }

    // FIXME Rule 3. Wrap All Primitives And Strings
    // FIXME method name with 'and'
    public List<String> findBooksAndRatings(String bookTitleFragment) {
        List<SearchResult> results = new LinkedList<>();
        for (String reader : books.keySet()) {
            List<SearchResult> foundBooks = books.get(reader)
                                                 .stream()
                                                 // FIXME Rule 5. One Dot Per Line
                                                 // FIXME Rule 6. Don’t Abbreviate
                                                 .filter(b -> b.getTitle().toLowerCase().contains(bookTitleFragment.toLowerCase()))
                                                 .map(b -> new SearchResult(reader, b.getTitle(), b.getRating()))
                                                 .collect(toList());
            results.addAll(foundBooks);
        }
        return results.stream()
                      // FIXME Rule 6. Don’t Abbreviate
                      .map(r -> format("%s: %s [%s/5]", r.getReader(), r.getBookTitle(), r.getRating()))
                      .collect(toList());
    }

}