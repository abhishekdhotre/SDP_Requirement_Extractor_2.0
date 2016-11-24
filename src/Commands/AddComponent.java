package Commands;

import compoiste.CompositeComponent;
import BusinessObjects.Action;
import BusinessObjects.BusinessProcess;
import BusinessObjects.Repository;
import BusinessObjects.RequirementComponent;
import BusinessObjects.Step;

public class AddComponent extends ListCommand {
	RequirementComponent parent;
	RequirementComponent child;
	int index;
	
	public AddComponent(RequirementComponent parent,RequirementComponent child,int index) {
		this.parent=parent;
		this.child=child;
		this.index = index;
	}
	
	@Override
	public Object execute()
	{	
		
		if(parent instanceof CompositeComponent ){
			((CompositeComponent) parent).addChildAt(index, child);
			return true;
		}
		
		return false;
	}

	@Override
	public Object undoExecute(){
		if(parent instanceof CompositeComponent ){
			((CompositeComponent) parent).remove(index);
			return true;
		}
		
		return false;
	}
}