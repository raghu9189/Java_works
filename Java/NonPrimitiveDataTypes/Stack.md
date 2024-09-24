A **stack** is a linear data structure that follows the **LIFO** (Last In, First Out) principle, where the last element added to the stack is the first one to be removed. You can think of it like a stack of plates; the plate on top is the first one you take out, and the last plate you put on the stack is the first one to be removed.

### **Key Concepts:**
- **LIFO (Last In, First Out)**: The most recently added item is the first one to be removed.
- **Push and Pop**: The two primary operations to add and remove elements in a stack.

### **Basic Stack Operations (Methods)**

1. **Push (add an element to the stack)**:
   - Adds an element to the top of the stack.
   - If the stack is implemented with a fixed size (e.g., using an array), an overflow condition may occur if it exceeds the size.

   ```java
   void push(T element);
   ```

2. **Pop (remove the top element from the stack)**:
   - Removes and returns the top element from the stack.
   - If the stack is empty, a **stack underflow** condition may occur.

   ```java
   T pop();
   ```

3. **Peek (view the top element without removing it)**:
   - Returns the top element of the stack without removing it.
   - Useful when you want to see what’s on top without modifying the stack.

   ```java
   T peek();
   ```

4. **isEmpty (check if the stack is empty)**:
   - Checks whether the stack is empty.
   - Returns `true` if there are no elements in the stack, `false` otherwise.

   ```java
   boolean isEmpty();
   ```

5. **size (get the number of elements in the stack)**:
   - Returns the total number of elements present in the stack.

   ```java
   int size();
   ```

---

### **Example of Stack in Java using `Stack` class**

Java provides a built-in **Stack** class, which is part of the `java.util` package. Here's an example:

```java
import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        // Creating a stack
        Stack<Integer> stack = new Stack<>();

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Peek at the top element
        System.out.println("Top element: " + stack.peek());

        // Pop elements from the stack
        System.out.println("Popped element: " + stack.pop());

        // Check if the stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty());

        // Get the current size of the stack
        System.out.println("Stack size: " + stack.size());
    }
}
```

### **Output:**
```
Top element: 30
Popped element: 30
Is stack empty? false
Stack size: 2
```

### **Explanation of Methods:**
1. **`push(10)`**, **`push(20)`**, **`push(30)`**: These add elements to the top of the stack.
2. **`peek()`**: Returns the top element (in this case, `30`), but does not remove it from the stack.
3. **`pop()`**: Removes the top element (`30`) and returns it.
4. **`isEmpty()`**: Checks whether the stack is empty.
5. **`size()`**: Returns the number of elements in the stack, which is `2` after popping one element.

### **Advantages of Stack**:
- Simple and easy to implement.
- Effective in handling recursive problems, such as **function call stack**.
- Used in many algorithms like **Depth-First Search (DFS)**, **backtracking**, etc.

### **Use Cases of Stack**:
- **Undo operations** in editors.
- **Backtracking** problems (like solving mazes).
- **Expression evaluation** and syntax parsing (e.g., evaluating **postfix expressions**).
- **Function calls** in programming languages, where each function call is pushed onto the call stack.

