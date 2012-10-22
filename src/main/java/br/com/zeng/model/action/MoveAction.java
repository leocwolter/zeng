package br.com.zeng.model.action;


public class MoveAction implements ActionType{
	private final Wrapper destination;
	
	public MoveAction(Wrapper destination) {
		this.destination = destination;
	}
	
	public String getActionText(){
		return "moved to the "+destination.getClass().getSimpleName()+" '"+destination.getName()+"'";
	}

}
