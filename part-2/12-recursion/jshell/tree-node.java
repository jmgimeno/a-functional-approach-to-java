/*
 * A FUNCTIONAL APPROACH TO JAVA
 * Chapter 12 - Recursion
 *
 * Example 12-3. Tree node structure
 */

public record Node<T>(T value, Node<T> left, Node<T> right) {

    public static <T> Node<T> of(T value, Node<T> left, Node<T> right) {
        return new Node<>(value, left, right);
    }

    public static <T> Node<T> of(T value) {
        return new Node<>(value, null, null);
    }

    public static <T> Node<T> left(T value, Node<T> left) {
        return new Node<>(value, left, null);
    }

    public static <T> Node<T> right(T value, Node<T> right) {
        return new Node<>(value, null, right);
    }
}

var root = Node.of("1",
                   Node.of("2",
                           Node.of("4",
                                   Node.of("7"),
                                   Node.of("8")),
                           Node.of("5")),
                   Node.right("3",
                              Node.left("6",
                                        Node.of("9"))));
