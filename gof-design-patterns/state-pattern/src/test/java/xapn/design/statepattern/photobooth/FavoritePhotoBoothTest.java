/**
 * 
 */
package xapn.design.statepattern.photobooth;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import xapn.design.statepattern.photobooth.FavoritePhotoBooth;
import xapn.design.statepattern.photobooth.PhotoBoothEmptyCashState;
import xapn.design.statepattern.photobooth.PhotoBoothException;
import xapn.design.statepattern.photobooth.PhotoBoothFullCashState;
import xapn.design.statepattern.photobooth.PhotoBoothOutOfOrderState;

/**
 * Test Case for
 * {@link xapn.design.statepattern.photobooth.FavoritePhotoBooth}.
 * 
 * @author Xavier Pigeon
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/photobooth-context.xml")
public class FavoritePhotoBoothTest {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(FavoritePhotoBoothTest.class);
    
    @Autowired
    private FavoritePhotoBooth favoritePhotoBooth;
    
    @Rule
    public TestName testName = new TestName();
    
    /**
     * Test method for
     * {@link xapn.design.statepattern.photobooth.FavoritePhotoBooth} .
     */
    @Test
    public void cash_should_be_empty_by_default() throws Exception {
        // Verification
        assertThat(favoritePhotoBooth.getState(), instanceOf(PhotoBoothEmptyCashState.class));
    }
    
    /**
     * Test method for
     * {@link xapn.design.statepattern.photobooth.FavoritePhotoBooth} .
     */
    @Test
    public void given_empty_cash_when_insert_coin_then_full_cash() throws Exception {
        // Setup
        favoritePhotoBooth.setPhotoPaper(1);
        favoritePhotoBooth.setState(favoritePhotoBooth.getEmptyCashState());
        
        // Process
        favoritePhotoBooth.insertCoin();
        
        // Verification
        assertThat(favoritePhotoBooth.getState(), instanceOf(PhotoBoothFullCashState.class));
        assertEquals(1, favoritePhotoBooth.getPhotoPaper());
    }
    
    /**
     * Test method for
     * {@link xapn.design.statepattern.photobooth.FavoritePhotoBooth} .
     */
    @Test
    public void given_full_cash_and_one_photo_paper_when_take_photo_then_out_of_order() throws Exception {
        // Setup
        favoritePhotoBooth.setPhotoPaper(1);
        favoritePhotoBooth.setState(favoritePhotoBooth.getFullCashState());
        
        // Process
        favoritePhotoBooth.takePhoto();
        
        // Verification
        assertThat(favoritePhotoBooth.getState(), instanceOf(PhotoBoothOutOfOrderState.class));
        assertEquals(0, favoritePhotoBooth.getPhotoPaper());
    }
    
    /**
     * Test method for
     * {@link xapn.design.statepattern.photobooth.FavoritePhotoBooth#takePhoto()}
     * .
     */
    @Test
    public void given_full_cash_and_some_photo_paper_when_take_photo_then_empty_cash_and_photo_paper_decreased()
            throws Exception {
        // Setup
        final int photoPaper = 5;
        favoritePhotoBooth.setPhotoPaper(photoPaper);
        favoritePhotoBooth.setState(favoritePhotoBooth.getFullCashState());
        
        // Process
        favoritePhotoBooth.takePhoto();
        
        // Verification
        assertThat(favoritePhotoBooth.getState(), instanceOf(PhotoBoothEmptyCashState.class));
        assertEquals(photoPaper - 1, favoritePhotoBooth.getPhotoPaper());
    }
    
    /**
     * Test method for
     * {@link xapn.design.statepattern.photobooth.FavoritePhotoBooth} .
     */
    @Test
    public void given_full_cash_when_give_change_then_empty_cash() throws Exception {
        // Setup
        final int photoPaperQuantity = 3;
        favoritePhotoBooth.setPhotoPaper(photoPaperQuantity);
        favoritePhotoBooth.setState(favoritePhotoBooth.getFullCashState());
        
        // Process step
        favoritePhotoBooth.giveChange();
        
        // Verification
        assertThat(favoritePhotoBooth.getState(), instanceOf(PhotoBoothEmptyCashState.class));
        assertEquals(photoPaperQuantity, favoritePhotoBooth.getPhotoPaper());
    }
    
    /**
     * Test method for
     * {@link xapn.design.statepattern.photobooth.FavoritePhotoBooth#insertCoin()}
     * .
     */
    @Test(expected = PhotoBoothException.class)
    public void given_full_cash_when_insert_coin_then_failure() throws Exception {
        // Setup
        favoritePhotoBooth.setState(favoritePhotoBooth.getFullCashState());
        
        // Process
        favoritePhotoBooth.insertCoin();
        
        // Verification
        // Nothing else to do.
    }
    
    /**
     * Test method for
     * {@link xapn.design.statepattern.photobooth.FavoritePhotoBooth} .
     */
    @Test
    public void given_full_cash_when_take_photo_then_empty_cash() throws Exception {
        // Setup
        favoritePhotoBooth.setPhotoPaper(2);
        favoritePhotoBooth.setState(favoritePhotoBooth.getFullCashState());
        
        // Process
        favoritePhotoBooth.takePhoto();
        
        // Verification
        assertThat(favoritePhotoBooth.getState(), instanceOf(PhotoBoothEmptyCashState.class));
        assertEquals(1, favoritePhotoBooth.getPhotoPaper());
    }
    
    /**
     * Test method for
     * {@link xapn.design.statepattern.photobooth.FavoritePhotoBooth#insertCoin()}
     * .
     */
    @Test(expected = PhotoBoothException.class)
    public void given_out_of_order_when_insert_coin_then_failure() throws Exception {
        // Setup
        favoritePhotoBooth.setState(favoritePhotoBooth.getOutOfOrderState());
        
        // Process
        favoritePhotoBooth.insertCoin();
        
        // Verification
        // Nothing else to do.
    }
    
    /**
     * Test method for
     * {@link xapn.design.statepattern.photobooth.FavoritePhotoBooth#reloadPhotoPaper()}
     * .
     */
    @Test
    public void given_out_of_order_when_reload_photo_paper_then_empty_cash() throws Exception {
        // Setup
        final int initialPhotoPaper = 0;
        final int expectedPhotoPaper = 10;
        favoritePhotoBooth.setPhotoPaper(initialPhotoPaper);
        favoritePhotoBooth.setState(favoritePhotoBooth.getOutOfOrderState());
        
        // Process
        favoritePhotoBooth.reloadPhotoPaper(expectedPhotoPaper);
        
        // Verification
        assertThat(favoritePhotoBooth.getState(), instanceOf(PhotoBoothEmptyCashState.class));
        assertEquals(expectedPhotoPaper, favoritePhotoBooth.getPhotoPaper());
    }
    
    /**
     * Test method for
     * {@link xapn.design.statepattern.photobooth.FavoritePhotoBooth#giveChange()}
     * .
     */
    @Test(expected = PhotoBoothException.class)
    public void given_printing_in_progress_when_give_change_then_failure() throws Exception {
        // Setup
        favoritePhotoBooth.setState(favoritePhotoBooth.getPrintingInProgressState());
        
        // Process
        favoritePhotoBooth.giveChange();
        
        // Verification
        // Nothing else to do.
    }
    
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        LOGGER.debug("TEST: " + testName.getMethodName());
    }
    
    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {}
}
