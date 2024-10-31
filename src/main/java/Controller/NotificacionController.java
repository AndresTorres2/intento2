package Controller;

import Model.DAO.EmailDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "NotificacionServlet", value = "/NotificacionServlet")
public class NotificacionController extends HttpServlet {
    EmailDAO emailDAO;
    @Override
    public void init() throws ServletException {
        super.init();
        emailDAO = new EmailDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.ruteador(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.ruteador(req, resp);
    }

    public void ruteador(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ruta = (req.getParameter("action") == null) ? "notificar" : req.getParameter("action");
        switch (ruta) {
            case "notificar":
                notificar(req, resp);
                break;
               default:
                   break;
        }
    }
    public void notificar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String correos = req.getParameter("destinatarios"); // Cadena de correos separados por comas
        String asunto = "Se ha iniciado la comparticion de la ubicación del viaje";
        String mensaje = "La ubicación del viaje se está compartiendo ahora con la descripción: " +
                req.getParameter("descripcion");

        // Convertir la cadena de correos en una lista de correos
        List<String> destinatarios = Arrays.asList(correos.split(","));

        emailDAO.enviarCorreo(destinatarios, asunto, mensaje);

        resp.getWriter().write("Correo enviado a todos los destinatarios.");
    }

}
