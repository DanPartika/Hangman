package Hangman;

import java.util.*;

import javax.print.attribute.standard.Finishings;

public class Hangman {
    public static void printGame() {
        System.out.println("  |____   ");
        System.out.println("  |    |  ");
        System.out.println("  |");  //    o   
        System.out.println("  |");  //   /|\\ 
        System.out.println("  |"); //   / \\  
        System.out.println("_____     \n\n");
         
    }
    public static void PrintfillinWord(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
    public static void LetterInput() {
        
    }

    public static void HangmanGame(String word) {
        printGame();
        int wordLength = word.length();
        char[] fillinWord = new char[wordLength];
        System.out.println("Your word is: ");

        for (int i = 0; i < wordLength; i++) {
            System.out.println("_ ");
        }
        //get input
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a letter: ");
        char guessLetter = sc.next().charAt(0);
        for (int i = 0; i < wordLength; i++) {
            if (word.charAt(i) == guessLetter){
                fillinWord[i] = guessLetter;
            } else {
                fillinWord[i] = '_';
            }
        }
        System.out.println(fillinWord);

    }

    
    public static void main(String[] args) {
        List<String> wordlist = Arrays.asList("Christmas", "December", "Presents");
        ArrayList<String> words = new ArrayList<>();
        words.addAll(wordlist);
        
        Random rand = new Random();
        int num = rand.nextInt(words.size());
        String guessWord = words.get(num);
        HangmanGame(guessWord);
    }
}
