package cyberfit.relogo

class Planner extends UserTurtle{
	
	def planScore = 0 //0 - no plan, 1 - average plan, 2 - excellent plan
	
	def setup() {
	}
	
	def step() {
		
		//need to add loop/timing logic here or at global level		
		
		if (RepastEssentials.GetTickCount() % 60 == 0) {
		def huntLead = oneOf(defenders().with({type.equals(2)} && {lead.equals(1)})) 
		def huntLink = createInteractionFFTo(huntLead)
		
		huntLink.lifetime = 120
		huntLink.color = blue()
		
		def networkLead = oneOf(defenders().with({type.equals(1)} && {lead.equals(1)}))
		def networkLink = createInteractionFFTo(huntLead)
		
		networkLink.lifetime = 120
		networkLink.color = blue()
		
		def hostsLead = oneOf(defenders().with({type.equals(3)} && {lead.equals(1)}))
		def hostsLink = createInteractionFFTo(huntLead)
		
		hostsLink.lifetime = 120
		hostsLink.color = blue()
		}
	}
}
