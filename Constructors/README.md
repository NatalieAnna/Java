CONSTRUCTORS

Duck aDuck = new Duck();

New object creation happens after reference declaration but BEFORE the object is as signed to the reference (ie "=" happens last). This means that the Duck object's state can be initialised (with instance variables etc) before being used.

Every class has a constructor - if you haven't written a constructor then the compiler does it for you (but once you put any constructor in your class, the compiler will not build the default no-arg constructor).

Always provide a no-arg constructor (with default values) so that a working object can be created.

Overloaded constructors means you have more than one constructor in a class. They must have different argument types and orders.

Instance variables are assigned a default value when you don't explicitly assign one. The default values are 0/0.0/false for primitives, and null for references.

CONSTRUCTOR CHAINING

Every object holds its own declared instance variables and also those from its superclasses - as one object - so all of the relevant constructors are called when creating an object. For example, calling Dog() also calls Canine(), Animal() and Object().
The compiler adds a call to super(), the superclass constructor), if you don't.

Each subclass constructor immediately invokes its own superclass constructor, until the Object constructor is on the top of the Stack. The call to super() must be the first cdstatement in each constructor.
