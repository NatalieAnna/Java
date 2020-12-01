POLYMORPHISM

Unlike in regular variable declaration where the reference type and the object type are the same:

Wolf w = new Wolf();

In polymorphism the reference type can be the superclass of the object type:

Animal w = new Wolf();

The result is that if you write your code using polymorphic arguments where you declare the method parameter as a superclass type then you can pass in any subclass object at runtime.

Animal[] animals = new Animal[3];

animals[0] = new Dog();

animals[1] = new Cat();

animals[2] = new Wolf();


OVERLOADED METHODS

An overloaded method is not an example of inheritance or polymorphism rather it's a method with the same name as an existing method but with different arguments. The arguments must be different but the return type and the access level can be anything. 
