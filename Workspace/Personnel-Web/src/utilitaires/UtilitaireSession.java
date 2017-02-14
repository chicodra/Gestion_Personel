package utilitaires;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UtilitaireSession {
	
	public static HttpSession getSession() {
        return (HttpSession)
          FacesContext.
          getCurrentInstance().
          getExternalContext().
          getSession(false);
      }
       
      public static HttpServletRequest getRequest() {
       return (HttpServletRequest) FacesContext.
          getCurrentInstance().
          getExternalContext().getRequest();
      }
 
      public static String getLogin()
      {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        return  session.getAttribute("userLogin").toString();
      }
       
      
      public static String getPassword()
      {
        HttpSession session = getSession();
        if ( session != null )
            return (String) session.getAttribute("userPasse");
        else
            return null;
      }
      
      public static String getTypeActe()
      {
        HttpSession session = getSession();
        if ( session != null )
            return (String) session.getAttribute("userTypeActe");
        else
            return null;
      }
}
