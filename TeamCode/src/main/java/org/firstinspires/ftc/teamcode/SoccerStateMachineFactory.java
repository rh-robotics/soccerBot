package org.firstinspires.ftc.teamcode;

import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineBuilder;

import java.util.EnumSet;

public class SoccerStateMachineFactory {

    public enum State  { INIT, MAIN, PENALTY, DRIBBLE, KICK, BLOCK, DONE }
    public enum Event  { START, FINISH, ENCROACH, RETREAT,RECEIVE,AIM,DEFEND,TRANSITION,KICKED }

    public static StateMachine<State, Event> build() throws Exception {

        StateMachineBuilder.Builder<State, Event> builder = StateMachineBuilder.builder();

        builder.configureStates()
                .withStates()
                .initial(State.INIT)
                .end(State.DONE)
                .states(EnumSet.allOf(State.class));

        builder.configureTransitions()
                .withExternal()
                .source(State.INIT).target(State.MAIN).event(Event.START)
                .and()
                .withExternal()
                .source(State.MAIN).target(State.DONE).event(Event.FINISH)
                .and()
                .withExternal()
                .source(State.PENALTY).target(State.MAIN).event(Event.RETREAT)
                .and()
                .withExternal()
                .source(State.MAIN).target(State.PENALTY).event(Event.ENCROACH)
                .and()
                .withExternal()
                .source(State.MAIN).target(State.DRIBBLE).event(Event.RECEIVE)
                .and()
                .withExternal()
                .source(State.MAIN).target(State.KICK).event(Event.AIM)
                .and()
                .withExternal()
                .source(State.DRIBBLE).target(State.KICK).event(Event.AIM)
                .and()
                .withExternal()
                .source(State.MAIN).target(State.BLOCK).event(Event.DEFEND)
                .and()
                .withExternal()
                .source(State.BLOCK).target(State.MAIN).event(Event.TRANSITION)
                .and()
                .withExternal()
                .source(State.KICK).target(State.MAIN).event(Event.KICKED);

        return builder.build();
    }
}
