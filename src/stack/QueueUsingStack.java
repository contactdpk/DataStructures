package stack;

/**
 * Created by Deepak on 7/14/2019.
 */
public class QueueUsingStack {
    private ArrayStack mainStack, auxStack;

    public QueueUsingStack() {
        mainStack = new ArrayStack();
        auxStack = new ArrayStack();
    }

    /**
     * Method 1 (By making enQueue operation costly)
     * This method makes sure that oldest entered element is always at the top of stack 1, so that deQueue operation
     * just pops from stack1. To put the element at top of mainStack, auxStack is used.
     */
    public void enQueue1(int data) {
        while (!mainStack.isEmpty()) {
            auxStack.push(mainStack.pop());
        }
        mainStack.push(data);
        while (!auxStack.isEmpty()) {
            mainStack.push(auxStack.pop());
        }
    }

    public int deQueue1() {
        if (mainStack.isEmpty()) {
            System.out.println("Queue Is Empty");
            return -1;
        }
        return mainStack.pop();
    }

    /**
     * Method 2 (By making deQueue operation costly)
     * In this method, in en-queue operation, the new element is entered at the top of stack1. In de-queue operation,
     * if stack2 is empty then all the elements are moved to stack2 and finally top of stack2 is returned.
     */

    public void enQueue2(int data) {
        mainStack.push(data);
    }

    public int deQueue2() {
        if (mainStack.isEmpty() && auxStack.isEmpty()) {
            System.out.println("Queue Is Empty");
            return -1;
        } else {
            if (auxStack.isEmpty()) {
                while (!mainStack.isEmpty()) {
                    auxStack.push(mainStack.pop());
                }
            }
            return auxStack.pop();
        }
    }
}
