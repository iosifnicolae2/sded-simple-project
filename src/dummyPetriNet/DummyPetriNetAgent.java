package dummyPetriNet;

import ro.tarnauca.mdplus.petrinetexec.core.PetriNet;
import ro.tarnauca.mdplus.petrinetexec.core.PetriNetEventGenerator;

public class DummyPetriNetAgent {	

	DummyContext context;
	public PetriNet myPetriNet = new PetriNet("Agent_Petri_Net", PetriNet.Capacity.FINITE);
	public PetriNetEventGenerator eventGeneratorA = new PetriNetEventGenerator();
	
	// declara pozitii si tranzitii

	public DummyPetriNetAgent(DummyContext context){

		this.context = context;
		
		// adauga pozitiile si tranzitiile retelei petri
		try {
			
		// "traseaza" arcele	
		} catch (Exception e) {
			e.printStackTrace();
		}	

		// declara si atribuie callback-uri

	}	
	
		public void step(){
			eventGeneratorA.addObserver(myPetriNet.getEventObserver());
			
			//executa tranzitii
		}
}
