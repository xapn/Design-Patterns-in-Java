/**
 * 
 */
package xapn.design.strategy.weaponchoice.weapon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xapn.design.strategy.weaponchoice.IWeapon;

/**
 * Rifle.
 * 
 * @author Xavier Pigeon
 */
public class Rifle extends AbstractWeapon implements IWeapon {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Rifle.class);
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void fire() {
        LOGGER.debug(owner.getName() + ": >->->->-> Rifle firing!");
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void lockTarget() {
        LOGGER.debug(owner.getName() + ": (0) Target locked.");
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void reload() {
        LOGGER.debug(owner.getName() + ": [-] Rifle reloaded.");
    }
}
