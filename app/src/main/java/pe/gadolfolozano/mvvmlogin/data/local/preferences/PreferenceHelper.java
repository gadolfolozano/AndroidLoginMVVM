package pe.gadolfolozano.mvvmlogin.data.local.preferences;

/**
 * Created by adolfo on 11/03/18.
 */

public interface PreferenceHelper {

    String getUserToken();

    void saveUserToken(String token);

}
