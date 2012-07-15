/**
 * 
 */
package xapn.design.strategy.weaponchoice.weapon;

import xapn.design.strategy.weaponchoice.CombatUnit;

/**
 * Abstract weapon.
 * 
 * @author Xavier Pigeon
 */
public abstract class AbstractWeapon {
    
    protected CombatUnit owner;
    
    /**
     * Getter for the field {@code owner}.
     * 
     * @return the owner
     */
    public CombatUnit getOwner() {
        return owner;
    }
    
    /**
     * Setter for the field {@code owner}.
     * 
     * @param owner the owner to set
     */
    public void setOwner(CombatUnit owner) {
        this.owner = owner;
    }
}
