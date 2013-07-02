package de.kacperbak.chapter9;

import de.kacperbak.AbstractWicketTest;
import de.kacperbak.chapter9models.ModelsExamples;
import org.junit.Test;

/**
 * User: bakka
 * Date: 16.06.13
 */
public class ModelsExamplesTest extends AbstractWicketTest{
    @Test
    public void testRender(){
        tester.startPage(ModelsExamples.class);
        tester.assertRenderedPage(ModelsExamples.class);
    }
}
