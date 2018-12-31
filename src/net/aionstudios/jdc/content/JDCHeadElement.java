package net.aionstudios.jdc.content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDCHeadElement {
	
	private String text = "";
	private String predefinedElements = "";
	private Map<String, String> attributes = new HashMap<String, String>();
	private List<JDCElement> children = new ArrayList<JDCElement>();
	
	public JDCHeadElement(String predefined) {
		predefinedElements = predefined != null && predefined.length()>1 ? predefined : "";
	}
	
	public JDCHeadElement addChild(JDCElement childElement) {
		children.add(childElement);
		return this;
	}
	
	public JDCHeadElement setAttribute(String attr, String values) {
		attributes.remove(attr);
		attributes.put(attr, values);
		return this;
	}
	
	public JDCHeadElement setText(String text) {
		this.text = text;
		return this;
	}
	
	public String makeString() {
		StringBuilder make = new StringBuilder();
		make.append(predefinedElements);
		make.append(text);
		for(JDCElement e:children) {
			make.append(e.makeString());
		}
		return make.toString();
	}
	
	public Map<String, String> getAttributes() {
		return attributes;
	}

}
