/**
 * 
 */
package xapn.design.statepattern.photobooth;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Photobooth state when the cash is empty.
 * 
 * @author Xavier Pigeon
 */
@Component
@Scope("prototype")
public class PhotoBoothEmptyCashState implements IPhotoBoothState {
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void developPhoto() {
        // TODO Auto-generated method stub
        throw new RuntimeException("Not yet implemented"); //
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void giveChange() throws PhotoBoothException {
        // TODO Auto-generated method stub
        throw new RuntimeException("Not yet implemented"); //
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void insertCoin() throws PhotoBoothException {
        // TODO Auto-generated method stub
        throw new RuntimeException("Not yet implemented"); //
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void reloadPhotoPaper(int photopaper) {
        // TODO Auto-generated method stub
        throw new RuntimeException("Not yet implemented"); //
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void takePhoto() throws PhotoBoothException {
        // TODO Auto-generated method stub
        throw new RuntimeException("Not yet implemented"); //
    }
}
