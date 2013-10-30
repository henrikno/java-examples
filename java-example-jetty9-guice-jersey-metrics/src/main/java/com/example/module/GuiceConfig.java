package com.example.module;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import com.yammer.metrics.guice.InstrumentationModule;
import com.yammer.metrics.jersey.InstrumentedResourceMethodDispatchAdapter;
import com.yammer.metrics.reporting.MetricsServlet;
import com.yammer.metrics.reporting.PingServlet;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

public class GuiceConfig extends GuiceServletContextListener {
    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new MyJerseyServletModule());
    }

    private static class MyJerseyServletModule extends JerseyServletModule {
        @Override
        protected void configureServlets() {
            install(new ExampleModule());
            install(new InstrumentationModule());
            install(new MyServletModule());
        }
    }

    private static class MyServletModule extends ServletModule {
        @Override
        protected void configureServlets() {
            // Bind metrics' resources
            bind(InstrumentedResourceMethodDispatchAdapter.class).in(Singleton.class);
            bind(PingServlet.class).in(Singleton.class);
            bind(MetricsServlet.class).in(Singleton.class);

            serve("/ping").with(PingServlet.class);
            serve("/metrics").with(MetricsServlet.class);

            // Set init params for Jersey
            Map<String, String> params = new HashMap<String, String>();
            params.put("com.sun.jersey.api.json.POJOMappingFeature", "true");
            // optional
            //params.put("com.sun.jersey.config.property.packages", "com.example.resource");
            //params.put("com.sun.jersey.config.feature.Trace", "true");

            // Route all requests through GuiceContainer
            serve("/*").with(GuiceContainer.class, params);
        }
    }
}
