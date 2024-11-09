package org.genshin.service;

import com.fasterxml.jackson.databind.*;
import org.genshin.controller.UidJsonFetcher;
import org.genshin.mapper.Mapper;
import org.genshin.model.*;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.lang.Math.clamp;
import static org.genshin.repository.DatabaseCalls.batchInsert;
import static org.genshin.repository.DatabaseCalls.initialInsert;

public class Controller {
    public static void driver(){
        Map<Integer, User> XiaoMainUserMap = new HashMap<>();
        // use akasha json to get an arraylist of all xiao users, then create a user object for each uid in that arraylist, then map all the uids and user objects into the above map
        ArrayList<Integer> uidList = UidJsonFetcher.jsonFetcher();
        for (Integer uid : uidList){
            User user = Mapper.userMapper("/Users/mohammedmusthaqasimshaik/IdeaProjects/ProjectXiao/JavaCBP04/src/main/java/org/genshin/assets/UserJSONs/"+uid+".json");
            XiaoMainUserMap.put(uid, user);
        }
        batchInsert(XiaoMainUserMap);
//        initialInsert(XiaoMainUserMap.get(809949310));
    }

    public static String deHasher(Long hashCode){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Long value;
            // Read JSON file into a Map
            Map<String, Object> LOC = (Map<String, Object>) objectMapper.readValue(new File("/Users/mohammedmusthaqasimshaik/IdeaProjects/ProjectXiao/JavaCBP04/src/main/java/org/genshin/assets/loc.json"), Map.class);
            Map<String, Object> charMap = (Map<String, Object>) objectMapper.readValue(new File("/Users/mohammedmusthaqasimshaik/IdeaProjects/ProjectXiao/JavaCBP04/src/main/java/org/genshin/assets/characters.json"), Map.class);
            if ((Map<String, Object>) charMap.get(hashCode.toString())!=null) {
                Map<String,Object> internal = (Map<String, Object>) charMap.get(hashCode.toString());
                Long nameTextMapHash= (Long) internal.get("NameTextMapHash");
                value = nameTextMapHash;
                //System.out.println(value);
            }
            else {
                value = hashCode;
            }
            Map<String,Object> en = (Map<String, Object>) LOC.get("en");
            String nameValue = (String) en.get(value.toString());
            return nameValue;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    } //takes any non prop hash code and returns its corresponding string

    public static String fightPropMapUnHasher(Integer hashCode){
        Map<Integer, String> hashValues = new HashMap<>();
        Integer[] keys = {1,2,3,4,5,6,7,8,9,10,11,20,22,23,26,27,28,29,30,40,41,42,43,44,45,46,50,51,52,53,54,55,56,70,71,72,73,74,75,76,80,81,1000,1001,1002,1003,1004,1005,1006,1010,2000,2001,2002,2003,3025,3026,3027,3028,3029,3030,3031,3032,3033,3034,3035,3036,3037,3038,3039,3040,3041,3042,3043,3044,3045,3046};
        String[] values = {"Base HP","HP","HP%","Base ATK","ATK","ATK%","Base DEF","DEF","DEF%","Base SPD","SPD%","CRIT Rate","CRIT DMG","Energy Recharge","Healing Bonus",
                "Incoming Healing Bonus","Elemental Mastery","Physical RES","Physical DMG Bonus","Pyro DMG Bonus","Electro DMG Bonus","Hydro DMG Bonus","Dendro DMG Bonus","Anemo DMG Bonus","Geo DMG Bonus",
                "Cryo DMG Bonus","Pyro RES","Electro RES","Hydro RES","Dendro RES","Anemo RES","Geo RES","Cryo RES","Pyro Enegry Cost","Electro Energy Cost","Hydro Energy Cost",
                "Dendro Energy Cost","Anemo Energy Cost","Cryo Energy Cost","Geo Energy Cost","Cooldown reduction","Shield Strength","Current Pyro Energy","Current Electro Energy","Current Hydro Energy","Current Dendro Energy","Current Anemo Energy"
                ,"Current Cryo Energy","Current Geo Energy","Current HP","Max HP","ATK Final","DEF Final","SPD Final","Elemental reaction CRIT Rate","Elemental reaction CRIT DMG","Elemental reaction (Overloaded) CRIT Rate","Elemental reaction (Overloaded) CRIT DMG","Elemental reaction (Swirl) CRIT Rate","Elemental reaction (Swirl) CRIT DMG","Elemental reaction (Electro-Charged) CRIT Rate","Elemental reaction (Electro-Charged) CRIT DMG","Elemental reaction (Superconduct) CRIT Rate","	Elemental reaction (Superconduct) CRIT DMG","Elemental reaction (Burn) CRIT Rate","Elemental reaction (Burn) CRIT DMG","Elemental reaction (Frozen (Shattered)) CRIT Rate",
                "Elemental reaction (Frozen (Shattered)) CRIT DMG","Elemental reaction (Bloom) CRIT Rate","Elemental reaction (Bloom) CRIT DMG","Elemental reaction (Burgeon) CRIT Rate","Elemental reaction (Burgeon) CRIT DMG",
                "Elemental reaction (Hyperbloom) CRIT Rate","Elemental reaction (Hyperbloom) CRIT DMG","Base Elemental reaction CRIT Rate","Base Elemental reaction CRIT DMG"};
        for(int i = 0; i < keys.length; i++){
            hashValues.put(keys[i], values[i]);
        }
        return hashValues.get(hashCode);
    } //prop hash codes but not prop map

