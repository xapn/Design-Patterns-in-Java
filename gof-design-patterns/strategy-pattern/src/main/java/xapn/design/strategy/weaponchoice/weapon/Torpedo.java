/**
 * 
 */
package xapn.design.strategy.weaponchoice.weapon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xapn.design.strategy.weaponchoice.IWeapon;

/**
 * Torpedo.
 * 
 * @author Xavier Pigeon
 */
public class Torpedo extends AbstractWeapon implements IWeapon {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Torpedo.class);
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void fire() {
        LOGGER.debug(owner.getName() + ": o-o-o-o-o-o-> Torpedo firing!");
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void lockTarget() {
        LOGGER.debug(owner.getName() + ": <.> Target locked.");
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void reload() {
        LOGGER.debug(owner.getName() + ": [<>] Torpedo reloaded.");
    }
}
