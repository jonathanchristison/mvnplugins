package org.apache.maven.plugins.shade.resource;

import java.util.Locale;

import junit.framework.TestCase;

/**
 * Test for {@link ApacheNoticeResourceTransformer}.
 * 
 * @author Benjamin Bentmann
 * @version $Id$
 */
public class ApacheNoticeResourceTransformerTest
    extends TestCase
{

    private ApacheNoticeResourceTransformer transformer;

    static
    {
        /*
         * NOTE: The Turkish locale has an usual case transformation for the letters "I" and "i", making it a prime
         * choice to test for improper case-less string comparisions.
         */
        Locale.setDefault( new Locale( "tr" ) );
    }

    public void setUp()
    {
        this.transformer = new ApacheNoticeResourceTransformer();
    }

    public void testCanTransformResource()
    {
        assertTrue( this.transformer.canTransformResource( "META-INF/NOTICE" ) );
        assertTrue( this.transformer.canTransformResource( "META-INF/NOTICE.TXT" ) );
        assertTrue( this.transformer.canTransformResource( "META-INF/Notice.txt" ) );
        assertFalse( this.transformer.canTransformResource( "META-INF/MANIFEST.MF" ) );
    }

}
