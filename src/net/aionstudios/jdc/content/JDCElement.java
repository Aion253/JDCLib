package net.aionstudios.jdc.content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A primitive document object used to generate JDC page content.
 * @author Winter Roberts
 */
public class JDCElement {
	
	private String type = "";
	private String text = "";
	private Map<String, String> attributes = new HashMap<String, String>();
	private List<JDCElement> children = new ArrayList<JDCElement>();
	
	/**
	 * Creates a new JDC Element with the named tag type.
	 * @param type The type of this tag (div - <div>), etc.
	 */
	public JDCElement(String type) {
		this.type = type;
	}
	
	/**
	 * Sets the value of the named tag attribute.
	 * @param attr The attribute name to be assigned.
	 * @param values The value to be assigned for the named attribute.
	 * @return This JDC Element.
	 */
	public JDCElement setAttribute(String attr, String values) {
		attributes.remove(attr);
		attributes.put(attr, values);
		return this;
	}
	
	/**
	 * Adds a child JDC Element, nested, with this as its parent.
	 * @param childElement The JDC Element to be added as this one's child.
	 * @return This JDC Element.
	 */
	public JDCElement addChild(JDCElement childElement) {
		children.add(childElement);
		return this;
	}
	
	/**
	 * Sets the internal text of this JDC Element.
	 * @param text The text to be written, outside of other tags, in this element.
	 * @return This JDC Element.
	 */
	public JDCElement setText(String text) {
		this.text = text;
		return this;
	}
	
	/**
	 * Changes the tag type of this JDC Element.
	 * @param type The type of this element.
	 * @return This JDC Element.
	 */
	public JDCElement setType(String type) {
		this.type = type;
		return this;
	}
	
	/**
	 * Creates and returns the html representation of this element and its nested children.
	 * @return The html string for this element.
	 */
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
