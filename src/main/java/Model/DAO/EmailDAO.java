package Model.DAO;
import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.util.List;
import java.util.Properties;
public class EmailDAO {


    public void enviarCorreo(List<String> destinatarios, String asunto, String mensaje) {
        Properties propiedades = new Properties();
        propiedades.put("mail.smtp.auth", "true");
        propiedades.put("mail.smtp.starttls.enable", "true");
        propiedades.put("mail.smtp.host", "smtp.gmail.com");
        propiedades.put("mail.smtp.port", "587");

        Session sesion = Session.getInstance(propiedades, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("tu_correo@example.com", "tu_contraseña");
            }
        });

        try {
            Message message = new MimeMessage(sesion);
            message.setFrom(new InternetAddress("tu_correo@example.com"));

            // Convertir la lista de destinatarios en un array de InternetAddress
            InternetAddress[] direcciones = destinatarios.stream()
                    .map(email -> {
                        try {
                            return new InternetAddress(email);
                        } catch (AddressException e) {
                            throw new RuntimeException(e);
                        }
                    }).toArray(InternetAddress[]::new);

            message.setRecipients(Message.RecipientType.TO, direcciones);
            message.setSubject(asunto);
            message.setText(mensaje);

            Transport.send(message);
            System.out.println("Correo enviado exitosamente a múltiples destinatarios");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
