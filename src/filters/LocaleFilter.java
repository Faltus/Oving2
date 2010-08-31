package filters;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;

/**
 * Servlet Filter implementation class LocaleFilter
 */
public class LocaleFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LocaleFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpRes = (HttpServletResponse) response;
		String cookieName = "locale";
		String defaultValue = "";
		Cookie[] cookies = httpReq.getCookies();
		if (cookies != null) {
			for (int i=0; i<cookies.length; i++) {
				Cookie cookie = cookies[i];
				if (cookieName.equals(cookie.getName()))
					defaultValue = cookie.getValue();
			}
		}
		String lng = defaultValue;
		
		
		Locale locale;
		String lngPara = request.getParameter("lng");
		if (lngPara != null) {
			String[] lngArray = lngPara.split("_");
			locale = new Locale(lngArray[0], lngArray[1]);
		} else {
			if (lng=="") {
				locale = request.getLocale();
			} else {
				String[] lngArray = lng.split("_");
				locale = new Locale(lngArray[0], lngArray[1]);
			}
		}
		Cookie localeCookie = new Cookie("locale", locale.toString());
		httpRes.addCookie(localeCookie);
		request.setAttribute("locale", locale);
		
		Config.set(httpReq.getSession(), Config.FMT_LOCALE, locale.toString());
		
		request = (ServletRequest) httpReq;
		response = (ServletResponse) httpRes;
		
		//Send videre
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
