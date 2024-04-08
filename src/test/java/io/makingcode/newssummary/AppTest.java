package io.makingcode.newssummary;


import io.makingcode.newssummary.Components.WebSiteCrawler;
import io.makingcode.newssummary.Models.SiteInfo;
import io.makingcode.newssummary.Modules.WebModule;
import io.makingcode.newssummary.Services.WebSiteContentReader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
@ExtendWith(MockitoExtension.class)
public class AppTest 
{
    @Mock
    WebSiteContentReader reader;

    @Mock
    WebModule web;
    @Mock
    WebSiteCrawler crawler;

    @InjectMocks
    Handler h;
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testThatProcessRequestIsNotNull(){
        //Arrange
        String url = "https://wowhead.com";
        Mockito.when(crawler.buildWeb()).thenReturn(web);
        Mockito.when(web.createWebSiteContentReader()).thenReturn(reader);
        Mockito.when(reader.getSiteContent(url)).thenReturn(TestData.webContent);

        //Act
        SiteInfo info = h.ProcessRequest(url);

        //Assert
        assertNotNull(info);
    }

    @Test
    public void testThatProcessRequestInfoUrlIsNotEmpty()
    {
        //Arrange
        String url = "https://wowhead.com";
        Mockito.when(crawler.buildWeb()).thenReturn(web);
        Mockito.when(web.createWebSiteContentReader()).thenReturn(reader);
        Mockito.when(reader.getSiteContent(url)).thenReturn(TestData.webContent);

        //Act
        SiteInfo info = h.ProcessRequest(url);

        //Assert
        assertTrue(url.equalsIgnoreCase(info.getUrl()));
    }

    @Test
    public void testThatProcessRequestInfoSiteContentIsNotEmpty()
    {
        //Arrange
        String url = "https://wowhead.com";
        Mockito.when(crawler.buildWeb()).thenReturn(web);
        Mockito.when(web.createWebSiteContentReader()).thenReturn(reader);
        Mockito.when(reader.getSiteContent(url)).thenReturn(TestData.webContent);

        //Act
        SiteInfo info = h.ProcessRequest(url);

        //Assert
        assertFalse(info.getSiteContent().isEmpty());
    }
}
