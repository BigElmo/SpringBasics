package com.bigelmo.controllers;

import com.bigelmo.data.Task;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@WebServlet(name = "Task", value = "/Task")
public class TaskController extends HttpServlet {
    private transient ServletConfig config;
    private ConcurrentMap<Integer, Task> tasks;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
        this.tasks = new ConcurrentHashMap<>();
        for (int i = 1; i < 100; i++) {
            tasks.put(i, new Task(i, "Task-" + i, "Description-" + i, 0, (int) (Math.random() * 10)));
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().print(this.tasks);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public ServletConfig getConfig() {
        return config;
    }

    public void setConfig(ServletConfig config) {
        this.config = config;
    }
}