    public static Damage FFXXiaoDps(User user, SetEffect setEffect){
        Integer setEffectCode;
        if(setEffect == null){
            setEffectCode = -1;
        } else if(Objects.equals(setEffect.getArtSet(), "Vermillion Hereafter")) {
            setEffectCode = 0;
        } else if (Objects.equals(setEffect.getArtSet(), "Marechaussee Hunter")) {
            setEffectCode = 1;
        } else {
            setEffectCode = -1;
        }
        Integer uid = Integer.parseInt(user.getUid());
        if(user.getAvatarInfoList() != null){
            for(AvatarInfoList o: user.getAvatarInfoList()){
                if(o.getAvatarId() == 10000026){
                    Long weaponId = null;

                    //getting weapon id
                    ArrayList<EquipList> EquipList=o.getEquipList();
                    for(EquipList equips:EquipList){
                        if(equips.getWeapon()!=null){
                            Flat flat= (Flat) equips.getFlat();
                            weaponId= Long.parseLong(flat.getNameTextMapHash());
                        }
                    }
                    String weaponName = deHasher(weaponId);

                    return xiaoDmgCalc(uid, o, setEffectCode, weaponName);
                }
            }
        }
        return null;
    }

    public static Double xiaoAtkCalc(AvatarInfoList xiao, Integer setEffectCode, String weaponName) {
        Double baseAtk = xiao.getFightPropMap().get(4);
        Double flatAtkBuff = xiao.getFightPropMap().get(5);
        Double setEffectAtkPercentBuff = 0.0;
        if(setEffectCode == 0){
            setEffectAtkPercentBuff = 0.48;
        }
        Double teamNoblesseAtkPercentBuff = 0.2;
        Double teamTenacityAtkPercentBuff = 0.2;
        Double percentageAtk = xiao.getFightPropMap().get(6) + setEffectAtkPercentBuff + teamTenacityAtkPercentBuff + teamNoblesseAtkPercentBuff;
        Double hpFinal = xiao.getFightPropMap().get(2000);

        Double weaponFlatAtkBuff = 0.0;
        Double weaponAtkPercentBuff = 0.0;
        if(Objects.equals(weaponName, "Staff of Homa")){
            weaponFlatAtkBuff = hpFinal*(0.018);
        } else if (Objects.equals(weaponName, "Calamity Queller")) {
            weaponAtkPercentBuff = 0.384;
        } else if (Objects.equals(weaponName, "Primordial Jade Winged-Spear")) {
            weaponAtkPercentBuff = 0.344;
        }

        Double finalAtkStat = ( baseAtk * (1+percentageAtk+weaponAtkPercentBuff) ) + flatAtkBuff+weaponFlatAtkBuff;
        return finalAtkStat;
    }

