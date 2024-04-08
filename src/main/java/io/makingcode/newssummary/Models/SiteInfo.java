package io.makingcode.newssummary.Models;

import java.util.Arrays;

public class SiteInfo {
    private String url;
    private String[] embeddedUrls;
    private String[] keywords;
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
                ", embeddedUrls=" + Arrays.toString(embeddedUrls) +
                ", keywords=" + Arrays.toString(keywords) +
                ", summary='" + summary + '\'' +
                ", siteContent='" + siteContent + '\'' +
                ", isProcessed=" + isProcessed +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String[] getEmbeddedUrls() {
        return embeddedUrls;
    }

    public void setEmbeddedUrls(String[] embeddedUrls) {
        this.embeddedUrls = embeddedUrls;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public void setKeywords(String[] keywords) {
        this.keywords = keywords;
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
