
class SingleCommandEvent {
	private String commandID;
	private String command;
	private String count;
	
	public SingleCommandEvent(String commandID, String command, String count){
		this.commandID = commandID;
		this.command = command;
		this.count = count;
	}
	
	public void setAll(String commandID, String command, String count){
		this.commandID = commandID;
		this.command = command;
		this.count = count;
	}
	
	public void setCommandId(String commandId){
		this.commandID = commandId;
	}
	
	public void setCommand(String command){
		this.command = command;
	}
	
	public void setCount(String count){
		this.count = count;
	}
	
	@Override
	public String toString() {
		return 	"CommandID: " + commandID + "\n" +
				"Command: " + command + "\n" +
				"Count: " + count + "\n";
	}
}
