package cyberfit.relogo

import static repast.simphony.relogo.Utility.*
import static repast.simphony.relogo.UtilityG.*

import cyberfit.ReLogoTurtle
import repast.simphony.relogo.Plural
import repast.simphony.relogo.Stop
import repast.simphony.relogo.Utility
import repast.simphony.relogo.UtilityG
import repast.simphony.relogo.schedule.Go
import repast.simphony.relogo.schedule.Setup

class Attacker extends UserTurtle {
	
	def tier = 1 // 1 - 6 based on Defense Science Board Report
	
	/* lockheed martin kill chain
	 * 0 = not started
	 * 1 = recon: connect to servers for random interval
	 * 2 = weaponization: connect to nowhere
	 * 3 = delivery
	 * 4 = exploitation
	 * 5 = c+c
	 * 6 = actions
	 * 7 = end
	 * */
	def phase = 0 // 1-7 identifying which phase of kill chain agent is in
	def phasetime = 0	
	def attacks = [] //array of attacks available to the agent
	
	def setup(){
		
	}

	def step() {
		
	   switch (phase) {
	    case 0:
			
			if(random.nextInt(100) > 50) {
				//proceed to phase 1
				phase = 1
			}
			
		break
		case 1:
		
			phasetime = random.nextInt(100)
		
			phase = 2
			print phasetime
		//here
		
		break
		case 2:
		break
		case 3:
		break
		case 4:
		break
		case 5:
		break
		case 6:
		break
	   }
	   
	   if(phasetime > 0)
		   phasetime = phasetime - 1
	   
	   print phasetime
	}
}
