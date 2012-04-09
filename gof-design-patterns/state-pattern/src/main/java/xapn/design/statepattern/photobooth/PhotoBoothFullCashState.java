/**
 * 
 */
package xapn.design.statepattern.photobooth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Photo booth state when the cash is full.
 * 
 * @author Xavier Pigeon
 */
@Component
@Scope("prototype")
public class PhotoBoothFullCashState implements IPhotoBoothState {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PhotoBoothFullCashState.class);
    private FavoritePhotoBooth photoBooth;
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void developPhoto() throws PhotoBoothException {
        throw new PhotoBoothException("Let's take a photo first, please.");
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
        photoBooth.setState(photoBooth.getEmptyCashState());
        photoBooth.displayMessage("Get your money back.");
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void insertCoin() throws PhotoBoothException {
        throw new PhotoBoothException("You have already paid, get your money back.");
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void reloadPhotoPaper(int photopaper) throws PhotoBoothException {
        throw new PhotoBoothException("Give change first, please.");
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
        photoBooth.displayMessage("Photo taken, development in progress.");
        photoBooth.setState(photoBooth.getPrintingInProgressState());
        photoBooth.developPhoto();
    }
}
