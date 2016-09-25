# object-calisthenics-by-example

**Books and Bits**: simple service (for social-networking IT book lovers)
to provide examples for Object Calisthenics rules.

There are two implementations:
1. `pl.timbercode.books_and_bits.before` contains "dirty" code with 
   `// FIXME` comments pointing out broken Object Calisthenics rules.
2. `pl.timbercode.books_and_bits.after` contains "clean"code with
   Object Calisthenics rules applied.
   
Both implementations share same test cases to make sure they work
in a same way. You can run those test with `./gradlew clean test`
command (required JDK 8 or newer).

## Object Calisthenics

I've read about Object Calisthenics in following places:
* http://williamdurand.fr/2013/06/03/object-calisthenics
* https://www.cs.helsinki.fi/u/luontola/tdd-2009/ext/ObjectCalisthenics.pdf

As far as I know they were designed Object Oriented programming
done in Java (before Java 8), therefore they some of rules
probably cannot be applied "as is" in another programming
languages and paradigms.

Object Calisthenics rules are:

1. Only one level of indentation per method
2. Don't use the `else` keyword
3. Wrap all primitives and strings
4. First Class Collections
5. One dot per line
6. Don't abbreviate
7. Keep all entities small
8. No classes with more than two instance variables
9. No getters/setters/properties
