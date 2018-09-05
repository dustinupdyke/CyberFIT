package cyberfit.relogo

import repast.simphony.relogo.factories.AbstractReLogoGlobalsAndPanelFactory

public class UserGlobalsAndPanelFactory extends AbstractReLogoGlobalsAndPanelFactory{
	public void addGlobalsAndPanelComponents(){
		
		addGlobal("CPTsReady", 0)
		
		addChooserWL("team1Deploy", "CPT 1 Deployment", ["N","T","M1","M2","M3","M4","M5","M6","M7","M8","M9"], 0)
		addChooserWL("team2Deploy", "CPT 2 Deployment", ["N","T","M1","M2","M3","M4","M5","M6","M7","M8","M9"], 0)
		addChooserWL("team3Deploy", "CPT 3 Deployment", ["N","T","M1","M2","M3","M4","M5","M6","M7","M8","M9"], 0)
		addChooserWL("team4Deploy", "CPT 4 Deployment", ["N","T","M1","M2","M3","M4","M5","M6","M7","M8","M9"], 0)

		addChooserWL("mission1Select", "Mission 1 Load", ["Op1","Op2","Op3"], 0)
		
	}
}