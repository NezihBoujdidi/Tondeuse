package tn.nezih.tondeuse;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            File inputFile = new File("src/main/resources/input.txt");
            Scanner scanner = new Scanner(inputFile);
            if (inputFile.length()==0){
                System.out.println("Le fichier est vide!");
                return;
            }
            String[] MaxXY = scanner.nextLine().split(" ");
            int max_X = Integer.parseInt(MaxXY[0]);
            int max_Y = Integer.parseInt(MaxXY[1]);
            if (max_X<0 || max_Y<0){
                System.out.println("Les dimensions de la pelouse doivent être positives!");
                return;
            }
            Pelouse pelouse = new Pelouse(max_X, max_Y);
            List<String> allFinalPositions = new ArrayList<>();

            while (scanner.hasNextLine()) {
                String[] initialPosition = scanner.nextLine().split(" ");
                int initial_X = Integer.parseInt(initialPosition[0]);
                int initial_Y = Integer.parseInt(initialPosition[1]);
                if (initial_X<0 || initial_Y<0 || initial_X>max_X || initial_Y>max_Y){
                    System.out.println("La position initiale de la tendeuse doit être dans la pelouse!");
                }
                char initialOrientation = initialPosition[2].charAt(0);
                if (initialOrientation!='N' && initialOrientation!='S' && initialOrientation!='W' && initialOrientation!='E'){
                    System.out.println("L'orientation initiale d'une tendeuse est invalide!");
                    return;
                }
                String instructions = scanner.nextLine();
                Position initialPos = new Position(initial_X, initial_Y, initialOrientation);
                Tondeuse tondeuse = new Tondeuse(initialPos, pelouse);
                tondeuse.executeListOfInstructions(instructions);
                String finalPosition = tondeuse.getCurrentPosition().toString();
                allFinalPositions.add(finalPosition);
            }

            scanner.close();

            System.out.println("Positions finales des tendeuses: ");
            for (String finalPosition : allFinalPositions) {
                System.out.println(finalPosition);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Fichier introuvable: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erreur:" + e.getMessage());
        }
    }
}