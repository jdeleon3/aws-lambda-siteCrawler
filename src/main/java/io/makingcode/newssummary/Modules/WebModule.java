package io.makingcode.newssummary.Modules;

import dagger.Module;
import dagger.Provides;
import io.makingcode.newssummary.Services.RSSContentReader;
import io.makingcode.newssummary.Services.WebSiteContentReader;

import javax.inject.Inject;
import javax.inject.Singleton;

@Module
public class WebModule {

    @Inject
    public WebModule(){}

    @Provides
    @Singleton
    public WebSiteContentReader createWebSiteContentReader()
    {
        return new WebSiteContentReader();
    }

    @Provides
    @Singleton
    public RSSContentReader createRSSContentReader(){return new RSSContentReader();}
}
