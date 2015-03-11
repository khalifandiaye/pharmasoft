package fr.mmm.pharmaware.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import fr.mmm.pharmaware.dao.MedicamentDao;
import fr.mmm.pharmaware.dto.MedicamentDTO;
import fr.mmm.pharmaware.entity.Medicament;
@FacesConverter("medicamentConverter")
public class MedicamentConverter implements Converter {
	
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
//                VenteBean service = (VenteBean) fc.getExternalContext().getApplicationMap().get("venteBean");
                Medicament med=(new MedicamentDao()).findByPk(Integer.parseInt(value));
                if(med!=null){
                	
                    return toDto(med);
                } else {
                	return null;
                }
                
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }
        else {
            return null;
        }
    }
 
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((MedicamentDTO) object).getNoMedicament());
        }
        else {
            return null;
        }
    }  
    
    private MedicamentDTO toDto(Medicament med){
    	MedicamentDTO dto=new MedicamentDTO();
        dto.setNoMedicament(med.getNoMedicament());
        dto.setLibelle(med.getLibelle());
        dto.setPrix(med.getPrix());
        dto.setCategorie(med.getCategorie()!=null?med.getCategorie().getLibelle():null);
        dto.setForme(med.getFormeMedicament()!=null?med.getFormeMedicament().getLibelle():null);
        dto.setType(med.getType()!=null?med.getType().getLibelle():null);
        dto.setListe(med.getListe()!=null?med.getListe().getLibelle():null);
        dto.setModeAdmin(med.getModeAdministration()!=null?med.getModeAdministration().getLibelle():null);
        dto.setModeCons(med.getModeConservation()!=null?med.getModeConservation().getLibelle():null);
//        dto.setCategorie(med.getCategorie()==null?med.getCategorie().getLibelle():null);
        
        return dto;
        
    }
}
