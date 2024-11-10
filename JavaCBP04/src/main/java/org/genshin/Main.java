package org.genshin;

import org.genshin.service.Controller;

import java.util.Scanner;

import static org.genshin.repository.DatabaseCalls.fetchTopPlayers;

public class Main {
    public static void main(String[] args) {
        Controller.driver();

        Scanner inp = new Scanner(System.in);
        int leaderboardOption = -1;
        int limitOption = -1;
        do{
            System.out.println("Choose an FFXX leaderboard: ");
            System.out.println("1. Unified Player Ranking");
            System.out.println("2. Marechaussee Hunter Ranking");
            System.out.println("3. Vermillion Hereafter Ranking");
            System.out.println("0. Exit");
            System.out.print("Option: ");
            leaderboardOption = inp.nextInt();
            while (leaderboardOption < 0 || leaderboardOption > 3) {
                System.out.println("Invalid option");
                System.out.print("Option: ");
                leaderboardOption = inp.nextInt();
            }
            if (leaderboardOption == 0) {
                break;
            } else{
                System.out.println("Give limit of top number of players: ");
                limitOption = inp.nextInt();
                if(leaderboardOption == 1){
                    fetchTopPlayers(limitOption);
                } else if(leaderboardOption == 2){
                    fetchTopPlayers(limitOption, "Marechaussee Hunter");
                } else if(leaderboardOption == 3){
                    fetchTopPlayers(limitOption, "Vermillion Hereafter");
                }
            }
        }while(leaderboardOption != 0);
    }
}
