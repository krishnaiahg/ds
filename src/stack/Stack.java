package stack;

public class Stack {
    
    Node top;
    
    int size = 0;

    public static void main(String[] args) {
    }

    
    public void push(int value) {
        Node newNode = new Node(value);
        
        if (top != null) {
            newNode.next = top;
        }
        top = newNode;
        size++;
    }
    
    public int pop() {
        if (top == null) {
            throw new IllegalStateException("Stack is Empty");
        }
        
        int value = top.value;
        
        top = top.next;
        size--;
        return value;
    }
    
    
    public int size() {
        return size;
    }
    
    private class Node {
        int value;
        Node next;
        
        Node(int value) {
            this.value = value;
        }
    }
}
