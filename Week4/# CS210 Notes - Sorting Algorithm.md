# CS210 Notes - Sorting Algorithm
### Different Sorting Algorithms: 
1. Bubble sorting
2. Insertion sorting
3. Selection sorting
---

### These algorithms all have a complexity of O(n2) 
- *BUBBLE, SELECTION, INSERTION*
- How to swap elements?
<pre>
int temp = arr[i];
arr[i] = arr[i + 1];
arr[i + 1] = temp;
//swap elements on index 'i' with elements on 'i+1'
</pre>
---
### Sorting Algorithm in Java21
 ***Insertion Algorithm***

- Insertion sort is a simple, comparison-based sorting algorithm that builds the final sorted array one element at a time. 
- It works by dividing the array into a sorted portion (initially just the first element) and an unsorted portion. 
- Then, for each element in the unsorted portion, it “inserts” it into its correct position in the sorted portion by shifting larger elements to the right.
<pre>
public static void insertionSort(int[] arr)
{
    int n = arr.length;
    for(int i = 1; i < n; i++)
    {
        int key = arr[i];
        int j = i - 1;
        while(j >= 0 && arr[j] > key)  //this is for checking if sorted group is bigger than key
        {
            arr[j + 1] = arr[j];       //paste the 'key' elements to the right-hand elements.
            j--;                       //keep checking elements till arr[j] 
        }
        arr[j + 1] = key;              //update 'key'
    }
}
</pre>

 ***Selection Algorithm***

- Selection sort uses a nested loop structure: an outer loop and an inner loop.

- The inner loop is responsible for scanning the unsorted portion (starting from the outer’s next index) to find the smallest element.

- After that, the algorithm swaps the found smallest element into the position at the “outer” index.
<pre>
public static void selectionSortMethod(int[] arr)
{
    
    for (int outer = 0; outer < arr.length; outer++)
    {
        int minIndex = outer;
        for (int inner = outer + 1; inner < arr.length; inner++)           //setup nested loop
        {
            if(arr[inner] < arr[minIndex])                                 //check the smallest elements
            {
                minIndex = inner;                                          //update the smallest index
            }
        }
        if (minIndex != outer) {                    
            swap(arr, outer, minIndex);                                    //swap
        }
    }
}

public static void swap(int[]arr, int outer, int minIndex)
{
    int tmp = arr[outer];
    arr[outer] = arr[minIndex];
    arr[minIndex] = tmp;
}
</pre>

### Recursion
- Recursion is a method which can call itself.
- When it call itself, it solve a small problem.

***Factorial***

5! = 5 * 4 * 3 * 2 * 1 = 120
<pre>
public static int factorial( int N ) { 
	if ( N == 1 ) 
		return 1; 
	else 
		return N * factorial( N-1 );                                  //5 * 4 * 3 ...... * 1
} 
</pre>

***Fibonacci series***

- The Fibonacci series is as follows:
- 1, 1, 2, 3, 5, 8, 13…
- Each term is calculated by the sum of the two terms before it

<pre>
public static long fibonacci(int n) {    
	if (n == 1) return 1;    
	if (n == 2) return 1;    
	return fibonacci(n-1) + fibonacci(n-2); 
}
</pre>

***The Efficiency of Recursion***

- Recursive implementation of fib is straightforward 
- First few calls to fib are quite fast 
- For larger values, the program pauses a long time between outputs 
- It turns out that using recursion to compute Fibonacci  numbers is terrible!!
- REMEMBER: recursion can simplify code but is not always more efficient
- A recursive method should not call itself more than once per input.
If we want to use recursion, without exponential increase in number of method calls, we can use **dynamic programing**

***Dynamic Programing***
- Time Com­plex­ity: O(n) , Space Com­plex­ity : O(n)
- To decide whether prob­lem can be solved by apply­ing Dynamic pro­gram­ming we check for two prop­er­ties. 

**Dynamic Programing - Bottom Up**

* Bottom-Up solu­tion for Fibonacci Series:

<pre>
public int fibBU(int x) {
	int fib[] = new int[x + 1];
	fib[0] = 0;
	fib[1] = 1;
	for (int i = 2; i < x + 1; i++) {
		fib[i] = fib[i - 1] + fib[i - 2];
	}
    return fib[x];
}
</pre>

* Top-Down solution for Fibonacci Series:

<pre>
public int fibTD(int n) {
	if(n==0) return 1;
	if(n==1) return 1;
	if(fib[n]!=0){
		return fib[n];
	}
    else{
		fib[n] = fibTD(n-1) + fibTD(n-2);
	    return fib[n];
	}
}
</pre>

