package by.it.sgolovach.jd03_04.java;

import javax.servlet.http.HttpServletRequest;

public class CmdLogout implements ActionComand {
    @Override
    public String execute(HttpServletRequest reg) throws Exception {
        return Action.LOGOUT.jsp;
    }
}
