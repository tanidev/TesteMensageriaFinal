package br.com.teste.jms.topic;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(mappedName="TestTopic", activationConfig =  {
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue="Auto-acknowledge"),
        @ActivationConfigProperty(propertyName="destinationType", propertyValue="javax.jms.Queue"),
        @ActivationConfigProperty(propertyName="destination", propertyValue="VirtualTopicConsumers.A.VirtualTopic.Teste"),
    })
public class TesteConsumerVirutalTopic2 implements MessageListener {
	
	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		try {
			System.out.println("TesteVirtualTopicB: Recebendo mensagem: " + ((TextMessage) message).getText());
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Finalizando mensagem!");
	}
	
}
