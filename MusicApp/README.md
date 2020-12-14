Music app using javax.sound.midi.*


Versions:

MusicApp.java - plays one hardcoded note.

MusicAppCL.java - plays one note determined by user input (instrument and note) from command line.


Notes:

- An event is an object of an Event class.

- Event-handling: the process of getting and handling a user event (i.e., the user clicks a button).

- Event source (like a button) creates an event object when the user does an action (like clicks a mouse or types a key). Usually your program will receive events (listener) rather than create them (i.e., being an event source).

- By implementing a listener interface you give the clicked button a way to call you back.
