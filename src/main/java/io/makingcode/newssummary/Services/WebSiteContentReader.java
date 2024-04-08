package io.makingcode.newssummary.Services;

import io.makingcode.newssummary.Models.SiteInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

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
}
