Here's a sample Java code demonstrating the use of all primitive data types:

```java
public class PrimitiveDataTypesExample {
    public static void main(String[] args) {
        // byte - 8-bit signed integer
        byte byteVar = 100;
        System.out.println("byte value: " + byteVar);
        
        // short - 16-bit signed integer
        short shortVar = 10000;
        System.out.println("short value: " + shortVar);
        
        // int - 32-bit signed integer
        int intVar = 100000;
        System.out.println("int value: " + intVar);
        
        // long - 64-bit signed integer
        long longVar = 10000000000L; // Note the 'L' at the end
        System.out.println("long value: " + longVar);
        
        // float - 32-bit floating point
        float floatVar = 20.5f; // Note the 'f' at the end
        System.out.println("float value: " + floatVar);
        
        // double - 64-bit floating point
        double doubleVar = 12345.6789;
        System.out.println("double value: " + doubleVar);
        
        // char - 16-bit Unicode character
        char charVar = 'A';
        System.out.println("char value: " + charVar);
        
        // boolean - 1-bit value (true or false)
        boolean booleanVar = true;
        System.out.println("boolean value: " + booleanVar);
    }
}
```

### Explanation:
- `byteVar`: Stores a small integer.
- `shortVar`: Stores a larger integer than `byte`.
- `intVar`: Most commonly used for integers.
- `longVar`: Stores very large integers, indicated with an `L`.
- `floatVar`: Used for decimal numbers, indicated with an `f`.
- `doubleVar`: More precise than `float` for decimal numbers.
- `charVar`: Stores a single character, enclosed in single quotes.
- `booleanVar`: Stores a true/false value.

### Output:
```
byte value: 100
short value: 10000
int value: 100000
long value: 10000000000
float value: 20.5
double value: 12345.6789
char value: A
boolean value: true
```