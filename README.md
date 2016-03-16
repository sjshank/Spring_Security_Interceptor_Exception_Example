# Spring_Security_Interceptor_Exception_Example
Spring 3.1 MVC based security-interceptor-exception handler example



Spring 3.1 MVC :
  
       The Spring Framework is an application framework and inversion of control container for the Java platform. The framework's core       features can be used by any Java application, but there are extensions for building web applications on top of the Java EE platform.
      Spring is a lightweight framework. It can be thought of as a framework of frameworks because it provides support to various           frameworks such as Struts, Hibernate, Tapestry, EJB, JSF etc. The framework, in broader sense, can be defined as a structure          where we find solution of the various technical problems.

Spring Security :

      Spring Security provides comprehensive security services for J2EE-based enterprise software applications. There is a particular       emphasis on supporting projects built using The Spring Framework, which is the leading J2EE solution for enterprise software          development.

Spring Interceptor -

      Spring MVC Interceptors are like Servlet Filters and allow us to intercept client request and process it. We can intercept            client request at three places – preHandle, postHandle and afterCompletion

Spring Exception Handling :

      Any web application requires good design for exception handling because we don’t want to serve container generated page when any       unhandled exception is thrown by our application. Spring MVC Framework provides following ways to help us achieving robust            exception   handling.

Controller Based - 

      We can define exception handler methods in our controller classes. All we need is to annotate these methods with                      @ExceptionHandler annotation. This annotation takes Exception class as argument. So if we have defined one of these for               Exception class, then all the exceptions thrown by our request handler method will have handled.


Global Exception Handler - 

        The handler methods in Global Controller Advice is same as Controller based exception handler methods and used when controller class is not able to handle the exception.


HandlerExceptionResolver –

        For generic exceptions, most of the times we serve static pages. Spring Framework provides HandlerExceptionResolver interface         that we can implement to create global exception handler.
        

  In this tutorial, I had developed a small Login functionality which uses Spring security for initial authentication and all the exception handling done by using HandlerExceptionResolver. 
  
  I have used JsonExceptionResolver to capture exceptions and then maps them to JSON objects, which then sends in the response body.
  
  It has Spring Interceptor as well, which will take care of every request to server and authenticate request from Spring Security based Authentication Principle Object.
  
  A CustomExceptionHandler class has been written for handling generic and validation thrown exceptions.
  
  This class has implemented JsonExceptionHandler interface method's JsonExceptionHandlerwhich gets call whenever an application thorws any exception. 
  
  This method will capture those exception and checks what type of exception at runtime and based on that error message maps into JSON Object.
