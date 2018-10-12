package net.aionstudios.jdc.content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDCHeadElement {
	
	private String text;
	private List<JDCElement> children = new ArrayList<JDCElement>();
	
	public JDCHeadElement() {
		
	}
	
	public JDCHeadElement addChild(JDCElement childElement) {
		children.add(childElement);
		return this;
	}
	
	public JDCHeadElement setText(String text) {
		this.text = text;
		return this;
	}
	
	public String makeString() {
		StringBuilder make = new StringBuilder();
		make.append(text);
		for(JDCElement e:children) {
			make.append(e.makeString());
		}
		return make.toString();
	}

}
