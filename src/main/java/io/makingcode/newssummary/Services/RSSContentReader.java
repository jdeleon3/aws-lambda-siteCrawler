package io.makingcode.newssummary.Services;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import javax.inject.Inject;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class RSSContentReader {
    @Inject
    public RSSContentReader(){}
    public SyndFeed getFeed(String url) throws IOException, FeedException {
        return new SyndFeedInput().build(new InputSource(URI.create(url).toURL().openStream()));
    }

    public List<String> processRSSFeed(String url) throws IOException, FeedException {

        SyndFeed feed = getFeed(url);
        List<String> links = new ArrayList<>();
        for(SyndEntry entry: feed.getEntries()){
            links.add(entry.getLink());
        }
        return links;
    }
}
