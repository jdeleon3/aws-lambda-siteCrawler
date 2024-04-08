package io.makingcode.newssummary.Modules;

import dagger.Module;
import dagger.Provides;
import io.makingcode.newssummary.Services.WebSiteContentReader;

import javax.inject.Inject;

@Module
public class WebModule {

    @Inject
    public WebModule(){}

    @Provides
    public WebSiteContentReader createWebSiteContentReader()
    {
        return new WebSiteContentReader();
    }
}