    public static Damage xiaoDmgCalc(Integer uid, AvatarInfoList xiao, Integer setEffectCode, String weaponName) {
        Map<String, Double> xiaoTalents= new HashMap<>();
        xiaoTalents.put("skill%", 4.0402);
        xiaoTalents.put("collision%", 1.6176);
        xiaoTalents.put("lowPlunge%", 3.2346);
        xiaoTalents.put("highPlunge%", 4.0402);
        Double finalAtkStat = xiaoAtkCalc(xiao, setEffectCode, weaponName);
        Double additiveBaseDmgBonus = 9000.0 + 0.32*(196.47+454.36); //xianyun and faruzan additiveBuffs

        Double skillFinalBaseDmg = finalAtkStat * xiaoTalents.get("skill%") + 0.32*(196.47+454.36);
        Double plungeCollisionFinalBaseDmg = finalAtkStat * xiaoTalents.get("collision%") + 0.32*(196.47+454.36);
        Double lowPlungeFinalBaseDmg = (finalAtkStat * xiaoTalents.get("lowPlunge%")) + additiveBaseDmgBonus;
        Double highPlungeFinalBaseDmg = (finalAtkStat * xiaoTalents.get("highPlunge%")) + additiveBaseDmgBonus;

        Double ultDmgBonusPercent = 0.952;
        Double xiaoA4PassiveDmgBonus = 0.25;
        Double anemoDmgBonus = xiao.getFightPropMap().get(44) + 0.324; //+seteffectbonus if any
        Double furinaDmgBonusBuffC2 = 1.00;

        Double dmgReductionTarget = 0.0;

        Double totalDmgBonus = (1+ultDmgBonusPercent+xiaoA4PassiveDmgBonus+anemoDmgBonus+furinaDmgBonusBuffC2 - dmgReductionTarget);
        Double totalDmgBonusNonUlt = (1+anemoDmgBonus+furinaDmgBonusBuffC2 - dmgReductionTarget);

        Double setEffectCritRateBonus = 0.0;
        if(setEffectCode == 1){
            setEffectCritRateBonus = 0.36;
        }
        Double finalCritRate = xiao.getFightPropMap().get(20) + 0.04 + setEffectCritRateBonus; //minimum of xianyun a1 passive in case of single target
        Double finalCritDmg = xiao.getFightPropMap().get(22) + 0.4; //faruzan c6

        Double avgCritMultiplier = 1 + (clamp(finalCritRate, 0.0, 100.0) * finalCritDmg); //avg crit
        Double defReduction = 0.0;
        Double defIgnore = 0.0;

        Double enemyDefMult = (double) ((90+100)/((90+100)+(100+100)*(1-defReduction)*(1-defIgnore)));

        Double standardEnemyBaseAnemoResistance = 0.1;
        Double resistanceShred = 0.3;
        Double enemyRes = standardEnemyBaseAnemoResistance - resistanceShred;

        Double enemyResMult = 0.0;
        if(enemyRes < 0){
            enemyResMult = 1-(enemyRes/2);
        } else if(enemyRes < 0.75){
            enemyResMult = 1-enemyRes;
        } else {
            enemyResMult = 1/(4*enemyRes + 1);
        }

        Double finalSkillDmg = skillFinalBaseDmg * totalDmgBonusNonUlt * avgCritMultiplier * enemyDefMult * enemyResMult;
        Double finalPlungeCollisionDmg = plungeCollisionFinalBaseDmg * totalDmgBonus * avgCritMultiplier * enemyDefMult * enemyResMult;
        Double finalLowPlungeDmg = lowPlungeFinalBaseDmg * totalDmgBonus * avgCritMultiplier * enemyDefMult * enemyResMult;
        Double finalHighPlungeDmg = highPlungeFinalBaseDmg * totalDmgBonus * avgCritMultiplier * enemyDefMult * enemyResMult;
        Double finalDPR = (11*finalHighPlungeDmg)+(11*finalPlungeCollisionDmg)+(2*finalSkillDmg);

        //dmg object
        Damage damage = new Damage(uid, 10000026, finalSkillDmg, finalPlungeCollisionDmg, finalLowPlungeDmg, finalHighPlungeDmg, finalDPR);

        return damage;
    } //messy code, but iss okay
}
