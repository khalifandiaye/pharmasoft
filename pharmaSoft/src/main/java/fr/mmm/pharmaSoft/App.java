package fr.mmm.pharmaSoft;

import fr.mmm.pharmaSoft.dao.TypeMedicamentDao;
import fr.mmm.pharmaSoft.entity.TypeMedicament;
import fr.mmm.pharmaSoft.views.ListeTypeMedicamentFenetre;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
//        TypeMedicamentDao typeDao= new TypeMedicamentDao();
//        TypeMedicament typeMed= new TypeMedicament();
//        typeMed.setLibelle("Gellule");
//        typeDao.create(typeMed);
//         MedicamentDao dao= new MedicamentDao();
//        Medicament med = new Medicament();
//        med.setNoMedicament(1);
//       med.setCode("gg");
//       med.setPrix(20.3);
//        med.setType(typeMed);
//        dao.create(med);
//         EmployeDao empDao=new EmployeDao();
//         Employe emp=new Employe();
//         emp.setNoEmploye(1);
//         emp.setNom("pierre");
//         emp.setPrenom("Legral");
//         empDao.create(emp);
////        List<Employe> employes = empDao.findAll();
//        //List<Medicament> results = dao.findAll();
//        Commande commande = new Commande();
//        commande.setDateCommande(new Date());
//        commande.setValide(true);
//        commande.addMedicament(med);
//        commande.setVendeur(emp);
//        CommandeDao comDao = new CommandeDao();
//        comDao.create(commande);
//        
//        List<Commande> commandes = comDao.findAll();
//        System.out.println(commandes);
    	
    	//TypeMedicamentFenetre frame = new TypeMedicamentFenetre();
    	 TypeMedicamentDao typeDao= new TypeMedicamentDao();
       TypeMedicament typeMed= new TypeMedicament();
       typeMed.setLibelle("Type 556");
       typeDao.create(typeMed);
    	ListeTypeMedicamentFenetre frame = new ListeTypeMedicamentFenetre();
    	frame.setVisible(true);
    }
}
