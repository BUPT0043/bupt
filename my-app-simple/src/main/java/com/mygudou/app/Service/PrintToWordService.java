package com.mygudou.app.Service;

import java.awt.Color;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.rtf.RtfWriter2;

/**
 * WordPrint:itext 设置格式
 */
@Service("PrintToWordService")
@Transactional
public class PrintToWordService {
    public void toWord(@RequestParam("param") String param,
            HttpServletRequest request, HttpServletResponse response) {
        Document document = new Document(PageSize.A4);
        String ctxPath = request.getSession().getServletContext()
                .getRealPath("/")
                + "download/";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
        String name = sdf.format(new Date());
        try {
            RtfWriter2.getInstance(document, new FileOutputStream(ctxPath
                    + name + ".doc"));
            document.open();
            Font font = new Font(Font.NORMAL, 20, Font.BOLD, new Color(0, 0, 0));
            Paragraph p = new Paragraph("合同", font);
            p.setAlignment(1);
            document.add(p);
            /**
             * <p>
             * 标记，切割 st[0]input st[1]input context st[2]input over
             */
            String[] sa = param.trim().split(",");
            for (String str: sa) {
                System.out.println("str   " + str);
                if (!"".equals(str)) {
                    String st[] = str.split("⋚");
                    Chunk c0 = new Chunk(st[0]);
                    Paragraph para = new Paragraph();
                    para.add(c0);
                    for (int i = 1; i < st.length; i++) {
                        Font f = new Font(Font.UNDERLINE);
                        Chunk c = new Chunk(st[i]);
                        if (i % 2 == 1) {
                            c.setFont(FontFactory.getFont(FontFactory.TIMES,
                                    11, Font.UNDERLINE));
                        }
                        para.add(c);
                    }
                    para.setIndentationLeft(20);
                    para.setFirstLineIndent(5f);
                    para.setSpacingAfter(-5f);
                    para.setSpacingBefore(-5f);
                    document.add(para);
                }
            }
            Font font1 = new Font(Font.NORMAL, 13, Font.BOLD,
                    new Color(0, 0, 0));
            Paragraph para1 = new Paragraph("甲方：", font1);
            Paragraph para2 = new Paragraph("乙方：", font1);
            Paragraph para3 = new Paragraph("日期：", font1);

            para1.setIndentationLeft(20);
            para2.setIndentationLeft(20);
            para3.setIndentationLeft(20);

            para1.setSpacingBefore(5f);
            para2.setSpacingBefore(5f);
            para3.setSpacingBefore(5f);

            para1.setAlignment(3);
            para2.setAlignment(3);
            para3.setAlignment(3);
            document.add(para1);
            document.add(para2);
            document.add(para3);
            document.close();

        } catch (com.lowagie.text.DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String fileName = name + ".doc";
        try {
            response.setCharacterEncoding("utf-8");
            PrintWriter print = response.getWriter();
            print.print(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
