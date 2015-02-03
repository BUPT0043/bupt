package com.mygudou.app.Service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 生成Download链接
 */
@Service("DownloadService")
@Transactional
public class DownloadService {
    public void download(@RequestParam("fileName") String fileName,
            HttpServletRequest request, HttpServletResponse response) {
        String ctxPath = request.getSession().getServletContext()
                .getRealPath("/")
                + "download/";
        File downloadFile = new File(ctxPath + fileName);
        response.addHeader("Content-Disposition", "attachment;filename="
                + fileName);
        response.addHeader("Content-Length", "" + downloadFile.length());
        response.setContentType("application/msword");// application/msword-->下载为word
        response.setCharacterEncoding("utf-8");
        InputStream fis = null;
        OutputStream os = null;
        try {
            fis = new BufferedInputStream(new FileInputStream(downloadFile));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            os = new BufferedOutputStream(response.getOutputStream());
            os.write(buffer);// 输出文件
            os.flush();

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    fis = null;
                }
            }

            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    os = null;
                }
            }

        }
    }
}
