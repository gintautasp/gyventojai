package statistika.gyventojai;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
public class GyventojuDuomenys implements Serializable{
	
	@Id
	private String salis;
	private String miestas;
	private String lytis;
	private Integer flag_gyv_mieste;
	private Integer amz_grupes;
	private Integer kiekis;
	
	public GyventojuDuomenys() {
	}
	/*public GyventojuDuomenys(String salis, String miestas, String lytis, Integer flag_gyv_mieste, Integer amz_grupes, Integer kiekis) {
		this.salis = salis;
		this.miestas = miestas;
		this.lytis = lytis;
		this.flag_gyv_mieste = flag_gyv_mieste;
		this.amz_grupes = amz_grupes;
		this.kiekis = kiekis;
	}*/
	public String getSalis() {
		return salis;
	}

	public void setSalis(String salis) {
		this.salis = salis;
	}

	public String getMiestas() {
		return miestas;
	}

	public void setMiestas(String miestas) {
		this.miestas = miestas;
	}

	public String getLytis() {
		return lytis;
	}

	public void setLytis(String lytis) {
		this.lytis = lytis;
	}

	public Integer getFlag_gyv_mieste() {
		return flag_gyv_mieste;
	}

	public void setFlag_gyv_mieste(Integer flag_gyv_mieste) {
		this.flag_gyv_mieste = flag_gyv_mieste;
	}

	public Integer getAmz_grupes() {
		return amz_grupes;
	}

	public void setAmz_grupes(Integer amz_grupes) {
		this.amz_grupes = amz_grupes;
	}

	public Integer getKiekis() {
		return kiekis;
	}

	public void setKiekis(Integer kiekis) {
		this.kiekis = kiekis;
	}


}
