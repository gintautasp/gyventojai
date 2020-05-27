package statistika.gyventojai;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManagerFactory;
@Controller
public class PageController {

	@Autowired 
	EntityManagerFactory factory;

	// @Bean
	public SessionFactory sessionFactory() {
		
	        if (factory.unwrap(SessionFactory.class) == null) {
	            throw new NullPointerException("factory is not a hibernate factory");
	        }
	        return factory.unwrap(SessionFactory.class);
	}
	
	@RequestMapping(path="/paieska", method={ RequestMethod.GET, RequestMethod.POST })
	public String paieska(
    		@RequestParam(name="salis_id", required=false, defaultValue="0") Integer salis_id
    		, @RequestParam(name="pagal_lyti", required=false, defaultValue="0") Integer pagal_lyti
    		, @RequestParam(name="pagal_gyv_mieste", required=false, defaultValue="0") Integer pagal_gyv_mieste
    		, @RequestParam(name="pagal_salis", required=false, defaultValue="0") Integer pagal_salis
    		, @RequestParam(name="amz_ribos", required=false, defaultValue="5") Integer amz_ribos
    		, @RequestParam(name="veiksmas", required=false, defaultValue="neieskoti") String veiksmas
    		, Model model 
    	) {
		
		/*BackEndMessage back_end_message = new BackEndMessage ( "nieko dar neveikem", false, "pranesimas_grey" );*/
		System.out.println ( salis_id );
		System.out.println ( pagal_lyti);
		System.out.println ( pagal_gyv_mieste);
		System.out.println ( pagal_salis );
		System.out.println ( amz_ribos);
		System.out.println ( veiksmas );
		
        if ( veiksmas.equals("ieskoti") ) {
        
	        Session session = this.sessionFactory().openSession(); 
			
			Filtrai gyv_duomenu_filtrai =  new Filtrai ( session );
	        model.addAttribute( "lst_gyv_duomenu", gyv_duomenu_filtrai.gyventojuDuomenys( salis_id, pagal_lyti, pagal_gyv_mieste, pagal_salis, amz_ribos ) ); 
	       
        }  else  {
        	
        	model.addAttribute( "lst_gyv_duomenu", new ArrayList<GyventojuDuomenys>() );
        }
    
        /*model.addAttribute( "lst_menu", Menu.values() ); */
        /*model.addAttribute( "back_end_message", back_end_message );*/
        List<String> stulp_pavadinimai;        
        Integer stulp_kiekis = 4;
        Integer amzius = 0;
		stulp_pavadinimai = new ArrayList<>();
		stulp_pavadinimai.add("Salis");
		stulp_pavadinimai.add("Miestas");
		if(pagal_lyti == 1) {
			stulp_pavadinimai.add("Lytis");
			stulp_kiekis += 1;
		}
		if(pagal_gyv_mieste == 1) {
			stulp_pavadinimai.add("Gyvena mieste");
			stulp_kiekis += 1;
		}
		stulp_pavadinimai.add("Amziu grupe");
		stulp_pavadinimai.add("Kiekis");
		while(amzius <= 85) {
		 	stulp_pavadinimai.add(amzius + "-" + (amzius + amz_ribos));
			amzius += amz_ribos;
		}
		model.addAttribute( "stulp_pavadinimai", stulp_pavadinimai);
		model.addAttribute( "stulp_kiekis", stulp_kiekis);
        return "paieska";
    }

}
