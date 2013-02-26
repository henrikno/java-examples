package no.slash;

import com.google.inject.servlet.GuiceFilter;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;
import org.junit.Test;
import static org.fest.assertions.Assertions.assertThat;

public class MyResourceTest extends JerseyTest {

    @Override
    protected AppDescriptor configure() {
        return new WebAppDescriptor.Builder()
                .filterClass(GuiceFilter.class)
                .contextListenerClass(GuiceConfig.class)
                .build();
    }

    @Test
    public void shouldGetTestBack() throws Exception {
        final String result = resource().path("test").get(String.class);
        assertThat(result).isEqualTo("Test");
    }
}
