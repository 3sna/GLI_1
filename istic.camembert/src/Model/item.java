package Model;

public class item {
	String intitulate;
	String Description;
	int Value;
	public item(String intitulate, String description, int value) {
		super();
		this.intitulate = intitulate;
		Description = description;
		Value = value;
	}
	public String getIntitulate() {
		return intitulate;
	}
	public void setIntitulate(String intitulate) {
		this.intitulate = intitulate;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getValue() {
		return Value;
	}
	public void setValue(int value) {
		Value = value;
	}
	

}
