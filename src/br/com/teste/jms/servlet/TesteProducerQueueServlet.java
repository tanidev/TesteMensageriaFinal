package br.com.teste.jms.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.teste.jms.queue.TesteProducerQueue;

@WebServlet("/queue")
public class TesteProducerQueueServlet extends HttpServlet {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -745260503869974413L;
	
	@Inject
	TesteProducerQueue testeProducer;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String message = req.getParameter("message");
			Integer numberOfMessages = Integer.parseInt(req.getParameter("numberOfMessages"));
			
			testeProducer.sendMessage(message, numberOfMessages);
			
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
