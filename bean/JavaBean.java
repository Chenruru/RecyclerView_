package test.bwie.com.recyclerview_.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/5/12 0012.
 */

public class JavaBean implements Serializable{
    private String title;
    private boolean check;

    public JavaBean(String title, boolean check) {
        this.title = title;
        this.check = check;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
