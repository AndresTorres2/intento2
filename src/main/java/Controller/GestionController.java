package Controller;

import Model.DAO.CalleDAO;
import Model.DAO.RutaDAO;
import Model.DAO.UsuarioDAO;
import Model.DAO.ViajeDAO;
import Model.DAO.BusDAO;
import Model.Entity.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GestionServlet", value = "/GestionServlet")
public class GestionController extends HttpServlet {
    RutaDAO rutaDAO ;
    CalleDAO calleDAO ;
    ViajeDAO viajeDAO;
    BusDAO busDAO;
    public UsuarioDAO usuarioDAO ;
    @Override
    public void init() throws ServletException {
        super.init();
        rutaDAO = new RutaDAO();
        calleDAO = new CalleDAO();
        usuarioDAO = new UsuarioDAO();
        viajeDAO = new ViajeDAO();
        busDAO = new BusDAO();
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

            case "gestionViajes": // Nueva acción para gestionar viajes
                gestionarViajes(req, resp);
                break;
            case "nuevoViaje":
                mostrarFormViaje(req, resp);
                break;
            case "guardarViaje":
                guardarViaje(req, resp);
                break;
            case "eliminarViaje":
                eliminarViaje(req, resp);
                break;
            case "formActualizarViaje":
                mostrarFormActualizarViaje(req, resp);
                break;
            case "actualizarViaje":
                actualizarViaje(req, resp);
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




    // Métodos para gestionar viajes
    public void gestionarViajes(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("viajes", viajeDAO.obtenerTodosLosViajes()); // Obtener todos los viajes
        RequestDispatcher dispatcher = req.getRequestDispatcher("/View/gestionViaje.jsp");
        dispatcher.forward(req, resp);
    }


    public void mostrarFormViaje(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("buses", busDAO.obtenerTodosLosBuses());
        req.setAttribute("rutas", rutaDAO.obtenerTodasLasRutas());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/View/registrarViaje.jsp");
        dispatcher.forward(req, resp);
    }


    public void guardarViaje(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }



    public void eliminarViaje(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        viajeDAO.eliminarViajeEnDB(Integer.parseInt(req.getParameter("viajeId")));

        req.setAttribute("viajes", viajeDAO.obtenerTodosLosViajes());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/View/gestionViaje.jsp");
        dispatcher.forward(req, resp);
    }


    private void mostrarFormActualizarViaje(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int viajeId = Integer.parseInt(req.getParameter("viajeId"));
        Viaje viaje = viajeDAO.obtenerViajePorCodigo(viajeId);

        req.setAttribute("viaje", viaje);
        req.setAttribute("buses", busDAO.obtenerTodosLosBuses());
        req.setAttribute("rutas", rutaDAO.obtenerTodasLasRutas());
        forward(req, resp, "/View/actualizarViaje.jsp");
    }

    private void actualizarViaje(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int viajeId = Integer.parseInt(req.getParameter("viajeId"));
        String busId = req.getParameter("busId"); // Mantenemos busId como String
        int rutaId = Integer.parseInt(req.getParameter("rutaId"));
        String fecha = req.getParameter("fecha");
        String horaDeSalida = req.getParameter("horaDeSalida");
        String jornada = req.getParameter("jornada");

        Bus bus = busDAO.obtenerBusPorId(busId);
        Ruta ruta = rutaDAO.obtenerRutaId(rutaId);
        Date fechaViaje = Date.valueOf(fecha);


        if (horaDeSalida != null && !horaDeSalida.isEmpty()) {
            horaDeSalida += ":00"; // Añadir los segundos
        }
        Time horaSalida = Time.valueOf(horaDeSalida);

        Viaje viaje = viajeDAO.obtenerViajePorCodigo(viajeId);
        viaje.setBus(bus);
        viaje.setRuta(ruta);
        viaje.setFecha(fechaViaje);
        viaje.setHoraDeSalida(horaSalida);
        viaje.setJornada(jornada);

        viajeDAO.actualizarViajeEnDB(viaje);
        gestionarViajes(req, resp);
    }





    private void forward(HttpServletRequest req, HttpServletResponse resp, String path) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher(path);
        dispatcher.forward(req, resp);
    }













}
