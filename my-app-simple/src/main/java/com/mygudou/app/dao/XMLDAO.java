package com.mygudou.app.dao;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.mygudou.app.model.Law;

public interface XMLDAO {

    public Map<String, Object> getDivorce(InputStream xml) throws Exception;

    public Map<String, Object> getDivorce1(InputStream xml) throws Exception;

    public List<Law> getDivorce2(InputStream xml) throws Exception;

}
