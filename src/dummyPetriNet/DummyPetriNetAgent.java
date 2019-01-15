package dummyPetriNet;

import ro.tarnauca.mdplus.petrinetexec.core.*;

public class DummyPetriNetAgent {	

	DummyContext context;
	public PetriNet myPetriNet = new PetriNet("Agent_Petri_Net", PetriNet.Capacity.FINITE);
	public PetriNetEventGenerator eventGeneratorA = new PetriNetEventGenerator();
	
	// declara pozitii si tranzitii

	public DummyPetriNetAgent(DummyContext context){

		this.context = context;
		
		// adauga pozitiile si tranzitiile retelei petri
		
		try {
			//
			// "traseaza" arcele

            // declara si atribuie callback-uri

        } catch (Exception e) {
			e.printStackTrace();
		}	


	}	
	
		public void step(){
			eventGeneratorA.addObserver(myPetriNet.getEventObserver());
			
			// executa tranzitii
			// execute active places
		}
}
