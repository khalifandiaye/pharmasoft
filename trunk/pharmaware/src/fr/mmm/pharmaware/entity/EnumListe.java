package fr.mmm.pharmaware.entity;

public enum EnumListe {
	
	LISTE1,
	LISTE2,
	LISTE3,
	NONLISTES;
	
	public static EnumListe[] getListes(){
		return EnumListe.values();
	}

}
