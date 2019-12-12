package net.aionstudios.jdc.content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The root element for JDC tag processing, it prevents the application from modifying elements out of scope.
 * @author Winter Roberts
 */
public class JDCHeadElement {
	
	private String text = "";
	private String predefinedElements = "";
	private Map<String, String> attributes = new HashMap<String, String>();
	private List<JDCElement> children = new ArrayList<JDCElement>();
	
	/**
	 * Creates a JDC Head Element.
	 * @param predefined The predefined tag name for this element.
	 */
	public JDCHeadElement(String predefined) {
		predefinedElements = predefined != null && predefined.length()>1 ? predefined : "";
	}
	
	/**
	 * Adds a child JDC Element, nested, with this as its parent.
	 * @param childElement The JDC Element to be added as this one's child.
	 * @return This JDC Head Element.
	 */
	public JDCHeadElement addChild(JDCElement childElement) {
		children.add(childElement);
		return this;
	}
	
	/**
	 * Sets the value of the named tag attribute.
	 * @param attr The attribute name to be assigned.
	 * @param values The value to be assigned for the named attribute.
	 * @return This JDC Head Element.
	 */
	public JDCHeadElement setAttribute(String attr, String values) {
		attributes.remove(attr);
		attributes.put(attr, values);
		return this;
	}
	
	/**
	 * Sets the internal text of this JDC Element.
	 * @param text The text to be written, outside of other tags, in this element.
	 * @return This JDC Element.
	 */
	public JDCHeadElement setText(String text) {
		this.text = text;
		return this;
	}
	
	/**
	 * Creates and returns the html representation of this element and its nested children.
	 * @return The html string for this element.
	 */
	public String makeString() {
		StringBuilder make = new StringBuilder();
		make.append(predefinedElements);
		make.append(text);
		for(JDCElement e:children) {
			make.append(e.makeString());
		}
		return make.toString();
	}
	
	/**
	 * @return The attributes assigned for this element.
	 */
	public Map<String, String> getAttributes() {
		return attributes;
	}

}
