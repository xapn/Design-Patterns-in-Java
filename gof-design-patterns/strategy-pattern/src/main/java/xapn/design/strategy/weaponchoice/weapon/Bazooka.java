/**
 * 
 */
package xapn.design.strategy.weaponchoice.weapon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xapn.design.strategy.weaponchoice.IWeapon;

/**
 * Bazooka.
 * 
 * @author Xavier Pigeon
 */
public class Bazooka extends AbstractWeapon implements IWeapon {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Bazooka.class);
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void fire() {
        LOGGER.debug(owner.getName() + ": ))--------ooOOOX Bazooka firing!");
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void lockTarget() {
        LOGGER.debug(owner.getName() + ": (+) Target locked.");
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void reload() {
        LOGGER.debug(owner.getName() + ": |x| Bazooka reloaded.");
    }
}
