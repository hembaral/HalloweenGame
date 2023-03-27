package org.example;

import org.w3c.dom.ls.LSOutput;

import javax.xml.catalog.Catalog;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class App {
    private static final String FIELD_DELIMITER = "\\|";
    private static final  String Base_file_find="src/main/resources/candies.txt";
    private final Scanner fileScanner=new Scanner(System.in);
    private static List<Candy>listOfCandies=new ArrayList<>();
    private static Random rand= new Random();


    public static void main(String[] args) throws FileNotFoundException {

        // Read the candies file
        File file = new File(Base_file_find);
        String candyName = null;
        String[] candy = new String[0];
        try (Scanner fileInput = new Scanner(file)) {
            while (fileInput.hasNextLine()) {
                candy = fileInput.nextLine().split(FIELD_DELIMITER);
                candyName = candy[0];
                Integer rating = Integer.valueOf(candy[1]);
                String origin = candy[2];

                // New Candy Object
                Candy candies = new Candy(candyName, rating, origin);
                listOfCandies.add(candies);


            }
        }

        /**
        LocalDate date = java.time.LocalDate.now();
        if (date.getMonth() == Month.OCTOBER && date.getDayOfMonth() == 30 ) {
*/
            while (true) {
                System.out.println("choose an option");
                System.out.println("1: Display candies");
                System.out.println("2: Search Candies");
                System.out.println("3:Trick or Treat");
                System.out.println("0: Exit");
                System.out.println();
                Scanner input = new Scanner(System.in);

                //Check what to do next
                // If 1, Print out all candies
                // If 2, Ability to search candies by name, origin, ratings
                // If 3, get random candy, and it displays boo or treat!!!
                String stringInput = input.nextLine();
                int intInput = Integer.parseInt(stringInput);


                if (intInput == 1) {
                    System.out.println("Candy Name, Ratings, Origin");
                    for (int i = 0; i < listOfCandies.size(); i++) {
                        System.out.println(listOfCandies.get(i).toString());
                    }
                    System.out.println();

                } else if (intInput == 2) {
                    while(true) {
                        System.out.println("Search Menu");
                        System.out.println("1:search By Name");
                        System.out.println("2:Search By Origin");
                        System.out.println("3:Search by Rating");
                        System.out.println("4: Go Back");
                        String word = input.nextLine();
                        int inputMenu = Integer.parseInt(word);

                        if (inputMenu == 1) {
                            System.out.print("Enter keyword to Search: ");
                            String searchWord = input.nextLine();
                            for (int i = 0; i < listOfCandies.size(); i++) {
                                if (listOfCandies.get(i).getName().toLowerCase().startsWith(searchWord) == true) {
                                    System.out.println(listOfCandies.get(i).toString());

                                }
                            }
                        } else if (inputMenu == 2) {
                            System.out.println("Enter search word by Origin");
                            String searchWord = input.nextLine();
                            for (int i = 0; i < listOfCandies.size(); i++) {
                                if (listOfCandies.get(i).getOrigin().toLowerCase().contains(searchWord) == true) {
                                    System.out.println(listOfCandies.get(i).toString());
                                }
                            }

                        }else if(inputMenu==3){
                            System.out.println("Enter valid number to search by status");
                            String searchNumber=input.nextLine();

                            for(int i=0;i< listOfCandies.size();i++){

                                if(listOfCandies.get(i).getStatus()==String.valueOf(true)){
                                    System.out.println(listOfCandies.get(i).toString());


                                }
                            }

                        }
                        else if (inputMenu == 4) {
                            System.out.println("Back to the main menu");
                            break;
                        }
                    }


                } else if (intInput == 3) {
                    int randNumber = rand.nextInt(31);
                    Candy randCandy = listOfCandies.get(randNumber);
                    System.out.println(randCandy.getName());
                    System.out.println(randCandy.getStatus());
                    System.out.println();

                } else if (intInput == 0) {
                    break;
                } else {
                    System.out.println("Please enter a valid option");
                }
                listOfCandies.add(new Candy("sodo", 5, "Philipino"));


        }
        /*
        else {
            System.out.println("Today is not Halloween!!! Please come back next Halloween");
        }
        */

        System.out.println("Thank you for playing my game!!!!");

    }
}







