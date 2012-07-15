/**
 * 
 */
package xapn.design.strategy.weaponchoice.badarmy;

import static xapn.design.strategy.weaponchoice.CombatUnitNameEnum.UNKNOWN;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xapn.design.strategy.weaponchoice.CombatUnitNameEnum;

/**
 * Bad combat unit.
 * 
 * @author Xavier Pigeon
 */
public class BadCombatUnit {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(BadCombatUnit.class);
    
    private String name;
    private WeaponEnum weapon;
    
    /**
     * Default constructor.
     * 
     * @param name the name
     * @param weapon the weapon
     */
    public BadCombatUnit(CombatUnitNameEnum unitName, WeaponEnum weapon) {
        name = (unitName == null) ? UNKNOWN.getName() : unitName.getName();
        this.weapon = weapon;
    }
    
    /**
     * Fight.
     */
    public void engageAndFight() {
        LOGGER.debug(name + ": engaged and fighting...");
        lockTarget();
        fireAtEnnemy();
        reloadWeapon();
    }
    
    /**
     * Fire with its own weapon.
     */
    public void fireAtEnnemy() {
        switch (weapon) {
        case BAZOOKA:
            LOGGER.debug(name + ": bazooka firing!");
            break;
        case MACHINE_GUN:
            LOGGER.debug(name + ": machine gun firing!");
            break;
        case MISSILE:
            LOGGER.debug(name + ": missile firing!");
            break;
        case RIFLE:
            LOGGER.debug(name + ": rifle firing!");
            break;
        case TORPEDO:
            LOGGER.debug(name + ": torpedo firing!");
            break;
        default:
            LOGGER.debug(name + ": unknown weapon.");
            break;
        }
    }
    
    /**
     * Lock the target.
     */
    public void lockTarget() {
        switch (weapon) {
        case BAZOOKA:
            LOGGER.debug(name + ": target locked with bazooka.");
            break;
        case MACHINE_GUN:
            LOGGER.debug(name + ": target locked with machine gun.");
            break;
        case MISSILE:
            LOGGER.debug(name + ": target locked with missile.");
            break;
        case RIFLE:
            LOGGER.debug(name + ": target locked with rifle.");
            break;
        case TORPEDO:
            LOGGER.debug(name + ": target locked with torpedo.");
            break;
        default:
            LOGGER.debug(name + ": unknown weapon.");
            break;
        }
    }
    
    /**
     * Reload its weapon.
     */
    public void reloadWeapon() {
        switch (weapon) {
        case BAZOOKA:
            LOGGER.debug(name + ": bazooka reloaded.");
            break;
        case MACHINE_GUN:
            LOGGER.debug(name + ": machine gun reloaded.");
            break;
        case MISSILE:
            LOGGER.debug(name + ": missile reloaded.");
            break;
        case RIFLE:
            LOGGER.debug(name + ": rifle reloaded.");
            break;
        case TORPEDO:
            LOGGER.debug(name + ": torpedo reloaded.");
            break;
        default:
            LOGGER.debug(name + ": unknown weapon.");
            break;
        }
    }
    
    /**
     * Setter for the field {@code weapon}.
     * 
     * @param weapon the weapon to set
     */
    public void setWeapon(WeaponEnum weapon) {
        this.weapon = weapon;
    }
}
