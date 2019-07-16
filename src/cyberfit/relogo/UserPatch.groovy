package cyberfit.relogo

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import repast.simphony.relogo.Stop;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG;
import repast.simphony.relogo.ast.Diffusible;
import repast.simphony.relogo.schedule.Go;
import repast.simphony.relogo.schedule.Setup;
import cyberfit.ReLogoPatch;

class UserPatch extends ReLogoPatch{
	
	def recolorPatch(){
		//pcolor = scaleColor(green(),zombieSignal,0.01, 1)
		//pcolor = white()
		pcolor = 121
	}
}