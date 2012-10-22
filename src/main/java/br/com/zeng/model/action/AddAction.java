package br.com.zeng.model.action;


public class AddAction implements ActionType{
	private Wrapper destination;

	public AddAction(Wrapper destination) {
		this.destination = destination;
	}

	public String getActionText() {
		return "added to '"+destination.getName()+"'";
	}

}
