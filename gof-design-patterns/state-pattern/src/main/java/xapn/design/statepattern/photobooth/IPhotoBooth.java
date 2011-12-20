/**
 * 
 */
package xapn.design.statepattern.photobooth;

/**
 * Interface for using the photo booth.
 * 
 * @author Xavier Pigeon
 */
public interface IPhotoBooth {
    
    /**
     * The photo booth develops the photo.
     */
    void developPhoto();
    
    /**
     * The photo booth gives change.
     */
    void giveChange() throws PhotoBoothException;
    
    /**
     * One inserts a coin in the photo booth.
     */
    void insertCoin() throws PhotoBoothException;
    
    /**
     * One adds photo paper to the photo booth.
     * 
     * @param photoPaper the photo paper to be added
     */
    void reloadPhotoPaper(int photoPaper);
    
    /**
     * The photo booth takes a photo.
     */
    void takePhoto() throws PhotoBoothException;
}
