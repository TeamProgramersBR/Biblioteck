/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.harlock.model;

import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Mail {
    
    

    public Mail() {           
    }
    public Properties props(){
                try{
                String mail = "bibliotecksenai@gmail.com";
                String pass = "senai123";
                Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
                return props;
                }catch(Exception e){
            e.printStackTrace();
            throw new Error("xablau2");
        }
    }
    public Session session(Properties props)throws MessagingException{
        try{
                final String mail = "bibliotecksenai@gmail.com";
                final String pass = "senai123";
    Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(mail, pass);
			}
		  });
    return session;
        }catch(Exception e){
            e.printStackTrace();
            throw new Error("xablau");
        }
    }
    public void reserva(Session session, String destinoMail, String titulo, String data){
    
    
        try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("bibliotecksenai@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(destinoMail));
			message.setSubject("Notificação de reserva");
			message.setText("Olá biblioteck informa,"
				+ "\n\n\n O usuario com cadastro no email "+destinoMail+" Fez a reserva ou emprestimo do tíulo "+titulo+", \n "
                                + " Caso seja uma reserva, compareça a biblioteca na data "+data+". \n\n\n"
                                + " Atenciosamente,Equipe Biblioteck."
                                
                        );
                                
			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	
    
    
    }
    public void cobranca(Session session,String destinoMail, String titulo, String multa){
    Random gerador = new Random();
    String nBoleto;
    nBoleto =" "+String.valueOf(gerador.nextInt(999999999));
    nBoleto +=" "+String.valueOf(gerador.nextInt(999999999));
    nBoleto +=" "+String.valueOf(gerador.nextInt(999999999));
    nBoleto +=" "+String.valueOf(gerador.nextInt(999999999));
    nBoleto +=" "+String.valueOf(gerador.nextInt(999999999));
    
        try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("bibliotecksenai@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(destinoMail));
			message.setSubject("Notificação de cobrança");
			message.setText("Olá biblioteck informa,"
				+ "\n\n\n O usuario com cadastro no email "+destinoMail+" tem uma pendencia referente ao tíulo "+titulo+", \n "
                                + " Para finalizar esta pendencia, compareça a biblioteca para o pagamento do valor de "+multa+" referente ao atraso de entrega do titulo citado. \n\n\n"
                                + " O numero do boleto referente a cobrança e : "+nBoleto+" pode ser pago em qualquer caixa do planeta terra. \n\n\n"
                                + " Atenciosamente,Equipe Biblioteck."
                                
                        );
                                
			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
        
    
    }
    public void cancelamento(Session session, String destinoMail, String titulo){
    
    
        
        try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("bibliotecksenai@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(destinoMail));
			message.setSubject("Notificação de cancelamento de reserva");
			message.setText("Olá biblioteck informa,"
				+ "\n\n\n O usuario com cadastro no email "+destinoMail+" Fez a reserva ou emprestimo do tíulo "+titulo+", \n "
                                + " Infelizmente seu titulo foi reservado por um usuario de prioridade, ou teve a reserva alterada por alguma indisponibilidade, fique de olho na disponibilidade do mesmo no nosso site. \n\n\n"
                                + " Atenciosamente,Equipe Biblioteck."
                                
                        );
                                
			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
        
    
    }
    
}
