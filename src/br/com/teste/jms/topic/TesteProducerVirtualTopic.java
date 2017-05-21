package br.com.teste.jms.topic;

import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

@Singleton
public class TesteProducerVirtualTopic {

	@Resource(lookup="java:/ConnectionFactory") 
	ConnectionFactory cf; 
	
	@Resource(lookup = "java:jboss/activemq/virtualtopic/Teste") 
	Topic myTopic; 
	
	public void sendMessage(String message, Integer numberOfMessages) throws JMSException {

		Connection connection = cf.createConnection();
	    Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	    MessageProducer publisher = session.createProducer(myTopic);
		
		for(int i = 1; i <= numberOfMessages; i++) {
			TextMessage textMessage = session.createTextMessage(message  + " [number: " + i + "]");
			publisher.send(textMessage);
		}
		
	}
	
	
}
