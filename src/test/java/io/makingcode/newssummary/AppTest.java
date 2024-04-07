package io.makingcode.newssummary;

import static org.junit.Assert.assertTrue;

import io.makingcode.newssummary.Models.SiteInfo;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testThatProcessRequestIsNotNull(){
        SiteCrawler sc = new SiteCrawler();
        SiteInfo info = sc.ProcessRequest("https://makingcode.io");
        Assert.assertNotNull(info);
    }

    @Test
    public void testThatProcessRequestInfoUrlIsNotEmpty()
    {
        SiteCrawler sc = new SiteCrawler();
        String url = "https://makingcode.io";
        SiteInfo info = sc.ProcessRequest(url);
        Assert.assertTrue(url.equalsIgnoreCase(info.getUrl()));
    }
}
