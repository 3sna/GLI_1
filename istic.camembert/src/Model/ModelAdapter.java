package Model;

import java.util.Observable;

public class ModelAdapter extends Observable implements intModel{
	public model mod;
	
	public ModelAdapter(model mod) {
		super();
		this.mod = mod;
	}

	@Override
	public void addItems(item it) {
		
		mod.addItems(it);
		setChanged();
		notifyObservers();
	}

	@Override
	public Boolean deleteItem(item it) {
		Boolean b = mod.deleteItem(it);
		setChanged();
		notifyObservers();
		return b;
	}

	@Override
	public void modify(item it) {
		// TODO Auto-generated method stub
		
	}

	

}
