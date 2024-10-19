package Controller;

import Model.DAO.CalleDAO;
import Model.DAO.RutaDAO;
import Model.Entity.Calle;
import Model.Entity.Ruta;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GestionServlet", value = "/GestionServlet")
public class GestionController extends HttpServlet {
    RutaDAO rutaDAO ;
    CalleDAO calleDAO ;

    @Override
    public void init() throws ServletException {
        super.init();
        rutaDAO = new RutaDAO();
        calleDAO = new CalleDAO();
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
        String ruta = (req.getParameter("action") == null) ? "login" : req.getParameter("action");
        switch (ruta) {
            case "validarUsuario":

                break;
            case "dashboardAdmin":
                //Aca redireccionamos a una vista donde seleccionara que quiere ver, por ejemplo se muestra Rutas, Viajes, Conductores
                mostrarDashboardAdmin(req,resp);
                break;
            case "gestionRutas":
                gestionarRutas(req,resp);
                break;
            case "nuevaRuta":
                mostrarFormRuta(req,resp);
                break;
            case "guardarRuta":
                guardarRuta(req,resp);
                break;
            case "eliminarRuta":
                eliminarRuta(req,resp);
                break;
            case "formActualizarRuta":
                mostrarFormActualizarRuta(req,resp);
                break;
            case "actualizarRuta":
                actualizarRuta(req,resp);
                break;
            case "dashboardEstudiante":
                //Redireccionar al viajeControler,es decir a la vista
                break;
            default:
                break;

        }

    }
    public void mostrarDashboardAdmin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/View/dashboardAdmin.jsp");
        dispatcher.forward(req, resp);
    }

    public void gestionarRutas(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("rutas", rutaDAO.obtenerTodasLasRutas());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/View/gestionRutas.jsp");
        dispatcher.forward(req, resp);
    }
    public void mostrarFormRuta(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.setAttribute("calles", calleDAO.obtenerTodasLasCalles());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/View/registrarRuta.jsp");
        dispatcher.forward(req, resp);

    }
    public void guardarRuta(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String origen = req.getParameter("origen");
        String destino = req.getParameter("destino");
        String[] callesIds = req.getParameterValues("calles");
        List<Calle> callesSeleccionadas = calleDAO.obtenerCallesSeleccionadas(callesIds);
        Ruta nuevaRuta = new Ruta(0,origen,destino,callesSeleccionadas);
        rutaDAO.guardarRutaDb(nuevaRuta);
        req.setAttribute("rutas", rutaDAO.obtenerTodasLasRutas());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/View/gestionRutas.jsp");
        dispatcher.forward(req, resp);

    }
    public void eliminarRuta(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        rutaDAO.eliminarRutaDb(Integer.parseInt(req.getParameter("rutaId")));
        req.setAttribute("rutas", rutaDAO.obtenerTodasLasRutas());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/View/gestionRutas.jsp");
        dispatcher.forward(req, resp);

    }
    public void mostrarFormActualizarRuta(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int rutaId = Integer.parseInt(req.getParameter("rutaId"));
        Ruta ruta = rutaDAO.obtenerRutaId(rutaId);
        req.setAttribute("ruta", ruta);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/View/actualizarRuta.jsp");
        dispatcher.forward(req, resp);
    }
    public void actualizarRuta(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int rutaId = Integer.parseInt(req.getParameter("rutaId"));
        String origen = req.getParameter("origen");
        String destino = req.getParameter("destino");
        String[] callesIds = req.getParameterValues("calles");
        List<Calle> callesSeleccionadas = calleDAO.obtenerCallesSeleccionadas(callesIds);
        Ruta ruta = rutaDAO.obtenerRutaId(rutaId);
        ruta.setOrigen(origen);
        ruta.setDestino(destino);
        ruta.setCalles(callesSeleccionadas);
        rutaDAO.actualizarRutaDb(ruta);
        req.setAttribute("rutas", rutaDAO.obtenerTodasLasRutas());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/View/gestionRutas.jsp");
        dispatcher.forward(req, resp);

    }

}
