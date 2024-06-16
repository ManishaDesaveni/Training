package com.example.Mockito.bussiness;

public class Businessimp {

	public Businessimp(Dataservice dataservice) {
		super();
		this.dataservice = dataservice;
	}

	private Dataservice dataservice;

	public int findgreater() {
		int data[] = dataservice.retrievedata();
		int larger = Integer.MIN_VALUE;
		for (int num : data) {
			if (num > larger) {
				larger = num;
			}
		}
		return larger;
	}

}

interface Dataservice {
	int[] retrievedata();
}
