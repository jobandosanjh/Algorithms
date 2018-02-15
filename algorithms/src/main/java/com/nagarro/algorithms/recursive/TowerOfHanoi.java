package com.nagarro.algorithms.recursive;

public final class TowerOfHanoi {

	public static void main(String[] args) {
		final TowerOfHanoi towerOfHanoi = new TowerOfHanoi();
		towerOfHanoi.TowersOfHanoi(3, 'S', 'D', 'A');
	}

	public void TowersOfHanoi(final int n, final char source,
			final char destination, final char auxiliary) {
		if (n == 1) {
			System.out.println("Move 1 disk from " + source + " to "
					+ destination);
			return;
		}
		TowersOfHanoi(n - 1, source, auxiliary, destination);
		System.out.println("Move disk from " + source + " to " + destination);
		TowersOfHanoi(n - 1, auxiliary, destination, source);
	}
}
