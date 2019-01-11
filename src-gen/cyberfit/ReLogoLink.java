package cyberfit;

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import groovy.lang.Closure;
import repast.simphony.relogo.*;
import repast.simphony.relogo.builder.GeneratedByReLogoBuilder;
import repast.simphony.relogo.builder.ReLogoBuilderGeneratedFor;

@GeneratedByReLogoBuilder
@SuppressWarnings({"unused","rawtypes","unchecked"})
public class ReLogoLink<T> extends BaseLink<T>	{

	/**
	 * Returns an agentset of attackers on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of attackers on patch p
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Attacker")
	public AgentSet<cyberfit.relogo.Attacker> attackersOn(Patch p){
		AgentSet<cyberfit.relogo.Attacker> result = new AgentSet<cyberfit.relogo.Attacker>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"attacker")){
			if (t instanceof cyberfit.relogo.Attacker)
			result.add((cyberfit.relogo.Attacker)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of attackers on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of attackers on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Attacker")
	public AgentSet<cyberfit.relogo.Attacker> attackersOn(Turtle t){
		AgentSet<cyberfit.relogo.Attacker> result = new AgentSet<cyberfit.relogo.Attacker>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"attacker")){
			if (tt instanceof cyberfit.relogo.Attacker)
			result.add((cyberfit.relogo.Attacker)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of attackers on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of attackers on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Attacker")
	public AgentSet<cyberfit.relogo.Attacker> attackersOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<cyberfit.relogo.Attacker>();
		}

		Set<cyberfit.relogo.Attacker> total = new HashSet<cyberfit.relogo.Attacker>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(attackersOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(attackersOn(p));
				}
			}
		}
		return new AgentSet<cyberfit.relogo.Attacker>(total);
	}

	/**
	 * Queries if object is a attacker.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a attacker
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Attacker")
	public boolean isAttackerQ(Object o){
		return (o instanceof cyberfit.relogo.Attacker);
	}

	/**
	 * Returns the attacker with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Attacker")
	public cyberfit.relogo.Attacker attacker(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof cyberfit.relogo.Attacker)
			return (cyberfit.relogo.Attacker) turtle;
		return null;
	}

	/**
	 * Returns an agentset containing all attackers.
	 * 
	 * @return agentset of all attackers
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Attacker")
	public AgentSet<cyberfit.relogo.Attacker> attackers(){
		AgentSet<cyberfit.relogo.Attacker> a = new AgentSet<cyberfit.relogo.Attacker>();
		for (Object e : this.getMyObserver().getContext().getObjects(cyberfit.relogo.Attacker.class)) {
			if (e instanceof cyberfit.relogo.Attacker){
				a.add((cyberfit.relogo.Attacker)e);
			}
		}
		return a;
	}

	/**
	 * Returns an agentset of defenders on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of defenders on patch p
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Defender")
	public AgentSet<cyberfit.relogo.Defender> defendersOn(Patch p){
		AgentSet<cyberfit.relogo.Defender> result = new AgentSet<cyberfit.relogo.Defender>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"defender")){
			if (t instanceof cyberfit.relogo.Defender)
			result.add((cyberfit.relogo.Defender)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of defenders on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of defenders on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Defender")
	public AgentSet<cyberfit.relogo.Defender> defendersOn(Turtle t){
		AgentSet<cyberfit.relogo.Defender> result = new AgentSet<cyberfit.relogo.Defender>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"defender")){
			if (tt instanceof cyberfit.relogo.Defender)
			result.add((cyberfit.relogo.Defender)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of defenders on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of defenders on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Defender")
	public AgentSet<cyberfit.relogo.Defender> defendersOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<cyberfit.relogo.Defender>();
		}

		Set<cyberfit.relogo.Defender> total = new HashSet<cyberfit.relogo.Defender>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(defendersOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(defendersOn(p));
				}
			}
		}
		return new AgentSet<cyberfit.relogo.Defender>(total);
	}

	/**
	 * Queries if object is a defender.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a defender
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Defender")
	public boolean isDefenderQ(Object o){
		return (o instanceof cyberfit.relogo.Defender);
	}

	/**
	 * Returns the defender with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Defender")
	public cyberfit.relogo.Defender defender(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof cyberfit.relogo.Defender)
			return (cyberfit.relogo.Defender) turtle;
		return null;
	}

	/**
	 * Returns an agentset containing all defenders.
	 * 
	 * @return agentset of all defenders
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Defender")
	public AgentSet<cyberfit.relogo.Defender> defenders(){
		AgentSet<cyberfit.relogo.Defender> a = new AgentSet<cyberfit.relogo.Defender>();
		for (Object e : this.getMyObserver().getContext().getObjects(cyberfit.relogo.Defender.class)) {
			if (e instanceof cyberfit.relogo.Defender){
				a.add((cyberfit.relogo.Defender)e);
			}
		}
		return a;
	}

	/**
	 * Returns an agentset of friendlys on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of friendlys on patch p
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Friendly")
	public AgentSet<cyberfit.relogo.Friendly> friendlysOn(Patch p){
		AgentSet<cyberfit.relogo.Friendly> result = new AgentSet<cyberfit.relogo.Friendly>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"friendly")){
			if (t instanceof cyberfit.relogo.Friendly)
			result.add((cyberfit.relogo.Friendly)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of friendlys on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of friendlys on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Friendly")
	public AgentSet<cyberfit.relogo.Friendly> friendlysOn(Turtle t){
		AgentSet<cyberfit.relogo.Friendly> result = new AgentSet<cyberfit.relogo.Friendly>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"friendly")){
			if (tt instanceof cyberfit.relogo.Friendly)
			result.add((cyberfit.relogo.Friendly)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of friendlys on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of friendlys on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Friendly")
	public AgentSet<cyberfit.relogo.Friendly> friendlysOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<cyberfit.relogo.Friendly>();
		}

		Set<cyberfit.relogo.Friendly> total = new HashSet<cyberfit.relogo.Friendly>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(friendlysOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(friendlysOn(p));
				}
			}
		}
		return new AgentSet<cyberfit.relogo.Friendly>(total);
	}

	/**
	 * Queries if object is a friendly.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a friendly
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Friendly")
	public boolean isFriendlyQ(Object o){
		return (o instanceof cyberfit.relogo.Friendly);
	}

	/**
	 * Returns the friendly with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Friendly")
	public cyberfit.relogo.Friendly friendly(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof cyberfit.relogo.Friendly)
			return (cyberfit.relogo.Friendly) turtle;
		return null;
	}

	/**
	 * Returns an agentset containing all friendlys.
	 * 
	 * @return agentset of all friendlys
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Friendly")
	public AgentSet<cyberfit.relogo.Friendly> friendlys(){
		AgentSet<cyberfit.relogo.Friendly> a = new AgentSet<cyberfit.relogo.Friendly>();
		for (Object e : this.getMyObserver().getContext().getObjects(cyberfit.relogo.Friendly.class)) {
			if (e instanceof cyberfit.relogo.Friendly){
				a.add((cyberfit.relogo.Friendly)e);
			}
		}
		return a;
	}

	/**
	 * Returns an agentset of planners on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of planners on patch p
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Planner")
	public AgentSet<cyberfit.relogo.Planner> plannersOn(Patch p){
		AgentSet<cyberfit.relogo.Planner> result = new AgentSet<cyberfit.relogo.Planner>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"planner")){
			if (t instanceof cyberfit.relogo.Planner)
			result.add((cyberfit.relogo.Planner)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of planners on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of planners on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Planner")
	public AgentSet<cyberfit.relogo.Planner> plannersOn(Turtle t){
		AgentSet<cyberfit.relogo.Planner> result = new AgentSet<cyberfit.relogo.Planner>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"planner")){
			if (tt instanceof cyberfit.relogo.Planner)
			result.add((cyberfit.relogo.Planner)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of planners on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of planners on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Planner")
	public AgentSet<cyberfit.relogo.Planner> plannersOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<cyberfit.relogo.Planner>();
		}

		Set<cyberfit.relogo.Planner> total = new HashSet<cyberfit.relogo.Planner>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(plannersOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(plannersOn(p));
				}
			}
		}
		return new AgentSet<cyberfit.relogo.Planner>(total);
	}

	/**
	 * Queries if object is a planner.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a planner
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Planner")
	public boolean isPlannerQ(Object o){
		return (o instanceof cyberfit.relogo.Planner);
	}

	/**
	 * Returns the planner with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Planner")
	public cyberfit.relogo.Planner planner(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof cyberfit.relogo.Planner)
			return (cyberfit.relogo.Planner) turtle;
		return null;
	}

	/**
	 * Returns an agentset containing all planners.
	 * 
	 * @return agentset of all planners
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Planner")
	public AgentSet<cyberfit.relogo.Planner> planners(){
		AgentSet<cyberfit.relogo.Planner> a = new AgentSet<cyberfit.relogo.Planner>();
		for (Object e : this.getMyObserver().getContext().getObjects(cyberfit.relogo.Planner.class)) {
			if (e instanceof cyberfit.relogo.Planner){
				a.add((cyberfit.relogo.Planner)e);
			}
		}
		return a;
	}

	/**
	 * Returns an agentset of terrains on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of terrains on patch p
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Terrain")
	public AgentSet<cyberfit.relogo.Terrain> terrainsOn(Patch p){
		AgentSet<cyberfit.relogo.Terrain> result = new AgentSet<cyberfit.relogo.Terrain>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"terrain")){
			if (t instanceof cyberfit.relogo.Terrain)
			result.add((cyberfit.relogo.Terrain)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of terrains on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of terrains on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Terrain")
	public AgentSet<cyberfit.relogo.Terrain> terrainsOn(Turtle t){
		AgentSet<cyberfit.relogo.Terrain> result = new AgentSet<cyberfit.relogo.Terrain>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"terrain")){
			if (tt instanceof cyberfit.relogo.Terrain)
			result.add((cyberfit.relogo.Terrain)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of terrains on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of terrains on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Terrain")
	public AgentSet<cyberfit.relogo.Terrain> terrainsOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<cyberfit.relogo.Terrain>();
		}

		Set<cyberfit.relogo.Terrain> total = new HashSet<cyberfit.relogo.Terrain>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(terrainsOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(terrainsOn(p));
				}
			}
		}
		return new AgentSet<cyberfit.relogo.Terrain>(total);
	}

	/**
	 * Queries if object is a terrain.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a terrain
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Terrain")
	public boolean isTerrainQ(Object o){
		return (o instanceof cyberfit.relogo.Terrain);
	}

	/**
	 * Returns the terrain with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Terrain")
	public cyberfit.relogo.Terrain terrain(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof cyberfit.relogo.Terrain)
			return (cyberfit.relogo.Terrain) turtle;
		return null;
	}

	/**
	 * Returns an agentset containing all terrains.
	 * 
	 * @return agentset of all terrains
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.Terrain")
	public AgentSet<cyberfit.relogo.Terrain> terrains(){
		AgentSet<cyberfit.relogo.Terrain> a = new AgentSet<cyberfit.relogo.Terrain>();
		for (Object e : this.getMyObserver().getContext().getObjects(cyberfit.relogo.Terrain.class)) {
			if (e instanceof cyberfit.relogo.Terrain){
				a.add((cyberfit.relogo.Terrain)e);
			}
		}
		return a;
	}

	/**
	 * Returns an agentset of userTurtles on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of userTurtles on patch p
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.UserTurtle")
	public AgentSet<cyberfit.relogo.UserTurtle> userTurtlesOn(Patch p){
		AgentSet<cyberfit.relogo.UserTurtle> result = new AgentSet<cyberfit.relogo.UserTurtle>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"userTurtle")){
			if (t instanceof cyberfit.relogo.UserTurtle)
			result.add((cyberfit.relogo.UserTurtle)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of userTurtles on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of userTurtles on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.UserTurtle")
	public AgentSet<cyberfit.relogo.UserTurtle> userTurtlesOn(Turtle t){
		AgentSet<cyberfit.relogo.UserTurtle> result = new AgentSet<cyberfit.relogo.UserTurtle>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"userTurtle")){
			if (tt instanceof cyberfit.relogo.UserTurtle)
			result.add((cyberfit.relogo.UserTurtle)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of userTurtles on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of userTurtles on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.UserTurtle")
	public AgentSet<cyberfit.relogo.UserTurtle> userTurtlesOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<cyberfit.relogo.UserTurtle>();
		}

		Set<cyberfit.relogo.UserTurtle> total = new HashSet<cyberfit.relogo.UserTurtle>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(userTurtlesOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(userTurtlesOn(p));
				}
			}
		}
		return new AgentSet<cyberfit.relogo.UserTurtle>(total);
	}

	/**
	 * Queries if object is a userTurtle.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a userTurtle
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.UserTurtle")
	public boolean isUserTurtleQ(Object o){
		return (o instanceof cyberfit.relogo.UserTurtle);
	}

	/**
	 * Returns the userTurtle with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.UserTurtle")
	public cyberfit.relogo.UserTurtle userTurtle(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof cyberfit.relogo.UserTurtle)
			return (cyberfit.relogo.UserTurtle) turtle;
		return null;
	}

	/**
	 * Returns an agentset containing all userTurtles.
	 * 
	 * @return agentset of all userTurtles
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.UserTurtle")
	public AgentSet<cyberfit.relogo.UserTurtle> userTurtles(){
		AgentSet<cyberfit.relogo.UserTurtle> a = new AgentSet<cyberfit.relogo.UserTurtle>();
		for (Object e : this.getMyObserver().getContext().getObjects(cyberfit.relogo.UserTurtle.class)) {
			if (e instanceof cyberfit.relogo.UserTurtle){
				a.add((cyberfit.relogo.UserTurtle)e);
			}
		}
		return a;
	}

	/**
	 * Queries if object is a interactionFF.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a interactionFF
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFF")
	public boolean isInteractionFFQ(Object o){
		return (o instanceof cyberfit.relogo.InteractionFF);
	}

	/**
	 * Returns an agentset containing all interactionFFs.
	 * 
	 * @return agentset of all interactionFFs
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFF")
	public AgentSet<cyberfit.relogo.InteractionFF> interactionFFs(){
		AgentSet<cyberfit.relogo.InteractionFF> a = new AgentSet<cyberfit.relogo.InteractionFF>();
		for (Object e : this.getMyObserver().getContext().getObjects(cyberfit.relogo.InteractionFF.class)) {
			if (e instanceof cyberfit.relogo.InteractionFF){
				a.add((cyberfit.relogo.InteractionFF)e);
			}
		}
		return a;
	}

	/**
	 * Returns the interactionFF between two turtles.
	 * 
	 * @param oneEnd
	 *            an integer
	 * @param otherEnd
	 *            an integer
	 * @return interactionFF between two turtles
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFF")
	public cyberfit.relogo.InteractionFF interactionFF(Number oneEnd, Number otherEnd) {
		return (cyberfit.relogo.InteractionFF)(this.getMyObserver().getNetwork("InteractionFF").getEdge(turtle(oneEnd),turtle(otherEnd)));
	}

	/**
	 * Returns the interactionFF between two turtles.
	 * 
	 * @param oneEnd
	 *            a turtle
	 * @param otherEnd
	 *            a turtle
	 * @return interactionFF between two turtles
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFF")
	public cyberfit.relogo.InteractionFF interactionFF(Turtle oneEnd, Turtle otherEnd) {
		return interactionFF(oneEnd.getWho(), otherEnd.getWho());
	}

	/**
	 * Queries if object is a interactionFT.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a interactionFT
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFT")
	public boolean isInteractionFTQ(Object o){
		return (o instanceof cyberfit.relogo.InteractionFT);
	}

	/**
	 * Returns an agentset containing all interactionFTs.
	 * 
	 * @return agentset of all interactionFTs
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFT")
	public AgentSet<cyberfit.relogo.InteractionFT> interactionFTs(){
		AgentSet<cyberfit.relogo.InteractionFT> a = new AgentSet<cyberfit.relogo.InteractionFT>();
		for (Object e : this.getMyObserver().getContext().getObjects(cyberfit.relogo.InteractionFT.class)) {
			if (e instanceof cyberfit.relogo.InteractionFT){
				a.add((cyberfit.relogo.InteractionFT)e);
			}
		}
		return a;
	}

	/**
	 * Returns the interactionFT between two turtles.
	 * 
	 * @param oneEnd
	 *            an integer
	 * @param otherEnd
	 *            an integer
	 * @return interactionFT between two turtles
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFT")
	public cyberfit.relogo.InteractionFT interactionFT(Number oneEnd, Number otherEnd) {
		return (cyberfit.relogo.InteractionFT)(this.getMyObserver().getNetwork("InteractionFT").getEdge(turtle(oneEnd),turtle(otherEnd)));
	}

	/**
	 * Returns the interactionFT between two turtles.
	 * 
	 * @param oneEnd
	 *            a turtle
	 * @param otherEnd
	 *            a turtle
	 * @return interactionFT between two turtles
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionFT")
	public cyberfit.relogo.InteractionFT interactionFT(Turtle oneEnd, Turtle otherEnd) {
		return interactionFT(oneEnd.getWho(), otherEnd.getWho());
	}

	/**
	 * Queries if object is a interactionTT.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a interactionTT
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionTT")
	public boolean isInteractionTTQ(Object o){
		return (o instanceof cyberfit.relogo.InteractionTT);
	}

	/**
	 * Returns an agentset containing all interactionTTs.
	 * 
	 * @return agentset of all interactionTTs
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionTT")
	public AgentSet<cyberfit.relogo.InteractionTT> interactionTTs(){
		AgentSet<cyberfit.relogo.InteractionTT> a = new AgentSet<cyberfit.relogo.InteractionTT>();
		for (Object e : this.getMyObserver().getContext().getObjects(cyberfit.relogo.InteractionTT.class)) {
			if (e instanceof cyberfit.relogo.InteractionTT){
				a.add((cyberfit.relogo.InteractionTT)e);
			}
		}
		return a;
	}

	/**
	 * Returns the interactionTT between two turtles.
	 * 
	 * @param oneEnd
	 *            an integer
	 * @param otherEnd
	 *            an integer
	 * @return interactionTT between two turtles
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionTT")
	public cyberfit.relogo.InteractionTT interactionTT(Number oneEnd, Number otherEnd) {
		return (cyberfit.relogo.InteractionTT)(this.getMyObserver().getNetwork("InteractionTT").getEdge(turtle(oneEnd),turtle(otherEnd)));
	}

	/**
	 * Returns the interactionTT between two turtles.
	 * 
	 * @param oneEnd
	 *            a turtle
	 * @param otherEnd
	 *            a turtle
	 * @return interactionTT between two turtles
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.InteractionTT")
	public cyberfit.relogo.InteractionTT interactionTT(Turtle oneEnd, Turtle otherEnd) {
		return interactionTT(oneEnd.getWho(), otherEnd.getWho());
	}

	/**
	 * Queries if object is a userLink.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a userLink
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.UserLink")
	public boolean isUserLinkQ(Object o){
		return (o instanceof cyberfit.relogo.UserLink);
	}

	/**
	 * Returns an agentset containing all userLinks.
	 * 
	 * @return agentset of all userLinks
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.UserLink")
	public AgentSet<cyberfit.relogo.UserLink> userLinks(){
		AgentSet<cyberfit.relogo.UserLink> a = new AgentSet<cyberfit.relogo.UserLink>();
		for (Object e : this.getMyObserver().getContext().getObjects(cyberfit.relogo.UserLink.class)) {
			if (e instanceof cyberfit.relogo.UserLink){
				a.add((cyberfit.relogo.UserLink)e);
			}
		}
		return a;
	}

	/**
	 * Returns the userLink between two turtles.
	 * 
	 * @param oneEnd
	 *            an integer
	 * @param otherEnd
	 *            an integer
	 * @return userLink between two turtles
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.UserLink")
	public cyberfit.relogo.UserLink userLink(Number oneEnd, Number otherEnd) {
		return (cyberfit.relogo.UserLink)(this.getMyObserver().getNetwork("UserLink").getEdge(turtle(oneEnd),turtle(otherEnd)));
	}

	/**
	 * Returns the userLink between two turtles.
	 * 
	 * @param oneEnd
	 *            a turtle
	 * @param otherEnd
	 *            a turtle
	 * @return userLink between two turtles
	 */
	@ReLogoBuilderGeneratedFor("cyberfit.relogo.UserLink")
	public cyberfit.relogo.UserLink userLink(Turtle oneEnd, Turtle otherEnd) {
		return userLink(oneEnd.getWho(), otherEnd.getWho());
	}

