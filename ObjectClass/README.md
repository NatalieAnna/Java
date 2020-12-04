OBJECT - the ultimate superclass

Every class in Java extends class Object, which has its own methods that are inherited. So, a Snowboard object can be treated as a Snowboard or an Object. The complier checks the class of the reference type, not the object type, to see if you can call a method using that reference. If the reference type is Object then you can only use the methods of the Object class unless you cast it into a Snowboard object. If the reference type is Snowboard then you can use Object's and Snowboard's methods.

Object s;

Snowboard theResult = (Snowboard) s;
