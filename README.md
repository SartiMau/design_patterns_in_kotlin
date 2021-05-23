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
    * [Private Class Data](#private-class-data)
    * [Protection Proxy](#protection-proxy)
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
![alt text](https://github.com/SartiMau/design_patterns_in_kotlin/blob/main/images/creational/abstract_factory.png.png?raw=true)

[Builder](/app/src/main/java/com/murosar/designpatternsinkotlin/creational/Builder.kt)
-------------------

[Factory Method](/app/src/main/java/com/murosar/designpatternsinkotlin/creational/FactoryMethod.kt)
-------------------

[Object Pool](/app/src/main/java/com/murosar/designpatternsinkotlin/creational/ObjectPool.kt)
-------------------

[Prototype](/app/src/main/java/com/murosar/designpatternsinkotlin/creational/Prototype.kt)
-------------------

[Singleton](/app/src/main/java/com/murosar/designpatternsinkotlin/creational/Singleton.kt)
-------------------
	
Structural
==========

>In Software Engineering, Structural Design Patterns are Design Patterns that ease the design by identifying a simple way to realize relationships between entities.
>
>**Source:** [sourcemaking.com](https://sourcemaking.com/design_patterns/structural_patterns)

[Adapter](/app/src/main/java/com/murosar/designpatternsinkotlin/structural/Adapter.kt)
-------------------

[Bridge](/app/src/main/java/com/murosar/designpatternsinkotlin/structural/Bridge.kt)
-------------------

[Composite](/app/src/main/java/com/murosar/designpatternsinkotlin/structural/Composite.kt)
-------------------

[Decorator](/app/src/main/java/com/murosar/designpatternsinkotlin/structural/Decorator.kt)
-------------------

[Facade](/app/src/main/java/com/murosar/designpatternsinkotlin/structural/Facade.kt)
-------------------

[Flyweight](/app/src/main/java/com/murosar/designpatternsinkotlin/structural/Flyweight.kt)
-------------------

[Private Class Data](/app/src/main/java/com/murosar/designpatternsinkotlin/structural/PrivateClassData.kt)
-------------------

[Proxy](/app/src/main/java/com/murosar/designpatternsinkotlin/structural/Proxy.kt)
-------------------	
	
Behavioral
==========

>In software engineering, behavioral design patterns are design patterns that identify common communication patterns between objects and realize these patterns. By doing so, these patterns increase flexibility in carrying out this communication.
>
>**Source:** [sourcemaking.com](https://sourcemaking.com/design_patterns/behavioral_patterns)

[Chain of Responsibility](/app/src/main/java/com/murosar/designpatternsinkotlin/behavioral/ChainOfResponsibility.kt)
-------------------

[Command](/app/src/main/java/com/murosar/designpatternsinkotlin/behavioral/Command.kt)
-------------------

[Interpreter](/app/src/main/java/com/murosar/designpatternsinkotlin/behavioral/Interpreter.kt)
-------------------

[Iterator](/app/src/main/java/com/murosar/designpatternsinkotlin/behavioral/Iterator.kt)
-------------------

[Mediator](/app/src/main/java/com/murosar/designpatternsinkotlin/behavioral/Mediator.kt)
-------------------

[Memento](/app/src/main/java/com/murosar/designpatternsinkotlin/behavioral/Memento.kt)
-------------------

[Null Object](/app/src/main/java/com/murosar/designpatternsinkotlin/behavioral/NullObject.kt)
-------------------

[Observer](/app/src/main/java/com/murosar/designpatternsinkotlin/behavioral/Observer.kt)
-------------------

[State](/app/src/main/java/com/murosar/designpatternsinkotlin/behavioral/State.kt)
-------------------

[Strategy](/app/src/main/java/com/murosar/designpatternsinkotlin/behavioral/Strategy.kt)
-------------------

[Template Method](/app/src/main/java/com/murosar/designpatternsinkotlin/behavioral/TemplateMethod.kt)
-------------------

[Visitor](/app/src/main/java/com/murosar/designpatternsinkotlin/behavioral/Visitor.kt)
-------------------
