package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import org.firstinspires.ftc.teamcode.SoccerStateMachineFactory.*;
import org.springframework.statemachine.StateMachine;

public class PrimaryTeleOp extends OpMode {
    StateMachine<State,Event> sm;
    @Override
    public void init() {
        try {
            sm = SoccerStateMachineFactory.build();
            sm.startReactively();
            sm.sendEvent(Event.START);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void loop() {

    }

    @Override
    public void stop() {
        sm.sendEvent(Event.FINISH);
    }
}
