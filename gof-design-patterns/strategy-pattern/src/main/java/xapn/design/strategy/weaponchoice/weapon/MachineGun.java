/**
 * 
 */
package xapn.design.strategy.weaponchoice.weapon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xapn.design.strategy.weaponchoice.IWeapon;

/**
 * Machine Gun.
 * 
 * @author Xavier Pigeon
 */
public class MachineGun extends AbstractWeapon implements IWeapon {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MachineGun.class);
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void fire() {
        LOGGER.debug(owner.getName() + ": #######>>> Machine Gun firing!");
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void lockTarget() {
        LOGGER.debug(owner.getName() + ": {x} Target locked.");
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void reload() {
        LOGGER.debug(owner.getName() + ": [#] Machine Gun reloaded.");
    }
}
