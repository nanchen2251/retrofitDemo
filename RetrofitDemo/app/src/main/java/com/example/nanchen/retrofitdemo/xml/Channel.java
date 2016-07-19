package com.example.nanchen.retrofitdemo.xml;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by 南尘 on 16-7-18.
 */
@Root(strict = false)//因为没有解析全，所以必须加上Root，默认为true,没有完全解析必须指定为false
public class Channel {
    @Path("channel")
    @Element(name = "title")
    private String title;

    @Path("channel")
    @ElementList(entry = "item",inline = true)
    private List<Item> list;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Item> getList() {
        return list;
    }

    public void setList(List<Item> list) {
        this.list = list;
    }
}
