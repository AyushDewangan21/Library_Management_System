package com.example.demo.Init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Book;
import com.example.demo.repo.BookRepo;

import jakarta.transaction.Transactional;
@Component
public class BookInitialize {

    @Autowired
    private BookRepo bookRepo;



    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void initBooksAndAssignToUser() {

        // Insert books once
        if (bookRepo.count() == 0) {

            Book book1 = new Book();
            book1.setBookName("Java Complete Reference");
            book1.setContent("“Java: The Complete Reference” provides a comprehensive overview of the Java programming language, covering its core principles, syntax, and architecture. It explains Java’s platform-independent design through the JVM and details essential programming fundamentals such as data types, operators, control flow, and object-oriented concepts including classes, inheritance, interfaces, and polymorphism. The book also explores advanced topics like exception handling, multithreading, file I/O, generics, collections, networking, and the Java Module System. Additionally, it introduces GUI development, lambda expressions, and the Streams API, offering best practices and practical examples to help developers write robust, efficient Java applications.");
            book1.setPrice("499");

            Book book2 = new Book();
            book2.setBookName("Spring in Action");
            book2.setContent("“Spring in Action” introduces developers to the Spring Framework by walking through its core principles of dependency injection, aspect-oriented programming, and modular architecture. The book explains how Spring simplifies enterprise Java development by providing a lightweight container, reusable components, and a consistent programming model. It covers fundamental modules like Spring Core, MVC, Data, Security, Boot, and Cloud, showing how they fit together to build scalable, testable applications. Through practical examples, it demonstrates building REST APIs, managing configuration, integrating persistence, and deploying modern microservices with Spring Boot. The goal is to help developers write clean, maintainable, production-ready applications using the Spring ecosystem.");
            book2.setPrice("599");

            Book book3 = new Book();
            book3.setBookName("JavaScript for Beginners");
            book3.setContent("“JavaScript for Beginners” introduces new programmers to the fundamentals of JavaScript, focusing on variables, data types, operators, functions, objects, and basic DOM interaction. It explains how JavaScript runs in web browsers, how it interacts with HTML and CSS, and how events drive user interaction. The book also covers arrays, loops, conditionals, and simple program logic, gradually leading learners toward creating interactive web pages. It emphasizes hands-on examples, clear explanations, and simple coding patterns so beginners can understand modern JavaScript basics and start building small web applications confidently.");
            book3.setPrice("399");

            Book book4 = new Book();
            book4.setBookName("Python Crash Course");
            book4.setContent("“Python Crash Course” is a hands-on introduction to Python, covering essential programming concepts such as variables, data structures, loops, conditionals, and functions. It guides readers through object-oriented programming, working with files, handling exceptions, and using libraries to build real-world applications. The book includes practical projects like simple games, data visualization, and web apps with Django, providing beginners with a strong foundation in Python development.");
            book4.setPrice("449");

            Book book5 = new Book();
            book5.setBookName("Clean Code");
            book5.setContent("“Clean Code” focuses on writing readable, maintainable, and efficient code through best practices, naming conventions, code smells, and refactoring techniques. It emphasizes craftsmanship in software development, explaining how to design classes, functions, and modules that communicate clearly and minimize complexity. Through real-world examples, the book teaches developers how to improve code quality, reduce bugs, and build high-performing, sustainable software systems.");
            book5.setPrice("699");

            Book book6 = new Book();
            book6.setBookName("Effective Java");
            book6.setContent("“Effective Java” provides expert-level guidance on writing robust, efficient, and maintainable Java programs. It presents best practices organized into actionable items covering topics like object creation, immutability, generics, enums, concurrency, serialization, and performance optimization. The book helps experienced developers deepen their mastery of Java’s nuances and adopt patterns that lead to cleaner, more reliable code.");
            book6.setPrice("649");

            Book book7 = new Book();
            book7.setBookName("Design Patterns: Elements of Reusable Object-Oriented Software");
            book7.setContent("This classic book introduces the concept of design patterns, offering proven solutions to common software design problems. It covers creational, structural, and behavioral patterns such as Singleton, Factory, Observer, Strategy, and Decorator. Through clear explanations and code examples, it helps developers create flexible, reusable, and maintainable software architectures.");
            book7.setPrice("799");

            Book book8 = new Book();
            book8.setBookName("You Don’t Know JS");
            book8.setContent("“You Don’t Know JS” is a deep dive into the core mechanics of JavaScript, focusing on scopes, closures, prototypes, the ‘this’ keyword, and asynchronous behavior. The series helps developers understand how JavaScript actually works under the hood, enabling them to write more predictable, optimized, and advanced JavaScript code.");
            book8.setPrice("429");

            Book book9 = new Book();
            book9.setBookName("Head First Design Patterns");
            book9.setContent("This visually engaging book explains design patterns in an intuitive and beginner-friendly way. Using real-world analogies, practical examples, and illustrated explanations, it covers essential patterns like Factory, Adapter, Command, Observer, and Singleton. It is designed to help developers recognize when and how to apply patterns to build flexible, scalable software.");
            book9.setPrice("559");

            Book book10 = new Book();
            book10.setBookName("HTML & CSS: Design and Build Websites");
            book10.setContent("This book offers a beginner-friendly introduction to building web pages using HTML and CSS. It covers structure, elements, styling, layout techniques, responsive design, and modern web development practices. The visual format makes concepts easy to understand, helping learners design clean and attractive web pages from scratch.");
            book10.setPrice("349");

            System.out.println("✔ All 10 books inserted into DB at startup!");


            bookRepo.save(book1);
            bookRepo.save(book2);
            bookRepo.save(book3);
            bookRepo.save(book4);
            bookRepo.save(book5);
            bookRepo.save(book6);
            bookRepo.save(book7);
            bookRepo.save(book8);
            bookRepo.save(book9);
            bookRepo.save(book10);

            System.out.println("✔ Books inserted into DB at startup!");
}

}
}
