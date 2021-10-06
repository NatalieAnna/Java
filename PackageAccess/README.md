Access controls for classes:

There are 4 access controls (3 access modifiers + default/package access).
- ACCESS MODIFIERS: public, protected, private.
- NONACCESS MODIFIERS: strictfp, final, abstract.

- PUBLIC: gives all classes from all packages access to the public class.
- FINAL: the class can’t be subclassed/extended/inherited (i,e String class).
- ABSTRACT: can’t be instantiated. Can only be extended/subclassed (ie from an abstract generic car class you would subclass a concrete Toyota class).

If class A had access to class B it can:
- Create an instance of class B;
- Extend class B (become subclass of class B);
- Access methods and variables in class B (depending on their access controls).

If class B is in another package then class A must import class B. To successfully import B both classes must be in the same package or class B must be marked as public.
