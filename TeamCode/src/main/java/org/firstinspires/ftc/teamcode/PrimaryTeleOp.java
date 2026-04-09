package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.SoccerStateMachineFactory.*;
import org.springframework.statemachine.StateMachine;

public class PrimaryTeleOp extends OpMode {
    StateMachine<State,Event> sm;
    Gamepad previous;
    Gamepad current;
    Robot robot;
    @Override
    public void init() {
        previous = new Gamepad();
        current = new Gamepad();
        try {
            sm = SoccerStateMachineFactory.build();
            sm.startReactively();
            sm.sendEvent(Event.START);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        robot = new Robot(sm, this);
    }

    @Override
    public void loop() {
        previous.copy(current);
        current.copy(gamepad1);
        robot.controllerUpdate(previous, current);

    }

    @Override
    public void stop() {
        sm.sendEvent(Event.FINISH);
    }
}
