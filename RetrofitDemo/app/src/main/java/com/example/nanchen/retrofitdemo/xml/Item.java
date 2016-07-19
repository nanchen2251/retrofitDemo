package com.example.nanchen.retrofitdemo.xml;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by 南尘 on 16-7-18.
 */
@Root(strict = false)
public class Item {
    @Element(name = "title")
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
