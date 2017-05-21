package br.com.teste.jms.queue;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig =  {
	    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue="Auto-acknowledge"),
	    @ActivationConfigProperty(propertyName="destinationType", propertyValue="javax.jms.Queue"),
	    @ActivationConfigProperty(propertyName="destination", propertyValue="activemq/queue/TestQueue?consumer.exclusive=true"),
	    @ActivationConfigProperty(propertyName="maxSessions", propertyValue="1")
})
public class TesteConsumerQueue1 implements MessageListener {

	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Queue 1 - Recebendo mensagem: " + ((TextMessage) message).getText());
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Finalizando mensagem!");
	}
	
}
