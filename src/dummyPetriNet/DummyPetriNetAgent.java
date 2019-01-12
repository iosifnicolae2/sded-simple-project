package dummyPetriNet;

import ro.tarnauca.mdplus.petrinetexec.core.*;

public class DummyPetriNetAgent {	

	DummyContext context;
	public PetriNet myPetriNet = new PetriNet("Agent_Petri_Net", PetriNet.Capacity.FINITE);
	public PetriNetEventGenerator eventGeneratorA = new PetriNetEventGenerator();
	
	// declara pozitii si tranzitii\
	String P1 = "P1";
	String P2 = "P2";
	String P3 = "P3";
	String P4 = "P4";
	String T1 = "T1";
	String T2 = "T2";
	String T3 = "T3";
	String T4 = "T4";

	public DummyPetriNetAgent(DummyContext context){

		this.context = context;
		
		// adauga pozitiile si tranzitiile retelei petri
		myPetriNet.addPlace(P1, P1, 1);
		myPetriNet.addPlace(P2, P2, 1);
		myPetriNet.addPlace(P3, P3, 0);
		myPetriNet.addPlace(P4, P4, 2);
		
		myPetriNet.addTransition(T1, T1, Transition.TransitionType.NORMAL);
		myPetriNet.addTransition(T2, T2, Transition.TransitionType.NORMAL);
		myPetriNet.addTransition(T3, T3, Transition.TransitionType.NORMAL);
		myPetriNet.addTransition(T4, T4, Transition.TransitionType.NORMAL);
		
		try {
			//
			// "traseaza" arcele
			myPetriNet.retrievePlace(P1).connectToOutputTransition(
					myPetriNet.retrieveTransition(T1), // transition
					"p1 to t1", // arcStringID
					"p1-t1", // arcLabel
					1 // arcWeight
			);
			myPetriNet.retrievePlace(P1).connectToOutputTransition(
					myPetriNet.retrieveTransition(T2), // transition
					"p1 to t2", // arcStringID
					"p1-t2", // arcLabel
					1 // arcWeight
			);

			myPetriNet.retrievePlace(P2).connectToOutputTransition(
					myPetriNet.retrieveTransition(T3), // transition
					"p2 to t3", // arcStringID
					"p2-t3", // arcLabel
					1 // arcWeight
			);
			myPetriNet.retrievePlace(P2).connectToOutputTransition(
					myPetriNet.retrieveTransition(T4), // transition
					"p2 to t4", // arcStringID
					"p2-t4", // arcLabel
					1 // arcWeight
			);
			myPetriNet.retrievePlace(P3).connectToOutputTransition(
					myPetriNet.retrieveTransition(T2), // transition
					"p3 to t2", // arcStringID
					"p3-t2", // arcLabel
					1 // arcWeight
			);
			myPetriNet.retrievePlace(P4).connectToOutputTransition(
					myPetriNet.retrieveTransition(T3), // transition
					"p4 to t3", // arcStringID
					"p4-t3", // arcLabel
					1 // arcWeight
			);
			
	
			myPetriNet.retrieveTransition(T1).connectToOutputPlace(
					myPetriNet.retrievePlace(P1), // place
					"t1 to p1", // arcStringID
					"t1-p1", // arcLabel
					1 // arcWeight
			);
			myPetriNet.retrieveTransition(T1).connectToOutputPlace(
					myPetriNet.retrievePlace(P2), // place
					"t1 to p2", // arcStringID
					"t1-p2", // arcLabel
					2 // arcWeight
			);
			myPetriNet.retrieveTransition(T1).connectToOutputPlace(
					myPetriNet.retrievePlace(P3), // place
					"t1 to p3", // arcStringID
					"t1-p3", // arcLabel
					1 // arcWeight
			);
			myPetriNet.retrieveTransition(T2).connectToOutputPlace(
					myPetriNet.retrievePlace(P4), // place
					"t2 to p4", // arcStringID
					"t2-p4", // arcLabel
					1 // arcWeight
			);
			myPetriNet.retrieveTransition(T3).connectToOutputPlace(
					myPetriNet.retrievePlace(P1), // place
					"t3 to p1", // arcStringID
					"t3-p1", // arcLabel
					1 // arcWeight
			);
			myPetriNet.retrieveTransition(T4).connectToOutputPlace(
					myPetriNet.retrievePlace(P3), // place
					"t4 to p3", // arcStringID
					"t4-p3", // arcLabel
					1 // arcWeight
			);


            // declara si atribuie callback-uri
            myPetriNet.retrieveTransition(T2).createTransitionCallback(new TransitionActionCallback() {

                @Override
                protected void callback(PetriNet arg0) {
                    System.out.println("S-a executat tranzitia t2.");

                }
            });

            PlaceActionCallback callback = new PlaceActionCallback() {

                @Override
                protected void callback(PetriNet arg0, Place arg1) {
                    System.out.println("S-a modificat marcajul pozitiei p4");

                }
            };

            myPetriNet.retrievePlace(P4).createActivePlaceCallback(1, callback);
            myPetriNet.retrievePlace(P4).createInactivePlaceCallback(1, callback);

        } catch (Exception e) {
			e.printStackTrace();
		}	


	}	
	
		public void step(){
			eventGeneratorA.addObserver(myPetriNet.getEventObserver());
			
			//executa tranzitii
            eventGeneratorA.pushEvent(T1, 100L);
            eventGeneratorA.pushEvent(T2, 200L);
            eventGeneratorA.pushEvent(T3, 300L);
            eventGeneratorA.pushEvent(T3, 400L);
            eventGeneratorA.pushEvent(T3, 500L);
		}
}
