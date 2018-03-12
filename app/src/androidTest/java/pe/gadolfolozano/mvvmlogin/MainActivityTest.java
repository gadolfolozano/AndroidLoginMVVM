package pe.gadolfolozano.mvvmlogin;

import android.support.design.widget.TextInputEditText;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pe.gadolfolozano.mvvmlogin.ui.main.MainActivity;
import pe.gadolfolozano.mvvmlogin.util.Constants;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertEquals;

/**
 * Created by gustavo.lozano on 3/12/2018.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void ensureFirstNameEmpty() throws Exception {
        MainActivity activity = rule.getActivity();
        View viewById = activity.findViewById(R.id.edtFirstName);
        assertThat(viewById, notNullValue());
        assertThat(viewById, instanceOf(TextInputEditText.class));
        TextInputEditText textInputEditText = (TextInputEditText) viewById;
        assertThat(textInputEditText, notNullValue());
        assertEquals(textInputEditText.getText().toString(), Constants.EMPTY);
    }

    @Test
    public void ensureLastNameEmpty() throws Exception {
        MainActivity activity = rule.getActivity();
        View viewById = activity.findViewById(R.id.edtLastName);
        assertThat(viewById, notNullValue());
        assertThat(viewById, instanceOf(TextInputEditText.class));
        TextInputEditText textInputEditText = (TextInputEditText) viewById;
        assertThat(textInputEditText, notNullValue());
        assertEquals(textInputEditText.getText().toString(), Constants.EMPTY);
    }

    @Test
    public void ensurePasswordEmpty() throws Exception {
        MainActivity activity = rule.getActivity();
        View viewById = activity.findViewById(R.id.edtPassword);
        assertThat(viewById, notNullValue());
        assertThat(viewById, instanceOf(TextInputEditText.class));
        TextInputEditText textInputEditText = (TextInputEditText) viewById;
        assertThat(textInputEditText, notNullValue());
        assertEquals(textInputEditText.getText().toString(), Constants.EMPTY);
    }
}
