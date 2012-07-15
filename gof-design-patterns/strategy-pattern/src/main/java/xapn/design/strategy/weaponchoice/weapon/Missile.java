/**
 * 
 */
package xapn.design.strategy.weaponchoice.weapon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xapn.design.strategy.weaponchoice.IWeapon;

/**
 * Missile.
 * 
 * @author Xavier Pigeon
 */
public class Missile extends AbstractWeapon implements IWeapon {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Missile.class);
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void fire() {
        LOGGER.debug(owner.getName() + ": ---===>>> Missile firing!");
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void lockTarget() {
        LOGGER.debug(owner.getName() + ": [x] Target locked.");
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void reload() {
        LOGGER.debug(owner.getName() + ": [0] Missile reloaded.");
    }
}
