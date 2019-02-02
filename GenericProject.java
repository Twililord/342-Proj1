/*
Aleksandar Knezevic - knezevi2
Create stack and queue data structures by inheriting from a generic abstract class,
implement methods for them, and accept any data type when an instance is created
*/

public class GenericProject {

    public static void main(String[] args) {
        /*
        GenericStack<Integer> stk = new GenericStack<Integer>(1);
        stk.push(2);
        stk.push(3);
        int l = stk.getLen();
        System.out.println("Length: " + l);
        stk.pop();
        stk.print();

        GenericQueue<Double> q = new GenericQueue<Double>(1.1);
        q.enqueue(2.2);
        q.enqueue(3.3);
        q.dequeue();
        l = q.getLen();
        System.out.println("Length: " + l);
        q.print();
        */
    }
}

abstract class GenericList<I> { //abstract class for stack and queue to inherit
    Node<I> head;       //data members
    private int length;

    public void print() { //method to print all values in list
        Node<I> h = this.head;
        if(h == null) {
            System.out.println("List empty!");
            return;
        }

        while(h != null) { //traverses list
            System.out.println(h.data);
            h = h.next;
        }
    }

    I delete() { //deletes node and returns its value
        if(this.head == null) { //checks if list is empty
            System.out.println("List empty!");
            return null;
        }

        Node<I> h = this.head; //creates copy of head
        I obj = h.data;         //copy of value

        this.head = h.next; //next node becomes head
        length--;           //decrements length

        return obj;
    }

    abstract void add(I data); //declaration of add method to be defined

    public int getLen() { //getters and setters for len
        return length;
    }

    public void setLen(int len) {
        length = len;
    }

    class Node<T> { //node class that holds value
        private T data; //node data members
        Node<T> next;

        Node(T obj) { //node constructor
            data = obj;
            next = null;
        }
    }
}

class GenericStack<I> extends GenericList<I> { //stack class, inherits from genlist
    GenericStack(I obj) { //constructor that takes in generic value
        this.head = new Node<I>(obj); //new instance of head
        setLen(1);
    }

    void add(I data) { //creates node with data value and adds to front of list
        Node<I> n = new Node<I>(data); //creates new node

        if(this.head == null) { //checks if list is empty
            System.out.println("List empty!");
            return;
        }

        n.next = this.head; //links to current head
        this.head = n;      //sets head to new node
        int len = getLen(); //gets length and increments
        setLen(++len);
    }

    public void push(I data) { //wrapper method for add
        add(data);
    }

    public I pop() { //wrapper method for delete
        I out = delete();
        return out;
    }
}

class GenericQueue<I> extends GenericList<I> { //queue class, inherits from genlist
    GenericQueue(I obj) { //constructor that takes in generic value
        this.head = new Node<I>(obj); //new instance of head
        setLen(1);
    }

    void add(I data) { //creates node with data value and adds to back of list
        Node<I> h = this.head;          //copy of head
        Node<I> n = new Node<I>(data);  //creates new node

        if(h == null) { //checks if list is empty
            System.out.println("List empty!");
            return;
        }

        while(h.next != null) //traverses to last node
            h = h.next;

        h.next = n; //links last node to new node

        int len = getLen(); //updates length
        setLen(++len);
    }

    public void enqueue(I data) { //wrapper method for add
        add(data);
    }

    public I dequeue() { //wrapper method for delete
        I out = delete();
        return out;
    }
}
