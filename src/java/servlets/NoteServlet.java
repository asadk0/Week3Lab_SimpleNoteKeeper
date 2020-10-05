package servlets;

import domain.Note;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 759175
 */
public class NoteServlet extends HttpServlet {

    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
            
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(req, res);
        
            String path = getServletContext().getRealPath("/WEB-INF/note.txt");
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));
           
            String title = br.readLine();
            String contents = br.readLine();
            
            Note note = new Note(title, contents);
            
            note.setTitle(title);
            note.setContents(contents);
            
            req.setAttribute("title", title);
            req.setAttribute("contents", contents);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
        String title = req.getParameter("title");
        String contents = req.getParameter("contents");
        
        if (title == null || title.equals("") ||
            contents == null || contents.equals("")) {
      
            String path = getServletContext().getRealPath("/WEB-INF/note.txt");
            // to write to a file
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false))); 
            
            pw.write(title);
            pw.write(contents);

            pw.close();
            
            Note note = new Note(title, contents);
            
            note.setTitle(title);
            note.setContents(contents);
            

            req.setAttribute("title", title);
            req.setAttribute("contents", contents);
       
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(req, res);
            
        
        }
    }


}
