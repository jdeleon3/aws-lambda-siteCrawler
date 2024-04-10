package io.makingcode.newssummary;


import com.rometools.rome.io.FeedException;
import io.makingcode.newssummary.Components.WebSiteCrawler;
import io.makingcode.newssummary.Models.SiteInfo;
import io.makingcode.newssummary.Modules.WebModule;
import io.makingcode.newssummary.Services.RSSContentReader;
import io.makingcode.newssummary.Services.WebSiteContentReader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
@ExtendWith(MockitoExtension.class)
public class AppTest 
{
    @Mock
    WebSiteContentReader reader
            ;
    @Mock
    RSSContentReader rssReader;

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
    public void testThatProcessRequestIsNotNull() throws FeedException, IOException {
        //Arrange
        String url = "https://fakewowhead.com";
        String rssUrl = "https://fakewowhead.com/feed/";
        Mockito.when(crawler.buildWeb()).thenReturn(web);
        Mockito.when(web.createWebSiteContentReader()).thenReturn(reader);
        Mockito.when(web.createRSSContentReader()).thenReturn(rssReader);
        Mockito.when(reader.getSiteContent(url)).thenReturn(TestData.webContent);
        Mockito.when(reader.findRSSFeedUrls(TestData.webContent)).thenCallRealMethod();
        Mockito.when(rssReader.processRSSFeed(rssUrl)).thenCallRealMethod();
        Mockito.when(rssReader.getFeed(rssUrl)).thenReturn(TestData.getRSSFeed());

        //Act
        SiteInfo info = h.ProcessRequest(url);

        //Assert
        assertNotNull(info);
    }

    @Test
    public void testThatProcessRequestInfoUrlIsNotEmpty() throws FeedException, IOException {
        //Arrange
        String url = "https://fakewowhead.com";
        String rssUrl = "https://fakewowhead.com/feed/";
        Mockito.when(crawler.buildWeb()).thenReturn(web);
        Mockito.when(web.createWebSiteContentReader()).thenReturn(reader);
        Mockito.when(web.createRSSContentReader()).thenReturn(rssReader);
        Mockito.when(reader.getSiteContent(url)).thenReturn(TestData.webContent);
        Mockito.when(reader.findRSSFeedUrls(TestData.webContent)).thenCallRealMethod();
        Mockito.when(rssReader.processRSSFeed(rssUrl)).thenCallRealMethod();
        Mockito.when(rssReader.getFeed(rssUrl)).thenReturn(TestData.getRSSFeed());

        //Act
        SiteInfo info = h.ProcessRequest(url);

        //Assert
        assertTrue(url.equalsIgnoreCase(info.getUrl()));
    }

    @Test
    public void testThatProcessRequestInfoSiteContentIsNotEmpty() throws FeedException, IOException {
        //Arrange
        String url = "https://fakewowhead.com";
        String rssUrl = "https://fakewowhead.com/feed/";
        Mockito.when(crawler.buildWeb()).thenReturn(web);
        Mockito.when(web.createWebSiteContentReader()).thenReturn(reader);
        Mockito.when(web.createRSSContentReader()).thenReturn(rssReader);
        Mockito.when(reader.getSiteContent(url)).thenReturn(TestData.webContent);
        Mockito.when(reader.findRSSFeedUrls(TestData.webContent)).thenCallRealMethod();
        Mockito.when(rssReader.processRSSFeed(rssUrl)).thenCallRealMethod();
        Mockito.when(rssReader.getFeed(rssUrl)).thenReturn(TestData.getRSSFeed());

        //Act
        SiteInfo info = h.ProcessRequest(url);

        //Assert
        assertFalse(info.getSiteContent().isEmpty());
    }

    @Test
    public void testThatRSSFeederReturns2Urls() throws FeedException, IOException {
        //Arrange
        String url = "https://fakewowhead.com";
        String rssUrl = "https://fakewowhead.com/feed/";
        Mockito.when(crawler.buildWeb()).thenReturn(web);
        Mockito.when(web.createWebSiteContentReader()).thenReturn(reader);
        Mockito.when(web.createRSSContentReader()).thenReturn(rssReader);
        Mockito.when(reader.getSiteContent(url)).thenReturn(TestData.webContent);
        Mockito.when(reader.findRSSFeedUrls(TestData.webContent)).thenCallRealMethod();
        Mockito.when(rssReader.processRSSFeed(rssUrl)).thenCallRealMethod();
        Mockito.when(rssReader.getFeed(rssUrl)).thenReturn(TestData.getRSSFeed());

        //Act
        SiteInfo info = h.ProcessRequest(url);

        //Assert
        assertEquals(2, info.getEmbeddedUrls().size());
    }
}
