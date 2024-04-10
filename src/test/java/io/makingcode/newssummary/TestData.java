package io.makingcode.newssummary;

import com.rometools.rome.feed.WireFeed;
import com.rometools.rome.feed.synd.*;

import java.util.ArrayList;
import java.util.List;

public class TestData {

    public static SyndFeed getRSSFeed(){
        SyndFeed feed = new SyndFeedImpl();
        List<SyndEntry> entries = new ArrayList<>();
        feed.setTitle("The Fakest Wowhead Site Ever");
        feed.setFeedType("rss_2.0");

        for(int i=0; i < 2; ++i){
            SyndEntry entry = new SyndEntryImpl();
            entry.setTitle("Article " + i);
            SyndContent description = new SyndContentImpl();
            description.setType("text/plain");
            description.setValue("This is Article " + i);
            entry.setDescription(description);
            entry.setLink("https://fakewowhead.com/articles/" + i);
            entries.add(entry);
        }
        feed.setEntries(entries);
        return feed;
        }


    public static String webContent = """
            <html>
            		<head><link rel="alternate" type="application/rss+xml" title="The Fakest Wowhead Site Ever feed" href="https://fakewowhead.com/feed/" /></head>
            		<body><p>This is a test</p></body>
            </html>
            """;
}
