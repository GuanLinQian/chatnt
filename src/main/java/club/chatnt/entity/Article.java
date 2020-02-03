package club.chatnt.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
public class Article implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String content;

    private String code;

    private LocalDateTime createTime;

    private Integer userId;

    private String title;

    private Integer isScreen;
@TableField(exist = false)
    private  User u;
@TableField(exist = false)
   private  Integer count=0;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getIsScreen() {
        return isScreen;
    }

    public void setIsScreen(Integer isScreen) {
        this.isScreen = isScreen;
    }

    @Override
    public String toString() {
        return "Article{" +
        "id=" + id +
        ", content=" + content +
        ", code=" + code +
        ", createTime=" + createTime +
        ", userId=" + userId +
        ", title=" + title +
        ", isScreen=" + isScreen +
        "}";
    }
}
