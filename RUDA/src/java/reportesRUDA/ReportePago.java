
package reportesRUDA;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.SimpleFileResolver;

public class ReportePago extends HttpServlet{

    public void ejecutarReporte(HttpServletRequest request, HttpServletResponse response, String tipo) throws JRException {
        Connection conn = null;
        try {
            
            //Se consulta la ruta del reporte
            String rutaReportes = this.getServletContext().getRealPath("/reportes");
            String rutaReporte = "/reportePago.jasper";            
            String rutaCompleta = rutaReportes + rutaReporte;

            List<File> parentFolders = new ArrayList();
            parentFolders.add(new File(rutaReportes));
            
           Map params = new HashMap();
            params.put(JRParameter.REPORT_FILE_RESOLVER, new SimpleFileResolver(parentFolders));
                    
            //Se abre el reporte
            InputStream inputStream = new FileInputStream(rutaCompleta);

            if (inputStream == null) {
                throw new ClassNotFoundException("Archivo .jasper no se encontro");
            }

            JRExporter exporter = null;
            
            //Se abre la cx
            Context initContext = new InitialContext();            
            DataSource ds = (DataSource)initContext.lookup("gepad");
            conn = ds.getConnection();
            //System.out.println("Conexion: "+conn.getCatalog());
            //Se llena el reporte
            JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, params, conn);

            //Se escribe en el flujo de datos de salida
            ServletOutputStream out = null;

            response.setContentType(tipo);
            if ("application/pdf".equals(tipo)) {
                response.setHeader("Content-disposition", "attachment; filename=\"estudiante.pdf\""); // The Save As popup magic is done here. You can give it any filename you want, this only won't work in MSIE, it will use current request URL as filename instead.
                out = response.getOutputStream();
                exporter = new JRPdfExporter();
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
                
            } 
            if (exporter != null) {
                exporter.exportReport();
            }

            if (out != null) {
                out.close();
            }

        } catch (Exception e) {
            Logger.getLogger(ReportePago.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(ReportePago.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
}