	/**
	 * Returns the value of the global variable CPTsReady.
	 *
	 * @return the value of the global variable CPTsReady
	 */
	@ReLogoBuilderGeneratedFor("global: CPTsReady")
	public Object getCPTsReady(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("CPTsReady");
	}

	/**
	 * Sets the value of the global variable CPTsReady.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: CPTsReady")
	public void setCPTsReady(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("CPTsReady",value);
	}

	/**
	 * Returns the value of the global variable MissionsReady.
	 *
	 * @return the value of the global variable MissionsReady
	 */
	@ReLogoBuilderGeneratedFor("global: MissionsReady")
	public Object getMissionsReady(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("MissionsReady");
	}

	/**
	 * Sets the value of the global variable MissionsReady.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: MissionsReady")
	public void setMissionsReady(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("MissionsReady",value);
	}

	/**
	 * Returns the value of the global variable team1Deploy.
	 *
	 * @return the value of the global variable team1Deploy
	 */
	@ReLogoBuilderGeneratedFor("global: team1Deploy")
	public Object getTeam1Deploy(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("team1Deploy");
	}

	/**
	 * Sets the value of the global variable team1Deploy.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: team1Deploy")
	public void setTeam1Deploy(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("team1Deploy",value);
	}

	/**
	 * Returns the value of the global variable team2Deploy.
	 *
	 * @return the value of the global variable team2Deploy
	 */
	@ReLogoBuilderGeneratedFor("global: team2Deploy")
	public Object getTeam2Deploy(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("team2Deploy");
	}

