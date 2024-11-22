package oneIntro;

public class Lab1 { // class name has to be same as file name! new class goes in new file!
    public static void main(String[] args) {
        System.out.println("Hello World");
        // System.out.println("First argument: " + args[0]);
    }

    // methods can go in here
}

// In line comments
/*
 * Docstrings
 * are like this!
 * made to run on diff OS's and CPU's
 * 
 * Java is programming language and environment (JDK)
 * App environment (JRE) runtime environ... JDK has both
 * Compiled with'javac {filename}.java into a class file then jvm runs the byte code ie faster than python
 * 
 * c# 2002 compiled again into CIL (common intermediate language) code.
 * 
 * naming conventions:
 * start with letter not number/dont use reserved words/Case sensitive
 * classes caps/pascalcase
 * methods & vars etc lower/camelcase
 * packages lowercase/camelcase
 * 
 * vars:
 * declared with type
 * can declare ie int x; but need to initialise with a value ie x = 10;
 * PRIMITIVE - directly stores value in stack
 * REFERENCE TYPES - like String references an object, think its immutable? ref stored on the stack, obj on heap memory
 * var reassignment --
 *      primitive - type is copied when as
 *      reference - multiple refs points to same obj so will overwrite!
 * Scope ie local vs global
 * 
 */