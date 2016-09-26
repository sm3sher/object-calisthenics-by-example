package pl.timbercode.books_and_bits.after.ratings;

import pl.timbercode.books_and_bits.after.readers.Reader;
import pl.timbercode.books_and_bits.after.readers.ReaderNotFoundException;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ReadersBooksRatings {

    private final Map<Reader, RatedBooks> ratedBooksByReaders = new HashMap<>();

    public void addReader(Reader reader) {
        ratedBooksByReaders.put(reader, new RatedBooks());
    }

    public RatedBooks ratedBooksOf(Reader reader) {
        if (!ratedBooksByReaders.containsKey(reader)) {
            throw new ReaderNotFoundException(reader);
        }
        return ratedBooksByReaders.get(reader);
    }

    public void addRating(Reader reader, RatedBook ratedBook) {
        ratedBooksOf(reader).add(ratedBook);
    }

    public Collection<ReadersBookRating> allRatedBooks() {
        Collection<ReadersBookRating> allReadersRatings = new LinkedList<>();
        for (Reader reader : ratedBooksByReaders.keySet()) {
            ratedBooksOf(reader).stream()
                                .map(ratedBook -> new ReadersBookRating(reader, ratedBook))
                                .forEach(readersRating -> allReadersRatings.add(readersRating));
        }
        return allReadersRatings;
    }

}