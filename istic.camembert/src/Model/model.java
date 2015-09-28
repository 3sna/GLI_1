package Model;

import java.util.ArrayList;

public class model implements intModel{

	String titre;
	ArrayList<item> items;
	
	public model(String titre) {
		super();
		this.titre = titre;
		this.items = new ArrayList<item>();
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public ArrayList<item> getItems() {
		return items;
	}
	public void setItems(ArrayList<item> items) {
		this.items = items;
	}
	@Override
	public void addItems(item it){
		getItems().add(it);
	}
	@Override
	public Boolean deleteItem(item it) {
		return getItems().remove(it);
	}
	@Override
	public void modify(item it) {
		//
	}
	public int total_items(){
		int somme=0;
		for(item e : getItems()){
			somme+=e.Value;
		}
		return somme;
	}
}
