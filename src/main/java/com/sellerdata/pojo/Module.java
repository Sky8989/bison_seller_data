package com.sellerdata.pojo;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @ClassName Module
 * @Description TODO
 * @Author Lee
 * @Date 19-6-28 下午4:03
 * @Version 1.0
 **/
@Entity
@Table(name = "module", schema = "bison")
public class Module {

    private int moduleId;

    private String moduleName;

    private String moduleUrlPath;

    private Timestamp utime;

    private Timestamp ctime;

    private int moduleType;

    private String modulePort;

    private String defaultSetting;

    public  Module(){

    }


    @Id
    @Column(name = "module_id", nullable = false)
    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    @Basic
    @Column(name = "module_name")
    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    @Basic
    @Column(name = "module_url_path")
    public String getModuleUrlPath() {
        return moduleUrlPath;
    }

    public void setModuleUrlPath(String moduleUrlPath) {
        this.moduleUrlPath = moduleUrlPath;
    }

    @Basic
    @Column(name = "module_type")
    public int getModuleType() {
        return moduleType;
    }

    public void setModuleType(int moduleType) {
        this.moduleType = moduleType;
    }

    @Basic
    @Column(name = "module_port")
    public String getModulePort() {
        return modulePort;
    }

    public void setModulePort(String modulePort) {
        this.modulePort = modulePort;
    }

    @Basic
    @Column(name = "default_setting")
    public String getDefaultSetting() {
        return defaultSetting;
    }

    public void setDefaultSetting(String defaultSetting) {
        this.defaultSetting = defaultSetting;
    }

    @Basic
    @Column(name = "utime")
    public Timestamp getUtime() {
        return utime;
    }

    public void setUtime(Timestamp utime) {
        this.utime = utime;
    }


    @Basic
    @Column(name = "ctime")
    public Timestamp getCtime() {
        return ctime;
    }

    public void setCtime(Timestamp ctime) {
        this.ctime = ctime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Module{");
        sb.append("moduleId=").append(moduleId);
        sb.append(", moduleName='").append(moduleName).append('\'');
        sb.append(", moduleUrlPath='").append(moduleUrlPath).append('\'');
        sb.append(", utime=").append(utime);
        sb.append(", ctime=").append(ctime);
        sb.append(", moduleType=").append(moduleType);
        sb.append(", modulePort='").append(modulePort).append('\'');
        sb.append(", defaultSetting='").append(defaultSetting).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
