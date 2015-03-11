package fr.mmm.pharmaware.commun;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@ManagedBean(name = "genericSecuredConverter")
@ViewScoped
public class GenericSecuredConverter implements Converter, Serializable {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 3803943180209244553L;
	private Map <UUID, Object> temporaryStore = new HashMap <UUID, Object> ();
 
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return temporaryStore.get(UUID.fromString(value));
    }
 
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        UUID id = UUID.randomUUID();
        temporaryStore.put(id, value);
        return id.toString();
    }
}
