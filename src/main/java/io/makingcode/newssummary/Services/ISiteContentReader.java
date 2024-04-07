package io.makingcode.newssummary.Services;

import io.makingcode.newssummary.Models.SiteInfo;

public interface ISiteContentReader {
    String getSiteContent(String url);
}
