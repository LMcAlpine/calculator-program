# CalculatorProgram
A Java Swing application that provides multiple calculator modes in a tabbed GUI. It supports binary, hexadecimal, decimal, and big-number arithmetic with additional conversion utilities.

## Features
- Binary Calculator

  - Addition, subtraction, multiplication, and division.

  - Convert between binary and decimal representations.

- Hex Calculator

  - Perform basic arithmetic on hexadecimal numbers.

  - Convert between hex and decimal.

- Decimal Calculator

  - Integer and floating‑point arithmetic.

- BigNumber Calculator

  - Operate on BigInteger and BigDecimal values.

  - Extra utilities: square, square root, factorial, greatest common divisor (GCD), and least common multiple (LCM).

## Requirements
Java Development Kit (JDK) 8 or later.
Swing is part of the standard JDK; no external libraries are required.

## Building and Running
# inside the calculator-program directory
javac -d out src/com/assignmentTwo/*.java
java -cp out com.assignmentTwo.Main
Launching the application opens a window with four tabs—one for each calculator type—plus separate panels for conversions.

## Project Structure
```graphql
src/com/assignmentTwo/
├── Main.java              # Entry point
├── GUI.java               # Hybrid controller/view
├── Calculator.java        # Abstract base class
├── BinaryCalculator.java  # Binary arithmetic + conversions
├── HexCalculator.java     # Hex arithmetic + conversions
├── DecimalCalculator.java # Decimal arithmetic (int & double)
├── BigNumberCalculator.java
├── BinaryConverter.java   # Interface for binary conversions
├── HexConverter.java      # Interface for hex conversions
├── CalculatorPanel.java   # Input panel
├── ConversionPanel.java   # Conversion utilities
├── TopPanel.java          # Title panel
├── MiddlePanel.java       # Holds calculator & result panels
└── ResultPanel.java       # Displays results
```

## Usage
Choose a tab to select the desired calculator type.

Enter one or two values in the text fields.

Pick an operation from the drop‑down menu or press Calculate in conversion panels.

Results appear instantly; clear buttons reset the fields.

For big-number operations, set precision when prompted and explore the additional utilities.
