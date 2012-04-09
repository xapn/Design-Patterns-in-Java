/**
 * 
 */
package xapn.design.statepattern.photobooth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Photo booth state when being out of order.
 * 
 * @author Xavier Pigeon
 */
@Component
@Scope("prototype")
public class PhotoBoothOutOfOrderState extends AbstractPhotoBoothState implements IPhotoBoothState {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PhotoBoothOutOfOrderState.class);
    private static final String OUT_OF_ORDER = "Out of order: no more photo paper.";
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void developPhoto() throws PhotoBoothException {
        throw new PhotoBoothException(OUT_OF_ORDER);
    }
    
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
        throw new PhotoBoothException("No money. Out of order.");
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void insertCoin() throws PhotoBoothException {
        throw new PhotoBoothException("Out of order: get your money back.");
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
        throw new PhotoBoothException("Out of order.");
    }
}
