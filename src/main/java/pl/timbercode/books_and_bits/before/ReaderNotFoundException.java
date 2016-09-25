package pl.timbercode.books_and_bits.before;

import static java.lang.String.format;

class ReaderNotFoundException extends RuntimeException {

    // FIXME Rule 3. Wrap All Primitives And Strings
    ReaderNotFoundException(String reader) {
        super(format("There is no registered reader named '%s'", reader));
    }

}
