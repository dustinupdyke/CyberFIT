package cyberfit.relogo

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import repast.simphony.relogo.Stop;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG;
import repast.simphony.relogo.schedule.Go;
import repast.simphony.relogo.schedule.Setup;
import cyberfit.ReLogoObserver;

class UserObserver extends ReLogoObserver{

	@Setup
	def setup(){
		print "setup"
		
		clearAll()
		
		setDefaultShape(Terrain,"box")
		loadBaseTerrain()
		
//		loadMissions()
	}
	
	@Go
	def go(){
		//print team1Deploy
		
		//DIE first
		ask(interactionFTs()) {
			step()
		}
		
		ask(interactionTTs()) {
			step()
		}
		
		ask(interactionFFs()) {
			step()
		}
		
		
		//then actions
		ask(terrains()) {
			step()
		}
		
		ask(defenders()) {
			step()
		}
		
		ask(attackers()) {
			step()
		}
		
		ask(friendlys()) {
			step()
		}
		
		
	}
	
	def loadBaseTerrain(){
		createTerrains(5){ [setxy(0,-200), setColor(brown())] }
		
		createDefenders(5){ [setxy(0,200), setColor(green())] }
		
		
		
	}
}

	