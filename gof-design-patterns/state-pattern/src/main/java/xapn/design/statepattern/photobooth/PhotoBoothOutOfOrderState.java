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
public class PhotoBoothOutOfOrderState implements IPhotoBoothState {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PhotoBoothOutOfOrderState.class);
    private FavoritePhotoBooth photoBooth;
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void developPhoto() {
        // TODO Auto-generated method stub
        throw new RuntimeException("Not yet implemented"); //
    }
    
    @Override
    public void displayMessage(String message) {
        // TODO Auto-generated method stub
        throw new RuntimeException("Not yet implemented"); //
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
        // TODO Auto-generated method stub
        throw new RuntimeException("Not yet implemented"); //
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
    public void reloadPhotoPaper(int photopaper) {
        photoBooth.setPhotoPaper(photoBooth.getPhotoPaper() + photopaper);
        photoBooth.setState(photoBooth.getEmptyCashState());
        photoBooth.displayMessage("Photo paper jetset supplied.");
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
        // TODO Auto-generated method stub
        throw new RuntimeException("Not yet implemented"); //
    }
}
