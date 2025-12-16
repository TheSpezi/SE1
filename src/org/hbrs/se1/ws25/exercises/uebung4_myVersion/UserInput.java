package org.hbrs.se1.ws25.exercises.uebung4_myVersion;

import org.hbrs.se1.ws25.exercises.uebung4_myVersion.Exceptions.ContainerException;
import org.hbrs.se1.ws25.exercises.uebung4_myVersion.Exceptions.UserStoryException;

import java.util.*;

public class UserInput {

    Container container = Container.getInstance();
    Scanner sc = new Scanner(System.in);

    /*manage user input*/
    public void input() {

        String input = null;
        System.out.println("UserStory-Tool V1.0 by spezi ");
        System.out.println("==========================");

        while (true) {
            System.out.print("> ");
            input = sc.nextLine();

            String[] inputs = input.split(" ");

            if (inputs[0].equals("help")) {
                help();
            } else if (inputs[0].equals("enter")) {
                if(inputs.length == 1) enter();
                else if(inputs.length == 8) enter(inputs[1],inputs[2],inputs[3],Integer.parseInt(inputs[4]),
                        Integer.parseInt(inputs[5]), Integer.parseInt(inputs[6]), Integer.parseInt(inputs[7]));
                        //ToDo: Akzeptanzkriterium muss ein "Wort" sein, bzw. kann keine Leerzeichen enthalten!!!
                else System.err.println("Ungueltige Erstellungs Parameter!");
            } else if (inputs[0].equals("store")) {
                String param = "";
                if (inputs.length > 1) param = inputs[1];
                store(param);
            } else if (inputs[0].equals("load")) {
                String param = "";
                if (inputs.length > 1) param = inputs[1];
                load(param);
            } else if (inputs[0].equals("dump")) {
                dump();
            } else if (inputs[0].equals("exit")) {
                exit();
                break;
            } else {
                System.err.println("Ungueltiger Befehl!");
            }
        }
    }

    /*help print*/
    private void help() {
        System.out.println("Folgende Befehle gibt es:");
        System.out.println("help - Anzeige aller Befehle");
        System.out.println("enter - Interaktive Erstellung einer UserStory");
        System.out.println("enter [Titel] [Akzeptankriterium] [Projekt] [Mehrwert] [Strafe] [Aufwand] [Risiko] - Auch möglich");
        System.out.println("store [Datei] - Speichen der UserStories auf der Festplatte");
        System.out.println("load [Datei] - Laden der UserStories von der Festplatte");
        System.out.println("dump - Ausgeben aller UserStories");
        System.out.println("exit - Beenden des Tools");
    }

    /*create user story interactively*/
    private void enter() {
        System.out.println("Erstellung einer User Story\n");
        try {

            System.out.print("Zu welchen Projekt gehoert die Story: ");
            String project = sc.nextLine();
            System.out.print("Titel: ");
            String title = sc.nextLine();
            System.out.print("Akzeptanzkriterium: ");
            String acceptance = sc.nextLine();
            System.out.print("Mehrwert: ");
            int value = sc.nextInt();
            System.out.print("Strafe: ");
            int penalty = sc.nextInt();
            System.out.print("Aufwand: ");
            int expense = sc.nextInt();
            System.out.print("Risiko: ");
            int risk = sc.nextInt();


            UserStory us = new UserStory(title, acceptance, project, value, penalty, expense, risk);
            container.addUserStory(us);
            System.out.println("User Story erfolgreich angelegt ^^");

        } catch (InputMismatchException e) {
            System.err.println("Bitte nur gueltige Zahlenwerte einsetzen!\nBitte User Story erneut eingeben");
        } catch (UserStoryException e) {
            System.err.println(e.getMessage() + "\nBitte User Story erneut eingeben.");
        } catch (ContainerException e){
            System.err.println(e.getMsg());
        } finally{
            sc.nextLine(); //remove line break
        }


    }

    /*create user story via param*/
    private void enter(String title, String acceptance, String project, int value, int penalty, int expense, int risk) {
        try {

            UserStory us = new UserStory(title, acceptance, project, value, penalty, expense, risk);
            container.addUserStory(us);
            System.out.println("User Story erfolgreich angelegt ^^");

        } catch (InputMismatchException e) {
            System.err.println("Bitte nur gueltige Zahlenwerte einsetzen!\nBitte User Story erneut eingeben");
            sc.nextLine();//remove line break
        } catch (UserStoryException e) {
            System.err.println(e.getMessage() + "\nBitte User Story erneut eingeben.");
            sc.nextLine(); //remove line break
        } catch (ContainerException e){
            System.err.println(e.getMsg());
            sc.nextLine();
        }


    }
    /*store user stories in file*/
    private void store(String filename) {
        try {
            container.store(filename);
            System.out.println("Speichern des Containers erfolgreich ^^");
        } catch (Exception e) {
            System.err.println("Speichern des Containers fehlgeschlagen!");
        }
    }

    /*load user stories from file*/
    private void load(String filename) {
        try {
            container.load(filename);
            System.out.println("Laden des Containers erfolgreich ^^");
        } catch (Exception e) {
            System.err.println("Laden des Containers fehlgeschlagen!");
        }
    }

    /*view all user stories */
    private void dump() {
        UserStoryView.dump(container.getList());
    }

    /*exit programm*/
    private void exit() {
        System.out.println("Programm wird verlassen");
        sc.close();
    }
}
