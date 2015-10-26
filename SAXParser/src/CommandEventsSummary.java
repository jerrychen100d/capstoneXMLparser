import java.util.ArrayList;
import java.util.List;

public class CommandEventsSummary {
	private List<GroupCommandEvents> commandSummary = new ArrayList<GroupCommandEvents>();
	
	public CommandEventsSummary(){
		
	}
	
	public void add(GroupCommandEvents gce){
		commandSummary.add(gce);
	}
	
	public Integer size(){return commandSummary.size();}
	
	@Override
	public String toString() {
		String info = "";
		
		for(GroupCommandEvents event : commandSummary){
			info += event.toString();
		}
		
		return info;
	}
}
