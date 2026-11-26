/// # ***Compact Source File with instance main method and the new IO class.***
/// ***It won't belong in any package***
private String greeting = "Hello Java";

void main() {
    var name = IO.readln("Enter your name: ");
    IO.println("This is new to Java 25! Hello " + name);
    printGreeting();
    printAuthors();
}

private void printGreeting() {
    IO.println(greeting);
}

void printAuthors() {
    // Implicit import of java.util.List within the java.base module
    var authors = List.of("James", "Bill", "Guy", "Alex", "Dan", "Gavin");
    for (var author : authors) {
        IO.println(author + ": " + author.length());
    }
}

// This main gets priority
//void main(String[] args) {
//    System.out.println("Hello there..");
//    main();
//}