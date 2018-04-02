package pe.gadolfolozano.mvvmlogin;

import org.junit.Test;

import pe.gadolfolozano.mvvmlogin.ui.model.BaseModelLiveData;
import pe.gadolfolozano.mvvmlogin.util.Constants;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testBaseModelLiveData() throws Exception {
        BaseModelLiveData baseModelLiveData = new BaseModelLiveData();
        baseModelLiveData.setErrorMessage("error");
        baseModelLiveData.setSuccesfull(false);

        assertEquals(false, baseModelLiveData.isSuccesfull());
        assertNotNull(baseModelLiveData);
        assertNotNull(baseModelLiveData.getErrorMessage());
        assertNull(baseModelLiveData.getData());
        assertEquals(0, baseModelLiveData.getStatusCode());
    }

}