package br.com.teste.jms.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.teste.jms.topic.TesteProducerVirtualTopic;

@WebServlet("/virtualtopic")
public class TesteProducerVirtualTopicServlet extends HttpServlet {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 9216657565198815837L;
	
	@Inject
	TesteProducerVirtualTopic testeProducer;
	
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
