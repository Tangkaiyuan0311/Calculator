# Calculator Project     

## [Doc](./doc/index.html)

## Overview

This project is a simple yet extensible calculator implementation in Java, designed with the Open-Closed Principle (OCP) and best practices for maintainability and extensibility in mind. The calculator supports basic arithmetic (chaining) operations (addition, subtraction, multiplication, and division) and allows changing implementation for each operation through Spring’s dependency injection system.

## Table of Contents

- [Design Principles](#design-principles)
- [Project Structure](#project-structure)
- [Usage](#usage)
    - [Basic Operations](#basic-operations)
    - [Chaining Operations](#chaining-operations)
- [Testing](#testing)
- [Doc](#JavaDoc)

## Design Principles

### Open-Closed Principle (OCP)

The project is designed with the Open-Closed Principle at its core, which states that software entities (classes, modules, functions, etc.) should be open for extension but closed for modification. This means you can extend the functionality of the calculator without modifying its existing code.

#### How OCP Is Applied

- **Enum-Based Operations**: The `Operation` enum defines the basic operations. Each operation in this enum is associated with a Spring bean that implements the operation. This design allows new operation or new implementation to be added via Spring beans without changing the core calculator logic.
- **Dynamic Operations**: The `BasicCalculator` class relies on the `OperationFormat` interface, allowing different operation implementations to be injected as Spring beans. This approach facilitates adding new operations by simply providing new Spring-managed beans.

### Maintainability and Extensibility

The project is structured to ensure that it is easy to maintain and extend:
- **Separation of Concerns**: The project decouples the operation logic from the calculator’s execution, allowing operation logics to be injected dynamically at runtime.
- **Modular Design**: The `Calculator` interface defines a contract that different implementations can adhere to. This makes it possible to introduce new types of calculators in the future without impacting existing functionality.

## Project Structure
```
calculator/
├── src/
│   ├── main/
│   │   ├── Impl/
│   │   │   ├── BasicCalculator.java
│   │   ├── model/
│   │   │   ├── Calculator.java
│   │   ├── operations/
│   │   │   ├── Operation.java
│   │   │   ├── OperationFormat.java
│   │   │   ├── Impl/
│   │   │   │   ├── AddOperation.java
│   │   │   │   ├── DivideOperation.java
│   │   │   │   ├── MultiplyOperation.java
│   │   │   │   ├── SubtractOperation.java
│   ├── test/
│   │   ├── Impl/
│   │   │   ├── BasicCalculatorTest.java
├── README.md
```
- **`Calculator.java`**: The interface defining the contract for calculator implementations.
- **`BasicCalculator.java`**: The main implementation of the `Calculator` interface, it performs basic operations and supports chaining.
- **`Operation.java`**: An enum representing basic arithmetic operations.
- **`OperationFormat.java`**: Interface for the strategy pattern used for different operation implementations.
- **`BasicCalculatorTest.java`**: Unit tests ensuring the correctness of the `BasicCalculator` implementation.

## Usage

### Basic Operations

The `BasicCalculator` class supports basic arithmetic operations such as addition, subtraction, multiplication, and division. These operations are defined in the `Operation` enum.

Example:

```java
Number result = calculator.basicCalculate(Operation.ADD, 2, 3);
System.out.println(result); // Outputs 5.0
```


### Chaining Operations

The chainOperations method allows you to perform multiple operations sequentially:

```java
Number result = calculator.setState(5)
        .chainOperations(Operation.ADD, 3)
        .chainOperations(Operation.MULTIPLY, 5)
        .getChainingResult();
System.out.println(result); // Outputs 40
```

## Testing

The project includes a comprehensive suite of unit tests to ensure the correctness of the calculator’s functionality. The tests are written using the JUnit framework and can be run using Maven or your preferred IDE.
```shell
mvn test
```


## JavaDoc

This project is fully documented here. [Doc](./doc/index.html)

