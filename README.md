# Spring_Security_Interceptor_Exception_Example
Spring 3.1 MVC based security-interceptor-exception handler example


  In this tutorial, I had developed a small Login functionality which uses Spring security for initial authentication and all the exception handling done by using HandlerExceptionResolver. 
  
  I have used JsonExceptionResolver to capture exceptions and then maps them to JSON objects, which then sends in the response body.
  
  It has Spring Interceptor as well, which will take care of every request to server and authenticate request from Spring Security based Authentication Principle Object.
  
  A CustomExceptionHandler class has been written for handling generic and validation thrown exceptions.
  
  This class has implemented JsonExceptionHandler interface method's JsonExceptionHandlerwhich gets call whenever an application thorws any exception. 
  
  This method will capture those exception and checks what type of exception at runtime and based on that error message maps into JSON Object.
