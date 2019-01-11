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
	
	def tier = 1 // 1 - 5 based on Defense Science Board Report, 5 being the most sophisticated
	
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
	def isPhaseSwitch = false
	
	def setup(){	
		//initialize attacks - if tier = 5, give attacks 1 to 99
		def attacks = random.nextInt(100) / 5
		def i = 0
		i.upto(attacks) {
			def attackNumber = (random.nextInt(100) / -5) + 100
			this.attacks.add(attackNumber) 
			print "adding attack ${attackNumber}" 
		}
	}

	def step() {
	   switch (phase) {
	    case 0:
		//case 0 means the attacker hasn't started, get random and if 50% or better, begin attack, this gives some random delay to starting	
		
			if(random.nextInt(100) > 50) {
				//proceed to phase 1
				phase = 1
				isPhaseSwitch = true
				phasetime = random.nextInt(100)
			}
			
			break
		case 1:
		/*this is recon phase
		 * every step, the attacker might create an interaction between their attacker machine and one of the terrain type 1 or 2
		 * the phase should run, on average, 80 ticks
		 * wait for at least 20 ticks before proceeding
		 * */
			if(phasetime < 1) {
				phase = 2
				isPhaseSwitch = true
				phasetime = random.nextInt(100)
			}
			
			if(random.nextInt(100) > 50) {
				//print "Recon connection"
				
				//get on an attacker workstation
				def attackerWorkstation = oneOf(terrains().with({type.equals(66)})) //connect me to a machine
				def attackerWorkstationLink = createInteractionFTTo(attackerWorkstation)
				attackerWorkstationLink.lifetime = phasetime
				attackerWorkstationLink.color = gray()
				attackerWorkstation.setColor(gray())
				
				//now connect from that workstation out to a target machine in the battlespace
				def target = oneOf(terrains().with({type.equals(1) || type.equals(2) || type.equals(3)}))
				def attackerTargetLink = attackerWorkstation.createInteractionTTTo(target)
				attackerTargetLink.lifetime = phasetime
				attackerTargetLink.color = gray()
				
				this.setColor(gray())
				
				//ZERO tier 5 teams will develop and deploy a custom zero-day vuln some percent of the time
				if(this.tier > 4) {
					def r = 0//random.nextInt(10)
					if(r < 1) {
						target.addZeroDay()
					}
				}
				//END ZERO
			}
			isPhaseSwitch = false
			break
		case 2:
		/*this is the weaponization phase, attacker will only connect to own attacker machine, as it is being prepped for delivery
		 * phase should run on average 60 ticks
		 * wait for at least 20 ticks before proceeding
		 * */
			if(phasetime < 1) {
				phase = 3
				isPhaseSwitch = true
				phasetime = random.nextInt(100)
			}
			if(isPhaseSwitch) {
				//print "Weaponizing"
				
				def attackerWorkstation = oneOf(terrains().with({type.equals(66)})) //connect me to a machine
				attackerWorkstation.setColor(pink())
				
				def attackerWorkstationLink = createInteractionFTTo(attackerWorkstation)
				attackerWorkstationLink.lifetime = phasetime
				attackerWorkstationLink.color = pink()
				
				this.setColor(pink())
			}
			
			isPhaseSwitch = false
			break
		case 3:
		/*this is delivery phase
		 * attacker machine will target terrain by type (based on attack type) and create interaction, if that terrain has vul id of one of attacker 
		 * attack ids, then payload is delivered, and phase is over
		 * phase should run average of 30 ticks
		 * wait for at least 5 ticks before proceeding
		 * */
			if(phasetime < 1) {
				phase = 4
				isPhaseSwitch = true
				phasetime = random.nextInt(100)
			}
			
			if(isPhaseSwitch) {
				//print "Delivering payload..."
				
				def attackerWorkstation = oneOf(terrains().with({type.equals(66)})) //connect me to a machine
				attackerWorkstation.setColor(magenta())
				
				def attackerWorkstationLink = createInteractionFTTo(attackerWorkstation)
				attackerWorkstationLink.lifetime = phasetime
				attackerWorkstationLink.color = magenta()
				
				//now connect from that workstation out to a target machine in the battlespace
				def attackedMachine = oneOf(terrains().with({type.equals(1) || type.equals(2) || type.equals(3)}))
				attackedMachine.setColor(magenta())
				def attackerTargetLink = attackerWorkstation.createInteractionTTTo(attackedMachine)
				attackerTargetLink.lifetime = phasetime
				attackerTargetLink.color = magenta()
				
				this.setColor(magenta())
			}
			
			isPhaseSwitch = false
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
			if(phasetime < 1) {
				phase = 5
				phasetime = random.nextInt(100)
			}
			
			isPhaseSwitch = false
			break
		case 5:
		/*this is command and control phase where compromised terrain phones home or to malicious server, 
		 * create InteractionTT with the attacker machine
		 * phase should run average of 20 ticks
		 */
			if(phasetime < 1) {
				phase = 6
				phasetime = random.nextInt(100)
			}
			
			isPhaseSwitch = false
			break
		case 6:
		/*this is actions on objectives phase
		 * depending on attack type, the exploited machine will make InteractionTT with some other machines, for now, just
		 * make random InteractionTT with other terrain, and set the lifespan of those IntaractionTTs to random value
		 * phase should run average of 85 ticks 
		 * */
			if(phasetime < 1) {
				phase = 0
				phasetime = 0
			}
			
			isPhaseSwitch = false
			break
	   }
	   
	   if(phasetime > -1)
		   phasetime = phasetime - 1
		   
		  
	   
	   //print "phase: " + phase + " | phasetime: " + phasetime
	}
}
