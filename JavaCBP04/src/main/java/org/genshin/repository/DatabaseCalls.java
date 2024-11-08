package org.genshin.repository;
import java.sql.*;

import org.genshin.model.*;

import java.util.ArrayList;
import java.util.Map;

import static org.genshin.service.Controller.deHasher;

public class DatabaseCalls {
    public static void initialInsert(User user) throws SQLException {
        try {
            playerDataInsert(user);
            artifactDataInsert(user);
            artCountInsert(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void playerDataInsert(User user) throws SQLException {
        Integer UID= Integer.valueOf((user.getUid()));
        Integer characterID=1021947690;
        Integer weaponID=null;
        ArrayList<AvatarInfoList> avatarInfoList=(ArrayList<AvatarInfoList>) user.getAvatarInfoList();
        for( AvatarInfoList avatarInfoListItem: avatarInfoList){
            if(avatarInfoListItem.getAvatarId()==10000026){
                ArrayList<EquipList> EquipList=avatarInfoListItem.getEquipList();
                for(EquipList equips:EquipList){
                    if(equips.getWeapon()!=null){
                        Flat flat= (Flat) equips.getFlat();
                        weaponID= Integer.valueOf(flat.getNameTextMapHash());
                    }
                }
            }
        }
        try {
            String url="jdbc:mysql://localhost:3306/pxe";
            String username="root";
            String pass="frozenapp";
            Connection con=DriverManager.getConnection(url,username,pass);
            Statement s= con.createStatement();
            s.execute("insert into playerData values("+UID+","+characterID+","+weaponID+");");
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void artifactDataInsert(User user){
        Integer UID= Integer.valueOf((user.getUid()));
        Integer characterID=1021947690;
        ArrayList<AvatarInfoList> avatarInfoList=(ArrayList<AvatarInfoList>) user.getAvatarInfoList();
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
                        artSet=deHasher(Integer.parseInt(flat.getSetNameTextMapHash()));
                        ArrayList<ReliquarySubstats> reliquarySubstats=flat.getReliquarySubstats();
                        for(ReliquarySubstats RS:reliquarySubstats){
                            if(RS.getAppendPropId()=="FIGHT_PROP_CRITICAL")
                                critRate=RS.getStatValue();
                            else if (RS.getAppendPropId()=="FIGHT_PROP_CRITICAL_HURT") {
                                critDamage=RS.getStatValue();
                            } else if (RS.getAppendPropId()=="FIGHT_PROP_ATTACK_PERCENT") {
                                percentAtk=RS.getStatValue();
                            } else if (RS.getAppendPropId()=="FIGHT_PROP_ATTACK") {
                                flatAtk=RS.getStatValue();
                            }
                        }
                        try {
                            String url = "jdbc:mysql://localhost:3306/pxe";
                            String username = "root";
                            String pass = "frozenapp";
                            Connection con = DriverManager.getConnection(url, username, pass);
                            Statement s = con.createStatement();
                            s.execute("insert into artifactData values("+UID+","+characterID+",'"+artPiece+"','"+mainStat+"',"+mainStatValue+",'"+artSet+"',"+critRate+","+critDamage+","+percentAtk+","+flatAtk+");");
                            con.close();
                        }catch (SQLException e){
                            throw new RuntimeException(e);
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
            String url = "jdbc:mysql://localhost:3306/pxe";
            String username = "root";
            String pass = "frozenapp";
            Connection con = DriverManager.getConnection(url, username, pass);
            Statement s = con.createStatement();
            ResultSet countMatrix=s.executeQuery("select artSet,count(*) as count from artifactData where (UID="+UID+" and characterID="+characterID+") group by artSet");
            while(countMatrix.next()){
                String AS=countMatrix.getString("artSet");
                Integer AC=countMatrix.getInt("count");
                if(AC>=2){
                    s.execute("insert into artCount values("+UID+","+characterID+",'"+AS+"',"+AC+");");
                }
            }
            con.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    };
}
