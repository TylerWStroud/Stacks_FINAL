// Name: Tyler Stroud
// Class: CS 3305/section W01
// Term: Spring 2025
// Instructor: Emin Mary Abraham
// Assignment: 4A

public class ReverseString {
    public static void main(String[] args) {
        // scanner, Stack(String) declaration
        java.util.Scanner scan = new java.util.Scanner(System.in);
        MyStack<String> stringStack = new MyStack<>();

        //MAIN MENU
        int input = 0;
        while(input != 3){
            try{
                String userText = " ";
                System.out.print("""
                        
                        -----------------MAIN MENU---------------
                        1 – Read input string of words
                        2 – Reverse string and display outputs
                        3 - Exit program
                        
                        Enter option number:\s""");
                input = Integer.parseInt(scan.nextLine());

                // in case user inputs a choice not on the menu
                if(input < 1 || input > 3)
                    System.out.println("That is not a valid menu option. Please choose between options 1-3.");

                // Menu functions
                switch(input) {
                    /* reads user input and parses into string stack */
                    case 1:
                        System.out.print("\nEnter your string text: ");
                        userText = scan.nextLine();

                        // creates string array for parsing into stack. Split by spaces.
                        String[] splitText = userText.split(" ");
                        // pushes each element of string array onto stack.
                        for (String str : splitText) {
                            stringStack.push(str);
                        }
                        break;

                    /* reverse string. display outputs */
                    case 2:
                            // in case option 1 isn't completed yet
                        if(stringStack.isEmpty())
                            System.out.println("You must enter a string first.");

                            // output
                        else {
                            System.out.print("\nEntered string:   " + userText);
                            System.out.print("\nReversed string:");
                            stringStack.printStack();
                            System.out.println();
                        }
                        break;
                }
            }catch(NumberFormatException e){
                // in case a number isn't inputted by user at choosing menu option
                System.out.println("That is not a valid menu option. Please choose between options 1-3.");
            }
        }
        System.out.println("Exiting...");
    }
}
