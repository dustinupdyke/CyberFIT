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
		
		print phase
	   switch (phase) {
	    case 0:
		//case 0 means the attacker hasn't started, get random and if 50% or better, begin attack, this gives some random delay to starting	
		
			if(random.nextInt(100) > 50) {
				//proceed to phase 1
				phase = 1
			}
			
		break
		case 1:
		/*this is recon phase
		 * every step, the attacker might create an interaction between their attacker machine and one of the terrain type 1 or 2
		 * the phase should run, on average, 80 ticks
		 * wait for at least 20 ticks before proceeding
		 * */
			phasetime = random.nextInt(100)
		
			phase = 2
			print phasetime
		//here
		
		break
		case 2:
		/*this is weaponization phase, attacker will only connect to own attacker machine, as it is being prepped for delivery
		 * phase should run on average 60 ticks
		 * wait for at least 20 ticks before proceeding
		 * */
		break
		case 3:
		/*this is delivery phase
		 * attacker machine will target terrain by type (based on attack type) and create interaction, if that terrain has vul id of one of attacker 
		 * attack ids, then payload is delivered, and phase is over
		 * phase should run average of 30 ticks
		 * wait for at least 5 ticks before proceeding
		 * */
		
		break
		case 4:
		/*this is exploitation phase, where the attack must work
		 * we already know that the attack matched the vulnerability during the delivery phase, but that specific vul might have been mitigated 
		 * during delivery or any tick since, so check again for a vul id on the terrain, and match to one of attack ids - if no match, go back
		 * to phase 0, 1, or 2 (pick one randomly)
		 * if a match exists between any of vul and attack ids, then the machine is exploited
		 * set one or more of CIA to 0 and set isCompromised to true (on the terrain turtle)
		 * 
		 * */
		break
		case 5:
		/*this is command and control phase where compromised terrain phones home or to malicious server, 
		 * create InteractionTT with the attacker machine
		 * phase should run average of 20 ticks
		 */
		break
		case 6:
		/*this is actions on objectives phase
		 * depending on attack type, the exploited machine will make InteractionTT with some other machines, for now, just
		 * make random InteractionTT with other terrain, and set the lifespan of those IntaractionTTs to random value
		 * phase shold run average of 85 ticks 
		 * */
		break
	   }
	   
	   if(phasetime > 0)
		   phasetime = phasetime - 1
	   
	   print phasetime
	}
}
