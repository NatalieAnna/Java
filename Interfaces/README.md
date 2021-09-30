INTERFACES

An interface is like a contract for what a class can do, so any class that implements the, for example, Bounceable interface, must agree to write the code for the abstract methods bounce() and setBounceFactor() methods. They define instance methods.

Classes from different inheritance trees can implement the same interface (or multiple interfaces). For example, any class might want to be saveable. Or you might want Ball and Tire to have bounce behaviour (when they don't share any inheritance relationship).

All interface methods are implicitly public and abstract (with no bodies) - this is what the compiler sees. In the implementing classes, all interface methods must be implemented and must be marked public.

An interface is a reference type, similar to a class, that can contain only constants, method signatures, default methods, static methods, and nested types. It cannot contain instance variables. Any interface variables are final and cannot be given another value by implementing classes.

Method bodies exist only for default methods and static methods. Interfaces cannot be instantiated, they can only be implemented by classes or extended by other interfaces.

It's as if a parent class defines what you are, but interfaces define the roles you can play.


