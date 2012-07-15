/**
 * 
 */
package xapn.design.strategy.weaponchoice;

/**
 * Interface for all weapon types.
 * 
 * @author Xavier Pigeon
 */
public interface IWeapon {
    
    /**
     * Fire.
     */
    void fire();
    
    /**
     * Lock the target.
     */
    void lockTarget();
    
    /**
     * Reload.
     */
    void reload();
    
    /**
     * Set the weapon owner.
     */
    void setOwner(CombatUnit owner);
}
