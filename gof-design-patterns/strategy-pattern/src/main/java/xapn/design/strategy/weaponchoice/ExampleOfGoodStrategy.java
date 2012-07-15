/**
 * 
 */
package xapn.design.strategy.weaponchoice;

import static xapn.design.strategy.weaponchoice.CombatUnitNameEnum.FIGHTER_AIRCRAFT;
import static xapn.design.strategy.weaponchoice.CombatUnitNameEnum.SOLDIER;
import static xapn.design.strategy.weaponchoice.CombatUnitNameEnum.SUBMARINE;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xapn.design.strategy.weaponchoice.weapon.Bazooka;
import xapn.design.strategy.weaponchoice.weapon.Missile;
import xapn.design.strategy.weaponchoice.weapon.Rifle;
import xapn.design.strategy.weaponchoice.weapon.Torpedo;

/**
 * Example of using the Strategy design pattern for implementing weapon choice.
 * 
 * @author Xavier Pigeon
 */
public class ExampleOfGoodStrategy {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ExampleOfGoodStrategy.class);
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        LOGGER.debug("War beginning.");
        
        Map<CombatUnitNameEnum, CombatUnit> army = new HashMap<CombatUnitNameEnum, CombatUnit>(3);
        army.put(SOLDIER, new CombatUnit(SOLDIER, new Rifle()));
        army.put(SUBMARINE, new CombatUnit(SUBMARINE, new Torpedo()));
        army.put(FIGHTER_AIRCRAFT, new CombatUnit(FIGHTER_AIRCRAFT, new Missile()));
        
        makeYourArmyFight(army.values());
        
        LOGGER.debug("The army is now increasing its fire power.");
        army.get(SOLDIER).setWeapon(new Bazooka());
        army.get(SUBMARINE).setWeapon(new Missile());
        army.get(FIGHTER_AIRCRAFT).setWeapon(new Missile());
        
        makeYourArmyFight(army.values());
        
        LOGGER.debug("War ended.");
    }
    
    private static void makeYourArmyFight(Collection<CombatUnit> army) {
        for (CombatUnit combatUnit : army) {
            combatUnit.engageAndFight();
        }
    }
}
