package linkedlist;

import com.sun.org.apache.regexp.internal.RE;

public class LinkedList {

    Node head;
    int size;
    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        
        list.add(7);
        list.add(6);
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        
        list.print();
        
        int max = list.max();
        
        System.out.println("max = " + max);
        
        // int maxR = list.maxR();
        // System.out.println("maxR = " + maxR);
        
       // list.delete(3);
        
        // list.alternate(3);
        // list.print();
        
        // list.reverse();
        // list.print();
        
        list.reverseKGroup(3);
        
        LinkedList l1 = new LinkedList();
        l1.add(3);
        l1.add(4);
        l1.add(2);
        
        LinkedList l2 = new LinkedList();
        l2.add(7);
        l2.add(6);
        l2.add(5);
        
        Node ret = l1.addTwoNumbers(l1.head, l2.head);
        
        ret.print();
        
        
    }
    
    public Node reverse() {
        head = reverse(head);
        return head;
    }
    
    
    public Node addTwoNumbers(Node l1, Node l2) {
        int remainder = 0;
        Node head = l1;
        l1.print();
        l2.print();
        Node last = l1;
        while (l1 != null && l2 != null) {
            int v1 = l1.value;
            int v2 = l2.value;
            
            int fv = v1 + v2 + remainder;
            
            
            int nv = fv %10;
            remainder = fv/10;
            l1.value = nv;
            
            last = l1;
            l1 = l1.next;
            l2 = l2.next;
            
        }
        System.out.print("remainder=" + remainder );
        last.print();
        if (remainder != 0) {
            last.next = new Node(remainder);
        }
        head.print();
        return head;
    }
    
    public Node reverseKGroup(int k) {
        Node temp = head;
        Node newHead = null;
        while (temp != null) {
            System.out.print("temp==:: ");
            temp.print();
            Node reverse = reverseKGroup(temp, k);
            System.out.print("temp after reversing==:: ");
            temp.print();
           if (newHead == null) {
               newHead = reverse;
           }
           temp = temp.next;
        }
        
        newHead.print();
        return newHead;
    }
    
    
    
    
    
    private Node reverseKGroup(Node first, int k) {
        Node reverse = null;
        Node tail = null;
        int i = 0;
        while (first != null && i < k) {
            Node second = first.next;
            first.next = reverse;
            if (tail == null) {
                tail = first;
            }
            reverse = first;
            first = second;
            i++;
            // reverse.print();
        }
        System.out.print("reverse==:: ");
        reverse.print();
        System.out.print("reverse tail==:: ");
        tail.print();
        tail.next = first;
        System.out.print("reverse after attaching ==:: ");
        reverse.print();
        return reverse;
    }
    
    private Node revrseI() {
        Node first = head;
        Node temp = null;
        while (first != null) {
            Node second = first.next;
            first.next = temp;
            temp = first;
            first = second;
            
        }
        
        return temp;
    }
    
    private Node reverse(Node h) {
        System.out.println("reverse(" + h + ")");
        
        if (h == null) {
            return null;
        }
        if (h.next == null) {
            System.out.println("->reverse(" + h + ")");

            return h;
        }

        Node second = h.next;
        Node r = reverse(second);
        second.next = h;
        System.out.print("reverse(" + h + ")->");
        h.next = null;
        r.print();
        return r;
        
    }
    
    
    public Node alternate(int k) {
        if (size() <= 2) {
            return head;
        }
        
        Node cur = head;
        Node kth = head;
        Node temp = null;
        k--;
        
        while (k >= 0) {
            temp = kth;
            kth = kth.next;
            k--;
        }
        
        temp.next = null;
        
        head = merge(cur, kth);
        
        return head;
       
    }
    
    private Node merge(Node first, Node second) {
        
        
      Node tail = null;
      Node head = null;
      while (true) {
          if (first == null || second == null) {
              break;
          }
          
          Node f = first;
          Node s = second;
          first = first.next;
          second = second.next;

          s.next = null;
          f.next = s;
          if (tail != null) {
              tail.next = f;
          }
          tail = s;
          if (head == null) {
              head = f;
          }
       }
      
      if (first != null) {
          tail.next = first;
      }
      
      if (second != null) {
          tail.next = second;
      }
      
      return head;
       
       
     }
    
    
    
    
    private void swapValues(Node first, Node second) {
        int temp = first.value;
        first.value = second.value;
        second.value = temp;
    }
    
    public int size() {
        return size;
    }
    public Node rotate(int k) {
        Node temp = head;
        Node cur = head;
       
       while (cur != null) {
           cur = cur.next;
           k--;
           if (k == 2) {
               break;
           }
       }
       
       Node h = cur.next;
       cur.next = null;
       return head;
    }
    
    
    public void delete(int n) {
        
        if (head == null) {
            return;
        }
        
        Node cursor = head;
        while (cursor.next != null) {
            if (cursor.next.value == n) {
                cursor.next = cursor.next.next;
                size--;
            }
            cursor = cursor.next;
        }
        
       if (head.value == n) { //head being the same as the value to be delete is a special case.
           head = head.next;
           size--;
       }
    }
    
    public void add(int data) {
        
        Node newNode = new Node(data);
        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
        size++;
    }
    
    
    public int max() {
        int max = Integer.MIN_VALUE;
        Node cursor = head;
        while (cursor != null) {
            max = Math.max(max, cursor.value);
            cursor = cursor.next;
        }
        return max;
    }
    
    public int maxR() {
        return maxR(head, Integer.MIN_VALUE);
    }
    
    private int maxR(Node node, int max) {
        if (node == null) {
            return max;
        } 
        max = Math.max(max,  node.value);
        return maxR(node.next, max);
    }
    
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + "-->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
    
    
   
    

    private class Node {
        int value;
        Node next;
        
        Node(int value) {
            this.value = value;
        }
        
        void print() {
            Node node = this;
            while (node != null) {
                System.out.print(node.value + "-->");
                node = node.next;
            }
            System.out.println("NULL");
            
        }
        public String toString() {
            return ""+value;
        }
    }
}
