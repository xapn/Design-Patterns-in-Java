/**
 * 
 */
package xapn.design.statepattern.photobooth;


/**
 * Abstract photo booth state.
 * 
 * @author Xavier Pigeon
 */
public abstract class AbstractPhotoBoothState implements IPhotoBooth {
    
    protected FavoritePhotoBooth photoBooth;
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void reloadPhotoPaper(int photoPaper) {
        photoBooth.setPhotoPaper(photoBooth.getPhotoPaper() + photoPaper);
        photoBooth.displayMessage("Photo paper jetset supplied.");
        photoBooth.setState(photoBooth.getEmptyCashState());
    }
}
