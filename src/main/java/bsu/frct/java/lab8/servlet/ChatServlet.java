package bsu.frct.java.lab8.servlet;

import bsu.frct.java.lab8.entity.ChatMessage;
import bsu.frct.java.lab8.entity.ChatUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.HashMap;

public class ChatServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    protected HashMap<String, ChatUser> activeUsers;
    protected ArrayList<ChatMessage> messages;

    @Override
    public void init() throws ServletException {
        super.init();

        activeUsers = (HashMap<String, ChatUser>) getServletContext().getAttribute("activeUsers");
        messages = (ArrayList<ChatMessage>) getServletContext().getAttribute("messages");

        if (activeUsers == null) {
            activeUsers = new HashMap<>();
            getServletContext().setAttribute("activeUsers", activeUsers);
        }
        if (messages == null) {
            messages = new ArrayList<>(100);
            getServletContext().setAttribute("messages", messages);
        }

    }

}
