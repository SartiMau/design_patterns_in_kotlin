# Design Patterns In Kotlin

Project made by [Mauro Sarti](mailto:mauro.sarti@globant.com) as a mission from My Growth

>In software engineering, a **design pattern** is a general repeatable solution to a commonly occurring problem in software design. A design pattern isn't a finished design that can be transformed directly into code. It is a description or template for how to solve a problem that can be used in many different situations.
>
>**Source:** [sourcemaking.com](https://sourcemaking.com/design_patterns)

## Table of Contents

* [Creational Patterns](#creational)
	* [Abstract Factory](#abstract-factory)
	* [Builder](#builder)
	* [Factory Method](#factory-method)
    * [Object Pool](#object-pool)
    * [Prototype](#prototype)
	* [Singleton](#singleton)
* [Structural Patterns](#structural)
    * [Adapter](#adapter)
    * [Bridge](#bridge)
    * [Composite](#composite) 
    * [Decorator](#decorator)
    * [Facade](#facade)
    * [Flyweight](#flyweight)
    * [Private Data Class](#private-data-class)
    * [Proxy](#proxy)
* [Behavioral Patterns](#behavioral)
	* [Chain of Responsibility](#chain-of-responsibility)
	* [Command](#command)
	* [Interpreter](#interpreter)
	* [Iterator](#iterator)
	* [Mediator](#mediator)
	* [Memento](#memento)
	* [Null Object](#null-object)
	* [Observer](#observer)
	* [State](#state)
	* [Strategy](#strategy)
	* [Template method](#template-method)
	* [Visitor](#visitor)
	
Creational
==========	

>In software engineering, creational design patterns are design patterns that deal with object creation mechanisms, trying to create objects in a manner suitable to the situation. The basic form of object creation could result in design problems or added complexity to the design. Creational design patterns solve this problem by somehow controlling this object creation.
>
>**Source:** [sourcemaking.com](https://sourcemaking.com/design_patterns/creational_patterns)

[Abstract Factory](/app/src/main/java/com/murosar/designpatternsinkotlin/creational/AbstractFactory.kt)
-------------------

Provides an interface for creating families of related or dependent objects without specifying their concrete class.

Use when:
- The object being represented is external to the system. 
- Objects need to be created on demand.
- Access control for the original object is required.
- Added functionality is required when an object is accessed.

Structure:
![alt text](https://github.com/SartiMau/design_patterns_in_kotlin/blob/main/images/creational/abstract_factory.png?raw=true)

[Builder](/app/src/main/java/com/murosar/designpatternsinkotlin/creational/Builder.kt)
-------------------

Separate the construction of a complex object from its representing so that the same construction process can create different representations.

Use when:
- Object creation algorithms should be decoupled from the system.
- Multiple representations of creation algorithms are required.
- The addition of new creation functionality without changing the core code is necessary.
- Runtime control over the creation process is required.

Structure:
![alt text](https://github.com/SartiMau/design_patterns_in_kotlin/blob/main/images/creational/builder.png?raw=true)

[Factory Method](/app/src/main/java/com/murosar/designpatternsinkotlin/creational/FactoryMethod.kt)
-------------------

Define an interface for creating an object, but let subclasses decide which class to instantiate. Lets a class defer instantiation to subclasses.

Use when:
- A class will not know what classes it will be required to create.
- Subclasses may specify what objects should be created.
- Parent classes wish to defer creation to their subclasses.

Structure:
![alt text](https://github.com/SartiMau/design_patterns_in_kotlin/blob/main/images/creational/factory_method.png?raw=true)

[Object Pool](/app/src/main/java/com/murosar/designpatternsinkotlin/creational/ObjectPool.kt)
-------------------

Object pooling can offer a significant performance boost.

Use when:
- The cost of initializing a class instance is high.
- The rate of instantiation of a class is high.
- The number of instantiations in use at any one time is low.

Structure:
![alt text](https://github.com/SartiMau/design_patterns_in_kotlin/blob/main/images/creational/object_pool.png?raw=true)

[Prototype](/app/src/main/java/com/murosar/designpatternsinkotlin/creational/Prototype.kt)
-------------------

Specify the kinds of objects to create using a prototypical instance, and create new objects by copying this prototype.

Use when:
- A class will not know what classes it will be required to create.
- Subclasses may specify what objects should be created.
- Parent classes wish to defer creation to their subclasses.

Structure:
![alt text](https://github.com/SartiMau/design_patterns_in_kotlin/blob/main/images/creational/prototype.png?raw=true)

[Singleton](/app/src/main/java/com/murosar/designpatternsinkotlin/creational/Singleton.kt)
-------------------
	
Ensure a class only has one instance and provide a global point of access to it.

Use when:
- Exactly one instance of a class is required.
- Controlled access to a single object is necessary.

Structure:
![alt text](https://github.com/SartiMau/design_patterns_in_kotlin/blob/main/images/creational/singleton.png?raw=true)	
	
Structural
==========

>In Software Engineering, Structural Design Patterns are Design Patterns that ease the design by identifying a simple way to realize relationships between entities.
>
>**Source:** [sourcemaking.com](https://sourcemaking.com/design_patterns/structural_patterns)

[Adapter](/app/src/main/java/com/murosar/designpatternsinkotlin/structural/Adapter.kt)
-------------------

Convert the interface of a class into another interface clients expect. Lets classes work together that couldn't otherwise because of incompatible interfaces.

Use when:
- A class to be used doesn’t meet interface requirements.
- Complex conditions tie object behavior to its state.
- Transitions between states need to be explicit.

Structure:
![alt text](https://github.com/SartiMau/design_patterns_in_kotlin/blob/main/images/structural/adapter.png?raw=true)

[Bridge](/app/src/main/java/com/murosar/designpatternsinkotlin/structural/Bridge.kt)
-------------------

Decouple an abstraction from its implementation so that the two can vary independently.

Use when:
- Abstractions and implementations should not be bound at compile time.
- Abstractions and implementations should be independently extensible.
- Changes in the implementation of an abstraction should have no impact on clients.
- Implementation details should be hidden from the client.

Structure:
![alt text](https://github.com/SartiMau/design_patterns_in_kotlin/blob/main/images/structural/bridge.png?raw=true)

[Composite](/app/src/main/java/com/murosar/designpatternsinkotlin/structural/Composite.kt)
-------------------

Compose objects into tree structures to represent part-whole hierarchies. Lets clients treat individual objects and compositions of objects uniformly.

Use when:
- Hierarchical representations of objects are needed.
- Objects and compositions of objects should be treated uniformly.

Structure:
![alt text](https://github.com/SartiMau/design_patterns_in_kotlin/blob/main/images/structural/composite.png?raw=true)

[Decorator](/app/src/main/java/com/murosar/designpatternsinkotlin/structural/Decorator.kt)
-------------------

Attach additional responsibilities to an object dynamically. Provide a flexible alternative to sub-classing for extending functionality.

Use when:
- Object responsibilities and behaviors should be dynamically modifiable.
- Concrete implementations should be decoupled from responsibilities and behaviors.
- Subclassing to achieve modification is impractical or impossible.
- Specific functionality should not reside high in the object hierarchy.
- A lot of little objects surrounding a concrete implementation is acceptable.

Structure:
![alt text](https://github.com/SartiMau/design_patterns_in_kotlin/blob/main/images/structural/decorator.png?raw=true)

[Facade](/app/src/main/java/com/murosar/designpatternsinkotlin/structural/Facade.kt)
-------------------

Provide a unified interface to a set of interfaces in a subsystem. Defines a high-level interface that makes the subsystem easier to use.

Use when:
- A simple interface is needed to provide access to a complex system.
- There are many dependencies between system implementations and clients.
- Systems and subsystems should be layered.

Structure:
![alt text](https://github.com/SartiMau/design_patterns_in_kotlin/blob/main/images/structural/facade.png?raw=true)

[Flyweight](/app/src/main/java/com/murosar/designpatternsinkotlin/structural/Flyweight.kt)
-------------------

Use sharing to support large numbers of fine-grained objects efficiently.

Use when:
- Many like objects are used and storage cost is high.
- The majority of each object’s state can be made extrinsic.
- A few shared objects can replace many unshared ones.
- The identity of each object does not matter.

Structure:
![alt text](https://github.com/SartiMau/design_patterns_in_kotlin/blob/main/images/structural/flyweight.png?raw=true)

[Private Data Class](/app/src/main/java/com/murosar/designpatternsinkotlin/structural/PrivateDataClass.kt)
-------------------

Protect the class state by minimizing the visibility and manipulation of its attributes.

Use when:
- The attribute manipulation is no desirable after the construction.

Structure:
![alt text](https://github.com/SartiMau/design_patterns_in_kotlin/blob/main/images/structural/private_data_class.png?raw=true)

[Proxy](/app/src/main/java/com/murosar/designpatternsinkotlin/structural/Proxy.kt)
-------------------	
	
Provide a surrogate or placeholder for another object to control access to it.

Use when:
- The object being represented is external to the system.
- Objects need to be created on demand.
- Access control for the original object is required.
- Added functionality is required when an object is accessed.

Structure:
![alt text](https://github.com/SartiMau/design_patterns_in_kotlin/blob/main/images/structural/proxy.png?raw=true)
	
Behavioral
==========

>In software engineering, behavioral design patterns are design patterns that identify common communication patterns between objects and realize these patterns. By doing so, these patterns increase flexibility in carrying out this communication.
>
>**Source:** [sourcemaking.com](https://sourcemaking.com/design_patterns/behavioral_patterns)

[Chain of Responsibility](/app/src/main/java/com/murosar/designpatternsinkotlin/behavioral/ChainOfResponsibility.kt)
-------------------

Avoid coupling the sender of a request to its receiver by giving more than one object a chance to handle the request. Chain the receiving objects and pass the request along the chain until an object handles it.

Use when:
- Multiple objects may handle a request and the handler doesn't have to be a specific object.
- A set of objects should be able to handle a request with the handler determined at runtime.
- A request not being handled is an acceptable potential outcome.

Structure:
![alt text](https://github.com/SartiMau/design_patterns_in_kotlin/blob/main/images/behavioral/chain_of_responsibility.png?raw=true)

[Command](/app/src/main/java/com/murosar/designpatternsinkotlin/behavioral/Command.kt)
-------------------

Encapsulate a request as an object, thereby letting you parameterize clients with different requests, queue or log requests, and support undoable operations.

Use when:
- You need callback functionality.
- Requests need to be handled at variant times or in variant orders.
- A history of requests is needed.
- The invoker should be decoupled from the object handling the invocation.

Structure:
![alt text](https://github.com/SartiMau/design_patterns_in_kotlin/blob/main/images/behavioral/command.png?raw=true)

[Interpreter](/app/src/main/java/com/murosar/designpatternsinkotlin/behavioral/Interpreter.kt)
-------------------

Given a language, define a representation for its grammar along with an interpreter that uses the representation to interpret sentences in the language.

Use when:
- There is grammar to interpret that can be represented as large syntax trees.
- The grammar is simple.
- Efficiency is not important.
- Decoupling grammar from underlying expressions is desired.

Structure:
![alt text](https://github.com/SartiMau/design_patterns_in_kotlin/blob/main/images/behavioral/interpreter.png?raw=true)

[Iterator](/app/src/main/java/com/murosar/designpatternsinkotlin/behavioral/Iterator.kt)
-------------------

Provide a way to access the elements of an aggregate object sequentially without exposing its underlying representation.

Use when:
- Access to elements is needed without access to the entire representation.
- Multiple or concurrent traversals of the elements are needed.
- A uniform interface for traversal is needed.
- Subtle differences exist between the implementation details of various iterators.

Structure:
![alt text](https://github.com/SartiMau/design_patterns_in_kotlin/blob/main/images/behavioral/iterator.png?raw=true)

[Mediator](/app/src/main/java/com/murosar/designpatternsinkotlin/behavioral/Mediator.kt)
-------------------

Define an object that encapsulates how a set of objects interact. Promotes loose coupling by keeping objects from referring to each other explicitly and it lets you vary their interactions independently.

Use when:
- Communication between sets of objects is well defined and complex.
- Too many relationships exist and common point of control or communication is needed.

Structure:
![alt text](https://github.com/SartiMau/design_patterns_in_kotlin/blob/main/images/behavioral/mediator.png?raw=true)

[Memento](/app/src/main/java/com/murosar/designpatternsinkotlin/behavioral/Memento.kt)
-------------------

Without violating encapsulation, capture and externalize an object's internal state so that the object can be restored to this state later.

Use when:
- The internal state of an object must be saved and restored at a later time.
- Internal state cannot be exposed by interfaces without exposing implementation.
- Encapsulation boundaries must be preserved.

Structure:
![alt text](https://github.com/SartiMau/design_patterns_in_kotlin/blob/main/images/behavioral/memento.png?raw=true)

[Null Object](/app/src/main/java/com/murosar/designpatternsinkotlin/behavioral/NullObject.kt)
-------------------

Encapsulate the absence of an object by providing a substitutable alternative that offers suitable default do nothing behavior. In short, a design where "nothing will come of nothing"

Use when:
- An object requires a collaborator. The Null Object pattern does not introduce this collaboration--it makes use of a collaboration that already exists.
- Some collaborator instances should do nothing.
- You want to abstract the handling of null away from the client.

Structure:
![alt text](https://github.com/SartiMau/design_patterns_in_kotlin/blob/main/images/behavioral/null_object.png?raw=true)

[Observer](/app/src/main/java/com/murosar/designpatternsinkotlin/behavioral/Observer.kt)
-------------------

Define a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.

Use when:
- State changes in one or more objects should trigger behavior in other objects.
- Broadcasting capabilities are required.
- An understanding exists that objects will be blind to the expense of notification.

Structure:
![alt text](https://github.com/SartiMau/design_patterns_in_kotlin/blob/main/images/behavioral/observer.png?raw=true)

[State](/app/src/main/java/com/murosar/designpatternsinkotlin/behavioral/State.kt)
-------------------

Allow an object to alter its behavior when its internal state changes. The object will appear to change its class.

Use when:
- The behavior of an object should be influenced by its state.
- Complex conditions tie object behavior to its state.
- Transitions between states need to be explicit.

Structure:
![alt text](https://github.com/SartiMau/design_patterns_in_kotlin/blob/main/images/behavioral/state.png?raw=true)

[Strategy](/app/src/main/java/com/murosar/designpatternsinkotlin/behavioral/Strategy.kt)
-------------------

Define a family of algorithms, encapsulate each one, and make them interchangeable. Lets the algorithm vary independently from clients that use it.

Use when:
- The only difference between many related classes is their behavior.
- Multiple versions or variations of an algorithm are required.
- Algorithms access or utilize data that calling code shouldn't be exposed to.
- The behavior of a class should be defined at runtime.
- Conditional statements are complex and hard to maintain.

Structure:
![alt text](https://github.com/SartiMau/design_patterns_in_kotlin/blob/main/images/behavioral/strategy.png?raw=true)

[Template Method](/app/src/main/java/com/murosar/designpatternsinkotlin/behavioral/TemplateMethod.kt)
-------------------

Define the skeleton of an algorithm in an operation, deferring some steps to subclasses. Lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure.

Use when:
- A single abstract implementation of an algorithm is needed.
- Common behavior among subclasses should be localized to a common class.
- Parent classes should be able to uniformly invoke behavior in their subclasses.
- Most or all subclasses need to implement the behavior.

Structure:
![alt text](https://github.com/SartiMau/design_patterns_in_kotlin/blob/main/images/behavioral/template_method.png?raw=true)

[Visitor](/app/src/main/java/com/murosar/designpatternsinkotlin/behavioral/Visitor.kt)
-------------------

Represent an operation to be performed on the elements of an object structure. Lets you define a new operation without changing the classes of the elements on which it operates.

Use when:
- An object structure must have many unrelated operations performed upon it.
- The object structure can’t change but operations performed on it can.
- Operations must be performed on the concrete classes of an object structure.
- Exposing internal state or operations of the object structure is acceptable.
- Operations should be able to operate on multiple object structures that implement the same interface sets.

Structure:
![alt text](https://github.com/SartiMau/design_patterns_in_kotlin/blob/main/images/behavioral/visitor.png?raw=true)
