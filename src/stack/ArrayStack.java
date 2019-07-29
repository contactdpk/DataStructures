package stack;

import java.util.Collection;

/**
 * Created by Deepak on 7/13/2019.
 */
public class ArrayStack {
    private final int MAX = 1000;
    private int top;
    private int a[] = new int[MAX]; // Maximum size of Stack

    public ArrayStack() {
        top = -1;
    }

    public boolean push(int data) {
        if (top >= MAX - 1) {
            System.out.println("Stack Overflow");
            return false;
        } else {
            a[++top] = data;
            System.out.println(data + "Pushed To Stack");
            return true;
        }
    }

    public int pop() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        }
        return a[top--];
    }

    public int peek() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        }
        return a[top];
    }

    boolean isEmpty() {
        return (top < 0);
    }
}
