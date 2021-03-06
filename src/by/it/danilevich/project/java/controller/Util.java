package by.it.danilevich.project.java.controller;

import by.it.danilevich.project.java.beans.UserBean;
import by.it.danilevich.project.java.dao.connect.CN;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Util {
    static UserBean getUserFromSession(HttpServletRequest req) {
        HttpSession session = req.getSession();
        Object objUser = session.getAttribute("user");
        if (objUser != null) {
            return (UserBean) objUser;
        }
        return null;
    }

    public static long getCurrentDate() {
        Date date = new Date();
        return date.getTime();

    }
}
