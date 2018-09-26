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
		setDefaultShape(Attacker,"person")
		
		loadBaseTerrain()
		loadCPTs()		
		loadAttackers()
		loadMissions()
		print "missions loaded"
		assignCPTs()
	}
	
	@Go
	def go(){
	
		//if(MissionsReady == 0) {
			//loadMissions()
			//MissionsReady = 1
		//}
		
			
			
		checkCPTsAssigned()
		if(CPTsReady == 1) {
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
		
		//if(ticks % 2592000 == 0) {
			//MissionsReady = 0
		//}
	}
	
	def checkCPTsAssigned() {
		
		if(team1Deploy == 'N' || team2Deploy == 'N' || team3Deploy == 'N' || team4Deploy == 'N') {
			CPTsReady = 0
		}
		else {
			CPTsReady = 1
		}
	}
	
	def loadMissions() {
		
		//Campaign c1 = new Campaign()
		//c1.loadMissions()

	}
	
	def assignCPTs() {
		def xu = 1
	}
	
	def loadBaseTerrain(){
		
		//Create Routers (type 1)
		createTerrains(1){ [setxy(-1,1), setColor(brown()), type = 1] }
		createTerrains(1){ [setxy(-1,2), setColor(brown()), type = 1] }
		createTerrains(1){ [setxy(-1,3), setColor(brown()), type = 1] }
		createTerrains(1){ [setxy(-1,4), setColor(brown()), type = 1] }
		
		//Create Routers (type 1)
		createTerrains(1){ [setxy(0,1), setColor(brown()), type = 1] }
		createTerrains(1){ [setxy(0,2), setColor(brown()), type = 1] }
		createTerrains(1){ [setxy(0,3), setColor(brown()), type = 1] }
		createTerrains(1){ [setxy(0,4), setColor(brown()), type = 1] }
				
		//Create Routers (type 1)
		createTerrains(1){ [setxy(2,1), setColor(brown()), type = 1] }
		createTerrains(1){ [setxy(2,2), setColor(brown()), type = 1] }
		createTerrains(1){ [setxy(2,3), setColor(brown()), type = 1] }
		createTerrains(1){ [setxy(2,4), setColor(brown()), type = 1] }
		
		//Create Servers (type 2)
		createTerrains(1){ [setxy(3,-6), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(3,-5), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(3,-4), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(3,-3), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(3,-2), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(3,-1), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(3,0), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(3,1), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(3,2), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(3,3), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(3,4), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(3,5), setColor(brown()), type = 2] }
		createTerrains(1){ [setxy(3,6), setColor(brown()), type = 2] }
		
		//Create Clients (type 3)
		
		//create attacker workstations
		createTerrains(1){ [setxy(-1, -20), setColor(pink()), type = 66] }
		createTerrains(1){ [setxy(-2, -20), setColor(pink()), type = 66] }
		createTerrains(1){ [setxy(-3, -20), setColor(pink()), type = 66] }
		createTerrains(1){ [setxy(-4, -20), setColor(pink()), type = 66] }
		createTerrains(1){ [setxy(-5, -20), setColor(pink()), type = 66] }
		createTerrains(1){ [setxy(0, -20), setColor(pink()), type = 66] }
		createTerrains(1){ [setxy(1, -20), setColor(pink()), type = 66] }
		createTerrains(1){ [setxy(2, -20), setColor(pink()), type = 66] }
		createTerrains(1){ [setxy(3, -20), setColor(pink()), type = 66] }
		createTerrains(1){ [setxy(4, -20), setColor(pink()), type = 66] }
		createTerrains(1){ [setxy(5,-20), setColor(pink()), type = 66] }
		
		//create defender workstations
		createTerrains(1){ [setxy(-29,10), setColor(lime()), type = 99] }
		createTerrains(1){ [setxy(-30,10), setColor(lime()), type = 99] }
		createTerrains(1){ [setxy(-31,10), setColor(lime()), type = 99] }
		createTerrains(1){ [setxy(-32,10), setColor(lime()), type = 99] }
		createTerrains(1){ [setxy(-33,10), setColor(lime()), type = 99] }
		createTerrains(1){ [setxy(-34,10), setColor(lime()), type = 99] }
	}
	
	def loadCPTs() {
		
		//Campaign c2 = new Campaign()
		//c2.loadCPTs()
		
		createDefenders(1){ [setxy(-24,20), setColor(green()), team = 1, rank = "O3", experienceMissions = 4, experienceTraining = 50] }
		createDefenders(1){ [setxy(-28,20), setColor(green()), team = 1, rank = "O2", experienceMissions = 1, experienceTraining = 45] }
		createDefenders(1){ [setxy(-32,20), setColor(green()), team = 1, rank = "O2", experienceMissions = 3, experienceTraining = 15] }
		createDefenders(1){ [setxy(-36,20), setColor(green()), team = 1, rank = "w4", experienceMissions = 16, experienceTraining = 90] }
		createDefenders(1){ [setxy(-40,20), setColor(green()), team = 1, rank = "w2", experienceMissions = 10, experienceTraining = 72] }
		
		
		/*
		createDefenders(1){ [setxy(-100,100), setColor(green()), team = 1, rank = "O3", experienceMissions = 4, experienceTraining = 50] }
		createDefenders(1){ [setxy(-99,90), setColor(green()), team = 1, rank = "O2", experienceMissions = 1, experienceTraining = 45] }
		createDefenders(1){ [setxy(-98,80), setColor(green()), team = 1, rank = "O2", experienceMissions = 3, experienceTraining = 15] }
		createDefenders(1){ [setxy(-97,0), setColor(green()), team = 1, rank = "w4", experienceMissions = 16, experienceTraining = 90] }
		createDefenders(1){ [setxy(-96,-40), setColor(green()), team = 1, rank = "w2", experienceMissions = 10, experienceTraining = 72] }
		createDefenders(1){ [setxy(-95,-80), setColor(green()), team = 1, rank = "e8", experienceMissions = 25, experienceTraining = 60] }
		createDefenders(1){ [setxy(-94,-100), setColor(green()), team = 1, rank = "e7", experienceMissions = 14, experienceTraining = 80] }
		createDefenders(1){ [setxy(-93,100), setColor(green()), team = 1, rank = "e6", experienceMissions = 10, experienceTraining = 42] }
		createDefenders(1){ [setxy(-92,100), setColor(green()), team = 1, rank = "e6", experienceMissions = 12, experienceTraining = 68] }
		createDefenders(1){ [setxy(-91,100), setColor(green()), team = 1, rank = "e6", experienceMissions = 6, experienceTraining = 22] }
		createDefenders(1){ [setxy(-90,100), setColor(green()), team = 1, rank = "e5", experienceMissions = 4, experienceTraining = 90] }
		createDefenders(1){ [setxy(-89,100), setColor(green()), team = 1, rank = "e5", experienceMissions = 12, experienceTraining = 72] }
		createDefenders(1){ [setxy(-88,100), setColor(green()), team = 1, rank = "e4", experienceMissions = 9, experienceTraining = 82] }
		createDefenders(1){ [setxy(-87,100), setColor(green()), team = 1, rank = "e4", experienceMissions = 4, experienceTraining = 32] }
		createDefenders(1){ [setxy(-86,100), setColor(green()), team = 1, rank = "e4", experienceMissions = 13, experienceTraining = 82] }
		createDefenders(1){ [setxy(-85,100), setColor(green()), team = 1, rank = "e4", experienceMissions = 1, experienceTraining = 8] }
		createDefenders(1){ [setxy(-84,100), setColor(green()), team = 1, rank = "e3", experienceMissions = 9, experienceTraining = 52] }
		createDefenders(1){ [setxy(-83,100), setColor(green()), team = 1, rank = "e3", experienceMissions = 6, experienceTraining = 42] }
		createDefenders(1){ [setxy(-82,100), setColor(green()), team = 1, rank = "e3", experienceMissions = 4, experienceTraining = 55] }
		createDefenders(1){ [setxy(-81,100), setColor(green()), team = 1, rank = "e3", experienceMissions = 1, experienceTraining = 13] }
		
		
		//Add CPT 1 to world
		createDefenders(1){ [setxy(-1500,1400), setColor(green()), team = 1, rank = "O3", experienceMissions = 4, experienceTraining = 50] }
		createDefenders(1){ [setxy(-1499,1400), setColor(green()), team = 1, rank = "O2", experienceMissions = 1, experienceTraining = 45] }
		createDefenders(1){ [setxy(-1498,1400), setColor(green()), team = 1, rank = "O2", experienceMissions = 3, experienceTraining = 15] }
		createDefenders(1){ [setxy(-1497,1400), setColor(green()), team = 1, rank = "w4", experienceMissions = 16, experienceTraining = 90] }
		createDefenders(1){ [setxy(-1496,1400), setColor(green()), team = 1, rank = "w2", experienceMissions = 10, experienceTraining = 72] }
		createDefenders(1){ [setxy(-1495,1400), setColor(green()), team = 1, rank = "e8", experienceMissions = 25, experienceTraining = 60] }
		createDefenders(1){ [setxy(-1494,1400), setColor(green()), team = 1, rank = "e7", experienceMissions = 14, experienceTraining = 80] }
		createDefenders(1){ [setxy(-1493,1400), setColor(green()), team = 1, rank = "e6", experienceMissions = 10, experienceTraining = 42] }
		createDefenders(1){ [setxy(-1492,1400), setColor(green()), team = 1, rank = "e6", experienceMissions = 12, experienceTraining = 68] }
		createDefenders(1){ [setxy(-1491,1400), setColor(green()), team = 1, rank = "e6", experienceMissions = 6, experienceTraining = 22] }
		createDefenders(1){ [setxy(-1490,1400), setColor(green()), team = 1, rank = "e5", experienceMissions = 4, experienceTraining = 90] }
		createDefenders(1){ [setxy(-1489,1400), setColor(green()), team = 1, rank = "e5", experienceMissions = 12, experienceTraining = 72] }
		createDefenders(1){ [setxy(-1488,1400), setColor(green()), team = 1, rank = "e4", experienceMissions = 9, experienceTraining = 82] }
		createDefenders(1){ [setxy(-1487,1400), setColor(green()), team = 1, rank = "e4", experienceMissions = 4, experienceTraining = 32] }
		createDefenders(1){ [setxy(-1486,1400), setColor(green()), team = 1, rank = "e4", experienceMissions = 13, experienceTraining = 82] }
		createDefenders(1){ [setxy(-1485,1400), setColor(green()), team = 1, rank = "e4", experienceMissions = 1, experienceTraining = 8] }
		createDefenders(1){ [setxy(-1484,1400), setColor(green()), team = 1, rank = "e3", experienceMissions = 9, experienceTraining = 52] }
		createDefenders(1){ [setxy(-1483,1400), setColor(green()), team = 1, rank = "e3", experienceMissions = 6, experienceTraining = 42] }
		createDefenders(1){ [setxy(-1482,1400), setColor(green()), team = 1, rank = "e3", experienceMissions = 4, experienceTraining = 55] }
		createDefenders(1){ [setxy(-1481,1400), setColor(green()), team = 1, rank = "e3", experienceMissions = 1, experienceTraining = 13] }
		
		
		//Add CPT 2 to world -1500, 1499
		createDefenders(1){ [setxy(-1500,1499), setColor(green()), team = 2, rank = "O3", experienceMissions = 2, experienceTraining = 75] }
		createDefenders(1){ [setxy(-1499,1499), setColor(green()), team = 2, rank = "O2", experienceMissions = 2, experienceTraining = 45] }
		createDefenders(1){ [setxy(-1498,1499), setColor(green()), team = 2, rank = "O1", experienceMissions = 1, experienceTraining = 70] }
		createDefenders(1){ [setxy(-1497,1499), setColor(green()), team = 2, rank = "w3", experienceMissions = 26, experienceTraining = 95] }
		createDefenders(1){ [setxy(-1496,1499), setColor(green()), team = 2, rank = "w3", experienceMissions = 20, experienceTraining = 82] }
		createDefenders(1){ [setxy(-1495,1499), setColor(green()), team = 2, rank = "e8", experienceMissions = 15, experienceTraining = 50] }
		createDefenders(1){ [setxy(-1494,1499), setColor(green()), team = 2, rank = "e8", experienceMissions = 11, experienceTraining = 67] }
		createDefenders(1){ [setxy(-1493,1499), setColor(green()), team = 2, rank = "e6", experienceMissions = 8, experienceTraining = 32] }
		createDefenders(1){ [setxy(-1492,1499), setColor(green()), team = 2, rank = "e6", experienceMissions = 11, experienceTraining = 61] }
		createDefenders(1){ [setxy(-1491,1499), setColor(green()), team = 2, rank = "e5", experienceMissions = 4, experienceTraining = 20] }
		createDefenders(1){ [setxy(-1490,1499), setColor(green()), team = 2, rank = "e5", experienceMissions = 4, experienceTraining = 70] }
		createDefenders(1){ [setxy(-1489,1499), setColor(green()), team = 2, rank = "e5", experienceMissions = 10, experienceTraining = 68] }
		createDefenders(1){ [setxy(-1488,1499), setColor(green()), team = 2, rank = "e4", experienceMissions = 8, experienceTraining = 78] }
		createDefenders(1){ [setxy(-1487,1499), setColor(green()), team = 2, rank = "e4", experienceMissions = 4, experienceTraining = 30] }
		createDefenders(1){ [setxy(-1486,1499), setColor(green()), team = 2, rank = "e4", experienceMissions = 12, experienceTraining = 80] }
		createDefenders(1){ [setxy(-1485,1499), setColor(green()), team = 2, rank = "e4", experienceMissions = 1, experienceTraining = 6] }
		createDefenders(1){ [setxy(-1484,1499), setColor(green()), team = 2, rank = "e3", experienceMissions = 8, experienceTraining = 52] }
		createDefenders(1){ [setxy(-1483,1499), setColor(green()), team = 2, rank = "e3", experienceMissions = 5, experienceTraining = 42] }
		createDefenders(1){ [setxy(-1482,1499), setColor(green()), team = 2, rank = "e3", experienceMissions = 3, experienceTraining = 53] }
		createDefenders(1){ [setxy(-1481,1499), setColor(green()), team = 2, rank = "e3", experienceMissions = 1, experienceTraining = 12] }
		
		//Add CPT 3 to world -1500, 1498
		createDefenders(1){ [setxy(-1500,1498), setColor(green()), team = 3, rank = "O3", experienceMissions = 2, experienceTraining = 70] }
		createDefenders(1){ [setxy(-1499,1498), setColor(green()), team = 3, rank = "O2", experienceMissions = 2, experienceTraining = 40] }
		createDefenders(1){ [setxy(-1498,1498), setColor(green()), team = 3, rank = "O1", experienceMissions = 1, experienceTraining = 66] }
		createDefenders(1){ [setxy(-1497,1498), setColor(green()), team = 3, rank = "w3", experienceMissions = 22, experienceTraining = 90] }
		createDefenders(1){ [setxy(-1496,1498), setColor(green()), team = 3, rank = "w3", experienceMissions = 19, experienceTraining = 80] }
		createDefenders(1){ [setxy(-1495,1498), setColor(green()), team = 3, rank = "e8", experienceMissions = 13, experienceTraining = 48] }
		createDefenders(1){ [setxy(-1494,1498), setColor(green()), team = 3, rank = "e8", experienceMissions = 10, experienceTraining = 67] }
		createDefenders(1){ [setxy(-1493,1498), setColor(green()), team = 3, rank = "e6", experienceMissions = 7, experienceTraining = 32] }
		createDefenders(1){ [setxy(-1492,1498), setColor(green()), team = 3, rank = "e6", experienceMissions = 10, experienceTraining = 61] }
		createDefenders(1){ [setxy(-1491,1498), setColor(green()), team = 3, rank = "e5", experienceMissions = 4, experienceTraining = 19] }
		createDefenders(1){ [setxy(-1490,1498), setColor(green()), team = 3, rank = "e5", experienceMissions = 4, experienceTraining = 66] }
		createDefenders(1){ [setxy(-1489,1498), setColor(green()), team = 3, rank = "e5", experienceMissions = 10, experienceTraining = 65] }
		createDefenders(1){ [setxy(-1488,1498), setColor(green()), team = 3, rank = "e4", experienceMissions = 7, experienceTraining = 78] }
		createDefenders(1){ [setxy(-1487,1498), setColor(green()), team = 3, rank = "e4", experienceMissions = 4, experienceTraining = 28] }
		createDefenders(1){ [setxy(-1486,1498), setColor(green()), team = 3, rank = "e4", experienceMissions = 11, experienceTraining = 80] }
		createDefenders(1){ [setxy(-1485,1498), setColor(green()), team = 3, rank = "e4", experienceMissions = 1, experienceTraining = 6] }
		createDefenders(1){ [setxy(-1484,1498), setColor(green()), team = 3, rank = "e3", experienceMissions = 8, experienceTraining = 51] }
		createDefenders(1){ [setxy(-1483,1498), setColor(green()), team = 3, rank = "e3", experienceMissions = 5, experienceTraining = 40] }
		createDefenders(1){ [setxy(-1482,1498), setColor(green()), team = 3, rank = "e3", experienceMissions = 3, experienceTraining = 52] }
		createDefenders(1){ [setxy(-1481,1498), setColor(green()), team = 3, rank = "e3", experienceMissions = 1, experienceTraining = 12] }
		
		//Add CPT 4 to world -1500, 1497
		createDefenders(1){ [setxy(-1500,1497), setColor(green()), team = 4, rank = "O3", experienceMissions = 2, experienceTraining = 75] }
		createDefenders(1){ [setxy(-1499,1497), setColor(green()), team = 4, rank = "O2", experienceMissions = 2, experienceTraining = 45] }
		createDefenders(1){ [setxy(-1498,1497), setColor(green()), team = 4, rank = "O1", experienceMissions = 1, experienceTraining = 70] }
		createDefenders(1){ [setxy(-1497,1497), setColor(green()), team = 4, rank = "w3", experienceMissions = 26, experienceTraining = 95] }
		createDefenders(1){ [setxy(-1496,1497), setColor(green()), team = 4, rank = "w3", experienceMissions = 20, experienceTraining = 82] }
		createDefenders(1){ [setxy(-1495,1497), setColor(green()), team = 4, rank = "e8", experienceMissions = 15, experienceTraining = 50] }
		createDefenders(1){ [setxy(-1494,1497), setColor(green()), team = 4, rank = "e8", experienceMissions = 11, experienceTraining = 67] }
		createDefenders(1){ [setxy(-1493,1497), setColor(green()), team = 4, rank = "e6", experienceMissions = 8, experienceTraining = 32] }
		createDefenders(1){ [setxy(-1492,1497), setColor(green()), team = 4, rank = "e6", experienceMissions = 11, experienceTraining = 61] }
		createDefenders(1){ [setxy(-1491,1497), setColor(green()), team = 4, rank = "e5", experienceMissions = 4, experienceTraining = 20] }
		createDefenders(1){ [setxy(-1490,1497), setColor(green()), team = 4, rank = "e5", experienceMissions = 4, experienceTraining = 70] }
		createDefenders(1){ [setxy(-1489,1497), setColor(green()), team = 4, rank = "e5", experienceMissions = 10, experienceTraining = 68] }
		createDefenders(1){ [setxy(-1488,1497), setColor(green()), team = 4, rank = "e4", experienceMissions = 8, experienceTraining = 78] }
		createDefenders(1){ [setxy(-1487,1497), setColor(green()), team = 4, rank = "e4", experienceMissions = 4, experienceTraining = 30] }
		createDefenders(1){ [setxy(-1486,1497), setColor(green()), team = 4, rank = "e4", experienceMissions = 12, experienceTraining = 80] }
		createDefenders(1){ [setxy(-1485,1497), setColor(green()), team = 4, rank = "e4", experienceMissions = 1, experienceTraining = 6] }
		createDefenders(1){ [setxy(-1484,1497), setColor(green()), team = 4, rank = "e3", experienceMissions = 8, experienceTraining = 52] }
		createDefenders(1){ [setxy(-1483,1497), setColor(green()), team = 4, rank = "e3", experienceMissions = 5, experienceTraining = 42] }
		createDefenders(1){ [setxy(-1482,1497), setColor(green()), team = 4, rank = "e3", experienceMissions = 3, experienceTraining = 53] }
		createDefenders(1){ [setxy(-1481,1497), setColor(green()), team = 4, rank = "e3", experienceMissions = 1, experienceTraining = 12] }
		
		//Add CPT 5 to world -1500, 1496
		createDefenders(1){ [setxy(-1500,1496), setColor(green()), team = 5, rank = "O3", experienceMissions = 2, experienceTraining = 74] }
		createDefenders(1){ [setxy(-1499,1496), setColor(green()), team = 5, rank = "O2", experienceMissions = 2, experienceTraining = 44] }
		createDefenders(1){ [setxy(-1498,1496), setColor(green()), team = 5, rank = "O1", experienceMissions = 1, experienceTraining = 69] }
		createDefenders(1){ [setxy(-1497,1496), setColor(green()), team = 5, rank = "w3", experienceMissions = 25, experienceTraining = 95] }
		createDefenders(1){ [setxy(-1496,1496), setColor(green()), team = 5, rank = "w3", experienceMissions = 20, experienceTraining = 81] }
		createDefenders(1){ [setxy(-1495,1496), setColor(green()), team = 5, rank = "e8", experienceMissions = 14, experienceTraining = 50] }
		createDefenders(1){ [setxy(-1494,1496), setColor(green()), team = 5, rank = "e8", experienceMissions = 11, experienceTraining = 66] }
		createDefenders(1){ [setxy(-1493,1496), setColor(green()), team = 5, rank = "e6", experienceMissions = 7, experienceTraining = 32] }
		createDefenders(1){ [setxy(-1492,1496), setColor(green()), team = 5, rank = "e6", experienceMissions = 11, experienceTraining = 60] }
		createDefenders(1){ [setxy(-1491,1496), setColor(green()), team = 5, rank = "e5", experienceMissions = 4, experienceTraining = 20] }
		createDefenders(1){ [setxy(-1490,1496), setColor(green()), team = 5, rank = "e5", experienceMissions = 4, experienceTraining = 69] }
		createDefenders(1){ [setxy(-1489,1496), setColor(green()), team = 5, rank = "e5", experienceMissions = 10, experienceTraining = 68] }
		createDefenders(1){ [setxy(-1488,1496), setColor(green()), team = 5, rank = "e4", experienceMissions = 8, experienceTraining = 78] }
		createDefenders(1){ [setxy(-1487,1496), setColor(green()), team = 5, rank = "e4", experienceMissions = 4, experienceTraining = 29] }
		createDefenders(1){ [setxy(-1486,1496), setColor(green()), team = 5, rank = "e4", experienceMissions = 12, experienceTraining = 80] }
		createDefenders(1){ [setxy(-1485,1496), setColor(green()), team = 5, rank = "e4", experienceMissions = 1, experienceTraining = 6] }
		createDefenders(1){ [setxy(-1484,1496), setColor(green()), team = 5, rank = "e3", experienceMissions = 7, experienceTraining = 52] }
		createDefenders(1){ [setxy(-1483,1496), setColor(green()), team = 5, rank = "e3", experienceMissions = 5, experienceTraining = 42] }
		createDefenders(1){ [setxy(-1482,1496), setColor(green()), team = 5, rank = "e3", experienceMissions = 3, experienceTraining = 53] }
		createDefenders(1){ [setxy(-1481,1496), setColor(green()), team = 5, rank = "e3", experienceMissions = 1, experienceTraining = 12] }

		//Add CPT 6 to world -1500, 1495
		createDefenders(1){ [setxy(-1500,1495), setColor(green()), team = 6, rank = "O3", experienceMissions = 2, experienceTraining = 74] }
		createDefenders(1){ [setxy(-1499,1495), setColor(green()), team = 6, rank = "O2", experienceMissions = 2, experienceTraining = 44] }
		createDefenders(1){ [setxy(-1498,1495), setColor(green()), team = 6, rank = "O1", experienceMissions = 1, experienceTraining = 69] }
		createDefenders(1){ [setxy(-1497,1495), setColor(green()), team = 6, rank = "w3", experienceMissions = 24, experienceTraining = 95] }
		createDefenders(1){ [setxy(-1496,1495), setColor(green()), team = 6, rank = "w3", experienceMissions = 20, experienceTraining = 81] }
		createDefenders(1){ [setxy(-1495,1495), setColor(green()), team = 6, rank = "e8", experienceMissions = 14, experienceTraining = 50] }
		createDefenders(1){ [setxy(-1494,1495), setColor(green()), team = 6, rank = "e8", experienceMissions = 11, experienceTraining = 64] }
		createDefenders(1){ [setxy(-1493,1495), setColor(green()), team = 6, rank = "e6", experienceMissions = 7, experienceTraining = 32] }
		createDefenders(1){ [setxy(-1492,1495), setColor(green()), team = 6, rank = "e6", experienceMissions = 11, experienceTraining = 59] }
		createDefenders(1){ [setxy(-1491,1495), setColor(green()), team = 6, rank = "e5", experienceMissions = 4, experienceTraining = 20] }
		createDefenders(1){ [setxy(-1490,1495), setColor(green()), team = 6, rank = "e5", experienceMissions = 4, experienceTraining = 69] }
		createDefenders(1){ [setxy(-1489,1495), setColor(green()), team = 6, rank = "e5", experienceMissions = 9, experienceTraining = 68] }
		createDefenders(1){ [setxy(-1488,1495), setColor(green()), team = 6, rank = "e4", experienceMissions = 8, experienceTraining = 78] }
		createDefenders(1){ [setxy(-1487,1495), setColor(green()), team = 6, rank = "e4", experienceMissions = 4, experienceTraining = 29] }
		createDefenders(1){ [setxy(-1486,1495), setColor(green()), team = 6, rank = "e4", experienceMissions = 12, experienceTraining = 80] }
		createDefenders(1){ [setxy(-1485,1495), setColor(green()), team = 6, rank = "e4", experienceMissions = 1, experienceTraining = 6] }
		createDefenders(1){ [setxy(-1484,1495), setColor(green()), team = 6, rank = "e3", experienceMissions = 7, experienceTraining = 51] }
		createDefenders(1){ [setxy(-1483,1495), setColor(green()), team = 6, rank = "e3", experienceMissions = 5, experienceTraining = 42] }
		createDefenders(1){ [setxy(-1482,1495), setColor(green()), team = 6, rank = "e3", experienceMissions = 3, experienceTraining = 53] }
		createDefenders(1){ [setxy(-1481,1495), setColor(green()), team = 6, rank = "e3", experienceMissions = 1, experienceTraining = 12] }
		
		//Add CPT 7 to world -1500, 1494
		createDefenders(1){ [setxy(-1500,1494), setColor(green()), team = 7, rank = "O3", experienceMissions = 2, experienceTraining = 74] }
		createDefenders(1){ [setxy(-1499,1494), setColor(green()), team = 7, rank = "O2", experienceMissions = 2, experienceTraining = 44] }
		createDefenders(1){ [setxy(-1498,1494), setColor(green()), team = 7, rank = "O1", experienceMissions = 1, experienceTraining = 69] }
		createDefenders(1){ [setxy(-1497,1494), setColor(green()), team = 7, rank = "w3", experienceMissions = 24, experienceTraining = 94] }
		createDefenders(1){ [setxy(-1496,1494), setColor(green()), team = 7, rank = "w3", experienceMissions = 20, experienceTraining = 80] }
		createDefenders(1){ [setxy(-1495,1494), setColor(green()), team = 7, rank = "e8", experienceMissions = 14, experienceTraining = 50] }
		createDefenders(1){ [setxy(-1494,1494), setColor(green()), team = 7, rank = "e8", experienceMissions = 11, experienceTraining = 64] }
		createDefenders(1){ [setxy(-1493,1494), setColor(green()), team = 7, rank = "e6", experienceMissions = 7, experienceTraining = 31] }
		createDefenders(1){ [setxy(-1492,1494), setColor(green()), team = 7, rank = "e6", experienceMissions = 10, experienceTraining = 59] }
		createDefenders(1){ [setxy(-1491,1494), setColor(green()), team = 7, rank = "e5", experienceMissions = 4, experienceTraining = 20] }
		createDefenders(1){ [setxy(-1490,1494), setColor(green()), team = 7, rank = "e5", experienceMissions = 4, experienceTraining = 69] }
		createDefenders(1){ [setxy(-1489,1494), setColor(green()), team = 7, rank = "e5", experienceMissions = 9, experienceTraining = 68] }
		createDefenders(1){ [setxy(-1488,1494), setColor(green()), team = 7, rank = "e4", experienceMissions = 8, experienceTraining = 77] }
		createDefenders(1){ [setxy(-1487,1494), setColor(green()), team = 7, rank = "e4", experienceMissions = 4, experienceTraining = 29] }
		createDefenders(1){ [setxy(-1486,1494), setColor(green()), team = 7, rank = "e4", experienceMissions = 12, experienceTraining = 80] }
		createDefenders(1){ [setxy(-1485,1494), setColor(green()), team = 7, rank = "e4", experienceMissions = 1, experienceTraining = 6] }
		createDefenders(1){ [setxy(-1484,1494), setColor(green()), team = 7, rank = "e3", experienceMissions = 7, experienceTraining = 51] }
		createDefenders(1){ [setxy(-1483,1494), setColor(green()), team = 7, rank = "e3", experienceMissions = 5, experienceTraining = 42] }
		createDefenders(1){ [setxy(-1482,1494), setColor(green()), team = 7, rank = "e3", experienceMissions = 3, experienceTraining = 53] }
		createDefenders(1){ [setxy(-1481,1494), setColor(green()), team = 7, rank = "e3", experienceMissions = 1, experienceTraining = 12] }
		
		//Add CPT 8 to world -1500, 1493
		createDefenders(1){ [setxy(-1500,1493), setColor(green()), team = 8, rank = "O3", experienceMissions = 2, experienceTraining = 74] }
		createDefenders(1){ [setxy(-1499,1493), setColor(green()), team = 8, rank = "O2", experienceMissions = 2, experienceTraining = 44] }
		createDefenders(1){ [setxy(-1498,1493), setColor(green()), team = 8, rank = "O1", experienceMissions = 1, experienceTraining = 69] }
		createDefenders(1){ [setxy(-1497,1493), setColor(green()), team = 8, rank = "w3", experienceMissions = 24, experienceTraining = 94] }
		createDefenders(1){ [setxy(-1496,1493), setColor(green()), team = 8, rank = "w3", experienceMissions = 20, experienceTraining = 80] }
		createDefenders(1){ [setxy(-1495,1493), setColor(green()), team = 8, rank = "e8", experienceMissions = 14, experienceTraining = 50] }
		createDefenders(1){ [setxy(-1494,1493), setColor(green()), team = 8, rank = "e8", experienceMissions = 11, experienceTraining = 64] }
		createDefenders(1){ [setxy(-1493,1493), setColor(green()), team = 8, rank = "e6", experienceMissions = 7, experienceTraining = 31] }
		createDefenders(1){ [setxy(-1492,1493), setColor(green()), team = 8, rank = "e6", experienceMissions = 10, experienceTraining = 59] }
		createDefenders(1){ [setxy(-1491,1493), setColor(green()), team = 8, rank = "e5", experienceMissions = 4, experienceTraining = 20] }
		createDefenders(1){ [setxy(-1490,1493), setColor(green()), team = 8, rank = "e5", experienceMissions = 4, experienceTraining = 69] }
		createDefenders(1){ [setxy(-1489,1493), setColor(green()), team = 8, rank = "e5", experienceMissions = 9, experienceTraining = 68] }
		createDefenders(1){ [setxy(-1488,1493), setColor(green()), team = 8, rank = "e4", experienceMissions = 8, experienceTraining = 77] }
		createDefenders(1){ [setxy(-1487,1493), setColor(green()), team = 8, rank = "e4", experienceMissions = 4, experienceTraining = 29] }
		createDefenders(1){ [setxy(-1486,1493), setColor(green()), team = 8, rank = "e4", experienceMissions = 12, experienceTraining = 80] }
		createDefenders(1){ [setxy(-1485,1493), setColor(green()), team = 8, rank = "e4", experienceMissions = 1, experienceTraining = 6] }
		createDefenders(1){ [setxy(-1484,1493), setColor(green()), team = 8, rank = "e3", experienceMissions = 7, experienceTraining = 51] }
		createDefenders(1){ [setxy(-1483,1493), setColor(green()), team = 8, rank = "e3", experienceMissions = 5, experienceTraining = 42] }
		createDefenders(1){ [setxy(-1482,1493), setColor(green()), team = 8, rank = "e3", experienceMissions = 3, experienceTraining = 53] }
		createDefenders(1){ [setxy(-1481,1493), setColor(green()), team = 8, rank = "e3", experienceMissions = 1, experienceTraining = 12] }

		//Add CPT 9 to world -1500, 1492
		createDefenders(1){ [setxy(-1500,1492), setColor(green()), team = 9, rank = "O3", experienceMissions = 2, experienceTraining = 74] }
		createDefenders(1){ [setxy(-1499,1492), setColor(green()), team = 9, rank = "O2", experienceMissions = 2, experienceTraining = 44] }
		createDefenders(1){ [setxy(-1498,1492), setColor(green()), team = 9, rank = "O1", experienceMissions = 1, experienceTraining = 69] }
		createDefenders(1){ [setxy(-1497,1492), setColor(green()), team = 9, rank = "w3", experienceMissions = 23, experienceTraining = 94] }
		createDefenders(1){ [setxy(-1496,1492), setColor(green()), team = 9, rank = "w3", experienceMissions = 20, experienceTraining = 80] }
		createDefenders(1){ [setxy(-1495,1492), setColor(green()), team = 9, rank = "e8", experienceMissions = 14, experienceTraining = 50] }
		createDefenders(1){ [setxy(-1494,1492), setColor(green()), team = 9, rank = "e8", experienceMissions = 11, experienceTraining = 62] }
		createDefenders(1){ [setxy(-1493,1492), setColor(green()), team = 9, rank = "e6", experienceMissions = 7, experienceTraining = 31] }
		createDefenders(1){ [setxy(-1492,1492), setColor(green()), team = 9, rank = "e6", experienceMissions = 10, experienceTraining = 59] }
		createDefenders(1){ [setxy(-1491,1492), setColor(green()), team = 9, rank = "e5", experienceMissions = 4, experienceTraining = 20] }
		createDefenders(1){ [setxy(-1490,1492), setColor(green()), team = 9, rank = "e5", experienceMissions = 4, experienceTraining = 69] }
		createDefenders(1){ [setxy(-1489,1492), setColor(green()), team = 9, rank = "e5", experienceMissions = 9, experienceTraining = 68] }
		createDefenders(1){ [setxy(-1488,1492), setColor(green()), team = 9, rank = "e4", experienceMissions = 8, experienceTraining = 77] }
		createDefenders(1){ [setxy(-1487,1492), setColor(green()), team = 9, rank = "e4", experienceMissions = 4, experienceTraining = 29] }
		createDefenders(1){ [setxy(-1486,1492), setColor(green()), team = 9, rank = "e4", experienceMissions = 12, experienceTraining = 80] }
		createDefenders(1){ [setxy(-1485,1492), setColor(green()), team = 9, rank = "e4", experienceMissions = 1, experienceTraining = 6] }
		createDefenders(1){ [setxy(-1484,1492), setColor(green()), team = 9, rank = "e3", experienceMissions = 7, experienceTraining = 50] }
		createDefenders(1){ [setxy(-1483,1492), setColor(green()), team = 9, rank = "e3", experienceMissions = 5, experienceTraining = 42] }
		createDefenders(1){ [setxy(-1482,1492), setColor(green()), team = 9, rank = "e3", experienceMissions = 3, experienceTraining = 53] }
		createDefenders(1){ [setxy(-1481,1492), setColor(green()), team = 9, rank = "e3", experienceMissions = 1, experienceTraining = 12] }
		
		//Add CPT 10 to world -1500, 1491
		createDefenders(1){ [setxy(-1500,1491), setColor(green()), team = 10, rank = "O3", experienceMissions = 2, experienceTraining = 74] }
		createDefenders(1){ [setxy(-1499,1491), setColor(green()), team = 10, rank = "O2", experienceMissions = 2, experienceTraining = 44] }
		createDefenders(1){ [setxy(-1498,1491), setColor(green()), team = 10, rank = "O1", experienceMissions = 1, experienceTraining = 69] }
		createDefenders(1){ [setxy(-1497,1491), setColor(green()), team = 10, rank = "w3", experienceMissions = 22, experienceTraining = 94] }
		createDefenders(1){ [setxy(-1496,1491), setColor(green()), team = 10, rank = "w3", experienceMissions = 20, experienceTraining = 80] }
		createDefenders(1){ [setxy(-1495,1491), setColor(green()), team = 10, rank = "e8", experienceMissions = 14, experienceTraining = 50] }
		createDefenders(1){ [setxy(-1494,1491), setColor(green()), team = 10, rank = "e8", experienceMissions = 11, experienceTraining = 62] }
		createDefenders(1){ [setxy(-1493,1491), setColor(green()), team = 10, rank = "e6", experienceMissions = 7, experienceTraining = 30] }
		createDefenders(1){ [setxy(-1492,1491), setColor(green()), team = 10, rank = "e6", experienceMissions = 10, experienceTraining = 59] }
		createDefenders(1){ [setxy(-1491,1491), setColor(green()), team = 10, rank = "e5", experienceMissions = 4, experienceTraining = 20] }
		createDefenders(1){ [setxy(-1490,1491), setColor(green()), team = 10, rank = "e5", experienceMissions = 4, experienceTraining = 69] }
		createDefenders(1){ [setxy(-1489,1491), setColor(green()), team = 10, rank = "e5", experienceMissions = 9, experienceTraining = 68] }
		createDefenders(1){ [setxy(-1488,1491), setColor(green()), team = 10, rank = "e4", experienceMissions = 8, experienceTraining = 77] }
		createDefenders(1){ [setxy(-1487,1491), setColor(green()), team = 10, rank = "e4", experienceMissions = 4, experienceTraining = 29] }
		createDefenders(1){ [setxy(-1486,1491), setColor(green()), team = 10, rank = "e4", experienceMissions = 11, experienceTraining = 80] }
		createDefenders(1){ [setxy(-1485,1491), setColor(green()), team = 10, rank = "e4", experienceMissions = 1, experienceTraining = 6] }
		createDefenders(1){ [setxy(-1484,1491), setColor(green()), team = 10, rank = "e3", experienceMissions = 7, experienceTraining = 49] }
		createDefenders(1){ [setxy(-1483,1491), setColor(green()), team = 10, rank = "e3", experienceMissions = 5, experienceTraining = 42] }
		createDefenders(1){ [setxy(-1482,1491), setColor(green()), team = 10, rank = "e3", experienceMissions = 3, experienceTraining = 53] }
		createDefenders(1){ [setxy(-1481,1491), setColor(green()), team = 10, rank = "e3", experienceMissions = 1, experienceTraining = 12] }
			*/
		
			}
	
	def loadAttackers() {
		createAttackers(1){ [setxy(5, -30), setColor(red()), tier = 1] }
		createAttackers(1){ [setxy(0, -30), setColor(red()), tier = 1] }
		createAttackers(1){ [setxy(-5,-30), setColor(red()), tier = 1] }
		//createAttackers(1){ [setxy(2,-400), setColor(red()), tier = 2] }
		//createAttackers(1){ [setxy(4,-400), setColor(red()), tier = 3] }
	}
}

	