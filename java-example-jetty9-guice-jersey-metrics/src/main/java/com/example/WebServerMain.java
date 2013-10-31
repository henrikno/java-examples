package com.example;

import com.example.module.GuiceConfig;
import com.google.inject.servlet.GuiceFilter;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebServerMain {
    private static final Logger logger = LoggerFactory.getLogger(WebServerMain.class);

    public static void main(String[] args) throws Exception {

        Server server = new Server(getPort());

        ServletContextHandler context = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS);

        context.addEventListener(new GuiceConfig());
        context.addFilter(GuiceFilter.class, "/*", null);

        context.addServlet(DefaultServlet.class, "/*");
        // Optional: configure DefaultServlet for static content
        //context.setResourceBase("src/main/webapp");
        //context.setWelcomeFiles(new String[]{"index.html"});

        server.start();
        logger.info("Server started");
        server.join();
    }

    private static int getPort() {
        String port = System.getenv("PORT") == null ? "8081" : System.getenv("PORT");
        return Integer.parseInt(port);
    }
}

