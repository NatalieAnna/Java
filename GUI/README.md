GUI & EVENTS

Gui1.java - create JFrame, add button

Gui2.java - implement ActionListener on button

Gui3.java - display blue square, display jpeg, paint randomly coloured circle, paint circle with gradient

Gui4.java - button colour changes with each click of button

Notes:

- An event is an object of an Event class.

- Event-handling: the process of getting and handling a user event (i.e., the user clicks a button).

- Event source (like a button) creates an event object when the user does an action (like clicks a mouse or types a key). Usually your program will receive events (be a listener) rather than create them (be an event source). A listener implements the interface, registers the button, and provides the event-handling. An event source accepts registrations (from listeners), gets events from the user, and calls the listener's event-handling methods (when the user clicks the button). The Event object is the argument to the event call-back method (from the interface) and carries data about the event back to the listener.

Listener GETS the event; Source SENDS the event; Event object HOLD DATA about the event (i.e., the X and Y coordinates for where the mouse was pressed. Or might be used for an onscreen calculator where each numeric key does the same thing so you register one listener and when you get an event you can call a method on the event object to find out which who the real event source [key] was).

- By implementing a listener interface you give the clicked button a way to call you back.
