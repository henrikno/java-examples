package com.example;

import com.yammer.metrics.Metrics;
import com.yammer.metrics.core.Meter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HelloWorldServlet extends HttpServlet {

    private final Meter requests = Metrics.newMeter(HelloWorldServlet.class, "requests", "requests", TimeUnit.SECONDS);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        requests.mark();
        response.getWriter().write("Hello World!");
    }
}
