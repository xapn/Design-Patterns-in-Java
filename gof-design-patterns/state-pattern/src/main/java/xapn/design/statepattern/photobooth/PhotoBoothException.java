/**
 * 
 */
package xapn.design.statepattern.photobooth;

/**
 * Exception for the photo booth working.
 * 
 * @author Xavier Pigeon
 */
public class PhotoBoothException extends Exception {
    
    private static final long serialVersionUID = 5280690447040268809L;
    
    /**
     * Constructor
     * 
     * @param message the message of the exception
     */
    public PhotoBoothException(String message) {
        super(message);
    }
}
