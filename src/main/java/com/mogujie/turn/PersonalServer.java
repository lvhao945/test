package com.mogujie.turn;



import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;


/**
 * 入口类
 * @author shinian
 */
public class PersonalServer {
	
	public static void start()
	{
		Server server = new Server();
		SelectChannelConnector connector = new SelectChannelConnector();
		connector.setPort(10012);
	    server.setConnectors(new Connector[]{connector});
	    
	    ServletContextHandler ctx = new ServletContextHandler(ServletContextHandler.SESSIONS);
	    ctx.setContextPath("/");
	//    ctx.addServlet(new ServletHolder(new CommondServlet()), "/command");
	    ctx.addServlet(new ServletHolder(new TestServlet()), "/test");
	    
	    server.setHandler(ctx);
	    try {
			server.start();
			System.out.println("start end");
		    server.join();
		} catch (Exception e) {
		}
	}
}
