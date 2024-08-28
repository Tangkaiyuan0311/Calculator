# Calculator Project     

## [Doc](./doc/index.html)

## Overview

This project is a simple yet extensible calculator implementation in Java, designed with the Open-Closed Principle (OCP) and best practices for maintainability and extensibility in mind. The calculator supports basic arithmetic operations (addition, subtraction, multiplication, and division) and allows for the dynamic addition of new operations at both compile and runtime.

## Table of Contents

- [Design Principles](#design-principles)
- [Project Structure](#project-structure)
- [Usage](#usage)
    - [Basic Operations](#basic-operations)
    - [Adding Custom Operations](#adding-custom-operations)
    - [Chaining Operations](#chaining-operations)
- [Testing](#testing)
- [Doc](#JavaDoc)

## Design Principles

### Open-Closed Principle (OCP)

The project is designed with the Open-Closed Principle at its core, which states that software entities (classes, modules, functions, etc.) should be open for extension but closed for modification. This means you can extend the functionality of the calculator without modifying its existing code.

#### How OCP Is Applied

- **Enum-Based Operations**: The `Operation` enum defines basic operations. By leveraging the polymorphic nature of enums in Java, each operation is implemented as an enum constant with its own `apply` method. This design allows new operations to be added simply by adding new enum constants.
- **Dynamic Operations**: The `BasicCalculator` class allows for dynamic operations to be added at runtime using the `addOperation` method. This means you can extend the calculator's functionality without altering its existing codebase.

### Maintainability and Extensibility

The project is structured to ensure that it is easy to maintain and extend:
- **Separation of Concerns**: The project separates the definition of operations (via the `Operation` enum) from their execution (handled by the `BasicCalculator` class). This makes it easy to modify or add new operations without affecting other parts of the system.
- **Modular Design**: The `Calculator` interface defines a contract that different implementations can adhere to. This makes it possible to introduce new types of calculators in the future without impacting existing functionality.

## Project Structure
```
calculator/
├── src/
│   ├── main/
│   │   ├── Impl/
│   │   │   ├── test/
│   │   │   │   ├── BasicCalculatorTest.java
│   │   │   ├── BasicCalculator.java
│   │   ├── model/
│   │   │   ├── Calculator.java
│   │   │   ├── Operation.java
├── README.md
```
- **`Calculator.java`**: The interface defining the contract for calculator implementations.
- **`BasicCalculator.java`**: The main implementation of the `Calculator` interface, supporting both basic and dynamic operations.
- **`Operation.java`**: An enum representing basic arithmetic operations.
- **`BasicCalculatorTest.java`**: Unit tests ensuring the correctness of the `BasicCalculator` implementation.

## Usage

### Basic Operations

The `BasicCalculator` class supports basic arithmetic operations such as addition, subtraction, multiplication, and division. These operations are defined in the `Operation` enum.

Example:

```java
BasicCalculator calculator = new BasicCalculator();
Number result = calculator.basicCalculate(Operation.ADD, 2, 3);
System.out.println(result); // Outputs 5.0
```

### Adding Custom Operations

You can add new operations to the calculator at runtime using the addOperation method:

```java
calculator.addOperation("customAdd", (num1, num2) -> num1.doubleValue() + 2 * num2.doubleValue());
Number customResult = calculator.calculate("customAdd", 2, 3);
System.out.println(customResult); // Outputs 8.0
```

### Chaining Operations

The chainOperations method allows you to perform multiple operations sequentially:

```java
Number chainedResult = calculator.chainOperations(5, List.of(Operation.ADD, Operation.MULTIPLY), List.of(3, 2));
System.out.println(chainedResult); // Outputs 16.0
```

## Testing

The project includes a comprehensive suite of unit tests to ensure the correctness of the calculator’s functionality. The tests are written using the JUnit framework and can be run using Maven or your preferred IDE.
```shell
mvn test
```


## JavaDoc

This project is fully documented here. [Doc](./doc/index.html)

