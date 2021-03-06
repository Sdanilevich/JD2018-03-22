package by.it.sgolovach.project.java.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {
    private ActionFactory actionFactory;

    @Override
    public void init() throws ServletException {
        actionFactory = new ActionFactory();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setHeader("Cache-control","no-store");
        CmdAbstract cmd = actionFactory.defineCmd(req);
        String viewPage;
        try {
            cmd.execute(req);
            viewPage = cmd.getJsp();
        } catch (Exception e) {
            viewPage = Action.ERROR.comand.getJsp();
        }
        getServletContext().getRequestDispatcher(viewPage).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setHeader("Cache-control","no-store");
        CmdAbstract cmd = actionFactory.defineCmd(req);
        String viewPage = Action.ERROR.comand.getJsp();
        try {
            CmdAbstract next = cmd.execute(req);
            if (next == null) {
                viewPage = cmd.getJsp();
                getServletContext().getRequestDispatcher(viewPage).forward(req, resp);
            } else {
                resp.sendRedirect("do?command="+next.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
