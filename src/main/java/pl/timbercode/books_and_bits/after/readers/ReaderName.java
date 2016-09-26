package pl.timbercode.books_and_bits.after.readers;

public class ReaderName {

    private final String name;

    ReaderName(String name) {
        this.name = name;
    }

    public String asText() {
        return name;
    }

}