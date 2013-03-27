package eu.emi.emir.ui.guice;

import static java.util.Arrays.asList;
import static java.util.regex.Pattern.compile;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceFilter;

import eu.emi.emir.ui.thread.TaskStarter;

public class BaseFilter extends GuiceFilter {

  private static Injector INJECTOR;

  public static final Pattern URI_ADMIN_PATTERN = compile("/_ah/.*");

  public static final Set<String> URI_NOADMIN_SET = new HashSet<String>(asList("/_ah/warmup"));

  public static Injector getInjector() {
    return INJECTOR;
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    if (INJECTOR != null) {
      throw new ServletException("Injector already created?!");
    }
    INJECTOR = Guice.createInjector(new BaseModule(), new ApplicationModule(), new ViewModule());
    filterConfig.getServletContext().log("Created injector with " + INJECTOR.getAllBindings().size() + " bindings.");
    
    super.init(filterConfig);
//TODO
//    TaskStarter starter = new TaskStarter();
//    starter.run();
  }
  

}