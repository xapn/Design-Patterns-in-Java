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
     * 
     * @throws a {@link PhotoBoothException} exception if something wrong.
     */
    void developPhoto() throws PhotoBoothException;
    
    /**
     * The photo booth displays a message to the client.
     */
    void displayMessage(String message);
    
    /**
     * The photo booth gives change.
     * 
     * @throws a {@link PhotoBoothException} exception if something wrong.
     */
    void giveChange() throws PhotoBoothException;
    
    /**
     * One inserts a coin in the photo booth.
     * 
     * @throws a {@link PhotoBoothException} exception if something wrong.
     */
    void insertCoin() throws PhotoBoothException;
    
    /**
     * One adds photo paper to the photo booth.
     * 
     * @param photoPaper the photo paper to be added
     * @throws a {@link PhotoBoothException} exception if something wrong.
     */
    void reloadPhotoPaper(int photoPaper) throws PhotoBoothException;
    
    /**
     * The photo booth takes a photo.
     * 
     * @throws a {@link PhotoBoothException} exception if something wrong.
     */
    void takePhoto() throws PhotoBoothException;
}
