package pl.timbercode.books_and_bits.after.readers;

import static java.lang.String.format;

public class ReaderNotFoundException extends RuntimeException {

    public ReaderNotFoundException(Reader reader) {
        super(format("There is no registered reader named '%s'", reader.name().asText()));
    }

}