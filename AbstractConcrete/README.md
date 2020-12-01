ABSTRACT & CONCRETE CLASSES

Adding the keyword 'abstract' to a class header prevents that class from being instantiated - you don't want an Animal object, only a Wolf object. Abstract classes can still be declared as reference types. An abstract class has no use unless it is extended.

Abstract methods allow you to use a superclass type as a method argument, return type, or array type. They don't have a body and are for the benefit of polymorphism.

public abstract void doSomething();

Implementing an abstract method is just like overriding a method.

The first concrete class in the inheritance tree must implement all abstract methods i.e., Dog must implement all of the abstract methods from both Animal and Canine. To implement means to provide a body - create a non-abstract method in your class with the same method signature and a return type that is compatible with the declared return type of the abstract method. 
