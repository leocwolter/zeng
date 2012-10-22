package br.com.zeng.model.action;


public class AddAction implements ActionType{

	private final Modifiable destination;

	public AddAction(Modifiable destination) {
		this.destination = destination;
	}

	public String getActionText() {
		return "added to '"+destination.getName()+"'";
	}

}
