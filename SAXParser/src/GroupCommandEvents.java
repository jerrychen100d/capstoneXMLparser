import java.util.ArrayList;
import java.util.List;

public class GroupCommandEvents {
	private List<SingleCommandEvent> commandGroup = new ArrayList<SingleCommandEvent>();
	private String date;
	
	public GroupCommandEvents(String date){
		this.date = date;
	}
	
	public void add(SingleCommandEvent sce){
		commandGroup.add(sce);
	}
	
	public void setDate(String date){
		this.date = date;
	}
	
	public String getDate(){
		return date;
	}
	
	@Override
	public String toString() {
		String info = "Usage Date: " + date +"\n";
		
		for(SingleCommandEvent commEvent : commandGroup){
			info += commEvent.toString();
			info += "\n";
		}
		
		return info;
	}
}
