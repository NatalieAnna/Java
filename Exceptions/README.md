EXCEPTIONS

Methods use 'exceptions' to tell the calling code that they failed. There will be a 'throws' clause in the risky method's declaration. They're risky because they can fail at runtime i.e., you cannot guarantee that the file is there or that the server is up.

To compile successfully they must be wrapped in a try/catch block.

try {

  // the caler calls riskyMethod()
  
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

RuntimeException is the only Exception subclass NOT checked by the compiler (as these relate to code errors that shouldn't be there in the first place).
