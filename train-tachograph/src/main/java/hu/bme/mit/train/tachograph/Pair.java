package hu.bme.mit.train.tachograph;

import java.util.Objects;

public class Pair implements Comparable<Pair> {
	private Double val1;
	private Double val2;
	Pair(Double val1, Double val2) {
		this.val1 = val1;
		this.val2 = val2;
	}

	@Override
	public boolean equals(Object obj) {
		var other = (Pair) obj;
		return val1.equals(other.val1) && val2.equals(other.val2);
	}

	@Override
	public int compareTo(Pair other) {
		if (val1.compareTo(other.val1) == 0) {
			return val2.compareTo(other.val2);
		}
		return val1.compareTo(other.val1);
	}
}
