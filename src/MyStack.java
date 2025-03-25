// Name: Tyler Stroud
// Class: CS 3305/section W01
// Term: Spring 2025
// Instructor: Emin Mary Abraham
// Assignment: 4A

public class MyStack<E>
{
    public Node<E> StackName;

    // constructor. Initially empty.
    public MyStack()
    {
        StackName = null;
    }

    // adds generic element to top of stack (FILO)
    public void push(E data) {
        Node<E> newNode = new Node<>(data);
        newNode.next = StackName;
        StackName = newNode;
    }

    // returns top generic element, then removes from stack
    public E pop() {
        Node<E> temp = StackName;
        if(StackName.next != null)
            StackName = StackName.next;
        else
            StackName = null;

        return temp.data;
    }

    // returns top generic element
    public E top() {
        if(isEmpty())
            return null;
        else {
            return StackName.data;
        }
    }

    // returns integer count of stacked elements
    public int size() {
        int stackSize = 0;
        // check nullity
        if(isEmpty())
            return stackSize;

        // traversal count
        else
        {
            Node<E> temp = StackName;
            stackSize++;
            while(temp.next != null)
            {
                stackSize++;
                temp = temp.next;
            }
        }
        return stackSize;
    }

    // checks stack nullity
    public boolean isEmpty() {
        return StackName == null;
    }

    // prints stack from top-to-bottom in a left to right format
    public void printStack() {
        Node<E> temp = StackName;
        System.out.print(String.format("%-2s"," "));
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }


    // class to create nodes as generic objects
    private class Node<E>
    {
        private E data;  //data field
        private Node<E> next; //link field

        public Node(E item) //constructor method
        {
            data = item;
            next = null;
        }
    }
}

