package Hangman;

import java.util.*;


public class Hangman {

    public static void printGame() {
        System.out.println("Welcome to the Christmas themed HangMan game!\nHint(Enter all your letters as lowercase)");
        System.out.println("  |____   ");
        System.out.println("  |    |  ");
        System.out.println("  |");  //    o   
        System.out.println("  |");  //   /|\\ 
        System.out.println("  |"); //   / \\  
        System.out.println("_____     \n\n");
         
    }

    public static void PrintGameWrong(int num) {
        switch (num) {
            case 1:
                System.out.println("  |____   ");
                System.out.println("  |    |  ");
                System.out.println("  |    o");    
                System.out.println("  |");  //   /|\\ 
                System.out.println("  |"); //   / \\  
                System.out.println("_____     \n\n");
                break;
            case 2:
                System.out.println("  |____   ");
                System.out.println("  |    |  ");
                System.out.println("  |    o"); 
                System.out.println("  |    |");  //   /\\ 
                System.out.println("  |"); //   / \\  
                System.out.println("_____     \n\n");
                break;
            case 3:
                System.out.println("  |____   ");
                System.out.println("  |    |  ");
                System.out.println("  |    o"); 
                System.out.println("  |    |");  //   /\\ 
                System.out.println("  |   /"); //   / \\  
                System.out.println("_____     \n\n");
                break;
            case 4:
                System.out.println("  |____   ");
                System.out.println("  |    |  ");
                System.out.println("  |    o"); 
                System.out.println("  |    |");  //   /\\ 
                System.out.println("  |   / \\"); //   / \\  
                System.out.println("_____     \n\n");
                break;
            case 5: 
                System.out.println("  |____   ");
                System.out.println("  |    |  ");
                System.out.println("  |    o"); 
                System.out.println("  |   /|");  //   /\\ 
                System.out.println("  |   / \\"); //   / \\  
                System.out.println("_____     \n\n");
                break;
            case 6:
                System.out.println("  |____   ");
                System.out.println("  |    |  ");
                System.out.println("  |    o"); 
                System.out.println("  |   /|\\");  //   /\\ 
                System.out.println("  |   / \\"); //   / \\  
                System.out.println("_____     \n\n");
                break;
        
            default:
            throw new Error("Shouldn't be here"); //end game should occur
                
        }
        
    }

    public static void PrintfillinWord(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    public static Boolean HasBlank(char[] fillinword) {
        for (char c : fillinword) {
            if (c == '_'){
                return true;
            }
        }
        return false;
    }

    public static void HangmanGame(String word) {
        printGame();
        int wordLength = word.length();
        char[] fillinWord = new char[wordLength];
        System.out.println("Your word is: ");
        word = word.toLowerCase();
        for (int i = 0; i < wordLength; i++) {
            fillinWord[i] = '_';
        }

        for (char c : fillinWord) {
            System.out.print(c);
        }

        //get input
        int check = 0;
        int numwrong = 0;
        while (HasBlank(fillinWord) && numwrong != 6) {
            Scanner sc = new Scanner(System.in);
            System.out.print("\n\nEnter a letter: ");
            char guessLetter = sc.next().charAt(0);
            
            for (int i = 0; i < wordLength; i++) {
                if (word.charAt(i) == guessLetter){
                    fillinWord[i] = guessLetter;
                    check += 1;
                } 
            }
            System.out.println(check);
            if (check == 0) {       
                System.out.println(guessLetter + " is not correct, try again. " + check);
                numwrong++;
                PrintGameWrong(numwrong);

            } else {
                check = 0;
            }
            for (char c : fillinWord) {
            System.out.print(c);
            }
        }
        for (int i = 0; i<wordLength; i++) {
            if (fillinWord[i] != word.charAt(i)) {
                System.out.println("\nEnd game, you Lose. \nWord was: " + word);
            } 
        }
        int i = 0;
        int j = 0;
        for (char c : fillinWord) {
            if (c == word.charAt(i)) {
                j++;
            }
            i++;
        }
        if (j == wordLength){
            System.out.println("\nYou Win!");
        }

    }

    
    public static void main(String[] args) {
        List<String> wordlist = Arrays.asList("Christmas", "December", "Presents", "Erik", "Tree", "Star", "Ornaments", "Snow");

        ArrayList<String> words = new ArrayList<>();
        words.addAll(wordlist);
        
        Random rand = new Random();
        int num = rand.nextInt(words.size());
        String guessWord = words.get(num);
        HangmanGame(guessWord);
    }
}
