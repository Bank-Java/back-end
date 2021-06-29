package models;

public abstract class Comprovante 
{
	private StringBuilder msg;

	public String getMsg() {
		return msg.toString();
	}
	public void setMsg(StringBuilder msg) {
		this.msg = msg;
	}
	
	public abstract String toString();
}
