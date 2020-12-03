INHERITANCE

An inheritance relationship means that the subclass inherits the public members (public instance variables and methods) of the superclass. The inherited methods can be overwritten (the arguments and types must match and the access level must be the same or better), appended to, and new methods and instance variables can be added.

Instance variables cannot be overwritten because inheritance is intended to modify behaviour. Behaviour is exposed through methods, and that's why they can be overridden. Fields are not behaviour but state.

When a method is called on an object using the dot operator the most specific method (the lowest on the inheritance tree) for that particular object is called.

We say that the subclass "extends" the superclass and this can be tested with the IS-A test i.e., "Wolf IS-A Animal" so "Wolf extends Animal", but you wouldn't say "Animal IS-A Wolf", so the relationship only works in one direction.

Inheritance avoids duplicate code in subclasses making it more efficient, simpler, and easier to develop and extend.
