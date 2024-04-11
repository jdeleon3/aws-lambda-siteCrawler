package io.makingcode.newssummary;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2HTTPEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2HTTPResponse;
import com.google.gson.Gson;
import com.rometools.rome.io.FeedException;
import io.makingcode.newssummary.Components.DaggerWebSiteCrawler;
import io.makingcode.newssummary.Components.WebSiteCrawler;
import io.makingcode.newssummary.Models.CrawlRequest;
import io.makingcode.newssummary.Models.SiteInfo;
import io.makingcode.newssummary.Modules.WebModule;
import org.apache.logging.log4j.core.util.JsonUtils;

import javax.inject.Inject;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

public class Handler implements RequestHandler<APIGatewayV2HTTPEvent, APIGatewayV2HTTPResponse> {

    public WebSiteCrawler crawler;

    public Handler(){
        this.crawler = DaggerWebSiteCrawler.create();
    }

    //public WebSiteCrawler crawler;
    @Override
    public APIGatewayV2HTTPResponse handleRequest(APIGatewayV2HTTPEvent event, Context context) {
        APIGatewayV2HTTPResponse response = new APIGatewayV2HTTPResponse();
        HashMap<String,String> responseHeaders = new HashMap<>();
        responseHeaders.put("Content-Type", "application/json");
        response.setIsBase64Encoded(false);
        Gson g = new Gson();
        try {
            CrawlRequest request = g.fromJson(event.getBody(), CrawlRequest.class);
            SiteInfo info = ProcessRequest(request.getUrl());
            response.setStatusCode(200);
            response.setBody(g.toJson(info));
        }
        catch (Exception e){
            response.setStatusCode(500);
            response.setBody("{\"error\": \"" + e.getMessage() + "\"}");
        }
        response.setHeaders(responseHeaders);
        return response;
    }

    public SiteInfo ProcessRequest(String url) throws FeedException, IOException, URISyntaxException {
        URI uri = URI.create(url);
        SiteInfo info = new SiteInfo();
        WebModule web = crawler.buildWeb();//.createWebSiteContentReader().getSiteContent(url)
        info.setUrl(url);
        info.setSiteContent(web.createWebSiteContentReader().getSiteContent(uri.toString()));
        String rssUrl;
        if(uri.getHost().contains("reddit.com")){
            rssUrl = uri.toString() + ".rss";
        }
        else{
            rssUrl = web.createWebSiteContentReader().findRSSFeedUrls(info.getSiteContent());
        }

        if(rssUrl != null && !rssUrl.isBlank()){
            if(!rssUrl.contains("http")){
                rssUrl = new URI(uri.getScheme(),uri.getHost(),rssUrl,null).toString();
            }
            List<String> links = web.createRSSContentReader().processRSSFeed(rssUrl);
            info.setEmbeddedUrls(links);
        }
        return info;
    }
}
