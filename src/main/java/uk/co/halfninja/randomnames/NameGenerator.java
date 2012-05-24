package uk.co.halfninja.randomnames;

public interface NameGenerator {
	Name generate(Gender gender);
	Name generate(Gender gender, Name mother, Name father);
}
