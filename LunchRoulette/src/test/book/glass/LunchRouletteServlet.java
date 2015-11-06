package test.book.glass;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LunchRouletteServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2111183550284082407L;
	public String lunch;

	/**
	 * 
	 */


	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html; charset=utf-8");
		 Map<String, Object> data = new HashMap<String, Object>();
		    data.put("food", LunchRoulette.getRandomCuisine());

		    String html = null;
			try {
				html = LunchRoulette.render(getServletContext(), "web/cuisine.ftl", data);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		resp.getWriter().append(html);
	}
}

