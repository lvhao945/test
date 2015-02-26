package com.mogujie.turn;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Set<String> st=new HashSet<String>();
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
        response.setCharacterEncoding("utf-8");
        String get=request.getParameter("get");
        String set=request.getParameter("set");
        if(get!=null&&(!get.equals("")))
        {
        	if(st.contains(get))response.getWriter().write("yes");
        	else response.getWriter().write("no");
        }
        if(set!=null&&(!set.equals("")))
        {
        	st.add(set);
        }
      
      //  response.getWriter().write("success");
	}
}
