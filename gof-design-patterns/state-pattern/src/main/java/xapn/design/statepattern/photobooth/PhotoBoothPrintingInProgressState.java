/**
 * 
 */
package xapn.design.statepattern.photobooth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Photo booth state when printing photos in progress.
 * 
 * @author Xavier Pigeon
 */
@Component
@Scope("prototype")
public class PhotoBoothPrintingInProgressState implements IPhotoBoothState {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PhotoBoothPrintingInProgressState.class);
    private static final String WAITING_MESSAGE = "Printing in progress, please wait.";
    private FavoritePhotoBooth photoBooth;
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void developPhoto() {
        photoBooth.setPhotoPaper(photoBooth.getPhotoPaper() - 1);
        photoBooth.displayMessage("Photo developed, please retrieve it.");
        
        if (photoBooth.getPhotoPaper() > 0) {
            photoBooth.setState(photoBooth.getEmptyCashState());
        } else {
            photoBooth.setState(photoBooth.getOutOfOrderState());
        }
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
        throw new PhotoBoothException(WAITING_MESSAGE);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void insertCoin() throws PhotoBoothException {
        throw new PhotoBoothException(WAITING_MESSAGE);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void reloadPhotoPaper(int photopaper) throws PhotoBoothException {
        throw new PhotoBoothException(WAITING_MESSAGE);
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
        throw new PhotoBoothException(WAITING_MESSAGE);
    }
}
