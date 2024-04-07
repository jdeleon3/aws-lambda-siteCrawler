package io.makingcode.newssummary.Services;

import io.makingcode.newssummary.Models.SiteInfo;

public class WebSiteContentReader implements ISiteContentReader {
    @Override
    public String getSiteContent(String url) {
        return """
                <html>
                    <head></head>
		            <body><p>This is a test</p></body>
                </html>""";
    }
}
