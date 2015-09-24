
import java.io.IOException; 
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import java.io.PrintWriter; 

public class longestPalindrome extends HttpServlet { 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
		String word= request.getParameter("word"); 
		String palindrome = longestPalindrome (word);
		PrintWriter out = response.getWriter(); 
		
		out.println ( "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n" + "<html> \n" + "<head> \n" + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"> \n" + "<title> Finding the longest palindrome </title> \n" + "</head> \n" + "<body> \n" + "<font size=\"12px\" color=\"" + "blue" + "\">" + "The Longest Palindrome is "+palindrome + "</font> \n" + "</body> \n" + "</html>" );
		
		  
		
	} 
	
	public String longestPalindrome(String s) {
		if (s.isEmpty()) {
			return null;
		}
	 
		if (s.length() == 1) {
			return s;
		}
	 
		String longest = s.substring(0, 1);
		for (int i = 0; i < s.length(); i++) {
			// get longest palindrome with center of i
			String tmp = helper(s, i, i);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
	 
			// get longest palindrome with center of i, i+1
			tmp = helper(s, i, i + 1);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
		}
	 
		return longest;
	}
	 
	
	public String helper(String s, int begin, int end) {
		while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}
		return s.substring(begin + 1, end);
	}
	
	
	
    }
	

