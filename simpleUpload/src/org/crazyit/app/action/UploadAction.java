package org.crazyit.app.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class UploadAction extends ActionSupport {
    //��װ�ļ�������������ĳ�Ա����
    private String title;
    //��װ�ϴ��ļ���ĳ�Ա����
    private File upload;
    //��װ�ϴ��ļ����͵ĳ�Ա����
    private String uploadContentType;
    //��װ�ϴ��ļ���������
    private String uploadFileName;
    //ֱ����struts.xml�ļ������õĳ�Ա����
    private String savePath;
    //����struts.xml�ļ�����ֵ�ķ���
    public void setSavePath(String value) {
        this.savePath = value;
    }
    //��ȡ�ϴ��ļ��ı���λ��
    private String getSavePath() throws Exception {
        return ServletActionContext.getServletContext()
                .getRealPath(savePath);
    }
    //title��setter��getter����
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return (this.title);
    }
    public void setUpload(File upload){
        this.upload = upload;
    }
    public File getUpload() {
        return (this.upload);
    }
    //uploadContentType��setter��getter����
    public void setUploadContentType(String uploadContentType){
        this.uploadContentType = uploadContentType;
    }
    public void setUploadFileName(String uploadFileName){
        this.uploadFileName = uploadFileName;
    }
    public String getUploadFileName() {
        return (this.uploadFileName);
    }
    @Override
    public String execute() throws Exception {
        //�Է��������ļ������ַ��ԭ�ļ��������ϴ��ļ������
        FileOutputStream fos = new FileOutputStream(getSavePath());
        FileInputStream fis = new FileInputStream(getUpload());
        byte[] buffer = new byte[1024];
        int len = 0;
        while((len = fis.read(buffer)) > 0) {
            fos.write(buffer, 0, len);
        }
        return SUCCESS;
    }
}
