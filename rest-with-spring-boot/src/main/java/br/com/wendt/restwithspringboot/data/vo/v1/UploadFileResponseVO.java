package br.com.wendt.restwithspringboot.data.vo.v1;

import java.io.Serializable;

public class UploadFileResponseVO implements Serializable {

    private static final long serialVersionUID = -6177629062943013602L;

    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;

    public UploadFileResponseVO() {
    }

    public UploadFileResponseVO(final String fileName, final String fileDownloadUri, final String fileType, final long size) {
        this.fileName = fileName;
        this.fileDownloadUri = fileDownloadUri;
        this.fileType = fileType;
        this.size = size;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(final String fileName) {
        this.fileName = fileName;
    }

    public String getFileDownloadUri() {
        return fileDownloadUri;
    }

    public void setFileDownloadUri(final String fileDownloadUri) {
        this.fileDownloadUri = fileDownloadUri;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(final String fileType) {
        this.fileType = fileType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(final long size) {
        this.size = size;
    }

}
