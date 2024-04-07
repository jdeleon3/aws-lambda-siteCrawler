package io.makingcode.newssummary;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import io.makingcode.newssummary.Models.SiteInfo;
import io.makingcode.newssummary.Services.ISiteContentReader;
import io.makingcode.newssummary.Services.WebSiteContentReader;

import java.util.Map;

/**
 * Hello world!
 *
 */
public class SiteCrawler implements RequestHandler<String, SiteInfo>
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    @Override
    public SiteInfo handleRequest(String input, Context context) {
        SiteInfo info;
        info = ProcessRequest(input);
        return info;
    }
    public SiteInfo ProcessRequest(String url){
        ISiteContentReader siteContentReader = new WebSiteContentReader();
        SiteInfo info = new SiteInfo();
        info.setUrl(url);
        info.setSummary(siteContentReader.getSiteContent(url));
        return info;
    }

}
