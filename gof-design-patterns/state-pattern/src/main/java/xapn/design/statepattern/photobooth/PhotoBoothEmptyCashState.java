/**
 * 
 */
package xapn.design.statepattern.photobooth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Photobooth state when the cash is empty.
 * 
 * @author Xavier Pigeon
 */
@Component
@Scope("prototype")
public class PhotoBoothEmptyCashState extends AbstractPhotoBoothState implements IPhotoBoothState {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PhotoBoothEmptyCashState.class);
    private static final String DESCRIPTION = "The cash is empty.";
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void developPhoto() throws PhotoBoothException {
        throw new PhotoBoothException(DESCRIPTION);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void displayMessage(String message) {
        LOGGER.debug(message);
    }
    
    /**
     * Getter for the field {@code photoBooth}
     * 
     * @return the photoBooth
     */
    public FavoritePhotoBooth getPhotoBooth() {
        return photoBooth;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void giveChange() throws PhotoBoothException {
        throw new PhotoBoothException(DESCRIPTION);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void insertCoin() throws PhotoBoothException {
        photoBooth.setState(photoBooth.getFullCashState());
        photoBooth.displayMessage("Ready to take one photo.");
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void reloadPhotoPaper(int photoPaper) {
        super.reloadPhotoPaper(photoPaper);
    }
    
    /**
     * Setter for the field {@code photoBooth}
     * 
     * @param photoBooth the photoBooth to set
     */
    @Override
    public void setPhotoBooth(FavoritePhotoBooth photoBooth) {
        this.photoBooth = photoBooth;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void takePhoto() throws PhotoBoothException {
        throw new PhotoBoothException(DESCRIPTION);
    }
}
