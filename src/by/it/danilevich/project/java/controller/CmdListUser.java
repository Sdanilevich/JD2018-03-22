package by.it.danilevich.project.java.controller;

import by.it.danilevich.project.java.beans.RoleBean;
import by.it.danilevich.project.java.beans.UserBean;
import by.it.danilevich.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdListUser extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        Dao dao=Dao.getInstance();
        List<UserBean> listOrder= dao.userDao.getAll("");
        List<RoleBean> listRole = dao.roleDao.getAll("");
        req.getSession().setAttribute("listUser",listOrder);
        req.getSession().setAttribute("listRole",listRole);
        return null;
    }
}
