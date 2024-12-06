package org.genshin;

import org.genshin.mapper.Mapper;
import org.genshin.model.User;
import org.genshin.service.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.genshin.controller.UidJsonFetcher.jsonFetcher;
import static org.genshin.repository.DatabaseCalls.*;
import static org.genshin.repository.DeletionHandler.deleteEntirePlayer;
import static org.genshin.service.Controller.userDetailPrintHandler;

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
            System.out.println("4. Print user data");
            System.out.println("5. Delete user data");
            System.out.println("6. Insert new player data");
            System.out.println("7. Update player data");

            System.out.println("0. Exit");
            System.out.print("Option: ");
            leaderboardOption = inp.nextInt();
            while (leaderboardOption < 0 || leaderboardOption > 7) {
                System.out.println("Invalid option");
                System.out.print("Option: ");
                leaderboardOption = inp.nextInt();
            }
            if (leaderboardOption == 0) {
                break;
            } else{
                if(leaderboardOption == 1){
                    System.out.println("Give limit of top number of players: ");
                    limitOption = inp.nextInt();
                    fetchTopPlayers(limitOption);
                } else if(leaderboardOption == 2){
                    System.out.println("Give limit of top number of players: ");
                    limitOption = inp.nextInt();
                    fetchTopPlayers(limitOption, "Marechaussee Hunter");
                } else if(leaderboardOption == 3){
                    System.out.println("Give limit of top number of players: ");
                    limitOption = inp.nextInt();
                    fetchTopPlayers(limitOption, "Vermillion Hereafter");
                } else if(leaderboardOption == 4){
                    System.out.print("Enter UID: ");
                    Integer uid = inp.nextInt();
                    userDetailPrintHandler(uid);
                } else if (leaderboardOption == 5) {
                    System.out.print("Enter UID: ");
                    Integer uid = inp.nextInt();
                    deleteEntirePlayer(uid);
                } else if (leaderboardOption == 6) {
                    System.out.print("Enter UID: ");
                    Integer uid = inp.nextInt();
                    insertNewPlayer(uid);
                } else if (leaderboardOption == 7) {
                    System.out.print("Enter UID: ");
                    Integer uid = inp.nextInt();
                    deleteEntirePlayer(uid);
                    insertNewPlayer(uid);
                    userDetailPrintHandler(uid);
                }
            }
        }while(leaderboardOption != 0);
    }
}
