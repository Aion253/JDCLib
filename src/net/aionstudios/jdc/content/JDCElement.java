package net.aionstudios.jdc.content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDCElement {
	
	private String type = "";
	private String text = "";
	private Map<String, String> attributes = new HashMap<String, String>();
	private List<JDCElement> children = new ArrayList<JDCElement>();
	
	public JDCElement(String type) {
		this.type = type;
	}
	
	public JDCElement setAttribute(String attr, String values) {
		attributes.remove(attr);
		attributes.put(attr, values);
		return this;
	}
	
	public JDCElement addChild(JDCElement childElement) {
		children.add(childElement);
		return this;
	}
	
	public JDCElement setText(String text) {
		this.text = text;
		return this;
	}
	
	public JDCElement setType(String type) {
		this.type = type;
		return this;
	}
	
	public String makeString() {
		StringBuilder make = new StringBuilder();
		make.append("<"+type+" ");
		for(int i = 0; i < attributes.size(); i++) {
			if(attributes.get(attributes.keySet().toArray()[i]) != null) {
				make.append(attributes.keySet().toArray()[i] + "=\"" + attributes.get(attributes.keySet().toArray()[i]) + "\" ");
			} else {
				make.append(attributes.keySet().toArray()[i]+" ");
			}
		}
		make.append(">"+text);
		for(JDCElement e:children) {
			make.append(e.makeString());
		}
		make.append("</"+type+">");
		return make.toString();
	}

}
