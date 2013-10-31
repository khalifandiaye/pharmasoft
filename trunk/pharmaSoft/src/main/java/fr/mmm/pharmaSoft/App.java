package fr.mmm.pharmaSoft;

import java.util.List;

import fr.mmm.pharmaSoft.dao.MedicamentDao;
import fr.mmm.pharmaSoft.entity.Medicament;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
         MedicamentDao dao= new MedicamentDao();
//        Medicament med = new Medicament("effaralgan",23.0,"ee"," description");
//        Medicament med1 = new Medicament("gddb",458.0,"ee"," description 1");
//       med1.setMedicamentId(9);
//        dao.create(med1);
//        dao.create(med);
        
        List<Medicament> results = dao.findAll();
        System.out.println(results);
    }
}
