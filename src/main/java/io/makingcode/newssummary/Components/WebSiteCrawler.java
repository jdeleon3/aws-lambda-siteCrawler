package io.makingcode.newssummary.Components;

import dagger.Component;
import io.makingcode.newssummary.Modules.WebModule;

@Component(modules = {WebModule.class})
public interface WebSiteCrawler {
    WebModule buildWeb();

}
