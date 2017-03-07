package de.roskenet.simplecms.controller;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class PathHelperTest {

    @Test
    public void testExtractPageName() {
        final String simplePath = "/page/mypage.html";
        final String multipleDirPath = "/page/dir/anotherpage.html";
        final String externalPath = "/static/something.html";
        
        assertThat("mypage", is(PathHelper.filterSuffix(simplePath)));
        assertThat("dir/anotherpage", is(PathHelper.filterSuffix(multipleDirPath)));
        assertThat("", is(PathHelper.filterSuffix(externalPath)));
    }

}
