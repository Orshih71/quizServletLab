import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class FormQuiz extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException, ServletException {
        HttpSession s = request.getSession();
        PrintWriter out = response.getWriter();
        Quiz quiz;
        out.print("<html><head><title>Quiz</title></head><body>");
        out.print("<h1>The Number Quiz</h1>");
        if (s.getAttribute("quiz") == null) {
            quiz = new Quiz();
            out.print("<h4>Your current score is 0.</h4>");
            out.print("<h4>Guess the next number in the sequence</h4>");
            out.print("<h4>" + quiz.getQuistions()[0] + "</h4>");
            out.print("<form method='get'>");
            out.print("<label> Your Answer:");
            out.print("<input name='answer' type='number'/>");
            out.print("</label>");
            out.print("<br/>");
            out.print("<br/>");
            out.print("<input type='submit' value='Submit'/>");
            out.print("</form>");
            request.getSession().setAttribute("quiz", quiz);
        } else {
            quiz = (Quiz) s.getAttribute("quiz");
            int answer = -1;
            if (request.getParameter("answer") != null) {
                answer = Integer.parseInt(request.getParameter("answer"));
            }
            if (quiz.getAnswers()[quiz.getQno()] == answer) {
                quiz.setScore(quiz.getScore() + 1);
            }
            quiz.setQno(quiz.getQno() + 1);
            out.print("<h4>Your current score is " + quiz.getScore() + ".</h4>");
            if (quiz.getQno() == quiz.getQuistions().length) {
                out.print("<h4>You have completed the Number Quiz, with a score of " + quiz.getScore() + " out of " + quiz.getQuistions().length + "</h4>");
            } else {
                out.print("<h4>Guess the next number in the sequence</h4>");
                out.print("<h4>" + quiz.getQuistions()[quiz.getQno()] + "</h4>");
                out.print("<form method='get'>");
                out.print("<label> Your Answer:");
                out.print("<input name='answer' type='number'/>");
                out.print("</label>");
                out.print("<br/>");
                out.print("<br/>");
                out.print("<input type='submit' value='Submit'/>");
                out.print("</form>");
            }
        }
        out.print("</body></html>");
    }
}
