# Introduction to Spring

## Creating a new Spring project
1. Use start.spring.io to create a new Spring project
    This website actually provides a SpringBoot project
2. Once you visit the website 
    <pre> a. Select a build tools eg: Maven, Gradle
    b. Select Spring version to work with
        M - Milestone version
        R - Release
        No suffix - Stable release
        SNAPSHOT - Under development(Avoid using these)
    c. Select a Java version
    d. Add required dependency based on what type of project you are building
    e. Click on generate and extract downloaded file to project location
    f. Import the project to IDE </pre>

## Some basics for Spring
1. <strong>Loosely coupled</strong><br>
    A dependency of a class/object need to be defined as an Interface rather than as an instance of a concrete class. <br>
    This can be achieved in 2 steps
    <pre> a. Instead of declaring an attribute and initializing that attribute in constructor using new keyword
        Get it as a parameter to the constructor and assign the reference to the field.
    b. Try to declare the attribute as interface type whose implementation is left up to the caller
        The caller may choose to pass any implementation of the interface as a parameter to the constructor. </pre>
    Example
    <pre>class Desktop {
        Keyboard keyboard;
        Mouse mouse;
        public Desktop(Keyboard keyboard, Mouse mouse){
            this.keyboard=keyboard;
            this.mouse=mouse;
        }
    }
   
    class Main {
        public static void main(String[] args){
            Keyboard gamingKeyboard = new GamingKeyboard();
            Mouse simpleMouse = new SimpleMouse();
            Desktop customDesktop = new Desktop(gamingKeyboard, simpleMouse);
       }
    }</pre> <br>
2. <strong>Bean</strong><br>
    Any object or instance whose lifecycle is managed by Spring is called a bean <br><br>
3. <strong>Spring context</strong><br>
   Inside a JVM, one can create a Spring context which is basically a container which is managed by Spring.
    A JVM might have multiple Spring context inside it. <br><br>
4. <strong>Inversion of Control(IoC)</strong><br>
    In normal life, the responsibility of injecting an instance of dependency is given to the caller. <br>
    One of the core features of Spring is, it inverts this control and takes up the responsibility of injecting the dependency by itself <br>
    This is called inversion of control. This is done using Auto wiring of beans and bean qualification. <br><br>
5. <strong>Auto wiring</strong> <br>
   Spring framework can inject dependencies automatically. <br>
   The Spring container detects those dependencies specified in the configuration file and the relationship between the beans. 

## Annotations in Spring
1. <strong>@Configuration</strong>: Annotation which indicates that a class has bean definitions <br><br>
2. <strong>@Bean</strong>: Annotation which is applied on a method to specify that it returns a bean to be managed by Spring context <br> 
    This is applied to method which are defined inside class that are annotated with @Configuration annotation <br><br>
3.  <strong>@Primary</strong>: When performing auto wiring or getting a bean of a specific class type using getBean method of spring context with class as parameter, Spring may find instances where multiple beans qualify for the type <br>
    Primary annotation in Spring is used to indicate the primary bean when multiple beans of the same type are present for auto wiring <br><br>
4.  <strong>@Qualifier</strong>: Annotation used to explicitly specify which bean should be injected. <br><br>
5. <strong>@Component</strong>: It is a class-level annotation. It is used to denote a class is a component and its instance should be managed by Spring context. <br><br>
6. <strong>@ComponentScan</strong>: It is used along with the @Configuration annotation to specify the packages that we want to be scanned. <br>
    If we do not specify any package then @ComponentScan is inferred as scanning current package for Components<br>
    To specify that a package need to be scanned for Components, we need to pass the pakcage name to the @ComponentScan <br>
    eg: @ComponentScan("myPackageName") <br>
    Once a package name is passed to the annotation, the package along with its sub-packages are scanned for component <br><br>
7. <strong>@Autowired</strong>: Annotation to tell Spring that an attribute is to be auto wired