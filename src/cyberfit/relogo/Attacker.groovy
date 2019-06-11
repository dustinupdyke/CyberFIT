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
	
	def aGrup = 0 //id of group the adversary
	def tier = 1 // 1 - 6 based on Defense Science Board Report, 6 being the most sophisticated
	def phase = 0 // 1-7 identifying which phase of kill chain agent is in
	def phasetime = 0
	def attacks = [] //array of attacks available to the agent
	def deliveredTo = [] //list of machines attacker delivered payload to
	def recons = [] //list of machines attacker conducted recon on
	def isPhaseSwitch = false
	
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
	
	//tier 1 - attack 1 - 20
	//tier 2 - attacks 1 - 40
	//tier 3 - attacks 1 - 60
	//tier 4 - attacks 1 - 80
	//tier 5 - attacks 1 - 99
	//tier 6 - attacks 0 - 99
	
	def chanceZeroDayCanBeDeveloped = 50000 //also must be tier = 6
	
	//def tierMultiplier = 20 * this.tier //of 100
	def tierMultiplier = 1
	
	def setup(){
		
	}

	def step() {
	   switch (phase) {
		case 0:
		//case 0 means the attacker hasn't started, get random and if 50% or better, begin attack, this gives some random delay to starting
		
			if(random.nextInt(100) > 50) {
				
				this.initialize()
				
				//print "Phase 0 this attacker has ${recons} and ${deliveredTo} and ${attacks}"
				
				tierMultiplier = 20 * tier.toInteger()
				
				if(tier.toInteger() == 6) {
					tierMultiplier = 100
				}
				
				def totalAttacks = 0
				if(tier.toInteger() == 1) {
					totalAttacks = 0
				}else if(tier.toInteger() == 2) {
					totalAttacks = 1
				}else if(tier.toInteger() == 3) {
					totalAttacks = 3
				}else if(tier.toInteger() == 4) {
					totalAttacks = 7
				}else {
					totalAttacks = 15
				}
				//print "this attacker with tier ${tier} has ${totalAttacks} attacks available"
				def i = 0
				i.upto(totalAttacks) {
					def attackNumber = random.nextInt(this.tierMultiplier)
					
					//check if attack is 0, if so, change to 1 so lower tier attackers don't have zero day avaialable
					if(attackNumber == 0) {
						attackNumber = 1
					}
					
					this.attacks.add(attackNumber)
				}
				
				//now if the attacker is phase 6 add zero day to its available attacks
				if(tier.toInteger() == 6) {
					this.attacks.add(0)
				}
				
				print "Tier ${tier} attacker has these attacks ${attacks}"
				
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
		
			//print "Recon Phase"
			if(phasetime < 1) {
				phase = 2
				isPhaseSwitch = true
				phasetime = random.nextInt(100)
				break
			}
			
			if(random.nextInt(100) > 50) {
				//print "Recon connection"
				
				//get on an attacker workstation
				def attackerWorkstation = oneOf(terrains().with({type.equals(66)})) //connect me to a machine
				def attackerWorkstationLink = createInteractionFTTo(attackerWorkstation)
				attackerWorkstationLink.lifetime = phasetime
				//attackerWorkstationLink.color = gray()
				//attackerWorkstation.setColor(gray())
				
				//now connect from that workstation out to a target machine in the battlespace
				def target = oneOf(terrains().with({type.equals(1) || type.equals(2) || type.equals(3)}))
				def attackerTargetLink = attackerWorkstation.createInteractionTTTo(target)
				attackerTargetLink.lifetime = phasetime
				//attackerTargetLink.color = gray()
				//print "adding ${target.who} to recons list ${recons}"
				recons.add(target.who)
				
				//print "attacker is connected to machine with ${target.vulns} for ${phasetime}"
				//print "vuln 1 is ${target.vulns[1]}"
				//print "total vulns is ${target.vulns.size()}"
				
				if(target.vulns.size() > 0) {
					
					def vulReader = target.vulns[random.nextInt(target.vulns.size())]
					
					if(vulReader == 0) {
						//print "zero day read"
						break
					}
					//print "attacker found vul ${vulReader}"
					//print "attacker is ${tier}"
					//Now, add the vulnerability to the attacker's list of attacks
					
					if(tier.toInteger() == 1) {
						if(vulReader < 21){
							//print "recon success attacker current attacks is ${attacks}###############"
							attacks.add(vulReader)
							//print "now is ${attacks}"
						}
					}else if(tier.toInteger() == 2) {
						if(vulReader < 41){
							attacks.add(vulReader)
						}
					}else if(tier.toInteger() == 3) {
						if(vulReader < 61){
							attacks.add(vulReader)
						}
					}else if(tier.toInteger() == 4) {
						if(vulReader < 81){
							attacks.add(vulReader)
						}
					}
					else {
						attacks.add(vulReader)
					}
					
				}
				
				
				//this.setColor(gray())
				
				//ZERO tier 6 teams will develop and deploy a custom zero-day vuln some percent of the time
				if(this.tier > 5) {
					def r = random.nextInt(chanceZeroDayCanBeDeveloped)
					if(r < 1) {
						//print "Zero day developed (1 in ${chanceZeroDayCanBeDeveloped}"
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
			//print "Weaponization Phase and phase time is ${phasetime}"
			
			if(phasetime < 1) {
				phase = 3
				isPhaseSwitch = true
				phasetime = random.nextInt(100)
				//print "break now"
				break
			}
			
			if(isPhaseSwitch) {
			//print "Weaponizing Connection and recons size is ${recons.size()}"
			//print "and recons is ${recons}"
			
			if(recons.size() <= 2) {
				phase = 1
				isPhaseSwitch = true
				phasetime = random.nextInt(100)
				break
			}
				
			def attackerWorkstation = oneOf(terrains().with({type.equals(66)})) //connect me to a machine
			def attackerWorkstationLink = createInteractionFTTo(attackerWorkstation)
			attackerWorkstationLink.lifetime = phasetime
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
				break
			}
			
			if(isPhaseSwitch) {
				
				//print "this is 1 time Delivery Phase ps true"
				
				if(recons.size() < 2) {
					phase = 1
					isPhaseSwitch = true
					phasetime = random.nextInt(100)
					break
				}
				
			}
	   
			if(random.nextInt(100) > 50) {
				//print "Delivering payload..."
				//print "This attacker recon on ${recons}"
				
				//print "all terrains is ${terrains()}"
				
				def attackerWorkstation = oneOf(terrains().with({type.equals(66)})) //connect me to a machine
				//attackerWorkstation.setColor(magenta())
				
				//print "aw is ${attackerWorkstation}"
				
				def attackerWorkstationLink = createInteractionFTTo(attackerWorkstation)
				
				//print "the link worked adn is ${attackerWorkstationLink}"
				
				attackerWorkstationLink.lifetime = 1
				//attackerWorkstationLink.color = magenta()
				//now connect from that workstation out to a target machine in the battlespace that was recon'd on
				if(recons.size() < 1) {
					phase = 1
					isPhaseSwitch = true
					phasetime = random.nextInt(100)
					break
				}
				
				def deliveryRandom = random.nextInt(recons.size())
				//print "dr is ${deliveryRandom} and recons at dr is ${recons[deliveryRandom]}"
			
				
				if(recons[deliveryRandom] == null) {
					break
				}
				
				def deliverySelect = recons[deliveryRandom]
				
				//print "ds is ${deliverySelect}"
				if(deliverySelect == null) {
					break
				}
				def attackedMachine = terrain(deliverySelect)
				def attackerTargetLink = attackerWorkstation.createInteractionTTTo(attackedMachine)
				attackerTargetLink.lifetime = phasetime
				def amNum = attackedMachine.who
						
				//attacker will load the attacked machine with one of its payloads
				def payloadRandom = random.nextInt(attacks.size())
				def payloadSelect = attacks[payloadRandom]
				if(payloadSelect == null) {
					break
				}
				attackedMachine.payloads.add(payloadSelect)
				deliveredTo.add(attackedMachine.who)
				/*print "payloads now are"
				print attackedMachine.payloads
				print "vulns now are"
				print attackedMachine.vulns
				print "delieverd to now"
				print deliveredTo*/
				//this.setColor(magenta())
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
				isPhaseSwitch = true
				phasetime = random.nextInt(100)
				break
			}
			//print "exploitation phase"
			//print "now phase switch is ${isPhaseSwitch}"
			if(isPhaseSwitch) {
				
				//print "delivered to size is ${deliveredTo.size()}"
				def i = 0
				i.upto(deliveredTo.size()) {
					if(deliveredTo[i] != null) {
						

					//print "Exploitation attempt ${i} on ${deliveredTo[i]}"
					
					//print "try attack now"
					terrain(deliveredTo[i]).tryAttack()
					
					i = i + 1
					}
				}
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
				isPhaseSwitch = true
				phasetime = random.nextInt(100)
				break
			}
			
			if(isPhaseSwitch) {
				//print "Command and Control Phase for ${phasetime} minutes"
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
				isPhaseSwitch = true
				phasetime = 0
				break
			}
			
			if(isPhaseSwitch) {
				phasetime = phasetime + 180
				//print "Actions on objectives phase for ${phasetime} minutes"
			}
			
			isPhaseSwitch = false
			break
	   }
	   
	   if(phasetime > -1)
		   phasetime = phasetime - 1
		
	}
	
	def initialize() {
		this.attacks = []
		this.recons = []
		this.deliveredTo = []
	}
}
