package de.kacperbak.chapter4;

import de.kacperbak.AbstractWicketTest;
import org.junit.Test;

/**
 * User: bakka
 * Date: 06.06.13
 */
public class FragmentExampleTest extends AbstractWicketTest {

    @Test
    public void render(){
        tester.startPage(FragmentExample.class);
        tester.assertRenderedPage(FragmentExample.class);
    }
}
