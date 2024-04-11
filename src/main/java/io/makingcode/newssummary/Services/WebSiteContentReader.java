package io.makingcode.newssummary.Services;

import io.makingcode.newssummary.Models.SiteInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.inject.Inject;
import java.io.IOException;

public class WebSiteContentReader {

    @Inject
    public WebSiteContentReader() {
    }

    public String getSiteContent(String url) {

        try {
            Document d = Jsoup.connect(url).get();
            return d.outerHtml();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String findRSSFeedUrls(String html){
        Document d = Jsoup.parse(html);
        Elements rssLinks = d.select("link[type=application/rss+xml]");
        if(!rssLinks.isEmpty()){
            return rssLinks.getFirst().attr("href");
        }
        else{
            rssLinks = d.select("link[type=application/atom+xml]");
            if(!rssLinks.isEmpty()){
                return rssLinks.getFirst().attr("href");
            }
        }
        return null;
    }
}
