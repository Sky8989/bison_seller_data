package com.sellerdata.pojo;

import javax.persistence.*;
import java.util.Objects;

/**
 * @ClassName AmzAsin
 * @Description TODO
 * @Author Lee
 * @Date 19-6-28 下午4:03
 * @Version 1.0
 **/
@Entity
@Table(name = "module_excute_status", schema = "bison")
public class ModuleExcuteStatus {
    private int excuteStatusId;
    private String excuteStatus;
    private String statusComment;

    public ModuleExcuteStatus(){

    }


    @Id
    @Column(name = "excute_status_id", nullable = false)
    public int getExcuteStatusId() {
        return excuteStatusId;
    }

    public void setExcuteStatusId(int excuteStatusId) {
        this.excuteStatusId = excuteStatusId;
    }

    @Basic
    @Column(name = "excute_status")
    public String getExcuteStatus() {
        return excuteStatus;
    }

    public void setExcuteStatus(String excuteStatus) {
        this.excuteStatus = excuteStatus;
    }

    @Basic
    @Column(name = "status_comment")
    public String getStatusComment() {
        return statusComment;
    }

    public void setStatusComment(String statusComment) {
        this.statusComment = statusComment;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ModuleExcuteStatus{");
        sb.append("excuteStatusId=").append(excuteStatusId);
        sb.append(", excuteStatus='").append(excuteStatus).append('\'');
        sb.append(", statusComment=").append(statusComment);
        sb.append('}');
        return sb.toString();
    }
}
