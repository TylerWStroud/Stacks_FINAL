// Name: Tyler Stroud
// Class: CS 3305/section W01
// Term: Spring 2025
// Instructor: Emin Mary Abraham
// Assignment: 4A

public class CheckPalindrome {
    public static void main(String[] args){
        // scanner, Stack(char) declaration
        java.util.Scanner scan = new java.util.Scanner(System.in);
        MyStack<Character> charStack = new MyStack<>();
        java.util.ArrayList<Character> charArray = new java.util.ArrayList<>();
        String userText = " ";

        // MAIN MENU
        int input = 0;
        while(input != 3){
            try{
                System.out.print("""
                        
                        -----------------MAIN MENU----------------
                        1 – Read input string
                        2 – Check palindrome and display output
                        3 - Exit program
                        
                        Enter option number:\s""");
                input = Integer.parseInt(scan.nextLine());

                // in case user inputs a choice not on the menu
                if(input < 1 || input > 3)
                    System.out.println("That is not a valid menu option. Please choose between options 1-3.");

                // Menu functions
                switch(input){
                    /* reads user input and parses into character Stack and character ArrayList for later comparison */
                    case 1:
                        charArray.clear();
                        System.out.print("Enter your string text: ");
                        userText = scan.nextLine();
                        // splits user input into a char array
                        char[] splitText = userText.toCharArray();

                        // pushes char array elements onto charStack and adds to character Array List
                        // converts all characters to uppercase for consistency during comparison
                        for(Character chr : splitText){
                            charStack.push(Character.toUpperCase(chr));
                            charArray.add(Character.toUpperCase(chr));
                        }
                        break;

                    /* palindrome check */
                    case 2:
                        // in case option 1 isn't completed yet
                        if(charStack.isEmpty())
                            System.out.println("You must enter a string first.");

                        else {
                            System.out.printf("%-19s%-1s", "\nEntered String: ", userText);
                            System.out.printf("%-19s", "\nJudgement: ");

                            boolean isPalindrome = true;
                            while (isPalindrome) {
                                // linearly compares Stack elements with ArrayList elements
                                for (Character chr : charArray) {
                                    // cutoff
                                    if (!charStack.pop().equals(chr)) {
                                        isPalindrome = false;
                                        System.out.print("Not palindrome");
                                        break;
                                    }
                                }

                                if (isPalindrome) {
                                    System.out.print("Palindrome");
                                    break;
                                }
                            }
                            System.out.println();
                        }
                        break;
                }
            }catch(NumberFormatException e){
                System.out.println("That is not a valid menu option. Please choose between options 1-3.");
            }
        }
        System.out.println("Exiting...");
    }
}
