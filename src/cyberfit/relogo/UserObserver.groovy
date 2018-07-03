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
		
		// initialize Random.uniform
		Random random = new Random()
				
		clearAll()
		
		setDefaultShape(Terrain,"box")
		setDefaultShape(Defender,"person")
		
		loadBaseTerrain()
		assignCPTs()
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
		
		//Create Routers (type 1)
		createTerrains(1){ [setxy(0,0), setColor(brown()), type = 1] }
		createTerrains(1){ [setxy(1,0), setColor(brown()), type = 1] }
		createTerrains(1){ [setxy(2,0), setColor(brown()), type = 1] }
		createTerrains(1){ [setxy(3,0), setColor(brown()), type = 1] }
				
		//Create Servers (type 2)
		createTerrains(1){ [setxy(-10,-100), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(-8,-100), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(-6,-100), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(-4,-100), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(-2,-100), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(0,-100), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(2,-100), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(4,-100), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(6,-100), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(8,-100), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(10,-100), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(12, -100), setColor(brown()), type = 2] }
		
		//Create Clients (type 3)
	}
	
	def assignCPTs() {
	
		createDefenders(1){ [setxy(0,200), setColor(green())] }
		createDefenders(1){ [setxy(1,200), setColor(green())] }
		createDefenders(1){ [setxy(2,200), setColor(green())] }
		createDefenders(1){ [setxy(3,200), setColor(green())] }
	}
}

	