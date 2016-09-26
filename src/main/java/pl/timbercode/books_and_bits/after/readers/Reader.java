package pl.timbercode.books_and_bits.after.readers;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Reader {

    private final String name;

    public Reader(String name) {
        this.name = name;
    }

    public ReaderName name() {
        return new ReaderName(name);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Reader that = (Reader) other;
        return new EqualsBuilder()
                .append(this.name, that.name)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(name)
                .toHashCode();
    }

}