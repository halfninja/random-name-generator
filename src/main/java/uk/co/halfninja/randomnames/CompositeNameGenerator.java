package uk.co.halfninja.randomnames;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A NameGenerator that picks between a list of delegate generators.
 * It is immutable so you create an empty one with newGenerator and
 * then build a list of generators using withGenerator(), which
 * returns a fresh generator each time.
 */
public class CompositeNameGenerator implements NameGenerator {

	private final List<Entry> entries;
	private final int totalWeighting;
	
	private static class Entry {
		@SuppressWarnings("unused")
		public final String id;
		public final NameGenerator generator;
		public final int weighting;
		public Entry(String id, NameGenerator generator, int weighting) {
			this.id = id;
			this.generator = generator;
			this.weighting = weighting;
		}
	}
	
	/**
	 * Pick a random NameGenerator from the possible ones, weighted by
	 * their weighting.
	 */
	private NameGenerator pickGenerator() {
		int choice = Randomness.random.nextInt(totalWeighting);
		for (Entry entry : entries) {
			if (choice < entry.weighting) {
				return entry.generator;
			} else {
				choice -= entry.weighting;
			}
		}
		throw new IllegalStateException("Bug in weight calculations");
	}
	
	@Override
	public Name generate(Gender gender) {
		return pickGenerator().generate(gender);
	}

	@Override
	public Name generate(Gender gender, Name mother, Name father) {
		return pickGenerator().generate(gender, mother, father);
	}
	
	private CompositeNameGenerator() {
		this(Collections.<Entry>emptyList(), 0);
	}
	
	public CompositeNameGenerator(List<Entry> newEntries, int totalWeighting) {
		this.entries = newEntries;
		this.totalWeighting = totalWeighting;
	}

	public static CompositeNameGenerator newGenerator() {
		return new CompositeNameGenerator();
	}

	public CompositeNameGenerator withGenerator(String string,
			NameGenerator generator, int weight) {
		if (weight < 1) throw new IllegalArgumentException("Weight must be at least 1");
		List<Entry> newEntries = new ArrayList<Entry>(entries);
		newEntries.add(new Entry(string, generator, weight));
		return new CompositeNameGenerator(newEntries, totalWeighting + weight);
	}

}
