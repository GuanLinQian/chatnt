package club.chatnt.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lq
 * @since 2020-01-30
 */
public class Mail implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String msubject;

    private String mto;

    private String mfrom;

    private String mcontent;

    private String mfilePath;

    private LocalDateTime mcreateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMsubject() {
        return msubject;
    }

    public void setMsubject(String msubject) {
        this.msubject = msubject;
    }

    public String getMto() {
        return mto;
    }

    public void setMto(String mto) {
        this.mto = mto;
    }

    public String getMfrom() {
        return mfrom;
    }

    public void setMfrom(String mfrom) {
        this.mfrom = mfrom;
    }

    public String getMcontent() {
        return mcontent;
    }

    public void setMcontent(String mcontent) {
        this.mcontent = mcontent;
    }

    public String getMfilePath() {
        return mfilePath;
    }

    public void setMfilePath(String mfilePath) {
        this.mfilePath = mfilePath;
    }

    public LocalDateTime getMcreateTime() {
        return mcreateTime;
    }

    public void setMcreateTime(LocalDateTime mcreateTime) {
        this.mcreateTime = mcreateTime;
    }

    @Override
    public String toString() {
        return "Mail{" +
        "id=" + id +
        ", msubject=" + msubject +
        ", mto=" + mto +
        ", mfrom=" + mfrom +
        ", mcontent=" + mcontent +
        ", mfilePath=" + mfilePath +
        ", mcreateTime=" + mcreateTime +
        "}";
    }
}
