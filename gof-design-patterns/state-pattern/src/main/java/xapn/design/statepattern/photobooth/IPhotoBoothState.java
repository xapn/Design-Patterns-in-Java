/**
 * 
 */
package xapn.design.statepattern.photobooth;

/**
 * Interface for photo booth states.
 * 
 * @author Xavier Pigeon
 */
public interface IPhotoBoothState extends IPhotoBooth {
    
    /**
     * Setter for the field {@code photoBooth}
     * 
     * @param photoBooth the photoBooth to set
     */
    public void setPhotoBooth(FavoritePhotoBooth photoBooth);
}
