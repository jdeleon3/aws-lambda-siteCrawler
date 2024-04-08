package io.makingcode.newssummary;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import io.makingcode.newssummary.Components.DaggerWebSiteCrawler;
import io.makingcode.newssummary.Components.WebSiteCrawler;
import io.makingcode.newssummary.Models.CrawlRequest;
import io.makingcode.newssummary.Models.SiteInfo;
import io.makingcode.newssummary.Modules.WebModule;

import javax.inject.Inject;

public class Handler implements RequestHandler<CrawlRequest, SiteInfo> {

    public WebSiteCrawler crawler;

    public Handler(){
        this.crawler = DaggerWebSiteCrawler.create();
    }
    //public WebSiteCrawler crawler;
    @Override
    public SiteInfo handleRequest(CrawlRequest request, Context context) {
        SiteInfo info = ProcessRequest(request.getUrl());
        return info;
    }

    public SiteInfo ProcessRequest(String url) {

        SiteInfo info = new SiteInfo();
        WebModule web = crawler.buildWeb();//.createWebSiteContentReader().getSiteContent(url)
        info.setUrl(url);
        info.setSiteContent(web.createWebSiteContentReader().getSiteContent(url));
        return info;
    }
}
