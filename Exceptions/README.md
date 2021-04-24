EXCEPTIONS

When an error occurs within a method, the method creates an object and hands it off to the runtime system. Creating an exception object and handing it to the runtime system is called throwing an exception. After a method throws an exception, the runtime system attempts to find something to handle it on the call stack. The runtime system searches the call stack for a method that contains a block of code that can handle the exception. This block of code is called an exception handler. The search begins with the method in which the error occurred and proceeds through the call stack in the reverse order in which the methods were called. The exception handler chosen is said to catch the exception. If the runtime system exhaustively searches all the methods on the call stack without finding an appropriate exception handler, as shown in the next figure, the runtime system (and, consequently, the program) terminates.

There are three basic categories of exceptions:

1. Checked exception.

For example, an application prompts the user for an input file name and the user supplies the name of a nonexistent file. A well-written program will catch this exception and notify the user of the mistake, possibly prompting for a corrected file name. Checked exceptions are subject to the Catch or Specify Requirement.

2. Unchecked exceptions:

2a. Error.

For example, an application successfully opens a file for input, but is unable to read the file because of a hardware or system malfunction. An application might choose to catch this exception, in order to notify the user of the problem — but it also might make sense for the program to print a stack trace and exit.

2b Runtime exception.

These usually indicate programming bugs, such as logic errors or improper use of an API. The application can catch this exception, but it probably makes more sense to eliminate the bug that caused the exception to occur.


Methods use 'checked exceptions' to tell the calling code that they failed. There will be a 'throws' clause in the risky method's declaration. They're risky because they can fail at runtime i.e., you cannot guarantee that the file is there or that the server is up.

To compile successfully they must be wrapped in a try/catch block.

try {

  // the caller calls riskyMethod()
  
  riskyMethod();
  
} catch(Exception ex) {

  // the risky method throws an exception back to the caller
  
  System.out.println("Failed");
  
  ex.printStackTrace();
  
} finally {

  System.out.println("Finally (optional) always executes");
  
}

One method catches what another method throws. An exception is always thrown back to the caller.

An exception is an object of type Exception with many subclasses.
Throwable > Exceptions > IOException / InterruptedException / RuntimeException...

RuntimeException is the only Exception subclass NOT checked by the compiler (as these relate to code errors that shouldn't be there in the first place) aka unchecked exceptions.

Exceptions can be 'ducked' by declaring 'throws Exception' to both the risky and the main methods.

Rules
- You cannot have a catch or finally without a try
- You cannot put code between the try and catch
- A try must be followed by either a catch or a finally
- A try with only a finally must still declare the exception

