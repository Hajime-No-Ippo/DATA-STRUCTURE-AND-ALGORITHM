[![ko-fi](https://www.ko-fi.com/img/githubbutton_sm.svg)](https://ko-fi.com/erictao)

---

## 1. Java Programming Fundamentals

The Java language is used to represent data structures and algorithms [1]. Java is positioned in the middle range of programming languages, offering abstraction while still relating closely to system concepts [2].

### Execution and Compilation
Compiling turns code written in Java (.java file) into a format (.class file) that can be run on the Java Virtual Machine (JVM), which simulates a physical machine [3, 4]. Running a Java program requires executing the **`main()` method**, which must be declared as `public static void main(String[] args)` [5, 6].

### Variables and Data Types
A variable is a name for a location in memory [7]. Variables must have a type and a name, and cannot be Java reserved words [7].

| Type Category | Examples | Description / Size |
| :--- | :--- | :--- |
| **Integers (Primitive)** | `byte`, `short`, **`int`**, `long` | Whole numbers. `int` is 4 bytes [8, 9]. |
| **Floating Point (Primitive)** | **`double`**, `float` | Numbers with decimal points. `double` is 8 bytes [8, 10]. |
| **Boolean (Primitive)** | `boolean` | Represents `true` or `false` (1 bit) [8, 10]. |
| **Character (Primitive)** | `char` | Represents Unicode code units (2 bytes) [8, 10]. |
| **Reference** | Objects (e.g., `String`, `Scanner`) | Typically start with a capital letter [7]. |

Variables defined within a method or loop are considered **local variables** and are disposed of by Java's garbage collector when the method exits (referring to variable **scope**) [11, 12]. A **class variable** (static/final) is shared by all objects of that class [13].

### Operators and Control Flow
Java supports fundamental programming structures: **sequence**, **selection**, and **iteration** [14].

*   **Arithmetic Operators:** Include addition (`+`), subtraction (`-`), multiplication (`*`), division (`/`), and remainder (`%`, modulus operator) [15, 16]. The increment (`++`) and decrement (`--`) operators add or subtract one from an operand [17].
*   **Relational Operators:** Used in conditional tests for selection statements, comparing values (`>`, `<`, `==`, `!=`, `>=`, `<=`) [18].
*   **Logical Operators:** Used to form complex boolean expressions: Logical NOT (`!`), Logical AND (`&&`), and Logical OR (`||`) [19].
*   **Selection Statements:** Conditional statements choose which code block executes, utilizing `if` and `if-else` [20, 21].
*   **Iteration (Loops):** Repetition statements include `while`, `do-while`, and `for` loops [22].
    *   **`for` loop:** Best suited when the number of iterations is known in advance, executing zero or more times [23, 24].
    *   **`while` loop:** Executes repeatedly as long as a condition is true (zero or more times) [24, 25].
    *   **`do-while` loop:** Executes the statement at least once before checking the condition [24, 26].

---

## 2. Arrays: Structure and Declaration

Arrays are objects used to store a list of values [27]. They are a way to group large numbers of variables together [27].

### Array Structure
An array occupies a **contiguous block of memory** divided into slots [27]. All values (elements) stored in the slots must be of the **same data type** [28, 29].

*   **Indexing:** Array slots are numbered sequentially starting at **zero** (0) [30]. An array of $N$ slots has indices from 0 through $N-1$ [30, 31].
*   **Declaration and Initialization:** An array is declared using the type, square brackets, a name, and specifying the length: `type[] arrayName = new type[length];` [32]. Once constructed, the number of slots cannot change [32].
    *   Example: `int[] myArray = new int[33];` [34].
    *   When created, slots are automatically initialized: numbers to 0, booleans to `false`, and Object References to `null` [35].
*   **Array Initialization as a List:** An array can be declared, constructed, and initialized in a single statement using curly braces: `int[] data = {23, 38, ...};` [36].

### Array Operations
Array elements (or entries) can be used just like standard variables, including in arithmetic expressions (e.g., `x + data[37]`) [38].

*   **Accessing Elements:** Elements are accessed using the array name and index: `data[index]` [28].
*   **Boundary Checking:** It is **not legal** to refer to a slot that does not exist, and indexes must be integer types [31]. Attempting to access an index outside the range $[0, N-1]$ results in an `ArrayIndexOutOfBoundsExceptionError` [39].
*   **Array Length:** The length of an array is accessed using the property `array.length` [40].
*   **Copying Arrays:** Simply setting one array equal to another (`array2 = array1;`) **does not copy the data**; it only copies the array location reference, meaning both variables point to the same array object [41, 42]. To copy contents, elements must be copied one by one, typically using a loop [43, 44].

### Two-Dimensional Arrays (2D Arrays)
Two-dimensional arrays store data using two separate indices, representing rows and columns, like a rectangle or a grid [45].

*   **Declaration:** `int[][] myArray = new int[46][27];` [47].
*   **Accessing:** Indexing follows the pattern: `array[row][column]` [47].
*   **Initialization:** Nested loops are commonly used for initializing or iterating over 2D arrays, with the outer loop typically handling rows and the inner loop handling columns [48, 49].

---

## 3. Algorithms with Arrays

Arrays are often processed using algorithms, typically involving loops due to their fixed size and defined indexing [50].

### Searching Algorithms
1.  **Linear Search:** Used to find an item in an array by starting at the beginning and checking every item until a match is found [51]. Checking every item is also known as linear search when checking data in an unordered array [52].
2.  **Binary Search (for Ordered Arrays):** If the array is sorted (ordered), binary search can be used, which is much faster, especially for larger arrays [52, 53].
    *   **Principle:** The algorithm repeatedly checks the middle element of the search range and halves the search space based on whether the search key is greater or smaller than the middle element [54, 55].
    *   **Efficiency:** The complexity of binary search is logarithmic, $O(\log n)$, meaning the number of steps required increases very slowly compared to the array size [56].

### Array Manipulation
*   **Finding Max/Min:** An algorithm starts by initializing a candidate value (e.g., the first element) and then compares that candidate with the remaining elements, updating the candidate if a larger (or smaller) value is found [57, 58].
*   **Inserting into a Partially Filled Array:** Since arrays have a fixed size, tracking the number of actual elements (`dataSize`) is necessary [59, 60]. New elements are added to the next available slot, indicated by `data[dataSize]` [61].
*   **Growing an Array (Increasing Capacity):** When an array is full, capacity is increased by creating a *new*, larger array (often double the size), copying all existing elements into the new array, and then redirecting the reference to the new data structure [62, 63].
*   **Inserting/Removing in Ordered Arrays:** Maintaining order requires moving elements.
    *   **Insertion:** Requires moving larger elements up one space to create a gap for the new element [64, 65].
    *   **Removal:** Requires shifting all subsequent elements down to fill the gap left by the removed item [66-68]. Deletion and insertion operations are slower for ordered arrays due to the need for shifting elements [69].

---

## 4. Object-Oriented Programming (OOP) Concepts

OOP provides advantages like reusable components and managing code complexity [70, 71].

### Classes and Objects
*   **Classes:** A class is a template defining a collection of variables (data) and methods (behavior) that operate on those variables [70, 72]. Each Java program consists of classes, typically written in separate files named the same as the class (e.g., `Circle` class in `Circle.java`) [73, 74].
*   **Methods:** Methods are pieces of reusable code that can take input values (parameters) and return results [71, 75]. Methods defined within a class often operate on that class's variables [72].
*   **Objects:** An object is an instance of a class [74]. Objects are created using the reserved word **`new`**, which triggers the class's **constructor** [74]. Objects allow methods to be called upon them using the dot (`.`) symbol (e.g., `myCircle.getArea()`) [76, 77]. Multiple objects can be created from the same class using different constructor values [78].

### Variable Types within Classes
Variables within classes are categorized by their scope and behavior [13]:
*   **Instance Variable:** Defined inside a class; every object created from that class gets its own unique instance of that variable [79]. They are often declared as `private` to control manipulation via methods [79, 80].
*   **Class Variable (Static):** A single copy of the variable shared by all objects of that class (e.g., `public static final PI = 3.1414;`) [13, 81].
*   **Parameter Variable:** A variable that arrives via a method call (input) [13].

### Encapsulation
**Encapsulation** is a core OOP principle where related information is tied together in a single data structure, and the system hides all non-important details [82, 83].

*   Users interacting with an object only need to know the input parameters and return type of the public methods; they do not need to know the internal implementation details [82, 83].
*   If instance variables are declared as `private`, they cannot be directly accessed or manipulated by other classes, forcing interaction through defined methods—this is key to encapsulation [80, 84].

### Utility and APIs
The Java Application Programming Interface (API) provides documentation outlining all the methods associated with a class, including the parameter names, types, and functionality [85]. Built-in classes like `String`, `Scanner`, and `Math` come with their own APIs [85].
*   The `Math` class includes utility methods like `Math.sqrt(x)` (square root) and `Math.pow(x, y)` (power) [86, 87].
*   The `Scanner` class, introduced in Java 5.0, is used for reading keyboard input, including methods like `nextInt()`, `nextDouble()`, and `nextLine()` [88, 89].

---

## 5. Application Example: Luhn's Algorithm

Luhn's Algorithm is used to check the validity of a credit card number [90].

### Problem Overview
The task is to take an $n$-digit credit card number (where the last digit is the check digit) and determine if it is valid or invalid based on the algorithm [90, 91].

### Luhn's Algorithm Steps
1.  Starting from the rightmost digit (the check digit), move left, doubling the value of every second digit [90].
    *   If the result of this doubling operation is greater than 9 (e.g., $8 \times 2 = 16$), the digits of the product are added (e.g., $1+6=7$) [90]. (Alternatively, subtract 9 from the product) [90].
2.  Take the sum of all the digits (including the non-doubled digits and the resulting values from Step 1) [90].
3.  If the total modulo 10 is equal to 0 (i.e., the total ends in zero), the number is valid; otherwise, it is not valid [90].
