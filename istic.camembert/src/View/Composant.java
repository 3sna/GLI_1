package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JComponent;

import Model.ModelAdapter;
import Model.item;

public class Composant extends JComponent{
		Graphics2D g2d;
		Dimension d;
		String titre="";
		ModelAdapter adapter;
		ArrayList<Arc2D.Double> items=new ArrayList<Arc2D.Double>();
		ArrayList<Line2D.Double> lines=new ArrayList<Line2D.Double>();

		public Composant(ModelAdapter adapter){
			this.adapter=adapter;
		}
		@Override
		public void paintComponent(Graphics g){
			super.paintComponents(g);
			g2d = (Graphics2D) g;			
			d=getSize();
			/*g2d.setColor(Color.GRAY);
			g2d.fillArc(d.width/2-75, d.height/2-75, 250, 250, 0, 30);
			g2d.setColor(Color.GREEN);
			g2d.fillArc(d.width/2-50, d.height/2-50, 200, 200, 30, 120);
			g2d.setColor(Color.RED);
			g2d.fillArc(d.width/2-50, d.height/2-50, 200, 200, 120+90, 150);*/
			Arc2D arc=new Arc2D.Double(0, 0,
                    200,
                    200,
                    90, 135,
                    Arc2D.OPEN);
			Draw_items(arc);
			g2d.setColor(Color.WHITE);
			g2d.fillOval(d.width/2-25, d.height/2-25, 150, 150);
			g2d.setColor(Color.BLUE);
			g2d.fillOval(d.width/2, d.height/2, 100, 100);	
			g2d.setColor(Color.WHITE);
			g2d.setFont(new Font("Arial",Font.BOLD,10));
			g2d.drawString(titre ,d.width/2+20, d.height/2+40);
			g2d.drawString(adapter.mod.total_items()+" Û",d.width/2+30, d.height/2+60);
			
			
		}

		public void Draw_titre(String titre){
			this.titre=titre;
		}
		private void Draw_items(Arc2D t){
			int total=adapter.mod.total_items();
			int angle=0;
			int index=0;
			int i=0,x2=0,y2=0;
			for(item e : adapter.mod.getItems() ){	
				angle=e.getValue()*360/total;
				
				items.add(new Arc2D.Double(d.width/2-50, d.height/2-50,
	                    200,
	                    200,
	                    index, angle-2,
	                    Arc2D.PIE));
				draw_items_content(i,e);
				g2d.setColor(Color.getHSBColor(123, 123, angle));
				g2d.fill(items.get(i));	
				i++;
				index+=angle;
			}
		}
		
		void draw_items_content(int i,item e){
			Line2D line;
			int x,y,x2,y2,x3,y3;
			x3=d.width/2+50;
			y3=d.height/2+50;
			x2=x3;
			y2=y3;
			x=(int)(items.get(i).getEndPoint().getX()-(items.get(i).getEndPoint().getX()-items.get(i).getStartPoint().getX())/2);
			y=(int)(items.get(i).getEndPoint().getY()-(items.get(i).getEndPoint().getY()-items.get(i).getStartPoint().getY())/2);
			do{
				
			if(x>(d.width/2+50)){
				x2=x-(d.width/2+50);
				System.out.println("x = "+x);
				x2+=x2;
				x=x2+d.width/2+50;
			}
			else{
				x2=-((d.width/2+50)-x);
				System.out.println("x = "+x);
				x2+=x2;
				x2=-x2;
				x=(d.width/2+50)-x2;
			}
			if(y> (d.height/2+50)){
				y2=-(y-(d.height/2+50));
				System.out.println("y = "+y);
				y2+=y2;
				y2=-y2;
				y=y2+d.height/2+50;
			}
			else{
				y2=(d.height/2+50) - y;
				System.out.println("y = "+y);
				y2+=y2;
				y=(d.height/2+50) - y2;
			}
			System.out.println("pow  "+Math.sqrt(Math.pow(x3-x2, 2)+Math.pow(y3-y2, 2)));
			}while(Math.sqrt(Math.pow(x3-x, 2)+Math.pow(y3-y, 2))<140);
			
			lines.add(new Line2D.Double(d.width/2+50, d.height/2+50,x,y));
			line=lines.get(i);
			g2d.setColor(Color.BLUE);
			g2d.fill(line);
			g2d.setColor(Color.black);
			g2d.drawString(e.getIntitulate(), x, y);
		}
}
