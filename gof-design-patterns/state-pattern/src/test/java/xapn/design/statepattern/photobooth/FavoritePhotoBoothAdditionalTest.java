/**
 * 
 */
package xapn.design.statepattern.photobooth;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
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

/**
 * Test Case for
 * {@link xapn.projects.statepattern.photobooth.FavoritePhotoBooth}.
 * 
 * @author Xavier Pigeon
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/photobooth-context.xml")
public class FavoritePhotoBoothAdditionalTest {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(FavoritePhotoBoothAdditionalTest.class);
    
    @Autowired
    private FavoritePhotoBooth favoritePhotoBooth;
    
    @Rule
    public TestName testName = new TestName();
    
    /**
     * Test method for
     * {@link xapn.projects.statepattern.photobooth.FavoritePhotoBooth#developPhoto()}
     * .
     */
    @Test(expected = PhotoBoothException.class)
    public void given_empty_cash_when_develop_photo_then_failure() throws Exception {
        // Setup
        favoritePhotoBooth.setState(favoritePhotoBooth.getEmptyCashState());
        
        // Process
        favoritePhotoBooth.developPhoto();
        
        // Verification
        // Nothing else to do.
    }
    
    /**
     * Test method for
     * {@link xapn.projects.statepattern.photobooth.FavoritePhotoBooth#giveChange()}
     * .
     */
    @Test(expected = PhotoBoothException.class)
    public void given_empty_cash_when_give_change_then_failure() throws Exception {
        // Setup
        favoritePhotoBooth.setState(favoritePhotoBooth.getEmptyCashState());
        
        // Process
        favoritePhotoBooth.giveChange();
        
        // Verification
        // Nothing else to do.
    }
    
    /**
     * Test method for
     * {@link xapn.projects.statepattern.photobooth.FavoritePhotoBooth#reloadPhotoPaper(int)}
     * .
     */
    @Test(expected = PhotoBoothException.class)
    public void given_empty_cash_when_reload_photo_paper_then_photo_paper_increased() throws Exception {
        // Setup
        final int initialPhotoPaper = 3;
        final int expectedPhotoPaper = 8;
        favoritePhotoBooth.setPhotoPaper(initialPhotoPaper);
        favoritePhotoBooth.setState(favoritePhotoBooth.getEmptyCashState());
        
        // Process
        favoritePhotoBooth.reloadPhotoPaper(expectedPhotoPaper - initialPhotoPaper);
        
        // Verification
        assertThat(favoritePhotoBooth.getPhotoPaper(), is(equalTo(expectedPhotoPaper)));
    }
    
    /**
     * Test method for
     * {@link xapn.projects.statepattern.photobooth.FavoritePhotoBooth#takePhoto()}
     * .
     */
    @Test(expected = PhotoBoothException.class)
    public void given_empty_cash_when_take_photo_then_failure() throws Exception {
        // Setup
        favoritePhotoBooth.setState(favoritePhotoBooth.getEmptyCashState());
        
        // Process
        favoritePhotoBooth.takePhoto();
        
        // Verification
        // Nothing else to do.
    }
    
    /**
     * Test method for
     * {@link xapn.projects.statepattern.photobooth.FavoritePhotoBooth#developPhoto()}
     * .
     */
    @Test(expected = PhotoBoothException.class)
    public void given_full_cash_when_develop_photo_then_failure() throws Exception {
        // Setup
        favoritePhotoBooth.setState(favoritePhotoBooth.getFullCashState());
        
        // Process
        favoritePhotoBooth.developPhoto();
        
        // Verification
        // Nothing else to do.
    }
    
    /**
     * Test method for
     * {@link xapn.projects.statepattern.photobooth.FavoritePhotoBooth#reloadPhotoPaper(int)}
     * .
     */
    @Test(expected = PhotoBoothException.class)
    public void given_full_cash_when_reload_photo_paper_then_failure() throws Exception {
        // Setup
        favoritePhotoBooth.setState(favoritePhotoBooth.getFullCashState());
        
        // Process
        favoritePhotoBooth.reloadPhotoPaper(1);
        
        // Verification
        // Nothing else to do.
    }
    
    /**
     * Test method for
     * {@link xapn.projects.statepattern.photobooth.FavoritePhotoBooth#developPhoto()}
     * .
     */
    @Test(expected = PhotoBoothException.class)
    public void given_out_of_order_when_develop_photo_paper_then_failure() throws Exception {
        // Setup
        favoritePhotoBooth.setState(favoritePhotoBooth.getOutOfOrderState());
        
        // Process
        favoritePhotoBooth.developPhoto();
        
        // Verification
        // Nothing else to do.
    }
    
    /**
     * Test method for
     * {@link xapn.projects.statepattern.photobooth.FavoritePhotoBooth#giveChange()}
     * .
     */
    @Test(expected = PhotoBoothException.class)
    public void given_out_of_order_when_give_change_then_failure() throws Exception {
        // Setup
        favoritePhotoBooth.setState(favoritePhotoBooth.getOutOfOrderState());
        
        // Process
        favoritePhotoBooth.giveChange();
        
        // Verification
        // Nothing else to do.
    }
    
    /**
     * Test method for
     * {@link xapn.projects.statepattern.photobooth.FavoritePhotoBooth#takePhoto()}
     * .
     */
    @Test(expected = PhotoBoothException.class)
    public void given_out_of_order_when_take_photo_then_failure() throws Exception {
        // Setup
        favoritePhotoBooth.setState(favoritePhotoBooth.getOutOfOrderState());
        
        // Process
        favoritePhotoBooth.takePhoto();
        
        // Verification
        // Nothing else to do.
    }
    
    /**
     * Test method for
     * {@link xapn.projects.statepattern.photobooth.FavoritePhotoBooth#insertCoin()}
     * .
     */
    @Test(expected = PhotoBoothException.class)
    public void given_printing_in_progress_when_insert_coin_then_failure() throws Exception {
        // Setup
        favoritePhotoBooth.setState(favoritePhotoBooth.getPrintingInProgressState());
        
        // Process
        favoritePhotoBooth.insertCoin();
        
        // Verification
        // Nothing else to do.
    }
    
    /**
     * Test method for
     * {@link xapn.projects.statepattern.photobooth.FavoritePhotoBooth#reloadPhotoPaper(int)}
     * .
     */
    @Test(expected = PhotoBoothException.class)
    public void given_printing_in_progress_when_reload_photo_paper_then_failure() throws Exception {
        // Setup
        favoritePhotoBooth.setPhotoPaper(1);
        favoritePhotoBooth.setState(favoritePhotoBooth.getPrintingInProgressState());
        
        // Process
        favoritePhotoBooth.reloadPhotoPaper(1);
        
        // Verification
        // Nothing else to do.
    }
    
    /**
     * Test method for
     * {@link xapn.projects.statepattern.photobooth.FavoritePhotoBooth#takePhoto()}
     * .
     */
    @Test(expected = PhotoBoothException.class)
    public void given_printing_in_progress_when_take_photo_then_failure() throws Exception {
        // Setup
        favoritePhotoBooth.setState(favoritePhotoBooth.getPrintingInProgressState());
        
        // Process
        favoritePhotoBooth.takePhoto();
        
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
