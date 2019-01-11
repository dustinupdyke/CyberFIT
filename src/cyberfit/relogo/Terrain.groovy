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

class Terrain extends ReLogoTurtle {

	def status = 0 // 0 - ok, 1 - compromised
	def type = 1 //1 - routing, 2 - server, 3 - user, 66 = attacker workstation, 99 = defender workstation
	def vulns = [] //array of vulnerability ids
	def missionsSupported = []

	
	def setup(){
	
	}
	
	def step() {

		generateVuls()
		
	}
	
	def generateVuls() {
		/*every step, terrain might grow a vulnerability, all possible vulnerabilities represented by integers 1 - 100
		 *the vulnerability id represents how serious it is - ie 1 is the simplest and 100 the most complicated/severe
		 *vulnerabilities can be exploited by attacker tier:
		 *tier 1: 1 - 29 
		 *tier 2: 30 - 59
		 *tier 3: 60 - 69
		 *tier 4: 70 - 79
		 *tier 5: 80 - 89
		 *tier 6: 90 - 99
		 * 
		 * vulnerabilities grow at a rate relative to their tier level, so tier 1 vulnerabilities are much more likely to occur than tier 2, 3, etc
		 * 
		 */
		
		
		/*get random r, if r < 50 then tier 1 vul occurred, get random r2 between 0 - 29, add to vul arrary
		 * if r < 2 then tier 6 vul occurred, get random r2 between 90 - 99, add to vul array
		   if r < 5 then tier 5 vul occurred, get random r2 between 80 - 89, add to vul array
		   if r < 10 then tier 4 vul occurred, get random r2 between 70 - 79, add to vul array
		   if r < 20 then tier 3 vul occurred, get random r2 between 60 - 69, add to vul array
		   if r < 40 then tier 2 vul occurred, get random r2 between 30 - 59, add to vul array
		   if r < 80 then tier 1 vul occurred, get random r2 between 1 - 29, add to vul array	
		*/
		
		//also, terrain might grow a zero day, at any given time		
		//get random r3 between 1 and 200, if r3 < 2, add 0 to vul array 
		
	}
	
}
