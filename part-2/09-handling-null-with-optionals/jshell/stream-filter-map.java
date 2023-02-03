/*
 * A FUNCTIONAL APPROACH TO JAVA
 * Chapter 9 - Handling null with Optionals
 *
 * Example 9-7. Intermediate operations to find an active admin
 */

import java.util.List;
import java.util.Optional;

public record Permissions(List<String> permissions, Group group) {
  public boolean isEmpty() {
    return permissions.isEmpty();
  }
}

public record Group(Optional<User> admin) {
  // NO BODY
}

public record User(boolean isActive) {
    // NO BODY
}

User admin = new User(true);

Group group = new Group(Optional.of(admin));

List<Permissions> permissions = List.of(new Permissions(List.of("A", "B", "C"),
                                                        group));

List<User> activeUsers =
  permissions.stream()
             .filter(Predicate.not(Permissions::isEmpty))
             .map(Permissions::group)
             .map(Group::admin)
             .filter(Optional::isPresent)
             .map(Optional::orElseThrow)
             .filter(User::isActive)
             .toList();
