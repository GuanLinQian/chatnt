package club.chatnt.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author lq
 * @since 2020-01-30
 */
public class User implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String loginId;

    private String nickName;

    private String password;

    private String signaTure;

    private String sex;

    private LocalDate birthday;

    private String telephone;

    private String name;

    private String email;

    private String intro;

    private String headPortrait;

    private Integer age;

    private String constellation;

    private String shengXiao;

    private String vocation;

    private Integer nationId;

    private Integer provinceId;

    private Integer cityId;

    private LocalDateTime createTime;

    private Integer isDisable;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSignaTure() {
        return signaTure;
    }

    public void setSignaTure(String signaTure) {
        this.signaTure = signaTure;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public String getShengXiao() {
        return shengXiao;
    }

    public void setShengXiao(String shengXiao) {
        this.shengXiao = shengXiao;
    }

    public String getVocation() {
        return vocation;
    }

    public void setVocation(String vocation) {
        this.vocation = vocation;
    }

    public Integer getNationId() {
        return nationId;
    }

    public void setNationId(Integer nationId) {
        this.nationId = nationId;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getIsDisable() {
        return isDisable;
    }

    public void setIsDisable(Integer isDisable) {
        this.isDisable = isDisable;
    }

    @Override
    public String toString() {
        return "User{" +
        "id=" + id +
        ", loginId=" + loginId +
        ", nickName=" + nickName +
        ", password=" + password +
        ", signaTure=" + signaTure +
        ", sex=" + sex +
        ", birthday=" + birthday +
        ", telephone=" + telephone +
        ", name=" + name +
        ", email=" + email +
        ", intro=" + intro +
        ", headPortrait=" + headPortrait +
        ", age=" + age +
        ", constellation=" + constellation +
        ", shengXiao=" + shengXiao +
        ", vocation=" + vocation +
        ", nationId=" + nationId +
        ", provinceId=" + provinceId +
        ", cityId=" + cityId +
        ", createTime=" + createTime +
        ", isDisable=" + isDisable +
        "}";
    }
}
