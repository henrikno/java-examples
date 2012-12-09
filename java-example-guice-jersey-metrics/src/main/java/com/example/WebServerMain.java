package com.example;

import com.example.module.GuiceConfig;
import com.example.servlet.EmptyServlet;
import com.google.inject.servlet.GuiceFilter;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class WebServerMain {

    public static void main(String[] args) throws Exception {

        Server server = new Server(8080);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addEventListener(new GuiceConfig());
        context.addFilter(GuiceFilter.class, "/*", null);
        context.setContextPath("/");
        server.setHandler(context);
        // Jetty wants at least one servlet to start.
        context.addServlet(EmptyServlet.class, "/");

        server.start();
        server.join();
    }
}

