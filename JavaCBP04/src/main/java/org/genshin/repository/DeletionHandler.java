package org.genshin.repository;
import java.sql.*;

import org.genshin.model.*;

import java.util.ArrayList;
import java.util.Map;

import static org.genshin.controller.UidJsonFetcher.uidRemover;
import static org.genshin.repository.DatabaseCalls.initialInsert;
import static org.genshin.service.Controller.deHasher;

public class DeletionHandler {
    static String url = "jdbc:mysql://localhost:3306/pxe";
    static String username = "root";
    static String pass = "frozenapp";

    public static void wipePlayers(Map<Integer, User> XiaoMainUserMap){
        for(Integer key : XiaoMainUserMap.keySet()){
            deleteEntirePlayer(XiaoMainUserMap.get(key));
        }
        System.out.println("Deletion Done.");
    }

    public static void resetDatabase(){
        try{
            Connection con=DriverManager.getConnection(url,username,pass);
            Statement s=con.createStatement();
            s.execute("delete from damage;");
            s.execute("delete from artCount;");
            s.execute("delete from artifactData;");
            s.execute("delete from playerData;");
            con.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    public static void deleteEntirePlayer(User user){
        Integer UID= Integer.valueOf(user.getUid());
        try {
            deleteDamage(user);
            deleteArtCount(user);
            deleteArtifactData(user);
            deletePlayerData(user);
            uidRemover(UID);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void deletePlayerData(User user){
        Integer UID= Integer.valueOf(user.getUid());
        try{
            Connection con=DriverManager.getConnection(url,username,pass);
            Statement s=con.createStatement();
            s.execute("delete from playerData where UID="+UID+";");
            con.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public static void deleteArtifactData(User user){
        Integer UID= Integer.valueOf(user.getUid());
        try{
            Connection con=DriverManager.getConnection(url,username,pass);
            Statement s=con.createStatement();
            s.execute("delete from artifactData where UID="+UID+";");
            con.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public static void deleteArtCount(User user){
        Integer UID= Integer.valueOf(user.getUid());
        try{
            Connection con=DriverManager.getConnection(url,username,pass);
            Statement s=con.createStatement();
            s.execute("delete from artCount where UID="+UID+";");
            con.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public static void deleteDamage(User user){
        Integer UID= Integer.valueOf(user.getUid());
        try{
            Connection con=DriverManager.getConnection(url,username,pass);
            Statement s=con.createStatement();
            s.execute("delete from damage where UID="+UID+";");
            con.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
