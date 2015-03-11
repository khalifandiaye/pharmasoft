package fr.mmm.pharmaware.dao;

public class Daos {
	
	private CommandeDao commandeDao;
	
	private TypeMedicamentDao typeMedicamentDao;
	
	private EmployeDao employeDao;
	
	private StockDao stockDao;
	
	private MedicamentDao medicamentDao;

	public Daos() {
		super();
		
	}

	public CommandeDao getCommandeDao() {
		return commandeDao;
	}

	public void setCommandeDao(CommandeDao commandeDao) {
		this.commandeDao = commandeDao;
	}

	public TypeMedicamentDao getTypeMedicamentDao() {
		return typeMedicamentDao;
	}

	public void setTypeMedicamentDao(TypeMedicamentDao typeMedicamentDao) {
		this.typeMedicamentDao = typeMedicamentDao;
	}

	public EmployeDao getEmployeDao() {
		return employeDao;
	}

	public void setEmployeDao(EmployeDao employeDao) {
		this.employeDao = employeDao;
	}

	public StockDao getStockDao() {
		return stockDao;
	}

	public void setStockDao(StockDao stockDao) {
		this.stockDao = stockDao;
	}

	public MedicamentDao getMedicamentDao() {
		return medicamentDao;
	}

	public void setMedicamentDao(MedicamentDao medicamentDao) {
		this.medicamentDao = medicamentDao;
	}
	
	
	
	
	
	

}
