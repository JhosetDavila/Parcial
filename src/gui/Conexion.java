package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Conexion {
    public static Connection conectar(){
        Connection con=null;    
        try {
            String url;
            url = "jdbc:mysql://localhost:3306/MULTA?user=root&&password=mysqladmin";
            con=DriverManager.getConnection(url);
            if (con !=null) {
                System.out.println("Conexion Satisfactoria");                
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return con;
    }

    public static void main(String[] args) {
        try {
            JasperReport jr=(JasperReport)JRLoader.loadObject(Conexion.class.getResource("./Reporte.jasper"));
            Map parametros=new HashMap<String,Object>();
            parametros.put("DNI",15465846);
            parametros.put("Multa","Pico Placa");
            parametros.put("Monto",400);
            parametros.put("Correo","jhosetdavila@gmail.com");
            JasperPrint jp=JasperFillManager.fillReport(jr,parametros,conectar());
            JasperViewer jv=new JasperViewer(jp);
            jv.show(); 
        } catch (JRException e) {
            System.err.print(e);
        }
    }
    
}
