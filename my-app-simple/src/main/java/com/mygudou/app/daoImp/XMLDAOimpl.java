package com.mygudou.app.daoImp;

import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import com.mygudou.app.dao.XMLDAO;
import com.mygudou.app.model.Category;
import com.mygudou.app.model.Item;
import com.mygudou.app.model.Law;

@Repository("XMLDAO")
public class XMLDAOimpl implements XMLDAO {

    public Map<String, Object> getDivorce(InputStream xml) throws Exception {

        Map<String, Object> map = new HashMap<String, Object>();
        List<Item> lst = null;
        List<String> lst3 = null;// lst3-categoryName
        Item it = null;
        XmlPullParserFactory pullParserFactory = XmlPullParserFactory
                .newInstance();
        XmlPullParser pullParser = pullParserFactory.newPullParser();
        pullParser.setInput(xml, "UTF-8");
        int event = pullParser.getEventType();// 调用方法，产生q事件
        String str = "";
        String strData = "";

        while (event != XmlPullParser.END_DOCUMENT) {

            String nodeName = pullParser.getName();
            switch (event) {
                case XmlPullParser.START_DOCUMENT:// 文档开始
                    lst = new LinkedList<Item>();
                    lst3 = new LinkedList<String>();
                    break;
                case XmlPullParser.START_TAG:

                    if ("Category".equals(nodeName)) {
                        String categoryName = pullParser.nextText();
                        lst3.add(categoryName);
                    }

                    if ("Data".equals(nodeName)) {
                        if (it == null) {
                            it = new Item();
                        }
                        strData += "" + pullParser.nextText() + "<br/>";
                        it.setData(strData);

                    }
                    if ("p".equals(nodeName)) {
                        str += pullParser.nextText() + "<br/>"; // 换行
                        it.setRefer(str);
                    }
                    break;
                case XmlPullParser.END_TAG:
                    if ("Item".equals(nodeName)) {
                        it.setRefer(str);
                        lst.add(it);
                        it = null;
                        str = "";
                        strData = "";
                    }
                    break;
            }
            event = pullParser.next();
        }
        map.put("item", lst);
        map.put("categoryName", lst3);
        return map;
    }

    public Map<String, Object> getDivorce1(InputStream xml) throws Exception {
        Map<String, Object> map = (Map<String, Object>) new HashMap<String, Object>();// 给后边Imple传值
        List<Category> lst1 = null;
        Category ca = null;
        XmlPullParserFactory pullParserFactory = XmlPullParserFactory
                .newInstance();
        XmlPullParser pullParser = pullParserFactory.newPullParser();
        pullParser.setInput(xml, "UTF-8");
        int event1 = pullParser.getEventType();// 调用方法，产生q事件
        String str = "";

        while (event1 != XmlPullParser.END_DOCUMENT) {

            String nodeName = pullParser.getName();
            switch (event1) {
                case XmlPullParser.START_DOCUMENT:// 文档开始
                    lst1 = new LinkedList<Category>();
                    break;
                case XmlPullParser.START_TAG:
                    if ("LawName".equals(nodeName)) {
                        String lawName = pullParser.nextText();
                        map.put("lawName", lawName);
                    }

                    if ("Category".equals(nodeName)) {
                        ca = new Category();
                        String name = pullParser.nextText();
                        ca.setCategoryname(name);
                    }
                case XmlPullParser.END_TAG:
                    if ("Category".equals(nodeName)) {
                        lst1.add(ca);
                        ca = null;
                    }
                    break;
            }
            event1 = pullParser.next();
        }
        map.put("category", lst1);
        return map;// 放到map里
    }

    public List<Law> getDivorce2(InputStream xml) throws Exception {

        List<Law> lst2 = null;
        Law la = null;
        XmlPullParserFactory pullParserFactory = XmlPullParserFactory
                .newInstance();
        XmlPullParser pullParser = pullParserFactory.newPullParser();
        pullParser.setInput(xml, "UTF-8");
        int event1 = pullParser.getEventType();
        String str = "";

        while (event1 != XmlPullParser.END_DOCUMENT) {

            String nodeName = pullParser.getName();
            switch (event1) {
                case XmlPullParser.START_DOCUMENT:// 文档开始
                    lst2 = new LinkedList<Law>();
                    break;
                case XmlPullParser.START_TAG:
                    if ("LawName".equals(nodeName)) {
                        la = new Law();
                        String name = pullParser.nextText();
                        la.setName(name);
                    }

                case XmlPullParser.END_TAG:
                    if ("LawName".equals(nodeName)) {
                        lst2.add(la);
                        la = null;
                    }
                    break;
            }
            event1 = pullParser.next();
        }
        return lst2;

    }

}
