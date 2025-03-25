// Name: Tyler Stroud
// Class: CS 3305/section W01
// Term: Spring 2025
// Instructor: Emin Mary Abraham
// Assignment: 4A

public class TestMyStack{
    public static void main(String[] args) throws Exception{
        java.util.Scanner scan = new java.util.Scanner(System.in);

        // empty stack creation
        MyStack<Integer> intStack = new MyStack<>();

        // MAIN MENU
        int input = 0;
        while(input != 7){
            try{
                System.out.print("""
                        
                        --------MAIN MENU-------
                        1 – Push element
                        2 – Pop element
                        3 – Get top element
                        4 – Get stack size
                        5 – Is empty stack?
                        6 - Print stack
                        7 - Exit program
                        
                        Enter option number:\s""");
                input = Integer.parseInt(scan.nextLine());

                // in case user inputs a choice not on the menu
                if(input < 1 || input > 7)
                    System.out.println("That is not a valid menu option. Please choose between options 1-7");

                // Menu functions
                switch(input) {
                    /* push() */
                    case 1:
                        int intElement = 0;
                        boolean isInteger = false;

                        // try/catch in case user inputs a non-integer value
                        while( !isInteger ){
                            System.out.print("\nEnter the (Integer) element you want to add to your stack: ");
                            String newElement = scan.nextLine();
                            try {
                                intElement = Integer.parseInt(newElement);
                                isInteger = true;
                            } catch (NumberFormatException e) {
                                System.out.print("\n** Error: That is not an Integer **");
                            }
                        }

                        // displaying results
                        System.out.println("\nMethod push()");
                        System.out.print("Stack before pushing "+intElement+" onto stack:");
                        intStack.printStack();
                        intStack.push(intElement);
                        System.out.print("\nStack after pushing "+intElement+" onto stack: ");
                        intStack.printStack();
                        System.out.println();
                        break;

                    /* pop() */
                    case 2:
                        System.out.println("\nMethod pop()");
                        if(intStack.isEmpty())
                            System.out.println("No elements in stack to pop.");
                        else {
                            System.out.print("Stack before popping "+intStack.top()+":");
                            intStack.printStack();
                            System.out.print("\nStack after popping "+intStack.pop()+": "); // .pop() call
                            intStack.printStack();
                            System.out.println();
                        }
                        break;

                    /* top() */
                    case 3:
                        System.out.println("\nMethod top()\nThe top element in the stack is: "+intStack.top());
                        break;

                    /* size() */
                    case 4:
                        System.out.println("\nMethod size()\nYour stack is "+intStack.size()+" elements.");
                        break;

                    /* isEmpty() */
                    case 5:
                        System.out.println("\nMethod isEmpty()");
                        if(intStack.isEmpty())
                            System.out.println("Your stack is empty.");
                        else{
                            System.out.println("Your stack is not empty.");
                        }
                        break;

                    /* printStack() */
                    case 6:
                        System.out.println("\nMethod printStack()");
                        System.out.print("Here is your stack: ");
                        intStack.printStack();
                        System.out.println();
                        break;
                }
            }catch(NumberFormatException e){
                // in case a number isn't inputted by user at choosing menu option
                System.out.println("\nInvalid menu option. Please choose between options 1-7");
            }
        }
        System.out.println("Exiting...");
    }
}

