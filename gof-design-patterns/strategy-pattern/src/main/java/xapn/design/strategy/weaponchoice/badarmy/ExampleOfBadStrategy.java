/**
 * 
 */
package xapn.design.strategy.weaponchoice.badarmy;

import static xapn.design.strategy.weaponchoice.CombatUnitNameEnum.FIGHTER_AIRCRAFT;
import static xapn.design.strategy.weaponchoice.CombatUnitNameEnum.SOLDIER;
import static xapn.design.strategy.weaponchoice.CombatUnitNameEnum.SUBMARINE;
import static xapn.design.strategy.weaponchoice.badarmy.WeaponEnum.BAZOOKA;
import static xapn.design.strategy.weaponchoice.badarmy.WeaponEnum.MACHINE_GUN;
import static xapn.design.strategy.weaponchoice.badarmy.WeaponEnum.MISSILE;
import static xapn.design.strategy.weaponchoice.badarmy.WeaponEnum.RIFLE;
import static xapn.design.strategy.weaponchoice.badarmy.WeaponEnum.TORPEDO;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xapn.design.strategy.weaponchoice.CombatUnitNameEnum;

/**
 * Example of using a bad army with a bad implementation.
 * 
 * @author Xavier Pigeon
 */
public class ExampleOfBadStrategy {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ExampleOfBadStrategy.class);
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        LOGGER.debug("War beginning.");
        
        Map<CombatUnitNameEnum, BadCombatUnit> army = new HashMap<CombatUnitNameEnum, BadCombatUnit>(3);
        army.put(SOLDIER, new BadCombatUnit(SOLDIER, RIFLE));
        army.put(SUBMARINE, new BadCombatUnit(SUBMARINE, TORPEDO));
        army.put(FIGHTER_AIRCRAFT, new BadCombatUnit(FIGHTER_AIRCRAFT, MACHINE_GUN));
        
        makeYourArmyFight(army.values());
        
        LOGGER.debug("The army is now increasing its fire power.");
        army.get(SOLDIER).setWeapon(BAZOOKA);
        army.get(SUBMARINE).setWeapon(MISSILE);
        army.get(FIGHTER_AIRCRAFT).setWeapon(MISSILE);
        
        makeYourArmyFight(army.values());
        
        LOGGER.debug("War ended.");
    }
    
    private static void makeYourArmyFight(Collection<BadCombatUnit> army) {
        for (BadCombatUnit combatUnit : army) {
            combatUnit.engageAndFight();
        }
    }
}
