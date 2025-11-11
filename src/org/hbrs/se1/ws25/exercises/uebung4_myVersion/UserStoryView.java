package org.hbrs.se1.ws25.exercises.uebung4_myVersion;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UserStoryView {

    /*idfk*/
    public static void dump(List<UserStory> list) {


        if(list.isEmpty()){
            System.err.println("Keine UserStories geladen oder angelegt!");
            return;
        }

        //Keine Ahnung was das hier ist oder macht
        //NICHT ANFASSEN

        List<UserStory> newList = list.stream()
                .filter(us -> us.getPrio() > 0)
                .sorted(Comparator.comparingDouble(UserStory::getPrio).reversed())
                .collect(Collectors.toList());


        output(newList);
    }

    /*print all user stories*/
    private static void output(List<UserStory> list) {

        System.out.println("Ausgabe aller User Stories:\n");
        System.out.printf("%-10s | %-25s | %-30s | %-25s%n", "Prioritaet", "Titel", "Akezptanzkriterium", "Projekt");
        System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");

        for (UserStory us : list) {
            System.out.printf("%-10.1f | %-25s | %-30s | %-25s%n",
                    us.getPrio(),
                    cut(us.getTitle(), 25),
                    cut(us.getAcceptance(), 30),
                    cut(us.getProject(), 25));
        }
    }

    /*cut string to certain len*/
    private static String cut(String s, int maxLen) {
        if (s.length() > maxLen) {
            return s.substring(0, maxLen - 3) + "...";
        }
        return s;
    }


}
