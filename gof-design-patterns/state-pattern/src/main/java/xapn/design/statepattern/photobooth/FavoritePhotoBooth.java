/**
 * 
 */
package xapn.design.statepattern.photobooth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Favorite Photo Booth.
 * <p/>
 * <ul>
 * <li>Initialization: At first, the cash is empty.</li>
 * <li>Insert a coin, then the cash becomes full.</li>
 * <li>If one wants to get given change, the coin is given back and the cash
 * becomes empty.</li>
 * <li>Allowed to get the money back until the photo is printed.</li>
 * <li>When the cash is full, if one takes a photo, the photo booth develops it,
 * and the cash becomes empty.</li>
 * <li>One pays to print only one photo at a time.</li>
 * <li>Out of order if there is no longer photo paper: add some photo paper to
 * make the photo booth working.</li>
 * <li>Impossible to insert coin if the photo booth is out of order.</li>
 * </ul>
 * </p>
 * 
 * @author Xavier Pigeon
 */
@Component
@Scope("prototype")
public class FavoritePhotoBooth implements IPhotoBooth {
    
    @Autowired
    private PhotoBoothEmptyCashState emptyCashState;
    @Autowired
    private PhotoBoothFullCashState fullCashState;
    @Autowired
    private PhotoBoothOutOfOrderState outOfOrderState;
    private int photoPaper;
    @Autowired
    private PhotoBoothPrintingInProgressState printingInProgressState;
    private IPhotoBoothState state;
    
    /**
     * Default constructor.
     */
    public FavoritePhotoBooth() {
        // TODO Auto-generated constructor stub
        throw new RuntimeException("Not yet implemented");
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void developPhoto() {
        // TODO Auto-generated method stub
        throw new RuntimeException("Not yet implemented"); //
    }
    
    /**
     * Getter for the field {@code emptyCashState}
     * 
     * @return the emptyCashState
     */
    public PhotoBoothEmptyCashState getEmptyCashState() {
        return emptyCashState;
    }
    
    /**
     * Getter for the field {@code fullCashState}
     * 
     * @return the fullCashState
     */
    public PhotoBoothFullCashState getFullCashState() {
        return fullCashState;
    }
    
    /**
     * Getter for the field {@code outOfOrderState}
     * 
     * @return the outOfOrderState
     */
    public PhotoBoothOutOfOrderState getOutOfOrderState() {
        return outOfOrderState;
    }
    
    /**
     * Getter for the field {@code photoPaper}
     * 
     * @return the photoPaper
     */
    public int getPhotoPaper() {
        return photoPaper;
    }
    
    /**
     * Getter for the field {@code printingInProgressState}
     * 
     * @return the printingInProgressState
     */
    public PhotoBoothPrintingInProgressState getPrintingInProgressState() {
        return printingInProgressState;
    }
    
    /**
     * Getter for the field {@code state}
     * 
     * @return the state
     */
    public IPhotoBoothState getState() {
        return state;
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
        // TODO Auto-generated method stub
        throw new RuntimeException("Not yet implemented"); //
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void reloadPhotoPaper(int photoPaper) {
        // TODO Auto-generated method stub
        throw new RuntimeException("Not yet implemented"); //
    }
    
    /**
     * Setter for the field {@code emptyCashState}
     * 
     * @param emptyCashState the emptyCashState to set
     */
    public void setEmptyCashState(PhotoBoothEmptyCashState emptyCashState) {
        this.emptyCashState = emptyCashState;
    }
    
    /**
     * Setter for the field {@code fullCashState}
     * 
     * @param fullCashState the fullCashState to set
     */
    public void setFullCashState(PhotoBoothFullCashState fullCashState) {
        this.fullCashState = fullCashState;
    }
    
    /**
     * Setter for the field {@code outOfOrderState}
     * 
     * @param outOfOrderState the outOfOrderState to set
     */
    public void setOutOfOrderState(PhotoBoothOutOfOrderState outOfOrderState) {
        this.outOfOrderState = outOfOrderState;
    }
    
    /**
     * Setter for the field {@code photoPaper}
     * 
     * @param photoPaper the photoPaper to set
     */
    public void setPhotoPaper(int photoPaper) {
        this.photoPaper = photoPaper;
    }
    
    /**
     * Setter for the field {@code printingInProgressState}
     * 
     * @param printingInProgressState the printingInProgressState to set
     */
    public void setPrintingInProgressState(PhotoBoothPrintingInProgressState printingInProgressState) {
        this.printingInProgressState = printingInProgressState;
    }
    
    /**
     * Setter for the field {@code state}
     * 
     * @param state the state to set
     */
    public void setState(IPhotoBoothState photoBoothState) {
        state = photoBoothState;
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
