package org.genshin.repository;
import java.sql.*;

import org.genshin.mapper.Mapper;
import org.genshin.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.genshin.controller.UidJsonFetcher.jsonFetcher;
import static org.genshin.service.Controller.FFXXiaoDps;
import static org.genshin.service.Controller.deHasher;

public class DatabaseCalls {
    static String url = "jdbc:mysql://localhost:3306/pxe";
    static String username = "root";
    static String pass = "frozenapp";

    public static void fetchTopPlayers(Integer top){
        try {
            Connection con=DriverManager.getConnection(url,username,pass);
            Statement s= con.createStatement();
            ResultSet RS=s.executeQuery("select ROW_NUMBER() OVER (ORDER BY DPR desc) AS Ranking, d.UID, DPR, artSet from damage d, artCount a where (d.UID = a.UID) order by DPR desc limit "+top+";");
            System.out.println(":::::::::::::::::::::::::::: Top "+top+" FFXX :::::::::::::::::::::::::::");
            dualLine(con, RS);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void fetchTopPlayers(Integer top,String artSet){
        try {
            Connection con=DriverManager.getConnection(url,username,pass);
            Statement s= con.createStatement();
            ResultSet RS=s.executeQuery("select ROW_NUMBER() OVER (ORDER BY DPR desc) AS Ranking, d.UID, DPR, artSet from damage d, artCount a where (d.UID = a.UID and artSet='"+artSet+"') order by DPR desc limit "+top+";");
            System.out.println(":::::::::::::::::: Top "+top+" FFXX "+artSet+" :::::::::::::::::");
            dualLine(con, RS);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void dualLine(Connection con, ResultSet RS) throws SQLException {

        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        while(RS.next()){
            Integer ranking=RS.getInt("Ranking");
            Long UID=RS.getLong(2);
            Long DPR=RS.getLong("DPR");
            System.out.println("::::::::::::::: ["+UID+"]\tRank: "+ranking+",\tDPR: "+DPR+" :::::::::::::::");
        }
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        con.close();
    }

    public static void insertNewPlayer(Integer uid){
        try {
            jsonFetcher(uid);
            User user = Mapper.userMapper("/Users/mohammedmusthaqasimshaik/IdeaProjects/ProjectXiao/JavaCBP04/src/main/java/org/genshin/assets/UserJSONs/"+uid+".json");
            Map<Integer, User> newUserMap = new HashMap<>();
            newUserMap.put(uid, user);
            batchInsert(newUserMap);
            System.out.println("User ["+uid+"] inserted");
        } catch (Exception e) {
            System.out.println("Error while inserting new user");
        }
    }

    public static void batchInsert(Map<Integer, User> XiaoMainUserMap){
        for (Integer key : XiaoMainUserMap.keySet()){
            User user = XiaoMainUserMap.get(key);
            if (user!=null) {
                initialInsert(user);
            }
        }
    }

    public static void initialInsert(User user) {
        if (user.getAvatarInfoList() != null) {
            try {
                playerDataInsert(user);
                artifactDataInsert(user);
                artCountInsert(user);
                SetEffect RS=getSetEffect(user);
                Damage damage = FFXXiaoDps(user, RS);
                damageInsert(damage);
                System.out.print(user.getUid()+" inserted successfully::");
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    public static void playerDataInsert(User user) throws SQLException {
        Integer UID= Integer.parseInt((user.getUid()));
        Integer characterID=1021947690;
        Long weaponID=null;
        ArrayList<AvatarInfoList> avatarInfoList=(ArrayList<AvatarInfoList>) user.getAvatarInfoList();
        if (avatarInfoList != null) {
            for( AvatarInfoList avatarInfoListItem: avatarInfoList){
                if(avatarInfoListItem.getAvatarId()==10000026){
                    ArrayList<EquipList> EquipList=avatarInfoListItem.getEquipList();
                    for(EquipList equips:EquipList){
                        if(equips.getWeapon()!=null){
                            Flat flat= (Flat) equips.getFlat();
                            weaponID= Long.parseLong(flat.getNameTextMapHash());
                        }
                    }
                }
            }
        }
        try {
            Connection con = DriverManager.getConnection(url, username, pass);
            Statement s = con.createStatement();
            s.execute("insert into playerData values(" + UID + "," + characterID + "," + weaponID + ");");
            con.close();
        }catch (SQLIntegrityConstraintViolationException e) {

        } catch (SQLException e) {
            System.out.println("["+UID+"] : "+e);
        }
    }

    public static void artifactDataInsert(User user){
        Integer UID= Integer.valueOf((user.getUid()));
        Integer characterID=1021947690;
        ArrayList<AvatarInfoList> avatarInfoList=(ArrayList<AvatarInfoList>) user.getAvatarInfoList();
        if (avatarInfoList == null){
            return;
        }
        for( AvatarInfoList avatarInfoListItem: avatarInfoList){
            if(avatarInfoListItem.getAvatarId()==10000026){
                ArrayList<EquipList> EquipList=avatarInfoListItem.getEquipList();
                for(EquipList equips:EquipList){
                    if(equips.getWeapon()==null){
                        String artPiece;
                        String mainStat;
                        Float mainStatValue;
                        String artSet;
                        Double critRate= (double) 0;
                        Double critDamage= (double) 0;
                        Double percentAtk= (double) 0;
                        Double flatAtk= (double) 0;
                        Flat flat= (Flat) equips.getFlat();
                        ReliquaryMainstat reliquaryMainstat=flat.getReliquaryMainstat();
                        mainStat=reliquaryMainstat.getMainPropId();
                        mainStatValue= (float) reliquaryMainstat.getStatValue();
                        artPiece=flat.getEquipType();
                        artSet=deHasher(Long.parseLong(flat.getSetNameTextMapHash()));


                        artSet = artSet.replace("'", "");


                        ArrayList<ReliquarySubstats> reliquarySubstats=flat.getReliquarySubstats();
                        for(ReliquarySubstats RS:reliquarySubstats){
                            if(Objects.equals(RS.getAppendPropId(), "FIGHT_PROP_CRITICAL")) {
                                critRate = RS.getStatValue();
                            }
                            else if (Objects.equals(RS.getAppendPropId(), "FIGHT_PROP_CRITICAL_HURT")) {
                                critDamage=RS.getStatValue();
                            } else if (Objects.equals(RS.getAppendPropId(), "FIGHT_PROP_ATTACK_PERCENT")) {
                                percentAtk=RS.getStatValue();
                            } else if (Objects.equals(RS.getAppendPropId(), "FIGHT_PROP_ATTACK")) {
                                flatAtk=RS.getStatValue();
                            }
                        }
                        try {
                            Connection con = DriverManager.getConnection(url, username, pass);
                            Statement s = con.createStatement();
                            s.execute("insert into artifactData values("+UID+","+characterID+",'"+artPiece+"','"+mainStat+"',"+mainStatValue+",'"+artSet+"',"+critRate+","+critDamage+","+percentAtk+","+flatAtk+");");
                            con.close();
                        }catch (SQLIntegrityConstraintViolationException e){
                            ;
                        } catch (SQLException e) {
                            System.out.println(e);;
                        }
                    }
                }
            }
        }
    }

    public static void artCountInsert(User user){
        Integer UID= Integer.valueOf((user.getUid()));
        Integer characterID=1021947690;
        try {
            Connection con = DriverManager.getConnection(url, username, pass);
            Statement s = con.createStatement();
            ResultSet countMatrix=s.executeQuery("select artSet,count(*) as count from artifactData where (UID="+UID+" and characterID="+characterID+") group by artSet");
            while(countMatrix.next()){
                String AS=countMatrix.getString("artSet");
                Integer AC=countMatrix.getInt("count");
                if(AC>=4){
                    s.execute("insert into artCount values("+UID+","+characterID+",'"+AS+"',"+AC+");");
                }
            }
            con.close();
        }catch (SQLException e){
            ;
        }
    }

    public static SetEffect getSetEffect(User user){
        Integer UID= Integer.valueOf((user.getUid()));
        Integer characterID=1021947690;
        String artSet = null;
        String statName = null;
        Double statChange= null;
        try{
            Connection con=DriverManager.getConnection(url,username,pass);
            Statement s=con.createStatement();
            ResultSet countMatrix=s.executeQuery("select artSet,count from artCount where (UID="+UID+" and characterID="+characterID+");");
            while(countMatrix.next()){
                if(countMatrix.getInt("count")>=4){
                    artSet=countMatrix.getString("artSet");
                    break;
                }
            }
            if(artSet!=null){
                ResultSet effectMatrix=s.executeQuery("select statName,statChange from artifactSetStore where artSet='"+artSet+"';");
                while(effectMatrix.next()){
                    statName=effectMatrix.getString("statName");
                    statChange= effectMatrix.getDouble("statChange");
                }
                SetEffect setEffect=new SetEffect(artSet,statName,statChange);
                return setEffect;
            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static void damageInsert(Damage damage){
        if (damage!=null) {
            Integer UID= damage.getUid();
            Integer characterID= damage.getCharacterId();
            Double CD= damage.getCD();
            Double E= damage.getE();
            Double LP= damage.getLP();
            Double HP= damage.getHP();
            Double DPR= damage.getDPR();
            try{
                Connection con = DriverManager.getConnection(url, username, pass);
                Statement s = con.createStatement();
                s.execute("insert into damage values("+UID+","+characterID+","+CD+","+E+","+LP+","+HP+","+DPR+");");
                con.close();
            }catch (SQLIntegrityConstraintViolationException e){
                ;
            } catch (SQLException e) {
                System.out.println(e);;
            }
        }
    }

    public static void printUserData(Integer UID,User user){
        try{
            Connection con = DriverManager.getConnection(url, username, pass);
            Statement s = con.createStatement();
            System.out.println("UID: "+ UID);
            try {
                System.out.println("Username: "+user.getPlayerInfo().getNickname());
            } catch (Exception e) {
                System.out.println("No Username");
            }
            ResultSet RS=s.executeQuery("select * from damage where (UID="+UID+");");
            while(RS.next()){
                System.out.println("Damage::::");
                System.out.println("Collision Damage::"+RS.getDouble("CD"));
                System.out.println("Elemental Skill Damage::"+RS.getDouble("E"));
                System.out.println("Low Plunge Damage::"+RS.getDouble("LP"));
                System.out.println("High Plunge Damage::"+RS.getDouble("HP"));
                System.out.println("Damage Per Rotation::"+RS.getDouble("DPR"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
