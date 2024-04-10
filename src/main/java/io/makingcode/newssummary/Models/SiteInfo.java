package io.makingcode.newssummary.Models;

import java.util.Arrays;
import java.util.List;

public class SiteInfo {
    private String url;
    private List<String> embeddedUrls;
    private List<String> keywords;
    private String summary;
    private String siteContent;
    private Boolean isProcessed;

    public SiteInfo(String url) {
        this.url = url;
    }

    public SiteInfo() {
    }

    @Override
    public String toString() {
        return "SiteInfo{" +
                "url='" + url + '\'' +
                ", embeddedUrls=" + embeddedUrls +
                ", keywords=" + keywords +
                ", summary='" + summary + '\'' +
                ", siteContent='" + siteContent + '\'' +
                ", isProcessed=" + isProcessed +
                '}';
    }

    public List<String> getEmbeddedUrls() {
        return embeddedUrls;
    }

    public void setEmbeddedUrls(List<String> embeddedUrls) {
        this.embeddedUrls = embeddedUrls;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Boolean getProcessed() {
        return isProcessed;
    }

    public void setProcessed(Boolean processed) {
        isProcessed = processed;
    }

    public String getSiteContent() {
        return siteContent;
    }

    public void setSiteContent(String siteContent) {
        this.siteContent = siteContent;
    }
}
