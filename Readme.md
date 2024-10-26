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
   The spring container acts as object factory and has the following jobs: <br>
   &emsp; a. Create and manage objects (Inversion of Control) <br>
   &emsp; b. Inject object dependencies (Dependency Injection)
      <br><br> 
6. <strong>Some Spring modules and their use</strong>
    <pre>a. Core: Dependency injection using IoC containers etc.
   b. Testing: Mock object, MVC tests etc.
   c. Data Access: Transactions, JDBC, JPA etc.
   d. Web Servlet: Spring MVC etc.
   </pre>

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
7. <strong>@Autowired</strong>: Annotation to tell Spring that an attribute is to be auto wired <br>
   Auto wiring can be done using 3 different approaches <br>
   <pre>a. Constructor based injection: A parameterized constructor is created and @Autowired annotation is annotated on this constructor
        Example: 
            class C1 {
                C2 obj;
                @Autowired
                public C1(C2 obj){
                    this.obj=obj;
                }
            }
   
   b. Field based injection: The field to be autowired is annotated with @Autowired annotation
        Example:
            class C1 {
                @Autowired
                C2 obj;
            }

   <em>Note: If a field has @Autowired annotation, this by default looks for a bean which has bean name same as the field name <br>
   eg: @Autowired
         String name
         <br> This will look for a bean of String type with name "name"</em>
   
   c. Setter based injection: The setter of attribute to be autowired is annotated with @Autowired annotation
        Example:
            class C1 {
                C2 obj;
                @Autowired
                public void setObj(C2 obj){
                    this.obj=obj;
                }
            }
   <em>Note: Function/setter name need not follow the conventional setter name method, 
   any function name with @Autowired which accepts reference of the same type can be used for setter injection </em></pre>
   a. It is recommended to use constructor based injection if dependency is mandatory to be set by caller <br>
   b. It is recommended to use setter based injection if dependency is not mandatory to be set by caller <br>
   c. One must avoid field based injection as it makes unit testing hard
   