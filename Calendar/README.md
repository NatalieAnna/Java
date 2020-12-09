Calendar is abstract but you can call the static method getInstance() on Calendar and it gives you an instance of a concrete subclass, which extends Calendar (and can be polymorphically assigned to Calendar).

Stackoverflow suggests java.time instead of java.util.Calendar.
