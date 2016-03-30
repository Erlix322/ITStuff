package Controller;

import ViewFactory.SuperView;
import ViewFactory.ViewFactory;

public class ProxyController implements SuperView{

	ViewFactory fc;
	
	@Override
	public void setParent(ViewFactory fac) {
		fc = fac;
		
	}

}
