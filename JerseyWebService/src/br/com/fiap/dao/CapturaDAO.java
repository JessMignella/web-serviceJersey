package br.com.fiap.dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import br.com.fiap.captura.to.CapturaTO;

public class CapturaDAO {
	
	static HashMap<String, CapturaTO> CapturaMap = getCapturaTOMap();
			
    public CapturaDAO(){
    	super();
    	
    	if(CapturaMap == null){
    		CapturaMap = new HashMap<String,CapturaTO>();
    		CapturaTO cap = new CapturaTO(22,22,22,"1999","1","myDevice");
    		CapturaTO cap2 = new CapturaTO(22,22,22,"2222","1","bolinha");
    		CapturaMap.put("9999",cap);
    		CapturaMap.put("2",cap2);
    	}
    }
	 
    public List<CapturaTO> getAllCapturas(){
    	List<CapturaTO> capturas = new ArrayList<CapturaTO>(CapturaMap.values());
    	return capturas;
    }
    
    public CapturaTO getCapturaTO(String id){
    	CapturaTO cap = CapturaMap.get(id);
    	return cap;
    }
    
    public CapturaTO addCapturaTo(CapturaTO cap){
    	cap.set_id(Integer.toString(CapturaMap.size()+1));
    	CapturaMap.put(cap.get_id(), cap);
    	return cap;
    }
    
    public void deleteCapturaTO(String id){
    	CapturaMap.remove(id);
    }
    
    public CapturaTO updateCapturaTO(CapturaTO cap){
    	if(Integer.parseInt(cap.get_id()) <= 0)
    		return null;   		
    		
    		 CapturaMap.put(cap.get_id(),cap);
    	     return cap;
    }
    
    private static HashMap<String, CapturaTO> getCapturaTOMap(){
		return CapturaMap;
    	
    }
}
