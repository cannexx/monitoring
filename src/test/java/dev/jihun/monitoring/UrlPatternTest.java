package dev.jihun.monitoring;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class UrlPatternTest {

    @Test
    public void urlPatternTest() {
        String regex = "^(https?):\\/\\/([^:\\/\\s]+)(:([^\\/]*))?((\\/[^\\s/\\/]+)*)?\\/?([^#\\s\\?]*)(\\?([^#\\s]*))?(#(\\w*))?$";

        Pattern p = Pattern.compile(regex);

        assertThat(p.matcher("http://www.yangsan.go.kr").matches(),is(true));
        assertThat(p.matcher("www.yangsan.go.kr").matches(),is(false));
    }
}
