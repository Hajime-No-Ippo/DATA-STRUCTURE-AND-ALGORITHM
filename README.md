[![ko-fi](https://www.ko-fi.com/img/githubbutton_sm.svg)](https://ko-fi.com/erictao)

Core Programming Concepts (Java, Arrays, and Algorithms)
This repository contains educational materials covering fundamental data structures (Arrays) and essential programming constructs in Java, focusing on memory management, algorithm efficiency, and object-oriented principles like Encapsulation.
1. Arrays: Structure and Fundamentals
Arrays are used to group large numbers of variables together and store a list of values. They are crucial for tasks that involve storing large inputs, such as 100 individual integer age values.
1.1 Array Structure and Indexing
• Memory Structure: An array is an object made out of a contiguous block of memory that is divided into several "slots".
• Data Consistency: Every slot holds a value of the same type (e.g., all int or all double).
• Indexing: Slots are accessed using an index, which must be an integer type. Indexing starts at zero. If an array has N slots, the indices range from 0 through N−1. Accessing a slot that does not exist results in a non-legal operation (boundary error).
• Fixed Size: Once an array has been constructed, the number of slots (its length) will not change.
• Initial Values: When an array is created, values are automatically initialized based on type: numbers default to 0, booleans to false, and object references to null.
1.2 Declaration and Usage
• Declaration Syntax: Arrays can be declared and constructed using syntax like: type[] arrayName = new type[length];. Examples include int[] myArray = new int; or double[] theArray = new double;.
• Direct Initialization: An array can be declared, constructed, and initialized in one statement using a list, e.g., int[] data = {23, 38, ...}.
• Elements as Variables: Array entries (or elements) can be used exactly like standard variables, including in arithmetic expressions.
• Dynamic Indexing: Variables or expressions that evaluate to an integer can be used as index values (e.g., data[index-3]).
1.3 Array Operations and Growth
• Copying: Assigning one array variable to another (e.g., array2 = array1;) does not copy the elements; it only copies the reference (location) in memory. To copy the contents, elements must be copied one by one, usually using a loop. The source and destination arrays must be of the same data type.
• Filling (Insertion): Since arrays are fixed size, inserting into a partially filled array often requires using a separate variable (like dataSize) to track how many elements are currently stored and identifying the next available slot.
• Growing an Array: If a fixed-size array is full and requires more space, the operation involves creating a new, larger array (e.g., doubling the length), copying all existing elements from the old array to the new array, and then updating the reference variable to point to the new array (data = newData;).
1.4 Two-Dimensional (2D) Arrays
• Structure: 2D arrays store data using two separate indices, visualized like a rectangle (rows and columns), useful for structures like maps or chessboards.
• Access: Access usually follows the pattern: row first, then column (e.g., myArray[row][column]).
• Initialization: Initializing or searching a 2D array commonly requires the use of two nested loops.
2. Array Algorithms and Efficiency
2.1 Linear Search (Unordered Arrays)
• Concept: Linear Search involves checking every item in an array starting from the beginning until the target item is found.
• Disadvantage: Linear search requires checking EVERY item, making it inefficient for searching large datasets.
2.2 Ordered Arrays and Binary Search
• Ordered Arrays: If the information in an array is sorted (ordered), a much faster search algorithm called Binary Search can be used.
• Binary Search Principle: Binary search operates by playing a "guessing game" where it checks the middle element of the current search space. Based on whether the middle element is larger or smaller than the target, the search space is instantly cut in half (or "halved").
• Algorithm Steps: The algorithm maintains lowerBound and upperBound variables to track the current range of the search. It repeats the process while the search space is greater than 0, adjusting the bounds until the target is found or the range is exhausted.
• Efficiency: As arrays get bigger, Binary Search is significantly more important than Linear Search. Its complexity is logarithmic, often denoted as O(logN), because each iteration halves the search space. A linear search, conversely, takes linear time, O(N).
2.3 Array Maintenance Challenges (Ordered Data)
While ordered arrays make searching fast, inserting and deleting elements become costly operations:
• Insertion: A new element must be inserted into the correct place to maintain the sort order, requiring an algorithm to move (shuffle) all succeeding elements up one slot to make room.
• Deletion: When an element is removed, a gap is left behind. An algorithm is needed to move all subsequent elements down to fill the gap.
• Evaluation: Ordered arrays are generally useful when searches are frequent and insertions/deletions are not.
3. Java Programming Fundamentals & OOP
3.1 Program Structure and Methods
• Java Programs are built up of multiple files called classes. Classes are composed of variables (storing information) and methods (chunks of code that perform a specific job and may return a result).
• Reusability: Splitting a program into distinct files (classes/methods) allows for easier component reuse.
• Method Structure: Methods are defined by their access modifier (public, private), return type (void, int, String, etc.), name, and parameter list. The return statement must be included at the end if the method is supposed to return an answer.
• Main Method: The main() method is a special method that always runs first by the Java Virtual Machine (JVM). It is typically declared as public static void main(String[] args).
    ◦ public: Can be run from anywhere.
    ◦ static: Can be run without creating an object.
    ◦ void: Does not return a result.
3.2 Variables and Data Types
• Variables are names for a location in memory.
• Primitive Types (fixed size, lowercase names): Include integers (byte, short, int, long) and floating-point numbers (float, double), characters (char), and boolean values (true/false).
    ◦ Casts ((int)) are used to convert values to a different type, such as converting a double to an int.
• Reference Types (objects): Start with a capital letter (e.g., String).
• Scope: The area of the program in which a variable is available is its scope.
    ◦ Local variables (defined inside a method/loop) only exist for the duration of that method and are disposed of by Java's garbage collector when the function exits.
    ◦ Instance variables (defined inside a class but outside methods) belong uniquely to each object created from that class and are often declared private.
    ◦ Class variables (static) are shared among all objects of that class.
3.3 Control Flow (Selection and Iteration)
Programming languages are largely based on three simple structures: Sequence (lines separated by semicolons), Selection (if/else), and Iteration (for/while/do).
• Selection (if/else): Conditional statements allow choosing which code runs next based on a Boolean test using relational operators (>, ==, !=, etc.). Block statements use curly braces {} to group multiple statements.
• Iteration (Loops): Repetition statements allow code to execute multiple times, controlled by a Boolean expression.
    ◦ while Loop: Executes zero or more times. The condition is tested prior to executing the loop body.
    ◦ do-while Loop: Executes at least once. The statement executes once initially, then the condition is evaluated.
    ◦ for Loop: Best suited when the number of executions can be determined in advance (definite size). It executes initialization once, then repeats the condition-statement-increment cycle.
3.4 Object-Oriented Concepts (Classes and Encapsulation)
• Classes and Objects: A Class is a collection of variables and methods that operate on those variables. An Object is an instance of a class, created using the new keyword. The constructor runs automatically when a new object is created.
• Calling Methods on Objects: Methods belonging to a class are invoked on a specific object using the dot operator (e.g., myCircle.getArea()).
• Encapsulation: This principle involves tying related pieces of information together in a single data structure and hiding the unimportant implementation details. Objects act like a black box; users know what information to use (input parameters) and what methods to call, but not how the methods work internally.
    ◦ Encapsulation is achieved by declaring instance variables as private, meaning other classes cannot access or manipulate them directly; instead, access is provided through public methods.
4. Lab Example: Luhn's Algorithm
The problem statement provided outlines the task of taking a credit card number and determining if it is valid using the Luhn's Algorithm.
The validation steps require:
1. Starting from the rightmost digit (the check digit) and moving left, doubling the value of every second digit.
    ◦ If the result of the doubling operation is greater than 9 (e.g., 2×8=16), the digits must be added together (e.g., 1+6=7). (Alternatively, 9 can be subtracted from the product if the result is >9).
2. Taking the sum of all digits.
3. The number is valid only if the total sum modulo 10 is equal to 0 (i.e., if the total ends in zero).
