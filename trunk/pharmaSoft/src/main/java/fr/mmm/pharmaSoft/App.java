package fr.mmm.pharmaSoft;

import java.util.Date;
import java.util.List;

import fr.mmm.pharmaSoft.dao.CommandeDao;
import fr.mmm.pharmaSoft.dao.EmployeDao;
import fr.mmm.pharmaSoft.dao.MedicamentDao;
import fr.mmm.pharmaSoft.dao.TypeMedicamentDao;
import fr.mmm.pharmaSoft.entity.Commande;
import fr.mmm.pharmaSoft.entity.Employe;
import fr.mmm.pharmaSoft.entity.Medicament;
import fr.mmm.pharmaSoft.entity.TypeMedicament;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        TypeMedicamentDao typeDao= new TypeMedicamentDao();
        TypeMedicament typeMed= new TypeMedicament();
        typeMed.setLibelle("Gellule");
        typeDao.create(typeMed);
         MedicamentDao dao= new MedicamentDao();
        Medicament med = new Medicament();
        med.setNoMedicament(1);
       med.setCode("gg");
       med.setPrix(20.3);
        med.setType(typeMed);
        dao.create(med);
         EmployeDao empDao=new EmployeDao();
         Employe emp=new Employe();
         emp.setNoEmploye(1);
         emp.setNom("pierre");
         emp.setPrenom("Legral");
         empDao.create(emp);
//        List<Employe> employes = empDao.findAll();
        //List<Medicament> results = dao.findAll();
        Commande commande = new Commande();
        commande.setDateCommande(new Date());
        commande.setValide(true);
        commande.addMedicament(med);
        commande.setVendeur(emp);
        CommandeDao comDao = new CommandeDao();
        comDao.create(commande);
        
        List<Commande> commandes = comDao.findAll();
        System.out.println(commandes);
    }
}
