package uk.co.halfninja.randomnames;

import static java.util.Collections.*;

import java.util.Collections;
import java.util.List;

public class Name {
	private final String givenName;
	private final String familyName;
	private final List<String> middleNames;
	private final String quotedName;
	
	private String string;
	
	public Name(String givenName, String familyName, List<String> middleNames, String quotedName) {
		this.givenName = givenName;
		this.familyName = familyName;
		this.middleNames = middleNames;
		this.quotedName = quotedName;
	}
	public Name(String givenName, String familyName) {
		this(givenName, familyName, Collections.<String>emptyList(), null);
	}
	public String getGivenName() {
		return givenName;
	}
	public String getFamilyName() {
		return familyName;
	}
	public List<String> getMiddleNames() {
		return unmodifiableList(middleNames);
	}
	public String getQuotedName() {
		return quotedName;
	}
	public String toString() {
		if (string == null) {
			StringBuilder sb = new StringBuilder();
			sb.append(givenName);
			boolean addSpace = true;
			if (quotedName != null) {
				sb.append(" \"").append(quotedName).append('"');
			}
			for (String middle : middleNames) {
				sb.append(middle).append(' ');
				addSpace = false;
			}
			if (addSpace) sb.append(' ');
			sb.append(familyName);
			string = sb.toString();
		}
		return string;
	}
}