	/**
	 * Sets the value of the global variable team2Deploy.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: team2Deploy")
	public void setTeam2Deploy(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("team2Deploy",value);
	}

	/**
	 * Returns the value of the global variable team3Deploy.
	 *
	 * @return the value of the global variable team3Deploy
	 */
	@ReLogoBuilderGeneratedFor("global: team3Deploy")
	public Object getTeam3Deploy(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("team3Deploy");
	}

	/**
	 * Sets the value of the global variable team3Deploy.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: team3Deploy")
	public void setTeam3Deploy(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("team3Deploy",value);
	}

	/**
	 * Returns the value of the global variable team4Deploy.
	 *
	 * @return the value of the global variable team4Deploy
	 */
	@ReLogoBuilderGeneratedFor("global: team4Deploy")
	public Object getTeam4Deploy(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("team4Deploy");
	}

	/**
	 * Sets the value of the global variable team4Deploy.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: team4Deploy")
	public void setTeam4Deploy(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("team4Deploy",value);
	}

	/**
	 * Returns the value of the global variable mission1Select.
	 *
	 * @return the value of the global variable mission1Select
	 */
	@ReLogoBuilderGeneratedFor("global: mission1Select")
	public Object getMission1Select(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("mission1Select");
	}

	/**
	 * Sets the value of the global variable mission1Select.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: mission1Select")
	public void setMission1Select(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("mission1Select",value);
	}


}