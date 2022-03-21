package my.javabrains;

import java.io.IOException;

import jakarta.servlet.jsp.*;
import jakarta.servlet.jsp.tagext.*;

public class BasicTagHandler implements Tag {

    private PageContext pc;
    private String myName;
    private int num;

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setParent(Tag t) {
    }

    public void setPageContext(PageContext p) {
        pc = p;
    }

    public void release() {
    }

    public Tag getParent() {
        return null;
    }

    public int doStartTag() {

        try {
            pc.getOut().println("This is a simple tag");
            pc.getOut().println("value of number and name is " + num + " , " + myName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return EVAL_BODY_INCLUDE;

    }

    public int doEndTag() {
        return EVAL_PAGE;
    }
}