package com.example;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("hello")
public class Properties {

    private String suffix;
    private String prefix;

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Properties() {
        prefix="hello from service preff";
        suffix="hello from service suff";
    }

    public Properties(String suffix, String prefix) {
        this.suffix = suffix;
        this.prefix = prefix;
    }
}
