package cyberfit.relogo

import repast.simphony.relogo.factories.AbstractReLogoGlobalsAndPanelFactory

public class UserGlobalsAndPanelFactory extends AbstractReLogoGlobalsAndPanelFactory{
	public void addGlobalsAndPanelComponents(){
		
		
		addChooserWL("team1Deploy", "CPT 1 Deployment", ["N","T","M1","M2","M3","M4","M5","M6","M7","M8","M9"], 0)
		addChooserWL("team2Deploy", "CPT 2 Deployment", ["N","T","M1","M2","M3","M4","M5","M6","M7","M8","M9"], 0)
		addChooserWL("team3Deploy", "CPT 3 Deployment", ["N","T","M1","M2","M3","M4","M5","M6","M7","M8","M9"], 0)
		addChooserWL("team4Deploy", "CPT 4 Deployment", ["N","T","M1","M2","M3","M4","M5","M6","M7","M8","M9"], 0)

		addChooserWL("mission1Select", "Mission 1 Load", ["Op1","Op2","Op3"], 0)
		
		/**
		 * Place custom panels and globals below, for example:
		 * 
	        addGlobal("globalVariable1")	// Globally accessible variable ( variable name)
	        // Slider with label ( variable name, slider label, minimum value, increment, maximum value, initial value )
	        addSliderWL("sliderVariable", "Slider Variable", 0, 1, 10, 5)
	        // Slider without label ( variable name, minimum value, increment, maximum value, initial value )
	        addSlider("sliderVariable2", 0.2, 0.1, 0.8, 0.5)
	        // Chooser with label  ( variable name, chooser label, list of choices , zero-based index of initial value )
	        addChooserWL("chooserVariable", "Chooser Variable", ["yes","no","maybe"], 2)
	        // Chooser without label  ( variable name, list of choices , zero-based index of initial value )
	        addChooser("chooserVariable2", [1, 66, "seven"], 0)
	        // State change button (method name in observer)
	        addStateChangeButton("change")
	        // State change button with label (method name in observer, label)
	        addStateChangeButtonWL("changeSomething","Change Something")
	        
		 */
	}
}