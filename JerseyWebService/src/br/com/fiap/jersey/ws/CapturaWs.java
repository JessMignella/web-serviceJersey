package br.com.fiap.jersey.ws;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.fiap.captura.to.CapturaTO;
import br.com.fiap.dao.CapturaDAO;

@Path("captura")
public class CapturaWs {
    CapturaDAO capDao = new CapturaDAO();    
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CapturaTO> getCapturas(){		
		List<CapturaTO> listCapturas = capDao.getAllCapturas();
		return listCapturas;
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public CapturaTO getCapturaTOById(@PathParam("id") String id){
		return capDao.getCapturaTO(id);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public CapturaTO addCapturaTO(CapturaTO cap){
	return capDao.addCapturaTo(cap);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public CapturaTO updateCapturaTO(CapturaTO cap){
	return capDao.updateCapturaTO(cap);
	}
	
	@DELETE
	@Path("/{id}")
	public void deleteCapturaTO(@PathParam("id") String id){
	   capDao.deleteCapturaTO(id);
	}
}
