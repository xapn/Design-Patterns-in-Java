/**
 * 
 */
package xapn.design.strategy.weaponchoice;

import static xapn.design.strategy.weaponchoice.CombatUnitNameEnum.UNKNOWN;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Combat unit.
 * 
 * @author Xavier Pigeon
 */
public class CombatUnit {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CombatUnit.class);
    
    private String name;
    private IWeapon weapon;
    
    /**
     * Default constructor.
     * 
     * @param name the name
     * @param weapon the weapon
     */
    public CombatUnit(CombatUnitNameEnum unitName, IWeapon weapon) {
        name = (unitName == null) ? UNKNOWN.getName() : unitName.getName();
        setWeapon(weapon);
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
        weapon.fire();
    }
    
    /**
     * Getter for the field {@code name}.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Lock the target.
     */
    public void lockTarget() {
        weapon.lockTarget();
    }
    
    /**
     * Reload its weapon.
     */
    public void reloadWeapon() {
        weapon.reload();
    }
    
    /**
     * Setter for the field {@code weapon}.
     * 
     * @param weapon the weapon to set
     */
    public void setWeapon(IWeapon weapon) {
        this.weapon = weapon;
        this.weapon.setOwner(this);
    }
}
