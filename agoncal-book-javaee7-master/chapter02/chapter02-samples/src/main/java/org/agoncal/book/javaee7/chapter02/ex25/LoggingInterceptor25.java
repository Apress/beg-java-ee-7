package org.agoncal.book.javaee7.chapter02.ex25;

import javax.inject.Inject;
import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class LoggingInterceptor25 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  private Logger logger;

  // ======================================
  // =           Public Methods           =
  // ======================================

  @AroundConstruct
  private void init(InvocationContext ic) throws Exception {
    logger.fine("Entering constructor");
    logger.severe("Entering constructor");
    try {
      ic.proceed();
    } finally {
      logger.severe("Exiting constructor");
      logger.fine("Exiting constructor");
    }
  }

  @AroundInvoke
  public Object logMethod(InvocationContext ic) throws Exception {
    logger.entering(ic.getTarget().toString(), ic.getMethod().getName());
    logger.severe(">>>" + ic.getTarget().toString() + " - " + ic.getMethod().getName());
    try {
      return ic.proceed();
    } finally {
      logger.severe("<<<" + ic.getTarget().toString() + " - " + ic.getMethod().getName());
      logger.exiting(ic.getTarget().toString(), ic.getMethod().getName());
    }
  }
}