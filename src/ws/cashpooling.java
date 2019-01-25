@WebService(serviceName = "ws_cashpooling", targetNamespace = "http://tempuri.org/")
public class ws_cashpooling {


    @WebMethod(operationName = "SubirConRutExtendido") BajarCartolaMagneticaExtendido
    public @WebResult(name = "SubirConRutExtendidoResult", bajarCartolaMagneticaResult
            header = false)
    String SubirConRutExtendido( BajarCartolaMagneticaExtendido
            @WebParam(name = "numeroreferencia") String numeroreferencia,
            @WebParam(name = "rutempresa") String rutempresa,
            @WebParam(name = "servicio") String servicio,
            @WebParam(name = "modulo") String modulo,
            @WebParam(name = "cuentacargo") String cuentacargo,
            @WebParam(name = "fechapago") String fechapago,
            @WebParam(name = "glosanomina") String glosanomina,
            @WebParam(name = "nombrearchivo") String nombrearchivo,
            @WebParam(name = "archivo") String archivo) throws Exception {
        String path = "";
        String res = "";
        int error = 0;
        byte[] data = null;
        if (nombrearchivo.length() > 4) {
            res = "Nombre archivo no valido :" + nombrearchivo;
            error = 1;
        }
        if (getFileExtension(nombrearchivo).length() == 0) {
            res = "Extension en archivo vacia :" + nombrearchivo;
            error = 1;
        }
        if (error == 0) {
            try {
                data = Base64.getDecoder().decode(archivo);
            } catch (Exception ex) {
                res = "Error al convertir desde Base64 " + ex.getMessage();
                error = 1;
            }
            Path dest = Paths.get(path, nombrearchivo);
            if (error == 0) {
                try {
                    Files.write(dest, data);
                } catch (Exception ex) {
                    res = "Error en escribir en la ruta : " + path + ", archivo :" + nombrearchivo + " " + ex.getMessage();
                    error = 1;
                }
            }
        }
        if (error == 0) {
            res = "Exito";
        }
        return res;
    }

}