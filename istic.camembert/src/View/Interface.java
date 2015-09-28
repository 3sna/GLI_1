package View;


import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import Model.*;

public class Interface implements Observer{

	/*
	 * Initialization of views
	 *  
	 */
	static ModelAdapter model;
	
	/**
	 * @param args
	 */
	public Interface() {
		// TODO Auto-generated method stub
		model=new ModelAdapter(new model("Camembert"));
		model.mod.getItems().add(new item("toto","toto",900));
		model.mod.getItems().add(new item("toti","toti",40));
		model.mod.getItems().add(new item("toti","toti",110));
		model.mod.getItems().add(new item("toti","toti",810));
		Composant compos=new Composant(model);
		compos.Draw_titre(model.mod.getTitre());
		compos.repaint();
		JFrame frame=new JFrame("Camembert");
		frame.getContentPane().add(compos);
		frame.pack();
		frame.setSize(500, 500);
		frame.setVisible(true);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
	
		
	}

}
