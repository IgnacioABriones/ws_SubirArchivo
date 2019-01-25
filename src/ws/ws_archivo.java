package ws;


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import Tools.EnvioFtp;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService(serviceName = "ws_SubirArchivo", targetNamespace = "http://tempuri.org/")
public class ws_archivo {
	
	  @Resource
	    WebServiceContext wsctx;
	
	@WebMethod(operationName = "SubirExtendido")
	public @WebResult(name = "SubirExtendidoResult", header = true) String SubirExtendido(
			@WebParam(name = "cuentacargo") String cuentacargo,
			@WebParam(name = "fechapago") String fechapago,
			@WebParam(name = "glosanomina") String glosanomina,
			@WebParam(name = "nombrearchivo") String nombrearchivo,
			@WebParam(name = "archivo") String archivo) throws Exception {
		
		MessageContext mctx = wsctx.getMessageContext();
		
		Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
        List userList = (List) http_headers.get("Username");
        List passList = (List) http_headers.get("Password");
		
        String username = "";
        String password = "";
        
        if(userList!=null){
        	//get username
        	username = userList.get(0).toString();
        }
        	
        if(passList!=null){
        	//get password
        	password = passList.get(0).toString();
        }
        
        if (username.equals("user") && password.equals("pass")){
        	return "usuario valido";
        }else{
        	return "usuario desconocido!";
        }
        
		String path="";
		String res="";
		int error=0;
		byte[] data=null;
		if(nombrearchivo.length()>4)
		{
			res="Nombre archivo no valido :"+nombrearchivo;
			error=1;
		}
         if(getFileExtension(nombrearchivo).length()==0)
         {
        	 res="Extension en archivo vacia :"+nombrearchivo; 
        	 error=1;
         }
         if(error==0)
         {
		try
		{
		data=Base64.getDecoder().decode(archivo);
		}
		catch(Exception ex)
		{
			res="Error al convertir desde Base64 "+ex.getMessage();
			error=1;
		}
		Path dest=Paths.get(path, nombrearchivo);
		if(error==0)
		{
		try
		{
		Files.write(dest,data);
		EnvioFtp.Envio("server", "usuario", "pass", "archivo");
		}
		catch(Exception ex)
		{
			res="Error en escribir en la ruta : "+path+", archivo :"+nombrearchivo+ " "+ex.getMessage();
			error=1;
		}
		}
         }
         if(error==0)
         {
        	 res="Exito";
         }
		return res;
	}
	@WebMethod(operationName = "SubirConRutExtendido")
	public @WebResult(name = "SubirConRutExtendidoResult", header = false) String SubirConRutExtendido(
			@WebParam(name = "numeroreferencia") String numeroreferencia,
			@WebParam(name = "rutempresa") String rutempresa,
			@WebParam(name = "servicio") String servicio,
			@WebParam(name = "modulo") String modulo,
			@WebParam(name = "cuentacargo") String cuentacargo,
			@WebParam(name = "fechapago") String fechapago,
			@WebParam(name = "glosanomina") String glosanomina,
			@WebParam(name = "nombrearchivo") String nombrearchivo,
			@WebParam(name = "archivo") String archivo) throws Exception {
		String path="";
		String res="";
		int error=0;
		byte[] data=null;
		if(nombrearchivo.length()>4)
		{
			res="Nombre archivo no valido :"+nombrearchivo;
			error=1;
		}
         if(getFileExtension(nombrearchivo).length()==0)
         {
        	 res="Extension en archivo vacia :"+nombrearchivo; 
        	 error=1;
         }
         if(error==0)
         {
		try
		{
		data=Base64.getDecoder().decode(archivo);
		}
		catch(Exception ex)
		{
			res="Error al convertir desde Base64 "+ex.getMessage();
			error=1;
		}
		Path dest=Paths.get(path, nombrearchivo);
		if(error==0)
		{
		try
		{
		Files.write(dest,data);
		}
		catch(Exception ex)
		{
			res="Error en escribir en la ruta : "+path+", archivo :"+nombrearchivo+ " "+ex.getMessage();
			error=1;
		}
		}
         }
         if(error==0)
         {
        	 res="Exito";
         }
		return res;
	}
	@WebMethod(operationName = "SubirConEspejoExtendido")
	public @WebResult(name = "SubirConEspejoExtendidoResult", header = false) String SubirConEspejoExtendido(
			@WebParam(name = "numeroreferencia") String numeroreferencia,
			@WebParam(name = "servicio") String servicio,
			@WebParam(name = "modulo") String modulo,
			@WebParam(name = "cuentacargo") String cuentacargo,
			@WebParam(name = "fechapago") String fechapago,
			@WebParam(name = "glosanomina") String glosanomina,
			@WebParam(name = "nombrearchivo") String nombrearchivo,
			@WebParam(name = "archivo") String archivo) throws Exception {
		String path="";
		String res="";
		int error=0;
		byte[] data=null;
		if(nombrearchivo.length()>4)
		{
			res="Nombre archivo no valido :"+nombrearchivo;
			error=1;
		}
         if(getFileExtension(nombrearchivo).length()==0)
         {
        	 res="Extension en archivo vacia :"+nombrearchivo; 
        	 error=1;
         }
         if(error==0)
         {
		try
		{
		data=Base64.getDecoder().decode(archivo);
		}
		catch(Exception ex)
		{
			res="Error al convertir desde Base64 "+ex.getMessage();
			error=1;
		}
		Path dest=Paths.get(path, nombrearchivo);
		if(error==0)
		{
		try
		{
		Files.write(dest,data);
		}
		catch(Exception ex)
		{
			res="Error en escribir en la ruta : "+path+", archivo :"+nombrearchivo+ " "+ex.getMessage();
			error=1;
		}
		}
         }
         if(error==0)
         {
        	 res="Exito";
         }
		return res;
	}
	@WebMethod(operationName = "SubirConEspejoRutExtendido")
	public @WebResult(name = "SubirConEspejoRutExtendidoResult", header = false) String SubirConEspejoRutExtendido(
			@WebParam(name = "numeroreferencia") String numeroreferencia,
			@WebParam(name = "rutempresa") String rutempresa,
			@WebParam(name = "servicio") String servicio,
			@WebParam(name = "modulo") String modulo,
			@WebParam(name = "cuentacargo") String cuentacargo,
			@WebParam(name = "fechapago") String fechapago,
			@WebParam(name = "glosanomina") String glosanomina,
			@WebParam(name = "nombrearchivo") String nombrearchivo,
			@WebParam(name = "archivo") String archivo) throws Exception {
		String path="";
		String res="";
		int error=0;
		byte[] data=null;
		if(nombrearchivo.length()>4)
		{
			res="Nombre archivo no valido :"+nombrearchivo;
			error=1;
		}
         if(getFileExtension(nombrearchivo).length()==0)
         {
        	 res="Extension en archivo vacia :"+nombrearchivo; 
        	 error=1;
         }
         if(error==0)
         {
		try
		{
		data=Base64.getDecoder().decode(archivo);
		}
		catch(Exception ex)
		{
			res="Error al convertir desde Base64 "+ex.getMessage();
			error=1;
		}
		Path dest=Paths.get(path, nombrearchivo);
		if(error==0)
		{
		try
		{
		Files.write(dest,data);
		}
		catch(Exception ex)
		{
			res="Error en escribir en la ruta : "+path+", archivo :"+nombrearchivo+ " "+ex.getMessage();
			error=1;
		}
		}
         }
         if(error==0)
         {
        	 res="Exito";
         }
		return res;
	}
	private String getFileExtension(String name ) {
	    int lastIndexOf = name.lastIndexOf(".");
	    if (lastIndexOf == -1) {
	        return ""; // empty extension
	    }
	    return name.substring(lastIndexOf);
	}
}


